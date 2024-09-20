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
    //tipo de actividad

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_definicion_actividad")
    @EqualsAndHashCode.Include
    private long id;


    private Double factorDeEmisionCombustible;
    private String unidadFactorDeEmision;
    private String emision; //es el string que se muestra de la emisión, por ejemplo 14.23 L/km

    @OneToMany(mappedBy = "definicionActividad")
    private Set<Actividad> actividades;
}
