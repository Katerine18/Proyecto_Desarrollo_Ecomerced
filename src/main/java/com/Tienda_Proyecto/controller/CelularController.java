package com.Tienda_Proyecto.controller;

import com.Tienda_Proyecto.domain.Celular;
import com.Tienda_Proyecto.service.CategoriaService;
import com.Tienda_Proyecto.service.CelularService;
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
@RequestMapping("/celular")
public class CelularController {

    @Autowired
    private CelularService celularService;
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var celulars = celularService.getCelulars(false);
        model.addAttribute("celulars", celulars);
        model.addAttribute("totalCelulars", celulars.size());
        
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        return "/celular/listado";
    }

    @GetMapping("/nuevo")
    public String celularNuevo(Celular celular) {
        return "/celular/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String celularGuardar(Celular celular,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            celularService.save(celular);
            celular.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "celular",
                            celular.getIdCelular()));
        }
        celularService.save(celular);
        return "redirect:/celular/listado";
    }

    @GetMapping("/eliminar/{idCelular}")
    public String celularEliminar(Celular celular) {
        celularService.delete(celular);
        return "redirect:/celular/listado";
    }

    @GetMapping("/modificar/{idCelular}")
    public String celularModificar(Celular celular, Model model) {
        celular = celularService.getCelular(celular);
        model.addAttribute("celular", celular);
        return "/celular/modifica";
    }
}