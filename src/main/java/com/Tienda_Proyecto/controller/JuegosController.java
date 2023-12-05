package com.Tienda_Proyecto.controller;
import com.Tienda_Proyecto.domain.Juegos;
import com.Tienda_Proyecto.service.JuegosService;
import com.Tienda_Proyecto.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/Juegos")
public class JuegosController {

    @Autowired
    private JuegosService juegosService;

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var juegos = juegosService.getAllJuegos();
        model.addAttribute("juegos", juegos);
        model.addAttribute("totalJuegos", juegos.size());
        return "/Juegos/listado";
    }

    @GetMapping("/nuevo")
    public String juegoNuevo(Juegos juego) {
        return "/Juegos/modifica";
    }

    @PostMapping("/guardar")
    public String juegoGuardar(Juegos juego, @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            juegosService.save(juego);
            juego.setRutaImagen(firebaseStorageService.cargaImagen(imagenFile, "Juegos", juego.getIdProducto()));
        }
        juegosService.save(juego);
        return "redirect:/Juegos/listado";
    }

    @GetMapping("/eliminar/{idJuego}")
    public String juegoEliminar(@PathVariable("idJuego") Long idJuego) {
        Juegos juego = juegosService.getJuegoById(idJuego);
        juegosService.delete(juego);
        return "redirect:/Juegos/listado";
    }

    @GetMapping("/modificar/{idJuego}")
    public String juegoModificar(@PathVariable("idJuego") Long idJuego, Model model) {
        Juegos juego = juegosService.getJuegoById(idJuego);
        model.addAttribute("juego", juego);
        return "/Juegos/modifica";
    }
}
