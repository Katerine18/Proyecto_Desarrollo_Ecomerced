package com.Tienda_Proyecto.service;

import com.Tienda_Proyecto.domain.Resenas;
import java.util.List;

public interface ResenasService {

    public List<Resenas> getResenas(boolean activo);
 
    public Resenas getResenas(Resenas resenas);

    public void save(Resenas resenas);

    public void delete(Resenas resenas);
}