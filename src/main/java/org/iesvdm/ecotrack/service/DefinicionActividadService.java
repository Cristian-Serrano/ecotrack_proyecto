package org.iesvdm.ecotrack.service;

import org.iesvdm.ecotrack.domain.DefinicionActividad;
import org.iesvdm.ecotrack.repository.DefinicionActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefinicionActividadService {
    @Autowired
    private DefinicionActividadRepository definicionActividadRepository;

    public Page<DefinicionActividad> findAll(int pagina, int tamanio){
        Pageable pageable = PageRequest.of(pagina, tamanio, Sort.by("id").ascending());
        Page<DefinicionActividad> pageAll = this.definicionActividadRepository.findAll(pageable);
        return pageAll;
    }

    public Optional<DefinicionActividad> one(long id){
        return definicionActividadRepository.findById(id);
    }

    public DefinicionActividad replace(Long id, DefinicionActividad definicionActividad){
        return this.definicionActividadRepository.findById(id)
                .map( p -> (id.equals(definicionActividad.getId())  ?
                        this.definicionActividadRepository.save(definicionActividad) : null))
                .get();
    }

    public void delete(Long id) {
        this.definicionActividadRepository.findById(id).map(p -> {
                    this.definicionActividadRepository.delete(p);
                    return p;
        });
    }

    /**
     * devuelve el valor y las unidades: 14,3 kg/L
     * @param id
     * @return
     */
    public String factorEmision(Long id){
        Optional<DefinicionActividad> actividadOpt = this.definicionActividadRepository.findById(id);
        if(actividadOpt.isPresent()){
            DefinicionActividad definicionActividad = actividadOpt.get();
            return definicionActividad.getFactorDeEmisionCombustible() + definicionActividad.getUnidadFactorDeEmision();
        }
        return "";
    }

    public DefinicionActividad save(DefinicionActividad definicionActividad){
        return this.definicionActividadRepository.save(definicionActividad);
    }

}
