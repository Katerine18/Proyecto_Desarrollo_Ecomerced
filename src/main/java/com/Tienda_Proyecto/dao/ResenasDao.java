
package com.Tienda_Proyecto.dao;

import com.Tienda_Proyecto.domain.Resenas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResenasDao extends JpaRepository<Resenas,Long> {
    
}