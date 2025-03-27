package com.miap.modelo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cuenta_seguridad_social")
public class CuentaSeguridadSocial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", nullable = false, unique = true)
    private String numero;

    // Mapeo de la relación bidireccional Uno a Uno
    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    // Mapeo de la relación de Uno a Muchos (una cuenta puede tener varias modalidades de afiliación)
    @Setter
    @Getter
    @OneToMany(mappedBy = "cuentaSeguridadSocial", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<ModalidadesAfiliacion> modalidadesAfiliaciones = new HashSet<>();

}
