package com.test01.test01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = {"/countries"})
public class CountrieController {

    // valor del server.port, del archivo properties
    @Value("${server.port}")
    private String port;

    // valor del spring.datasource.url, del archivo properties
    @Value("${spring.datasource.url}")
    private String urldb;

    @Autowired
    @Qualifier("lista2") // especifica el bean declarado en el contexto de spring
    private List<String> list;

    @Autowired
    private Component01 component01;

    @Autowired
    private CountrieRepository countrieRepository;
    
    @GetMapping(value = {"/inicio"})
    public String inicio(
        Model model,
        HttpServletRequest request,
        @RequestParam(value = "id", required = false, defaultValue = "0") int id,
        @RequestParam(value = "name", required = false, defaultValue = "") String name
    ) {
        model.addAttribute("componente", component01);

        // elementos del properties agregados como atributos al modelo
        model.addAttribute("port", port);
        model.addAttribute("urldb", urldb);

        model.addAttribute("ruta_actual", request.getRequestURI());
        model.addAttribute("param_id", id);
        model.addAttribute("param_name", name);
        model.addAttribute("lista", countrieRepository.findAll());
        model.addAttribute("lista_filtrada", countrieRepository.findByIdAndNameStartingWithIgnoreCase(id, name));
        model.addAttribute("nuevo_countrie", new Countrie());

        System.out.println("List: " + list);
        return "countries";
    }

    @PostMapping(value = {"/inicio/nuevo"})
    public String nuevo(Countrie countrie){
        System.out.println("countrie: " + countrie.getName());
        return "redirect:/countries/inicio";
    }
}
