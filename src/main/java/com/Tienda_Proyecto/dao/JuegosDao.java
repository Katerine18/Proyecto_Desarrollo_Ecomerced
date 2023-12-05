package com.Tienda_Proyecto.dao;

import com.Tienda_Proyecto.domain.Juegos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface JuegosDao extends JpaRepository<Juegos, Long> {

    public List<Juegos> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    @Query(value = "SELECT j FROM Juegos j WHERE j.precio BETWEEN :precioInf AND :precioSup ORDER BY j.descripcion ASC")
    public List<Juegos> consultaJPQL(double precioInf, double precioSup);
}
