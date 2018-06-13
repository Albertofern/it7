/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import modelo.FotoVehiDAO;
import modelo.MensajeDAO;
import modelo.PasajeroDAO;
import modelo.UsuarioDAO;
import modelo.VehiculoDAO;
import modelo.ViajeDAO;
import webServiceREST.entidades.Mensaje;
import webServiceREST.entidades.Pasajeros;
import webServiceREST.entidades.Usuario;
import webServiceREST.entidades.Viaje;

/**
 *
 * @author Antonio Jose Herrera Tabaco
 */
public class buscaViajeAction extends ActionSupport {

    private String origen;
    private String destino;
    private String fechaHora;
    private int plazas;
    private double precio;
    private List listadoViajes;
    private List listadoFotos;
    private String idViaje;
    private String idUsuario;
    MensajeDAO mensajeDao = new MensajeDAO();
    UsuarioDAO usuarioDao = new UsuarioDAO();

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(String idViaje) {
        this.idViaje = idViaje;
    }

    ViajeDAO viajeDao = new ViajeDAO();
    VehiculoDAO vehiculoDao = new VehiculoDAO();
    PasajeroDAO pasajeroDao = new PasajeroDAO();
    FotoVehiDAO fotoDao = new FotoVehiDAO();

    public List getListadoFotos() {
        return listadoFotos;
    }

    public void setListadoFotos(List listadoFotos) {
        this.listadoFotos = listadoFotos;
    }

    public List getListadoViajes() {
        return listadoViajes;
    }

    public void setListadoViajes(List listadoViajes) {
        this.listadoViajes = listadoViajes;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public buscaViajeAction() {
    }

    public String buscaViaje() throws ParseException {
        if (!fechaHora.equals("")) {
            Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(fechaHora);
            String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);

            List listadoProvisional = viajeDao.buscaViaje(origen, destino, formattedDate);
            List listaFinal = new ArrayList();

            for (int i = 0; i < listadoProvisional.size(); i++) { //Muestro todos los viajes que tengan plazas disponibles
                Viaje v = (Viaje) listadoProvisional.get(i);

                if (v.getPlazasMax() > pasajeroDao.listarPasajeros(v.getIdViaje()).size()) {
                    v.setFotosVehiculo(fotoDao.fotosVehiculo(String.valueOf(v.getIdVehiculoElegido().getIdVehiculo())));
                    v.setListaPasajeros(pasajeroDao.listarPasajeros(v.getIdViaje()));
                    listaFinal.add(v);
                }
            }
            listadoViajes = listaFinal;

        } else {
            List listadoProvisional = viajeDao.listarViajes();
            List listaFinal = new ArrayList();
            for (int i = 0; i < listadoProvisional.size(); i++) {
                Viaje v = (Viaje) listadoProvisional.get(i);

                if (v.getPlazasMax() > pasajeroDao.listarPasajeros(v.getIdViaje()).size()) {
                    v.setFotosVehiculo(fotoDao.fotosVehiculo(String.valueOf(v.getIdVehiculoElegido().getIdVehiculo())));
                    v.setListaPasajeros(pasajeroDao.listarPasajeros(v.getIdViaje()));
                    listaFinal.add(v);
                }
            }
            listadoViajes = listaFinal;
        }

        return SUCCESS;
    }

    public String reservarViaje() {

        Pasajeros p = new Pasajeros(null);

        Map sesion = (Map) ActionContext.getContext().get("session");
        Usuario u = (Usuario) sesion.get("usuario");

        p.setIdUsuario(u);

        Viaje v = viajeDao.getViajePorId(idViaje);
        p.setIdViaje(v);

        pasajeroDao.reservaViaje(p, Integer.parseInt(this.idViaje));

        Date d = new Date();
        Mensaje m = new Mensaje(0, u.getNombre() + " " + u.getApellidos() + " ha realizado una reserva en uno de tus viajes", d);
        m.setIdUsuarioRecibe(v.getIdUsuarioPublica());
        m.setIdUsuarioEnvia(u);
        mensajeDao.enviarMensaje(m);

        return SUCCESS;
    }

    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void validate() {
        if (!fechaHora.equals("") && (origen.trim().length() == 0 || destino.trim().length() == 0)) {
            addFieldError("origen", "Debe introducir origen");
            addFieldError("origen", "Debe introducir destino");
        }

        if (!Pattern.matches("20[0-9][0-9]-[01][0-9]-[0-3][0-9]T[0-2][0-3]:[0-5][0-9]", fechaHora) && fechaHora.trim().length() != 0) {
            addFieldError("origen", "La fecha no es correcta (yyyy-mm-ddTHH:mm)");
        }
    }
}
