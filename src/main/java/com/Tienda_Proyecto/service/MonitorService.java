package com.Tienda_Proyecto.service;

import com.Tienda_Proyecto.domain.Monitor;
import java.util.List;

public interface MonitorService {

    public List<Monitor> getMonitores(boolean activo);
    // Se obtiene un listado de monitores en un List


    // Se obtiene un Monitor, a partir del id de un monitor
    public Monitor getMonitor(Monitor monitor);

    // Se inserta un nuevo monitor si el id del monitor esta vacío
    // Se actualiza un monitor si el id del monitor NO esta vacío
    public void save(Monitor monitor);

    // Se elimina el monitor que tiene el id pasado por parámetro
    public void delete(Monitor monitor);
    
    //Ejemplo de una consulta con un Query
    public List<Monitor> consultaQuery(double precioInf, double precioSup);
    
    //Ejemplo de una consulta con un Query
    public List<Monitor> consultaJPQL(double precioInf, double precioSup);
}