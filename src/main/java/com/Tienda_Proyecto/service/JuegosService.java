package com.Tienda_Proyecto.service;

import com.Tienda_Proyecto.domain.Juegos;

import java.util.List;

public interface JuegosService {

    // Se obtiene un listado de juegos en un List
    List<Juegos> getAllJuegos();

    // Se obtiene un juego, a partir del id de un juego
    Juegos getJuegoById(Long id);

    // Se inserta un nuevo juego si el id del juego está vacío
    // Se actualiza un juego si el id del juego NO está vacío
    void save(Juegos juego);

    // Se elimina el juego que tiene el id pasado por parámetro
    void delete(Juegos juego);
}
