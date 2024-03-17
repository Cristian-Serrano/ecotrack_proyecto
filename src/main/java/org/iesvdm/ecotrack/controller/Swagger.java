package org.iesvdm.ecotrack.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.ecotrack.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Slf4j
@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/data-api")
public class Swagger {
    @GetMapping(value={"","/"})
    public RedirectView mostrarSwagger() {
        return new RedirectView("http://localhost:8080/swagger-ui/index.html");
    }

    @GetMapping(value={"/explorer","/explorer/"})
    public RedirectView mostrarExplorer() {
        return new RedirectView("http://localhost:8080/data-api/explorer/index.html#uri=/data-api");
    }
}
