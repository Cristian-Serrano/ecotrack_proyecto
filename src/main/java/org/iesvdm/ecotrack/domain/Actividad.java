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
    private long id;

    private BigDecimal combustibleUtilizado;
    private BigDecimal factorDeEmisionCombustible;
    private String unidadFactorDeEmision;
    private Date fecha;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Usuario usuario;
}
