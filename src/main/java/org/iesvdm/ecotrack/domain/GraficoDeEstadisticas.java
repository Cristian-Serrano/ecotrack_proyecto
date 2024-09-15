package org.iesvdm.ecotrack.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "grafico_de_estadisticas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GraficoDeEstadisticas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grafico")
    @EqualsAndHashCode.Include
    private long id;

    @OneToMany(mappedBy = "graficoDeEstadisticas")
    private List<Actividad> actividades;
}
