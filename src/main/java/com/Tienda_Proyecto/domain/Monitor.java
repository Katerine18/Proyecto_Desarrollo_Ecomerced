package com.Tienda_Proyecto.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "monitor")
public class Monitor implements Serializable {

    private static final long serialVersinUID =1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column (name="id_monitor")
    private Long idMonitor;
    //private Long idCategoria;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private String rutaImagen;
    private boolean activo;
    
    @ManyToOne
    @JoinColumn(name="id_categoria", updatable = false)
    Categoria categoria;

}
