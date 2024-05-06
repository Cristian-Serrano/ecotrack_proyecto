package org.iesvdm.ecotrack.repository;

import org.iesvdm.ecotrack.domain.DefinicionActividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefinicionActividadRepository extends JpaRepository<DefinicionActividad, Long> {

}