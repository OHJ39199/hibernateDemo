package com.miap.modelo;
import javax.persistence.*;

@Entity
@Table(name = "modalidades_afiliacion")
public class ModalidadesAfiliacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "descripcion")
    private String descripcion;

    // Mapeo de la relación de Muchos a Uno (muchas modalidades de afiliación pueden ser de una misma cuenta)
    @ManyToOne
    @JoinColumn(name = "cuenta_seguridad_social_id", nullable = false)
    private CuentaSeguridadSocial cuentaSeguridadSocial;

}
