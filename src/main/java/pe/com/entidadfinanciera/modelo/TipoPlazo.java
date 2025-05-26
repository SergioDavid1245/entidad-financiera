package pe.com.entidadfinanciera.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "TIPOPLAZO")
public class TipoPlazo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "diasDuracion")
    private int diasDuracion;

    @Column(name = "tasaInteresBase")
    private double tasaInteresBase;

    @OneToMany(mappedBy = "tipoPlazo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DepositoPlazo> depositos;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public int getDiasDuracion() { return diasDuracion; }
    public void setDiasDuracion(int diasDuracion) { this.diasDuracion = diasDuracion; }
    public double getTasaInteresBase() { return tasaInteresBase; }
    public void setTasaInteresBase(double tasaInteresBase) { this.tasaInteresBase = tasaInteresBase; }
    public List<DepositoPlazo> getDepositos() { return depositos; }
    public void setDepositos(List<DepositoPlazo> depositos) { this.depositos = depositos; }
}
