package org.iesvdm.ecotrack.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "actividad")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad")
    @EqualsAndHashCode.Include
    private long id;

    private Double combustibleUtilizado;
    private Double factorDeEmisionCombustible;
    private String unidadFactorDeEmision;
    private Date fecha;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Usuario usuario;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private GraficoDeEstadisticas graficoDeEstadisticas;
}
