package com.Tienda_Proyecto.domain;
 //Hay que modificarlo con la info de las tablas de denis
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "inicio")
public class Inicio implements Serializable {

    private static final long serialVersinUID =1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column (name="id_categoria")
    private Long idCategoria;    
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    @OneToMany
    @JoinColumn(name="id_categoria",updatable=false)
    private List<Inicio>productos;
}
