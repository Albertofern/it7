/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import modelo.MensajeDAO;
import modelo.PasajeroDAO;
import modelo.PuntuacionDAO;
import modelo.TelefonoDAO;
import modelo.UsuarioDAO;
import modelo.VehiculoDAO;
import modelo.ViajeDAO;
import webServiceREST.entidades.Mensaje;
import webServiceREST.entidades.Pasajeros;
import webServiceREST.entidades.Puntuacion;
import webServiceREST.entidades.Telefono;
import webServiceREST.entidades.Usuario;
import webServiceREST.entidades.Vehiculo;
import webServiceREST.entidades.Viaje;

/**
 *
 * @author alberto
 */
public class miCuentaAction extends ActionSupport {
    
    List<Usuario> listadoUsuarios = new ArrayList<Usuario>();
    List<Telefono> listadoTelefonos = new ArrayList<Telefono>();

    //mis datos
    String usuario;
    String nombre;
    String apellidos; 
    String email;
    String localidad;
    String sexo;
    
    Integer nuevoTlf;
    String idTelefono;
    
    //Mis viajes
    List<Viaje> listaViajes = new ArrayList<Viaje>();
    String idViaje;
    String idPasajero;
    int numPasajeros;
    
    //Mis opiniones
    List<Puntuacion> listaPuntuacionRealizadas = new ArrayList<Puntuacion>();
    List<Puntuacion> listaPuntuacionRecibidas = new ArrayList<Puntuacion>();
    String idPuntuacion;
    
    //Mis mensajes
    List<Mensaje> listaMensajesEnviados = new ArrayList<Mensaje>();
    List<Mensaje> listaMensajesRecibidos = new ArrayList<Mensaje>();
    String idMensaje;
    
    //Mis Reservas
    List<Pasajeros> listaReservas = new ArrayList<Pasajeros>();
    
