package com.Tienda_Proyecto.service;

import com.Tienda_Proyecto.domain.Producto;
import java.util.List;

public interface ProductoService {

    public List<Producto> getProductos(boolean activo);
    // Se obtiene un listado de productos en un List


    // Se obtiene un Producto, a partir del id de un producto
    public Producto getProducto(Producto producto);

    // Se inserta un nuevo producto si el id del producto esta vacío
    // Se actualiza un producto si el id del producto NO esta vacío
    public void save(Producto producto);

    // Se elimina el producto que tiene el id pasado por parámetro
    public void delete(Producto producto);
    
    //Ejemplo de una consulta con un Query
    public List<Producto> consultaQuery(double precioInf, double precioSup);
    
    //Ejemplo de una consulta con un Query
    public List<Producto> consultaJPQL(double precioInf, double precioSup);
}