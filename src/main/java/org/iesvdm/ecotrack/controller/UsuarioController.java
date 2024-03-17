package org.iesvdm.ecotrack.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.ecotrack.domain.Usuario;
import org.iesvdm.ecotrack.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/v1/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value={"","/"},params ={"!buscar","!ordenar"})
    public Page<Usuario> all() {
        log.info("Accediendo a todos los usuarios");
        return this.usuarioService.findAll(0,3);
    }

    @GetMapping(value={"/{id}","/{id}/"})
    public Optional<Usuario> one(@PathVariable("id") Long id) {
        log.info("Accediendo a todos los usuarios");
        return this.usuarioService.one(id);
    }

    @PostMapping({"","/"})
    public Usuario newUsuario(@RequestBody Usuario usuario) {
        return this.usuarioService.save(usuario);
    }
}
