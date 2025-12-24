package ma.fsr.tp1.cabinetmedical.service;

import ma.fsr.tp1.cabinetmedical.model.Consultation;
import ma.fsr.tp1.cabinetmedical.model.RendezVous;
import ma.fsr.tp1.cabinetmedical.repository.ConsultationRepository;
import ma.fsr.tp1.cabinetmedical.repository.RendezVousRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class ConsultationService {
    private final ConsultationRepository consultationRepository;
    private final RendezVousRepository rendezVousRepository;

    public ConsultationService(ConsultationRepository consultationRepository, RendezVousRepository rendezVousRepository) {
        this.consultationRepository = consultationRepository;
        this.rendezVousRepository = rendezVousRepository;
    }

    public Consultation saveConsultation(Long rendezVousId, String rapport) {
        RendezVous rendezVous = rendezVousRepository.findById(rendezVousId)
                .orElseThrow(() -> new IllegalArgumentException("Rendez-vous introuvable"));

        if (consultationRepository.findByRendezVous(rendezVous).isPresent()) {
            throw new IllegalStateException("Consultation déjà existante");
        }

        Consultation consultation = new Consultation();
        consultation.setDateConsultation(LocalDate.now());
        consultation.setRapport(rapport);
        consultation.setRendezVous(rendezVous);

        rendezVous.setStatus("CONSULTE");
        rendezVousRepository.save(rendezVous);

        return consultationRepository.save(consultation);
    }
}