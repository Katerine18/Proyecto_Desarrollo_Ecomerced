package com.Tienda_Proyecto.service.impl;

import com.Tienda_Proyecto.dao.ResenasDao;
import com.Tienda_Proyecto.domain.Resenas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Tienda_Proyecto.service.ResenasService;

@Service
public class ResenasServiceImpl implements ResenasService {

    @Autowired
    private ResenasDao resenasDao;

    @Override
    @Transactional(readOnly = true)
    public List<Resenas> getResenas(boolean activo) {
        var resenas = resenasDao.findAll();
        return resenas;
    }

    @Override
    @Transactional(readOnly = true)
    public Resenas getResenas(Resenas resenas) {
        return resenasDao.findById(resenas.getIdResenas()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Resenas resenas) {
        resenasDao.save(resenas);
    }

    @Override
    @Transactional
    public void delete(Resenas resenas) {
        resenasDao.delete(resenas);
    }

}