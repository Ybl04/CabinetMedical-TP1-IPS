package ma.fsr.tp1.cabinetmedical.dto;
import java.time.LocalDate;

public class CreateRendezVousRequest {
    private LocalDate dateRdv;
    private Long patientId;
    private Long medecinId;

    public LocalDate getDateRdv() { return dateRdv; }
    public void setDateRdv(LocalDate dateRdv) { this.dateRdv = dateRdv; }
    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }
    public Long getMedecinId() { return medecinId; }
    public void setMedecinId(Long medecinId) { this.medecinId = medecinId; }
}