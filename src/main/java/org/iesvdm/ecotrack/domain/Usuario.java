package org.iesvdm.ecotrack.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    @EqualsAndHashCode.Include
    private long id;
    private String nombre_de_usuario;
    private String nombre_de_pila;
    private String contrasenia;
    private String email;

    @ManyToMany(mappedBy = "usuarios")
    private Set<Rol> roles;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<DefinicionActividad> actividades;
}
