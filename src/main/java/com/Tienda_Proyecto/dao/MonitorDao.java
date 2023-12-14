
package com.Tienda_Proyecto.dao;

import com.Tienda_Proyecto.domain.Monitor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MonitorDao extends JpaRepository<Monitor,Long> {
    
    //Ejemplo de una consulta con un Query
    public List<Monitor> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
    
    //Ejemplo de una consulta con JPQL
    @Query(value="Select a from Monitor a where a.precio between :precioInf and :precioSup order by a.descripcion asc")
    public List<Monitor> consultaJPQL(double precioInf, double precioSup);
    
}