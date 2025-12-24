package ma.fsr.tp1.cabinetmedical.service;

import ma.fsr.tp1.cabinetmedical.repository.PatientRepository;
import ma.fsr.tp1.cabinetmedical.model.Patient;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientService {
    private final PatientRepository repo;

    // Constructeur manuel
    public PatientService(PatientRepository repo) {
        this.repo = repo;
    }

    public Patient createPatient(Patient p) {
        if (p.getNom() == null || p.getNom().isBlank()) {
            throw new IllegalArgumentException("Le nom est obligatoire.");
        }
        return repo.save(p);
    }

    public List<Patient> ListPatients() {
        return repo.findAll();
    }
}