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
@Table(name = "puntuacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puntuacion.findAll", query = "SELECT p FROM Puntuacion p")
    , @NamedQuery(name = "Puntuacion.findByIdPuntuacion", query = "SELECT p FROM Puntuacion p WHERE p.idPuntuacion = :idPuntuacion")
    , @NamedQuery(name = "Puntuacion.findByPuntuacion", query = "SELECT p FROM Puntuacion p WHERE p.puntuacion = :puntuacion")
    , @NamedQuery(name = "Puntuacion.findByComentario", query = "SELECT p FROM Puntuacion p WHERE p.comentario = :comentario")})
public class Puntuacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_puntuacion")
    private Integer idPuntuacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntuacion")
    private int puntuacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "comentario")
    private String comentario;
    @JoinColumn(name = "id_usuario_puntua", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioPuntua;
    @JoinColumn(name = "id_usuario_recibe", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioRecibe;

    public Puntuacion() {
    }

    public Puntuacion(Integer idPuntuacion) {
        this.idPuntuacion = idPuntuacion;
    }

    public Puntuacion(Integer idPuntuacion, int puntuacion, String comentario) {
        this.idPuntuacion = idPuntuacion;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
    }

    public Integer getIdPuntuacion() {
        return idPuntuacion;
    }

    public void setIdPuntuacion(Integer idPuntuacion) {
        this.idPuntuacion = idPuntuacion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getIdUsuarioPuntua() {
        return idUsuarioPuntua;
    }

    public void setIdUsuarioPuntua(Usuario idUsuarioPuntua) {
        this.idUsuarioPuntua = idUsuarioPuntua;
    }

    public Usuario getIdUsuarioRecibe() {
        return idUsuarioRecibe;
    }

    public void setIdUsuarioRecibe(Usuario idUsuarioRecibe) {
        this.idUsuarioRecibe = idUsuarioRecibe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPuntuacion != null ? idPuntuacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puntuacion)) {
            return false;
        }
        Puntuacion other = (Puntuacion) object;
        if ((this.idPuntuacion == null && other.idPuntuacion != null) || (this.idPuntuacion != null && !this.idPuntuacion.equals(other.idPuntuacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webServiceREST.entidades.Puntuacion[ idPuntuacion=" + idPuntuacion + " ]";
    }
    
}
