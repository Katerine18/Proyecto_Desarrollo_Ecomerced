package com.Tienda_Proyecto.controller;

import com.Tienda_Proyecto.domain.Inicio;
import com.Tienda_Proyecto.service.InicioService;
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
@RequestMapping("/inicio")
public class InicioController {

    @Autowired
    private InicioService inicioService;

    @GetMapping("/nuevo")
    public String InicioNuevo(Inicio inicio) {
        return "/inicio/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String categoriaGuardar(Inicio inicio,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            inicioService.save(inicio);
            inicio.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "categoria",
                            inicio.getIdCategoria()));
        }
        inicioService.save(inicio);
        return "redirect:/inicio/inicio_sesion";
    }

    @GetMapping("/eliminar/{idCategoria}")
    public String categoriaEliminar(Inicio inicio) {
        inicioService.delete(inicio);
        return "redirect:/inicio/inicio_sesion";
    }

    @GetMapping("/modificar/{idCategoria}")
    public String categoriaModificar(Inicio inicio, Model model) {
        inicio = inicioService.getCategoria(inicio);
        model.addAttribute("inicio", inicio);
        return "/inici/modifica";
    }
}
