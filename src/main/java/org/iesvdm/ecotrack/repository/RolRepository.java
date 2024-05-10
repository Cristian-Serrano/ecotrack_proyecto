package org.iesvdm.ecotrack.repository;



import org.iesvdm.ecotrack.domain.ERol;
import org.iesvdm.ecotrack.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByRol(ERol rol);
}