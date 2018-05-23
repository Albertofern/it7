/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServiceREST.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gonza
 */
@Entity
@Table(name = "foto_vehi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FotoVehi.findAll", query = "SELECT f FROM FotoVehi f")
    , @NamedQuery(name = "FotoVehi.findByIdFotoVehi", query = "SELECT f FROM FotoVehi f WHERE f.idFotoVehi = :idFotoVehi")
    , @NamedQuery(name = "FotoVehi.findByRutaFoto", query = "SELECT f FROM FotoVehi f WHERE f.rutaFoto = :rutaFoto")})
public class FotoVehi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_foto_vehi")
    private Integer idFotoVehi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ruta_foto")
    private String rutaFoto;
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo")
    @ManyToOne(optional = false)
    private Vehiculo idVehiculo;

    public FotoVehi() {
    }

    public FotoVehi(Integer idFotoVehi) {
        this.idFotoVehi = idFotoVehi;
    }

    public FotoVehi(Integer idFotoVehi, String rutaFoto) {
        this.idFotoVehi = idFotoVehi;
        this.rutaFoto = rutaFoto;
    }

    public Integer getIdFotoVehi() {
        return idFotoVehi;
    }

    public void setIdFotoVehi(Integer idFotoVehi) {
        this.idFotoVehi = idFotoVehi;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    public Vehiculo getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Vehiculo idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFotoVehi != null ? idFotoVehi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FotoVehi)) {
            return false;
        }
        FotoVehi other = (FotoVehi) object;
        if ((this.idFotoVehi == null && other.idFotoVehi != null) || (this.idFotoVehi != null && !this.idFotoVehi.equals(other.idFotoVehi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webServiceREST.entidades.FotoVehi[ idFotoVehi=" + idFotoVehi + " ]";
    }
    
}
