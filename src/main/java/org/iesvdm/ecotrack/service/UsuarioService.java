package org.iesvdm.ecotrack.service;

import org.iesvdm.ecotrack.domain.Usuario;
import org.iesvdm.ecotrack.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Page<Usuario> findAll(int pagina,int tamanio){
        Pageable pageable = PageRequest.of(pagina, tamanio, Sort.by("id").ascending());
        Page<Usuario> pageAll = this.usuarioRepository.findAll(pageable);
        return pageAll;
    }

    public Optional<Usuario> one(long id){
        return usuarioRepository.findById(id);
    }

}


