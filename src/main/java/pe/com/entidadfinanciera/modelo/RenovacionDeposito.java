package pe.com.entidadfinanciera.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RenovacionDeposito")
public class RenovacionDeposito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDepositoPlazo")
    private DepositoPlazo deposito;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaRenovacion")
    private Date fechaRenovacion;

    @Column(name = "nuevoPlazoDias")
    private int nuevoPlazoDias;

    @Column(name = "nuevaTasaInteres")
    private double nuevaTasaInteres;

    @Column(name = "observaciones")
    private String observaciones;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public DepositoPlazo getDeposito() { return deposito; }
    public void setDeposito(DepositoPlazo deposito) { this.deposito = deposito; }
    public Date getFechaRenovacion() { return fechaRenovacion; }
    public void setFechaRenovacion(Date fechaRenovacion) { this.fechaRenovacion = fechaRenovacion; }
    public int getNuevoPlazoDias() { return nuevoPlazoDias; }
    public void setNuevoPlazoDias(int nuevoPlazoDias) { this.nuevoPlazoDias = nuevoPlazoDias; }
    public double getNuevaTasaInteres() { return nuevaTasaInteres; }
    public void setNuevaTasaInteres(double nuevaTasaInteres) { this.nuevaTasaInteres = nuevaTasaInteres; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}
