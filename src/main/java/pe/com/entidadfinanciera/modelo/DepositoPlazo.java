package pe.com.entidadfinanciera.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "DepositoPlazo")
public class DepositoPlazo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idBanquero")
    private Banquero banquero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idOficina")
    private Oficina oficina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoPlazo")
    private TipoPlazo tipoPlazo;

    @Column(name = "monto")
    private double monto;

    @Column(name = "tasaInteres")
    private double tasaInteres;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaInicio")
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaVencimiento")
    private Date fechaVencimiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estado estado;

    @Column(name = "interesProyectado")
    private double interesProyectado;

    @OneToOne(mappedBy = "deposito", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CancelacionAnticipada cancelacion;

    @OneToMany(mappedBy = "deposito", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RenovacionDeposito> renovaciones;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Banquero getBanquero() { return banquero; }
    public void setBanquero(Banquero banquero) { this.banquero = banquero; }
    public Oficina getOficina() { return oficina; }
    public void setOficina(Oficina oficina) { this.oficina = oficina; }
    public TipoPlazo getTipoPlazo() { return tipoPlazo; }
    public void setTipoPlazo(TipoPlazo tipoPlazo) { this.tipoPlazo = tipoPlazo; }
    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }
    public double getTasaInteres() { return tasaInteres; }
    public void setTasaInteres(double tasaInteres) { this.tasaInteres = tasaInteres; }
    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }
    public Date getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(Date fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }
    public double getInteresProyectado() { return interesProyectado; }
    public void setInteresProyectado(double interesProyectado) { this.interesProyectado = interesProyectado; }
    public CancelacionAnticipada getCancelacion() { return cancelacion; }
    public void setCancelacion(CancelacionAnticipada cancelacion) { this.cancelacion = cancelacion; }
    public List<RenovacionDeposito> getRenovaciones() { return renovaciones; }
    public void setRenovaciones(List<RenovacionDeposito> renovaciones) { this.renovaciones = renovaciones; }
}