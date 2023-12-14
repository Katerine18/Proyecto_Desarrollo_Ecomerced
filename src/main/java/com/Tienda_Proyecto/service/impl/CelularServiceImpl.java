package com.Tienda_Proyecto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Tienda_Proyecto.domain.Celular;
import com.Tienda_Proyecto.dao.CelularDao;
import com.Tienda_Proyecto.service.CelularService;
import java.util.List;

@Service
public class CelularServiceImpl implements CelularService {

    @Autowired
    private CelularDao celularDao;

    @Override
    @Transactional(readOnly = true)
    public List<Celular> getCelulars(boolean activo) {
        return celularDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Celular getCelular(Celular celular) {
        return celularDao.findById(celular.getIdCelular()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Celular celular) {
        celularDao.save(celular);
    }

    @Override
    @Transactional
    public void delete(Celular celular) {
        celularDao.delete(celular);
    }
    
    // Ejemplo de una consulta con un Query
    @Override
    @Transactional(readOnly = true)
    public List<Celular> consultaQuery(double precioInf, double precioSup) {
        return celularDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
    
    // Ejemplo de una consulta con un Query
    @Override
    @Transactional(readOnly = true)
    public List<Celular> consultaJPQL(double precioInf, double precioSup) {
        return celularDao.consultaJPQL(precioInf, precioSup);
    }
}