package com.Tienda_Proyecto.service;

import com.Tienda_Proyecto.domain.Celular;
import java.util.List;

public interface CelularService {

    public List<Celular> getCelulars(boolean activo);
    // Se obtiene un listado de celulars en un List


    // Se obtiene un Celular, a partir del id de un celular
    public Celular getCelular(Celular celular);

    // Se inserta un nuevo celular si el id del celular esta vacío
    // Se actualiza un celular si el id del celular NO esta vacío
    public void save(Celular celular);

    // Se elimina el celular que tiene el id pasado por parámetro
    public void delete(Celular celular);
    
    //Ejemplo de una consulta con un Query
    public List<Celular> consultaQuery(double precioInf, double precioSup);
    
    //Ejemplo de una consulta con un Query
    public List<Celular> consultaJPQL(double precioInf, double precioSup);
}