package ma.fsr.tp1.cabinetmedical.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class RendezVous {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateRdv;
    private String status;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;

    public RendezVous() {}

    public RendezVous(Long id, LocalDate dateRdv, String status, Patient patient, Medecin medecin) {
        this.id = id;
        this.dateRdv = dateRdv;
        this.status = status;
        this.patient = patient;
        this.medecin = medecin;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getDateRdv() { return dateRdv; }
    public void setDateRdv(LocalDate dateRdv) { this.dateRdv = dateRdv; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
    public Medecin getMedecin() { return medecin; }
    public void setMedecin(Medecin medecin) { this.medecin = medecin; }
}