package com.Tienda_Proyecto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Tienda_Proyecto.domain.Monitor;
import com.Tienda_Proyecto.dao.MonitorDao;
import com.Tienda_Proyecto.service.MonitorService;
import java.util.List;

@Service
public class MonitorServiceImpl implements MonitorService {

    @Autowired
    private MonitorDao monitorDao;

    @Override
    @Transactional(readOnly = true)
    public List<Monitor> getMonitores(boolean activo) {
        return monitorDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Monitor getMonitor(Monitor monitor) {
        return monitorDao.findById(monitor.getIdMonitor()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Monitor monitor) {
        monitorDao.save(monitor);
    }

    @Override
    @Transactional
    public void delete(Monitor monitor) {
        monitorDao.delete(monitor);
    }
    
    // Ejemplo de una consulta con un Query
    @Override
    @Transactional(readOnly = true)
    public List<Monitor> consultaQuery(double precioInf, double precioSup) {
        return monitorDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
    
    // Ejemplo de una consulta con un Query
    @Override
    @Transactional(readOnly = true)
    public List<Monitor> consultaJPQL(double precioInf, double precioSup) {
        return monitorDao.consultaJPQL(precioInf, precioSup);
    }
}