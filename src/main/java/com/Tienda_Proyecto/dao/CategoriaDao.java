
package com.Tienda_Proyecto.dao;

import com.Tienda_Proyecto.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository<Categoria,Long> {
    
}
