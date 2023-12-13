package com.Tienda_Proyecto.controller;

import com.Tienda_Proyecto.domain.Resenas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.Tienda_Proyecto.service.ResenasService;

@Controller
@RequestMapping("/Resenas")
public class ResenasController {

    @Autowired
    private ResenasService resenasService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var resenas = resenasService.getResenas(false);
        model.addAttribute("resenas", resenas);
        model.addAttribute("totalResenas", resenas.size());
        return "/Resenas/listado";
    }

    @GetMapping("/nuevo")
    public String resenaNuevo(Resenas resenas) {
        return "/Resenas/modifica";
    }

    @PostMapping("/guardar")
    public String resenaGuardar(Resenas resena) {
        resenasService.save(resena);
        return "redirect:/Resenas/listado";
    }
   

    @GetMapping("/eliminar/{idResenas}")
    public String resenaEliminar(Resenas resena) 
        {
        resenasService.delete(resena);
        return "redirect:/Resenas/listado";
    }

    @GetMapping("/modificar/{idResenas}")
    public String resenaModificar(Resenas resena, Model model) {
        resena = resenasService.getResenas(resena);
        model.addAttribute("resenas", resena);
        return "/Resenas/modifica";
    }
}