    //Mis coches
    List<Vehiculo> listaCoches = new ArrayList<Vehiculo>();
    String idCoche;
    String marca;
    String modelo;
    String color;
    int plazas;
    
    
    public miCuentaAction() {
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String toMiCuenta(){
        return SUCCESS;
    }
    
    public String toMisDatos(){
        //Recojo el usuario de la sesion y lo guardo en una lista
        Map sesion = (Map) ActionContext.getContext().get("session");
        Usuario u = (Usuario) sesion.get("usuario");
        this.getListadoUsuarios().add(u);
        TelefonoDAO tDao = new TelefonoDAO();
        this.setListadoTelefonos(tDao.listarTelefonosUsuarios(u.getIdUsuario()));
        //UsuarioDAO usuarioDAO = new UsuarioDAO();
        //this.setListadoUsuarios(usuarioDAO.buscarUsuarioPorID(INPUT));
        return SUCCESS;
    }
    
    public String modificarMisDatos(){
        //Obtengo el usuario de la sesion
        Map sesion = (Map) ActionContext.getContext().get("session");
        Usuario u = (Usuario) sesion.get("usuario");
        UsuarioDAO uDao = new UsuarioDAO();
        uDao.updateUsuario(u.getIdUsuario(), this.getUsuario(), this.getNombre(), this.getApellidos(), this.getEmail(), this.getLocalidad(), this.getSexo());
        //Llamo al metodo toMisDatos() para recargar la pagina
        this.toMisDatos();
        return SUCCESS;
    }

    public String agregarTelefono(){
        //Obtengo el usuario de la sesion
        Map sesion = (Map) ActionContext.getContext().get("session");
        Usuario u = (Usuario) sesion.get("usuario");
        // Creo un objeto telefono nuevo y le paso por set el usuario y el telefono
        Telefono t = new Telefono();
        t.setIdUsuario(u);
        t.setNumTel(this.getNuevoTlf());
        // Creo un objeto TelefonoDAO y le paso el objeto telefono
        TelefonoDAO tDao = new TelefonoDAO();
        tDao.createTelefono(t);
        //Llamo al metodo toMisDatos() para recargar la pagina
        this.toMisDatos();
        return SUCCESS;
    }
    
    public String modificarTelefono(){
        // Creo un objeto TelefonoDAO y le paso el objeto telefono
        TelefonoDAO tDao = new TelefonoDAO();
        tDao.updateTelefono(this.getIdTelefono(), this.getNuevoTlf());
        //Llamo al metodo toMisDatos() para recargar la pagina
        this.toMisDatos();
        return SUCCESS;
    }
    
    public String eliminarTelefono(){
        // Creo un objeto TelefonoDAO y le paso el objeto telefono
        TelefonoDAO tDao = new TelefonoDAO();
        tDao.deleteTelefono(this.getIdTelefono());
        //Llamo al metodo toMisDatos() para recargar la pagina
        this.toMisDatos();
        return SUCCESS;
    }
    
    public String toMisViajes(){
        //Creo un objeto ViajeDAO para obtener la lista de viajes
        ViajeDAO vDao = new ViajeDAO();
        List<Viaje> listaViajesNoFiltrada = vDao.listarViajes();
        List<Viaje> listaViajesFiltrada = new ArrayList<Viaje>();
        //Obtengo el usuario de la sesion
        Map sesion = (Map) ActionContext.getContext().get("session");
        Usuario u = (Usuario) sesion.get("usuario");
        //Creo un objeto PasajeroDAO para obtener la lista de viajes
        PasajeroDAO pDao = new PasajeroDAO();
        List<List<Pasajeros>> listaPasajerosPorViaje = new ArrayList<List<Pasajeros>>();
        
        //Recorro la lista para obtener los vuajes del usuario actual
        for(int i=0; i < listaViajesNoFiltrada.size();i++){
            if(listaViajesNoFiltrada.get(i).getIdUsuarioPublica().getIdUsuario() == u.getIdUsuario()){
                //Obtengo el viaje actual y le agrego los pasajeros que van en ese viaje
                listaViajesNoFiltrada.get(i).setListaPasajeros(pDao.listarPasajeros(listaViajesNoFiltrada.get(i).getIdViaje()));
                listaViajesFiltrada.add(listaViajesNoFiltrada.get(i));
            }
        }
        this.setListaViajes(listaViajesFiltrada);
        
        return SUCCESS;
    }
    
    public String eliminarViaje(){
        // Creo un objeto TelefonoDAO y le paso el objeto telefono
        ViajeDAO vDao = new ViajeDAO();
        vDao.deleteViaje(this.getIdViaje());
        //Llamo al metodo toMisViajes() para recargar la pagina
        this.toMisViajes();
        return SUCCESS;
    }
    
    public String eliminarPasajeroViaje(){
        // Creo un objeto PasajeroDAO y le paso el idPasajero
        PasajeroDAO pDao = new PasajeroDAO();
        pDao.deletePasajeros(this.getIdPasajero());
        //Llamo al metodo toMisViajes() para recargar la pagina
        this.toMisViajes();
        return SUCCESS;
    }
    
    public String toMisOpiniones(){
        
        //Obtengo el usuario de la sesion
        Map sesion = (Map) ActionContext.getContext().get("session");
        Usuario u = (Usuario) sesion.get("usuario");
        PuntuacionDAO pDao = new PuntuacionDAO();
        this.setListaPuntuacionRealizadas(pDao.listarPuntuacionRealizadas(u.getIdUsuario()));
        this.setListaPuntuacionRecibidas(pDao.listarPuntuacionRecibidas(u.getIdUsuario()));
        
        return SUCCESS;
    }
    
    public String eliminarPuntuacion(){
        // Creo un objeto PuntuacionDAO y le paso el idPuntuacion
        PuntuacionDAO pDao = new PuntuacionDAO();
        pDao.deletePuntuacion(this.getIdPuntuacion());
        //Llamo al metodo toMisOpiniones() para recargar la pagina
        this.toMisOpiniones();
        return SUCCESS;
    }
    
    public String toMisMensajes(){
        //Obtengo el usuario de la sesion
        Map sesion = (Map) ActionContext.getContext().get("session");
        Usuario u = (Usuario) sesion.get("usuario");
        MensajeDAO mDao = new MensajeDAO();
        this.setListaMensajesEnviados(mDao.buscarEnviaMensaje(u.getNomUsuario()));
        this.setListaMensajesRecibidos(mDao.buscarRecibeMensaje(u.getNomUsuario()));
        return SUCCESS;
    }
    
    public String eliminarMensaje(){
        // Creo un objeto MensajeDAO y le paso el idMensaje
        MensajeDAO mDao = new MensajeDAO();
        mDao.deleteMensaje(Integer.parseInt(this.getIdMensaje()));
        //Llamo al metodo toMisMensajes() para recargar la pagina
        this.toMisMensajes();
        return SUCCESS;
    }
    
    public String toMisReservas(){
        //Obtengo el usuario de la sesion
        Map sesion = (Map) ActionContext.getContext().get("session");
        Usuario u = (Usuario) sesion.get("usuario");        
        //Creo un objeto PasajeroDAO para obtener los viajes donde soy pasajero
        PasajeroDAO pDao = new PasajeroDAO();
        List<Pasajeros> listaPasajerosReservas = pDao.listarPasajerosPorUsuarios(u.getIdUsuario());
        
        
        this.setListaReservas(listaPasajerosReservas);
        
        return SUCCESS;
    }
    
    public String eliminarReserva(){
        // Creo un objeto PasajeroDAO y le paso el idPasajero para eliminarlo
        PasajeroDAO pDao = new PasajeroDAO();
        pDao.deletePasajeros(this.getIdPasajero());
        //Llamo al metodo toMisMensajes() para recargar la pagina
        this.toMisReservas();
        return SUCCESS;
    }
    
    public String toMisCoches(){
        //Obtengo el usuario de la sesion
        Map sesion = (Map) ActionContext.getContext().get("session");
        Usuario u = (Usuario) sesion.get("usuario");        
        //Creo un objeto VehiculoDAO para obtener los vehiculos
        VehiculoDAO vDao = new VehiculoDAO();
        List<Vehiculo> listaCoches = vDao.listadoVehiculosUsuario(u.getIdUsuario());
        
        this.setListaCoches(listaCoches);
        
        return SUCCESS;
    }
    
    public String toAgregarCoche(){        
        return SUCCESS;
    }
    
    public String agregarCoche(){
        //Obtengo el usuario de la sesion
        Map sesion = (Map) ActionContext.getContext().get("session");
        Usuario u = (Usuario) sesion.get("usuario");
        // Creo un objeto vehiculo nuevo y le paso por set el usuario y los datos del formulario
        Vehiculo v = new Vehiculo();
        v.setIdUsuario(u);
        v.setMarca(this.getMarca());
        v.setModelo(this.getModelo());
        v.setColor(this.getColor());
        v.setPlazas(this.getPlazas());
        v.setIdFotoVehiculo(0);
        // Creo un objeto VehiculoDAO y le paso el objeto Vehiculo
        VehiculoDAO vDao = new VehiculoDAO();
        vDao.createVehiculo(v);
        //Llamo al metodo toMisCoches() para recargar la pagina de listado de coches
        this.toMisCoches();
        return SUCCESS;
    }
    
    public String toModificarCoche(){
        // Creo un objeto VehiculoDAO y recibo un objeto Vehiculo
        VehiculoDAO vDao = new VehiculoDAO();
        Vehiculo v = vDao.getVehiculoPorId(this.getIdCoche());
        this.getListaCoches().clear();
        this.getListaCoches().add(v);
        
        return SUCCESS;
    }
    
    public String modificarCoche(){
        // Creo un objeto VehiculoDAO y recibo un objeto Vehiculo
        VehiculoDAO vDao = new VehiculoDAO();
        Vehiculo v = vDao.getVehiculoPorId(this.getIdCoche());
        v.setMarca(this.getMarca());
        v.setModelo(this.getModelo());
        v.setColor(this.getColor());
        v.setPlazas(this.getPlazas());
        v.setIdFotoVehiculo(0);
        // Paso el objeto Vehiculo al dao para que lo guarde
        vDao.updateVehiculo(this.getIdCoche(),v);
        //Llamo al metodo toMisCoches() para recargar la pagina de listado de coches
        this.toMisCoches();
        return SUCCESS;
    }
    
    public String agregarFotos(){
        // Creo un objeto VehiculoDAO y recibo un objeto Vehiculo
        VehiculoDAO vDao = new VehiculoDAO();
        Vehiculo v = vDao.getVehiculoPorId(this.getIdCoche());
        String ruta = System.getProperty("catalina.home") + "/images/coche.jpg";
        File nuevoFile = new File(ruta);
        
        
        
        // Paso el objeto Vehiculo al dao para que lo guarde
        //vDao.updateVehiculo(this.getIdCoche(),v);
        //Llamo al metodo toMisCoches() para recargar la pagina de listado de coches
        this.toMisCoches();
        return SUCCESS;
    }
    
    public String eliminarCoche(){
        //Creo un objeto VehiculoDAO para obtener los vehiculos
        VehiculoDAO vDao = new VehiculoDAO();
        vDao.deleteVehiculo(this.getIdCoche());
        //Llamo al metodo toMisCoches() para recargar la pagina
        this.toMisCoches();
        return SUCCESS;
    }
    
    // Getter y setter MisDatos
    public List<Usuario> getListadoUsuarios() {
        return listadoUsuarios;
    }

    public void setListadoUsuarios(List<Usuario> listadoUsuarios) {
        this.listadoUsuarios = listadoUsuarios;
    }

    public List<Telefono> getListadoTelefonos() {
        return listadoTelefonos;
    }

    public void setListadoTelefonos(List<Telefono> listadoTelefonos) {
        this.listadoTelefonos = listadoTelefonos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public Integer getNuevoTlf() {
        return nuevoTlf;
    }

    public void setNuevoTlf(Integer nuevoTlf) {
        this.nuevoTlf = nuevoTlf;
    }

    public String getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(String idTelefono) {
        this.idTelefono = idTelefono;
    }

    //Getter y setter Mis Viajes

    public List<Viaje> getListaViajes() {
        return listaViajes;
    }

    public void setListaViajes(List<Viaje> listaViajes) {
        this.listaViajes = listaViajes;
    }

    public String getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(String idViaje) {
        this.idViaje = idViaje;
    }

    public String getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(String idPasajero) {
        this.idPasajero = idPasajero;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }
    
    //Getter y setter Mis Opiniones

    public List<Puntuacion> getListaPuntuacionRealizadas() {
        return listaPuntuacionRealizadas;
    }

    public void setListaPuntuacionRealizadas(List<Puntuacion> listaPuntuacionRealizadas) {
        this.listaPuntuacionRealizadas = listaPuntuacionRealizadas;
    }

    public List<Puntuacion> getListaPuntuacionRecibidas() {
        return listaPuntuacionRecibidas;
    }

    public void setListaPuntuacionRecibidas(List<Puntuacion> listaPuntuacionRecibidas) {
        this.listaPuntuacionRecibidas = listaPuntuacionRecibidas;
    }

    public String getIdPuntuacion() {
        return idPuntuacion;
    }

    public void setIdPuntuacion(String idPuntuacion) {
        this.idPuntuacion = idPuntuacion;
    }
    
    //Getter y setter Mis Mensajes

    public List<Mensaje> getListaMensajesEnviados() {
        return listaMensajesEnviados;
    }

    public void setListaMensajesEnviados(List<Mensaje> listaMensajesEnviados) {
        this.listaMensajesEnviados = listaMensajesEnviados;
    }

    public List<Mensaje> getListaMensajesRecibidos() {
        return listaMensajesRecibidos;
    }

    public void setListaMensajesRecibidos(List<Mensaje> listaMensajesRecibidos) {
        this.listaMensajesRecibidos = listaMensajesRecibidos;
    }

    public String getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(String idMensaje) {
        this.idMensaje = idMensaje;
    }
    
    //Getter y setter Mis Reservas

    public List<Pasajeros> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Pasajeros> listaReservas) {
        this.listaReservas = listaReservas;
    }
    
    //Getter y setter Mis Coches

    public List<Vehiculo> getListaCoches() {
        return listaCoches;
    }

    public void setListaCoches(List<Vehiculo> listaCoches) {
        this.listaCoches = listaCoches;
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

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public String getIdCoche() {
        return idCoche;
    }

    public void setIdCoche(String idCoche) {
        this.idCoche = idCoche;
    }
    
    
    
}
