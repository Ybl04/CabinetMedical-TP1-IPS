package ma.fsr.tp1.cabinetmedical.service;

import ma.fsr.tp1.cabinetmedical.model.Medecin;
import ma.fsr.tp1.cabinetmedical.model.Patient;
import ma.fsr.tp1.cabinetmedical.model.RendezVous;
import ma.fsr.tp1.cabinetmedical.repository.MedecinRepository;
import ma.fsr.tp1.cabinetmedical.repository.PatientRepository;
import ma.fsr.tp1.cabinetmedical.repository.RendezVousRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class RendezVousService {
    private final RendezVousRepository repo;
    private final PatientRepository patientRepository;
    private final MedecinRepository medecinRepository;

    public RendezVousService(RendezVousRepository repo, PatientRepository patientRepository, MedecinRepository medecinRepository) {
        this.repo = repo;
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
    }

    public RendezVous createRendezVous(LocalDate dateRdv, Long patientId, Long medecinId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Patient introuvable"));
        Medecin medecin = medecinRepository.findById(medecinId)
                .orElseThrow(() -> new IllegalArgumentException("Médecin introuvable"));

        RendezVous rdv = new RendezVous(null, dateRdv, "EN_ATTENTE", patient, medecin);
        return repo.save(rdv);
    }

    public List<RendezVous> listRendezVous() { return repo.findAll(); }
}