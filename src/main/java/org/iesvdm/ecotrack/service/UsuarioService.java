package org.iesvdm.ecotrack.service;

import org.iesvdm.ecotrack.domain.Usuario;
import org.iesvdm.ecotrack.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Usuario replace(Long id, Usuario usuario){
        return this.usuarioRepository.findById(id)
                .map( p -> (id.equals(usuario.getId())  ?
                        this.usuarioRepository.save(usuario) : null))
                .get();
        /*.orElseThrow(() -> new UsuarioNotFoundException(id));*/
    }

    public void delete(Long id) {
        this.usuarioRepository.findById(id).map(p -> {
                    this.usuarioRepository.delete(p);
                    return p;})
                .get();
        /*.orElseThrow(() -> new UsuarioNotFoundException(id));*/
    }

    public Usuario save(Usuario usuario){
        return this.usuarioRepository.save(usuario);
    }

}
