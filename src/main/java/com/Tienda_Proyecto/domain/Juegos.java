package com.Tienda_Proyecto.domain;


import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "juegos")
public class Juegos implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_juego")
    private Long idProducto;
    
    @Column(name = "descripcion", nullable = false, length = 30)
    private String descripcion;
    
    @Column(name = "detalle", nullable = false, length = 1600)
    private String detalle;
    
    @Column(name = "precio")
    private double precio;
    
    @Column(name = "existencias")
    private int existencias;
    
    @Column(name = "ruta_imagen", length = 1024)
    private String rutaImagen;
    
    @Column(name = "activo")
    private boolean activo;
    
    @ManyToOne
    @JoinColumn(name="id_categoria", updatable = false)
    private Categoria categoria;
}
