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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gonza
 */
@Entity
@Table(name = "telefono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefono.findAll", query = "SELECT t FROM Telefono t")
    , @NamedQuery(name = "Telefono.findByIdTel", query = "SELECT t FROM Telefono t WHERE t.idTel = :idTel")
    , @NamedQuery(name = "Telefono.findByNumTel", query = "SELECT t FROM Telefono t WHERE t.numTel = :numTel")})
public class Telefono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tel")
    private Integer idTel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_tel")
    private int numTel;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Telefono() {
    }

    public Telefono(Integer idTel) {
        this.idTel = idTel;
    }

    public Telefono(Integer idTel, int numTel) {
        this.idTel = idTel;
        this.numTel = numTel;
    }

    public Integer getIdTel() {
        return idTel;
    }

    public void setIdTel(Integer idTel) {
        this.idTel = idTel;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTel != null ? idTel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefono)) {
            return false;
        }
        Telefono other = (Telefono) object;
        if ((this.idTel == null && other.idTel != null) || (this.idTel != null && !this.idTel.equals(other.idTel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webServiceREST.entidades.Telefono[ idTel=" + idTel + " ]";
    }
    
}
