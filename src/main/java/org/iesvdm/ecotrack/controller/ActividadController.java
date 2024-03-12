package org.iesvdm.ecotrack.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.ecotrack.domain.Actividad;
import org.iesvdm.ecotrack.domain.Usuario;
import org.iesvdm.ecotrack.service.ActividadService;
import org.iesvdm.ecotrack.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/actividades")
public class ActividadController {
    @Autowired
    private ActividadService actividadService;

    @GetMapping(value={"","/"}/*,params ={"!buscar","!ordenar"}*/)
    public Page<Actividad> all() {
        log.info("Accediendo a todas las actividades");
        return this.actividadService.findAll(0,10);
    }

    @GetMapping(value={"/{id}","/{id}/"})
    public Optional<Actividad> one(@PathVariable("id") Long id) {
        log.info("Accediendo a todas las actividades");
        return this.actividadService.one(id);
    }
}
