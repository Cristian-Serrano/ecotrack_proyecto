package org.iesvdm.ecotrack;

import org.iesvdm.ecotrack.domain.Actividad;
import org.iesvdm.ecotrack.domain.Usuario;
import org.iesvdm.ecotrack.service.ActividadService;
import org.iesvdm.ecotrack.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class EcotrackApplicationTests {
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ActividadService actividadService;

	@Test
	void contextLoads() {
	}

	@Test
	void postUsuariosYActividades(){
		Date fecha = new Date();

		Usuario usuario1 = new Usuario(1,"pila1","alberto1","123","email@email.com",false,null);
		Usuario usuario2 = new Usuario(2,"pila2","alberto2","123","email@email.com",false,null);
		Usuario usuario3 = new Usuario(3,"pila3","alberto3","123","email@email.com",false,null);
		this.usuarioService.save(usuario1);
		this.usuarioService.save(usuario2);
		this.usuarioService.save(usuario3);


		Actividad actividad1 = new Actividad(1,1d,12.2d,"kgCO2/L",fecha,usuario1,null);
		Actividad actividad2 = new Actividad(2,1d,17.2d,"kgCO2/L",fecha,usuario2,null);
		Actividad actividad3 = new Actividad(3,1d,21.2d,"kgCO2/L",fecha,usuario3,null);
		this.actividadService.save(actividad1);
		this.actividadService.save(actividad2);
		this.actividadService.save(actividad3);
	}

	@Test
	void getUsuarios(){
		String usuarios = this.usuarioService.findAll(0,2).toString();
		System.out.println(usuarios);
	}
}
