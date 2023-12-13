package com.Tienda_Proyecto.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "resenas")
public class Resenas implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_resenas")
    private Long idResenas;
    
    private String resenasD;
    private boolean activo;
    
    public Resenas(String resenasD) {
        this.resenasD = resenasD;
        this.activo = activo;
    }

    public Resenas() {
    }

}
