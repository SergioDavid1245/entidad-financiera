package pe.com.entidadfinanciera.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Banquero")
public class Banquero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "emailCorporativo")
    private String emailCorporativo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "cargo")
    private String cargo;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaIngreso")
    private Date fechaIngreso;

    @Column(name = "activo")
    private boolean activo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idOficina")
    private Oficina oficina;

    @OneToMany(mappedBy = "banquero", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DepositoPlazo> depositos;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getEmailCorporativo() { return emailCorporativo; }
    public void setEmailCorporativo(String emailCorporativo) { this.emailCorporativo = emailCorporativo; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    public Date getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(Date fechaIngreso) { this.fechaIngreso = fechaIngreso; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
    public Oficina getOficina() { return oficina; }
    public void setOficina(Oficina oficina) { this.oficina = oficina; }
    public List<DepositoPlazo> getDepositos() { return depositos; }
    public void setDepositos(List<DepositoPlazo> depositos) { this.depositos = depositos; }
}
