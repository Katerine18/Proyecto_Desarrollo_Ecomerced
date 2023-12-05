package com.Tienda_Proyecto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Tienda_Proyecto.domain.Juegos;
import com.Tienda_Proyecto.dao.JuegosDao;
import com.Tienda_Proyecto.service.JuegosService;
import java.util.List;

@Service
public class JuegosServiceImpl implements JuegosService {

    @Autowired
    private JuegosDao juegosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Juegos> getAllJuegos() {
        return juegosDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Juegos getJuegoById(Long idJuego) {
        return juegosDao.findById(idJuego).orElse(null);
    }

    @Override
    @Transactional
    public void save(Juegos juego) {
        juegosDao.save(juego);
    }

    @Override
    @Transactional
    public void delete(Juegos juego) {
        juegosDao.delete(juego);
    }
}

