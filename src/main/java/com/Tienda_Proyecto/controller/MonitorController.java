package com.Tienda_Proyecto.controller;

import com.Tienda_Proyecto.domain.Monitor;
import com.Tienda_Proyecto.service.CategoriaService;
import com.Tienda_Proyecto.service.MonitorService;
import com.Tienda_Proyecto.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/monitor")
public class MonitorController {

    @Autowired
    private MonitorService monitorService;
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var monitores = monitorService.getMonitores(false);
        model.addAttribute("monitores", monitores);
        model.addAttribute("totalMonitores", monitores.size());
        
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        return "/monitor/listado";
    }

    @GetMapping("/nuevo")
    public String monitorNuevo(Monitor monitor) {
        return "/monitor/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String monitorGuardar(Monitor monitor,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            monitorService.save(monitor);
            monitor.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "monitor",
                            monitor.getIdMonitor()));
        }
        monitorService.save(monitor);
        return "redirect:/monitor/listado";
    }

    @GetMapping("/eliminar/{idMonitor}")
    public String monitorEliminar(Monitor monitor) {
        monitorService.delete(monitor);
        return "redirect:/monitor/listado";
    }

    @GetMapping("/modificar/{idMonitor}")
    public String monitorModificar(Monitor monitor, Model model) {
        monitor = monitorService.getMonitor(monitor);
        model.addAttribute("monitor", monitor);
        return "/monitor/modifica";
    }
}