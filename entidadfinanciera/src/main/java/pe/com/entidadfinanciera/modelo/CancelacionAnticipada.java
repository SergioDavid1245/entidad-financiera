package pe.com.entidadfinanciera.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CancelacionAnticipada")
public class CancelacionAnticipada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDepositoPlazo")
    private DepositoPlazo deposito;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaCancelacion")
    private Date fechaCancelacion;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "penalidadAplicada")
    private double penalidadAplicada;

    @Column(name = "montoDevuelto")
    private double montoDevuelto;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public DepositoPlazo getDeposito() { return deposito; }
    public void setDeposito(DepositoPlazo deposito) { this.deposito = deposito; }
    public Date getFechaCancelacion() { return fechaCancelacion; }
    public void setFechaCancelacion(Date fechaCancelacion) { this.fechaCancelacion = fechaCancelacion; }
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public double getPenalidadAplicada() { return penalidadAplicada; }
    public void setPenalidadAplicada(double penalidadAplicada) { this.penalidadAplicada = penalidadAplicada; }
    public double getMontoDevuelto() { return montoDevuelto; }
    public void setMontoDevuelto(double montoDevuelto) { this.montoDevuelto = montoDevuelto; }
}