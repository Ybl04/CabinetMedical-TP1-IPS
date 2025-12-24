package ma.fsr.tp1.cabinetmedical.web;

import ma.fsr.tp1.cabinetmedical.model.Medecin;
import ma.fsr.tp1.cabinetmedical.service.MedecinService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/medecins")
public class MedecinController {
    private final MedecinService medecinService;

    public MedecinController(MedecinService medecinService) {
        this.medecinService = medecinService;
    }

    @PostMapping
    public Medecin create(@RequestBody Medecin medecin){ return medecinService.createMedecin(medecin); }

    @GetMapping
    public List<Medecin> getAll(){ return medecinService.listMedecins(); }
}