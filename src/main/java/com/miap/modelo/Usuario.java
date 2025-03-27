package com.miap.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {

    // Mapeo de la clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    // Mapeo de una relación de Uno a Uno (bidireccional)
    @OneToOne(mappedBy = "usuario")
    private CuentaSeguridadSocial cuentaSeguridadSocial;

    // Mapeo de una relación de Uno a Muchos (un usuario puede tener varias direcciones)
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval =
            true)
    private Set<Direccion> direcciones = new HashSet<>();

    // Relación muchos a muchos con Organizacion
    @Setter
    @Getter
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "usuario_organizacion",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "organizacion_id")
    )
    private Set<Organizacion> organizaciones = new HashSet<>();

}
