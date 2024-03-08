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
}
