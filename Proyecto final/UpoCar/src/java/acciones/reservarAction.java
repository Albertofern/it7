/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.Map;
import modelo.MensajeDAO;
import modelo.PasajeroDAO;
import modelo.ViajeDAO;
import webServiceREST.entidades.Mensaje;
import webServiceREST.entidades.Pasajeros;
import webServiceREST.entidades.Usuario;
import webServiceREST.entidades.Viaje;

/**
 *
 * @author Antonio Jose Herrera Tabaco
 */
public class reservarAction extends ActionSupport {
    
    ViajeDAO viajeDao = new ViajeDAO();
    PasajeroDAO pasajeroDao = new PasajeroDAO();
    MensajeDAO mensajeDao = new MensajeDAO();
    private String idViaje;

    public String getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(String idViaje) {
        this.idViaje = idViaje;
    }
    
    
    public reservarAction() {
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
    
}
