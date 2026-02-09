package ingrid.com.libreria.controller;

import ingrid.com.libreria.libros.Libro;
import ingrid.com.libreria.libros.LibroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;

    // LISTAR LIBROS
    @GetMapping({"/", "/listaLibros"})
    public String inicio(Model model) {
        model.addAttribute("listaLibros", libroRepository.findAll());
        return "listaLibros";
    }

    // FORMULARIO NUEVO LIBRO
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("libro", new Libro());
        return "Libro";
    }

    // GUARDAR LIBRO
    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute Libro libro) {
        libroRepository.save(libro);
        return "redirect:/listaLibros";
    }

    // BUSCAR LIBROS
    @GetMapping("/buscar")
    public String buscarLibros(@RequestParam("criterio") String criterio, Model model) {

        if (criterio == null || criterio.trim().isEmpty()) {
            model.addAttribute("listaLibros", libroRepository.findAll());
        } else {
            model.addAttribute("listaLibros",
                    libroRepository.buscarPorTodo(criterio));
        }

        return "listaLibros";
    }

    // EDITAR LIBRO
    @GetMapping("/editar/{id}")
    public String editarLibro(@PathVariable Long id, Model model) {

        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id inválido: " + id));

        model.addAttribute("libro", libro);
        return "Libro";
    }

    // ELIMINAR LIBRO
    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable Long id) {
        libroRepository.deleteById(id);
        return "redirect:/listaLibros";
    }
}
