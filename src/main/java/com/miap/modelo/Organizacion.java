package com.miap.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "organizacion")
public class Organizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    // Relación muchos a muchos con Usuario
    @Setter
    @Getter
    @ManyToMany(mappedBy = "organizaciones")
    private Set<Usuario> usuarios = new HashSet<>();

}
