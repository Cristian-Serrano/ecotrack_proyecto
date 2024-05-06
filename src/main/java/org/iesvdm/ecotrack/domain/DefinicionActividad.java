package org.iesvdm.ecotrack.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "definicion_actividad")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DefinicionActividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_definicion_actividad")
    @EqualsAndHashCode.Include
    private long id;


    private Double factorDeEmisionCombustible;
    private String unidadFactorDeEmision;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Rol rol;

    @OneToMany(mappedBy = "definicionActividad")
    private Set<Actividad> actividades;
}
