package org.iesvdm.ecotrack.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.ecotrack.domain.DefinicionActividad;
import org.iesvdm.ecotrack.service.DefinicionActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/v1/api/actividades")
public class DefinicionActividadController {
    @Autowired
    private DefinicionActividadService actividadService;

    @GetMapping(value={"","/"}/*,params ={"!buscar","!ordenar"}*/)
    public Page<DefinicionActividad> all() {
        log.info("Accediendo a todas las actividades");
        return this.actividadService.findAll(0,3);
    }

    @GetMapping(value={"/{id}","/{id}/"})
    public Optional<DefinicionActividad> one(@PathVariable("id") Long id) {
        log.info("Accediendo a todas las actividades");
        return this.actividadService.one(id);
    }

    @PostMapping({"","/"})
    public DefinicionActividad newActividad(@RequestBody DefinicionActividad definicionActividad) {
        return this.actividadService.save(definicionActividad);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteActividad(@PathVariable("id") Long id) {
        this.actividadService.delete(id);
    }
}
