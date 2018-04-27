package modelo;
// Generated 27-abr-2018 5:50:38 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Provincia generated by hbm2java
 */
public class Provincia  implements java.io.Serializable {


     private Integer idProvincia;
     private String nombre;
     private Set localidads = new HashSet(0);

    public Provincia() {
    }

	
    public Provincia(String nombre) {
        this.nombre = nombre;
    }
    public Provincia(String nombre, Set localidads) {
       this.nombre = nombre;
       this.localidads = localidads;
    }
   
    public Integer getIdProvincia() {
        return this.idProvincia;
    }
    
    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getLocalidads() {
        return this.localidads;
    }
    
    public void setLocalidads(Set localidads) {
        this.localidads = localidads;
    }




}


