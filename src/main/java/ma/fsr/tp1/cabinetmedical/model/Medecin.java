package ma.fsr.tp1.cabinetmedical.model;

import jakarta.persistence.*;

@Entity
public class Medecin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String specialite;
    private String email;

    public Medecin() {}

    public Medecin(Long id, String nom, String specialite, String email) {
        this.id = id;
        this.nom = nom;
        this.specialite = specialite;
        this.email = email;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getSpecialite() { return specialite; }
    public void setSpecialite(String specialite) { this.specialite = specialite; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}