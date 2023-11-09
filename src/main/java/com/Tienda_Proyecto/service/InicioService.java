package com.Tienda_Proyecto.service;

 //Hay que modificarlo con la info de las tablas de denis

import com.Tienda_Proyecto.domain.Inicio;
import java.util.List;

public interface InicioService {

    public List<Inicio> getCategorias(boolean activo);
    // Se obtiene un listado de categorias en un List


    // Se obtiene un Categoria, a partir del id de un categoria
    public Inicio getCategoria(Inicio inicio);

    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Inicio inicio);

    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Inicio inicio);
}
