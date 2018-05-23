/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServiceREST.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gonza
 */
@Entity
@Table(name = "viaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Viaje.findAll", query = "SELECT v FROM Viaje v")
    , @NamedQuery(name = "Viaje.findByIdViaje", query = "SELECT v FROM Viaje v WHERE v.idViaje = :idViaje")
    , @NamedQuery(name = "Viaje.findByPuntoRecogida", query = "SELECT v FROM Viaje v WHERE v.puntoRecogida = :puntoRecogida")
    , @NamedQuery(name = "Viaje.findByPlazasMax", query = "SELECT v FROM Viaje v WHERE v.plazasMax = :plazasMax")
    , @NamedQuery(name = "Viaje.findByPercioPersona", query = "SELECT v FROM Viaje v WHERE v.percioPersona = :percioPersona")
    , @NamedQuery(name = "Viaje.findByFechaSalida", query = "SELECT v FROM Viaje v WHERE v.fechaSalida = :fechaSalida")})
public class Viaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_viaje")
    private Integer idViaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "punto_recogida")
    private String puntoRecogida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plazas_max")
    private int plazasMax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "percio_persona")
    private double percioPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "fecha_salida")
    private String fechaSalida;
    @JoinTable(name = "pasajeros", joinColumns = {
        @JoinColumn(name = "id_viaje", referencedColumnName = "id_viaje")}, inverseJoinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToMany
    private Collection<Usuario> usuarioCollection;
    @JoinColumn(name = "id_localidad_destino", referencedColumnName = "id_localidad")
    @ManyToOne(optional = false)
    private Localidad idLocalidadDestino;
    @JoinColumn(name = "id_localidad_origen", referencedColumnName = "id_localidad")
    @ManyToOne(optional = false)
    private Localidad idLocalidadOrigen;
    @JoinColumn(name = "id_usuario_publica", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioPublica;
    @JoinColumn(name = "id_vehiculo_elegido", referencedColumnName = "id_vehiculo")
    @ManyToOne(optional = false)
    private Vehiculo idVehiculoElegido;

    public Viaje() {
    }

    public Viaje(Integer idViaje) {
        this.idViaje = idViaje;
    }

    public Viaje(Integer idViaje, String puntoRecogida, int plazasMax, double percioPersona, String fechaSalida) {
        this.idViaje = idViaje;
        this.puntoRecogida = puntoRecogida;
        this.plazasMax = plazasMax;
        this.percioPersona = percioPersona;
        this.fechaSalida = fechaSalida;
    }

    public Integer getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(Integer idViaje) {
        this.idViaje = idViaje;
    }

    public String getPuntoRecogida() {
        return puntoRecogida;
    }

    public void setPuntoRecogida(String puntoRecogida) {
        this.puntoRecogida = puntoRecogida;
    }

    public int getPlazasMax() {
        return plazasMax;
    }

    public void setPlazasMax(int plazasMax) {
        this.plazasMax = plazasMax;
    }

    public double getPercioPersona() {
        return percioPersona;
    }

    public void setPercioPersona(double percioPersona) {
        this.percioPersona = percioPersona;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    public Localidad getIdLocalidadDestino() {
        return idLocalidadDestino;
    }

    public void setIdLocalidadDestino(Localidad idLocalidadDestino) {
        this.idLocalidadDestino = idLocalidadDestino;
    }

    public Localidad getIdLocalidadOrigen() {
        return idLocalidadOrigen;
    }

    public void setIdLocalidadOrigen(Localidad idLocalidadOrigen) {
        this.idLocalidadOrigen = idLocalidadOrigen;
    }

    public Usuario getIdUsuarioPublica() {
        return idUsuarioPublica;
    }

    public void setIdUsuarioPublica(Usuario idUsuarioPublica) {
        this.idUsuarioPublica = idUsuarioPublica;
    }

    public Vehiculo getIdVehiculoElegido() {
        return idVehiculoElegido;
    }

    public void setIdVehiculoElegido(Vehiculo idVehiculoElegido) {
        this.idVehiculoElegido = idVehiculoElegido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idViaje != null ? idViaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viaje)) {
            return false;
        }
        Viaje other = (Viaje) object;
        if ((this.idViaje == null && other.idViaje != null) || (this.idViaje != null && !this.idViaje.equals(other.idViaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webServiceREST.entidades.Viaje[ idViaje=" + idViaje + " ]";
    }
    
}
