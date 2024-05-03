package org.iesvdm.ecotrack.service;

import org.iesvdm.ecotrack.domain.Actividad;
import org.iesvdm.ecotrack.domain.Usuario;
import org.iesvdm.ecotrack.repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActividadService {
    @Autowired
    private ActividadRepository actividadRepository;

    public Page<Actividad> findAll(int pagina,int tamanio){
        Pageable pageable = PageRequest.of(pagina, tamanio, Sort.by("id").ascending());
        Page<Actividad> pageAll = this.actividadRepository.findAll(pageable);
        return pageAll;
    }

    public Optional<Actividad> one(long id){
        return actividadRepository.findById(id);
    }

    public Actividad replace(Long id, Actividad actividad){
        return this.actividadRepository.findById(id)
                .map( p -> (id.equals(actividad.getId())  ?
                        this.actividadRepository.save(actividad) : null))
                .get();
    }

    public void delete(Long id) {
        this.actividadRepository.findById(id).map(p -> {
                    this.actividadRepository.delete(p);
                    return p;
        })
                .get();
    }

    /**
     * devuelve el valor y las unidades: 14,3 kg/L
     * @param id
     * @return
     */
    public String factorEmision(Long id){
        Optional<Actividad> actividadOpt = this.actividadRepository.findById(id);
        if(actividadOpt.isPresent()){
            Actividad actividad = actividadOpt.get();
            return actividad.getFactorDeEmisionCombustible() + actividad.getUnidadFactorDeEmision();
        }
        return "";
    }

    public Actividad save(Actividad actividad){
        return this.actividadRepository.save(actividad);
    }

}
