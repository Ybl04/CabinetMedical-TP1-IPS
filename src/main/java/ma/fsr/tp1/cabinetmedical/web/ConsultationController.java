package ma.fsr.tp1.cabinetmedical.web;

import ma.fsr.tp1.cabinetmedical.model.Consultation;
import ma.fsr.tp1.cabinetmedical.service.ConsultationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/consultations")
public class ConsultationController {
    private final ConsultationService consultationService;

    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @PostMapping("create-from/{rdvId}")
    public Consultation addConsultation(@RequestBody String rapport, @PathVariable("rdvId") Long rdvId ){
        return consultationService.saveConsultation(rdvId, rapport);
    }
}