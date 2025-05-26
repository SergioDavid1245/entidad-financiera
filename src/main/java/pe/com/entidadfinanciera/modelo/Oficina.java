package pe.com.entidadfinanciera.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Oficina")
public class Oficina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @OneToMany(mappedBy = "oficina", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Banquero> banqueros;

    @OneToMany(mappedBy = "oficina", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DepositoPlazo> depositos;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public List<Banquero> getBanqueros() { return banqueros; }
    public void setBanqueros(List<Banquero> banqueros) { this.banqueros = banqueros; }
    public List<DepositoPlazo> getDepositos() { return depositos; }
    public void setDepositos(List<DepositoPlazo> depositos) { this.depositos = depositos; }
}