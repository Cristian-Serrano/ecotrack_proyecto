package org.iesvdm.ecotrack.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private long id;

    @OneToMany
    private List<Actividad> actividades;
}
