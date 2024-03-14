package org.iesvdm.ecotrack;

import org.iesvdm.ecotrack.domain.Usuario;
import org.iesvdm.ecotrack.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EcotrackApplicationTests {
	@Autowired
	private UsuarioService usuarioService;

	@Test
	void contextLoads() {
	}

	@Test
	void postUsuarios(){
		Usuario usuario1 = new Usuario(1,"pila1","alberto1","123","email@email.com",false,null);
		Usuario usuario2 = new Usuario(2,"pila2","alberto2","123","email@email.com",false,null);
		Usuario usuario3 = new Usuario(3,"pila3","alberto3","123","email@email.com",false,null);
		this.usuarioService.save(usuario1);
		this.usuarioService.save(usuario2);
		this.usuarioService.save(usuario3);

	}

	@Test
	void getUsuarios(){
		String usuarios = this.usuarioService.findAll(0,2).toString();
		System.out.println(usuarios);

	}

}
