/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;
import Controlador.ContrasenaDaoHibernate;
import Controlador.TelefonoDaoHibernate;
import Controlador.UsuarioDaoHibernate;
import DAO.Contrasena;
import DAO.Telefono;
import DAO.Usuario;
import static com.sun.faces.facelets.util.Path.context;
import java.util.List;
import javax.faces.application.Application;
import javax.faces.bean.ApplicationScoped;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
//import javax.faces.context.FacesContext;
//import javax.servlet.http.HttpServletRequest;
//import javax.faces.bean.ViewScoped;



/**
 *
 * @author Rodrigo
 */

@ManagedBean
//@RequestScoped
//@ViewScoped
@ApplicationScoped


public class MBUsuario {
    private String correo;
    private String nombre;
    private String appPaterno;
    private String appMaterno;
    private String calle;
    private String colonia;
    private String delegacion;
    private int num;
    private int codigopostal;
    
    private String contrasena;
    private int telefono;
    
    private String msn;
    
  //  private final HttpServletRequest httpServletRequest;
//    private final FacesContext faceContext;
    
   private Usuario usuario;
 

  //  public MBUsuario (){
    
  //  faceContext = FacesContext.getCurrentInstance();
//    httpServletRequest  = (HttpServletRequest)faceContext.getExternalContext().getRequest();
//}
    
    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the appPaterno
     */
    public String getAppPaterno() {
        return appPaterno;
    }

    /**
     * @param appPaterno the appPaterno to set
     */
    public void setAppPaterno(String appPaterno) {
        this.appPaterno = appPaterno;
    }

    /**
     * @return the appMaterno
     */
    public String getAppMaterno() {
        return appMaterno;
    }

    /**
     * @param appMaterno the appMaterno to set
     */
    public void setAppMaterno(String appMaterno) {
        this.appMaterno = appMaterno;
    }

    /**
     * @return the calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * @param calle the calle to set
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * @return the colonia
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * @param colonia the colonia to set
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * @return the delegacion
     */
    public String getDelegacion() {
        return delegacion;
    }

    /**
     * @param delegacion the delegacion to set
     */
    public void setDelegacion(String delegacion) {
        this.delegacion = delegacion;
    }

    /**
     * @return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * @return the codigopostal
     */
    public int getCodigopostal() {
        return codigopostal;
    }

    /**
     * @param codigopostal the codigopostal to set
     */
    public void setCodigopostal(int codigopostal) {
        this.codigopostal = codigopostal;
    }
    
    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    

    /**
     * @return the msn
     */
    public String getMsn() {
        return msn;
    }

    /**
     * @param msn the msn to set
     */
    public void setMsn(String msn) {
        this.msn = msn;
    }
    
       
    public String guarda() {
        Usuario tmp = new Usuario();
        Telefono tmp1 = new Telefono();
        Contrasena tmp2 = new Contrasena();
        String redirecciona = "";
        try {
            tmp.setCorreo(getCorreo());
            tmp.setNombre(getNombre());
            tmp.setApepaterno(appPaterno);
            tmp.setApematerno(appMaterno);
            tmp.setCalle(calle);
            tmp.setColonia(colonia);
            tmp.setDelegacion(delegacion);
            tmp.setNumero(num);
            tmp.setCodigopostal(codigopostal);
            
            UsuarioDaoHibernate usuarioDAO = new UsuarioDaoHibernate();
            usuarioDAO.save(tmp);
            
            TelefonoDaoHibernate telefonoDao = new TelefonoDaoHibernate();
            tmp1.setUsuario(tmp);
            tmp1.setTelefono(telefono);
            telefonoDao.save(tmp1);
            
            ContrasenaDaoHibernate contrasenaDao = new ContrasenaDaoHibernate();
            tmp2.setUsuario(tmp);
            tmp2.setContrasena(contrasena);
            contrasenaDao.save(tmp2);
            
            setMsn("La cuenta se ha creado satisfactoriamente.");
            redirecciona = "index";
        } catch (Exception e) {
            System.out.println("Hubo un error al intentar crear la cuenta" + e);
            setMsn("Datos invalidos, vuelva a intentarlo");    
            redirecciona = "registroIH";
        }
        
        
        return redirecciona;
    }
    
       public void actualizar() {
        Usuario tmp = new Usuario();
        Telefono tmp1 = new Telefono();
        Contrasena tmp2 = new Contrasena();
        try {
            tmp.setNombre(nombre);
            tmp.setCorreo(correo);
            tmp.setApematerno(appMaterno);
            tmp.setApepaterno(appPaterno);
            tmp.setCalle(calle);
            tmp.setCodigopostal(codigopostal);
            tmp.setColonia(colonia);
            tmp.setDelegacion(delegacion);
            tmp.setNumero(num);
            
            UsuarioDaoHibernate usuarioDAO = new UsuarioDaoHibernate();
            usuarioDAO.update(tmp);
            
            TelefonoDaoHibernate telefonoDao = new TelefonoDaoHibernate();
            tmp1.setUsuario(tmp);
            tmp1.setCorreo(correo);
            tmp1.setTelefono(telefono);
            telefonoDao.update(tmp1);
            
            ContrasenaDaoHibernate contrasenaDao = new ContrasenaDaoHibernate();
            tmp2.setUsuario(tmp);
            tmp2.setCorreo(correo);
            tmp2.setContrasena(contrasena);
            contrasenaDao.update(tmp2);

            
            msn = "El usuario se guardo correctamente";
        } catch (Exception e) {

            msn = "upss! Ocurrio un error " + e;
            System.out.println(" upss! Ocurrio un error.  " + e);
        }
    }
 
    
    
    public String inicioSesion(){
  List<Usuario> listUsuario;
  UsuarioDaoHibernate usuarioDao = new UsuarioDaoHibernate();
  listUsuario= usuarioDao.findAll();
  String saludo = "";
        for (Usuario usuarioD : listUsuario) {
         if(this.correo.equals(usuarioD.getCorreo()) && this.contrasena.equals(usuarioD.getContrasena().getContrasena())){
             System.out.println(usuarioD.toString());
            this.nombre = usuarioD.getNombre();
            this.appMaterno = usuarioD.getApematerno();
            this.appPaterno = usuarioD.getApepaterno();
            this.calle = usuarioD.getCalle();
            this.codigopostal = usuarioD.getCodigopostal();
            this.colonia = usuarioD.getColonia();
            this.delegacion = usuarioD.getDelegacion();
            this.contrasena = usuarioD.getContrasena().getContrasena();
            this.num = usuarioD.getNumero();
            this.telefono = usuarioD.getTelefono().getTelefono();
            
        setMsn("Hola "+ usuarioD.getNombre() + " has iniciado Sesión" );
        saludo= "administrarCuentaIH";            
        
        break;
            }else {
                setMsn("Correo o contraseña incorrecta");
                saludo= "index";                    
          }    
        }
        return saludo;                
    }
    
    
    
    public String cerrarSesion(){
//        httpServletRequest.getSession().removeAttribute("sessionUsuario");
        setMsn("Sesión Cerrada correctamente" );
        return "index";
    }
    
    
    public String eliminarUsuario(){
        UsuarioDaoHibernate usuarioDAO = new UsuarioDaoHibernate();
        List<Usuario> lista = usuarioDAO.findAll();
        for (Usuario temp:  lista) {
            if (this.correo.equals((temp.getCorreo()))) {
                usuarioDAO.delete(temp);
                break;
            }
                setMsn("La cuenta ha sido eliminada");    
        }return "index";
    }
    
    
    
    
    

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
    

    

