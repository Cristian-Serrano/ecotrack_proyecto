package org.iesvdm.ecotrack.domain;

import org.iesvdm.ecotrack.domain.Actividad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "estadistica")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Estadistica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadistica")
    private long id;
    private Double toneladasEmitidas;

    @OneToMany
    private Actividad actividad;
}
