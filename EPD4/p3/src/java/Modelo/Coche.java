package Modelo;
// Generated 07-mar-2018 13:08:35 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Coche generated by hbm2java
 */
public class Coche  implements java.io.Serializable {


     private Integer id;
     private String matricula;
     private String modelo;
     private Date horaEntrada;
     private Date horaSalida;
     private int tiempoPermitido;

    public Coche() {
    }

    public Coche(String matricula, String modelo, Date horaEntrada, Date horaSalida, int tiempoPermitido) {
       this.matricula = matricula;
       this.modelo = modelo;
       this.horaEntrada = horaEntrada;
       this.horaSalida = horaSalida;
       this.tiempoPermitido = tiempoPermitido;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getMatricula() {
        return this.matricula;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getModelo() {
        return this.modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public Date getHoraEntrada() {
        return this.horaEntrada;
    }
    
    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
    public Date getHoraSalida() {
        return this.horaSalida;
    }
    
    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }
    public int getTiempoPermitido() {
        return this.tiempoPermitido;
    }
    
    public void setTiempoPermitido(int tiempoPermitido) {
        this.tiempoPermitido = tiempoPermitido;
    }

    public boolean esSuperado() {
        boolean superado = false;
        if ((this.getHoraEntrada().getTime() + this.getTiempoPermitido() * 60000) < this.getHoraSalida().getTime()) {
            superado = true;
        }
        return superado;
    }


}


