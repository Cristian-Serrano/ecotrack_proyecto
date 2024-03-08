package org.iesvdm.ecotrack.repository;

import org.iesvdm.ecotrack.domain.Actividad;
import org.iesvdm.ecotrack.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long> {

}