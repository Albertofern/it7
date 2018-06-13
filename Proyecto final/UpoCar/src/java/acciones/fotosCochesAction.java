/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletContext;
import modelo.FotoVehiDAO;
import modelo.VehiculoDAO;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import webServiceREST.entidades.FotoVehi;
import webServiceREST.entidades.Vehiculo;

public class fotosCochesAction extends ActionSupport {
    
    //Mis coches
    List<Vehiculo> listaCoches = new ArrayList<Vehiculo>();
    String idCoche;
    String marca;
    String modelo;
    String color;
    String plazas;
    File fotoCoche;
    String idFotoVehi;
    
    
    public fotosCochesAction() {
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    /*
    Devuelve una lista de coches para mostrarlo en la vista
    */
    public String toModificarCoche(){
        // Creo un objeto VehiculoDAO y recibo un objeto Vehiculo
        VehiculoDAO vDao = new VehiculoDAO();
        Vehiculo v = vDao.getVehiculoPorId(this.getIdCoche());
        FotoVehiDAO fDAO = new FotoVehiDAO();
        v.setListaFotosVehiculos(fDAO.fotosVehiculo(this.getIdCoche()));
        this.getListaCoches().clear();
        this.getListaCoches().add(v);
        
        return SUCCESS;
    }
    
    /*
    Obtiene un vehiculo
    Genera un nuemro aleatorio entre 1 y 6
    Genera otro numero alatorio entre 1 y 10000 y lo multiplica por el anterior
    Genera un nombre de fichero con el id y el modelo del coche mas el valor aleatorio anterior
    Genera ruta relativa
    Copia foto del temporal y fichero
    Actualiza la foto en la base de datos
    Llama al metodo toModificarCoche
    */
    public String agregarFotoCoche() throws IOException{
        // Creo un objeto VehiculoDAO y recibo un objeto Vehiculo
        VehiculoDAO vDao = new VehiculoDAO();
        Vehiculo v = vDao.getVehiculoPorId(this.getIdCoche());
        //Creo ServletContext
        ServletContext context = ServletActionContext.getServletContext();
        
        Random r = new Random();
        int valorDadoAleatorio = r.nextInt(6)+1;
        int valorGrandeAleatorio = (r.nextInt(9999)+1) * valorDadoAleatorio;
        
        String nombreFichero = v.getIdVehiculo() + v.getModelo() + valorGrandeAleatorio + ".png";
        String rutaRelativa = "images/fotosCoches/" + nombreFichero;
        String ruta = context.getRealPath("/") + rutaRelativa;
        File fichero = new File(ruta);
        FileUtils.copyFile(this.getFotoCoche(), fichero);

        FotoVehi f = new FotoVehi(v, "./"+rutaRelativa);
        FotoVehiDAO fDAO = new FotoVehiDAO();
        fDAO.createFotoVehi(f);
        //Llamo al metodo toModificarCoche() para recargar la pagina de listado de coches
        this.toModificarCoche();
        return SUCCESS;
    }
    /*
    Elimina de la base de datos la foto del coche pasado por id
    Llama al metodo toModificarCoche
    */
    public String eliminarFotoCoche(){
        // Creo un objeto FotoVehiDAO y le paso el idFotoVehi para eliminarlo
        FotoVehiDAO fDAO = new FotoVehiDAO();
        fDAO.deleteFotoVehi(this.getIdFotoVehi());
        //Llamo al metodo toModificarCoche() para recargar la pagina
        this.toModificarCoche();
        return SUCCESS;
    }
            
    /* Getter y setter */        
    
    public List<Vehiculo> getListaCoches() {
        return listaCoches;
    }

    public void setListaCoches(List<Vehiculo> listaCoches) {
        this.listaCoches = listaCoches;
    }

    public String getIdCoche() {
        return idCoche;
    }

    public void setIdCoche(String idCoche) {
        this.idCoche = idCoche;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlazas() {
        return plazas;
    }

    public void setPlazas(String plazas) {
        this.plazas = plazas;
    }

    public File getFotoCoche() {
        return fotoCoche;
    }

    public void setFotoCoche(File fotoCoche) {
        this.fotoCoche = fotoCoche;
    }

    public String getIdFotoVehi() {
        return idFotoVehi;
    }

    public void setIdFotoVehi(String idFotoVehi) {
        this.idFotoVehi = idFotoVehi;
    }
    
}
