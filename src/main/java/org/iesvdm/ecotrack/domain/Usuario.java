package org.iesvdm.ecotrack.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(	name = "usuario",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "nombre_de_usuario"),
                @UniqueConstraint(columnNames = "email")
        })
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

    @NotBlank
    @Size(max = 20)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String contrasenia;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "usuario_rol",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<DefinicionActividad> actividades;

    public Usuario(String nombreUsuario, String email, String contrasenia) {

        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.contrasenia = contrasenia;

    }
}
