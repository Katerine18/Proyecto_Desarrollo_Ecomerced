
package com.Tienda_Proyecto.service.impl;


import com.Tienda_Proyecto.dao.InicioDao;
import com.Tienda_Proyecto.domain.Inicio;
import com.Tienda_Proyecto.service.InicioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InicioServiceImpl implements InicioService {

    @Autowired
    private InicioDao inicioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Inicio> getCategorias(boolean activo) {
        var categorias = inicioDao.findAll();
        return categorias;
    }

    @Override
    @Transactional(readOnly = true)
    public Inicio getCategoria(Inicio inicio) {
        return inicioDao.findById(inicio.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Inicio inicio) {
        inicioDao.save(inicio);
    }

    @Override
    @Transactional
    public void delete(Inicio inicio) {
        inicioDao.delete(inicio);
    }

}
