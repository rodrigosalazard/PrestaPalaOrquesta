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
import java.util.List;

import javax.faces.bean.ManagedBean;


/**
 *
 * @author Rodrigo
 */
@ManagedBean

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
    
    public MBUsuario(){
}

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
    
       public String getUsuarios() {
        UsuarioDaoHibernate usuarioDAO = new UsuarioDaoHibernate();
        List<Usuario> lista = usuarioDAO.findAll();
        for (Usuario temp : lista) {
            if (this.correo.equals((temp.getCorreo())) && this.correo.equals(temp.getTelefono().getCorreo()) 
                    && this.correo.equals(temp.getContrasena().getCorreo())) {
                this.nombre = temp.getNombre();
                this.appMaterno = temp.getApematerno();
                this.appPaterno = temp.getApepaterno();
                this.calle = temp.getCalle();
                this.colonia = temp.getColonia();
                this.delegacion = temp.getDelegacion();
                this.num = temp.getNumero();
                
                this.telefono = temp.getTelefono().getTelefono();
                this.contrasena = temp.getContrasena().getContrasena();
                
                
                break;
            }

        }
return "administrarCuenta2IH";
    }

    public void guarda() {
        Usuario tmp = new Usuario();
        Telefono tmp1 = new Telefono();
        Contrasena tmp2 = new Contrasena();
        try {
            tmp.setCorreo(getCorreo());
            tmp.setNombre(getNombre());
            tmp.setApematerno(appPaterno);
            tmp.setApepaterno(appPaterno);
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
            
            setMsn("La cuenta se ha creado satisfactoriamente");
        } catch (Exception e) {

            System.out.println("Hubo un error al intentar crear la cuenta" + e);
        }
    }
    
    
    public String inicioSesion(){

  List<Usuario> listUsuario;
  UsuarioDaoHibernate usuarioDao = new UsuarioDaoHibernate();
  listUsuario= usuarioDao.findAll();
  String saludo = "";
        for (Usuario usuario : listUsuario) {
            System.out.println("AAA"+usuario.toString());
         if(this.correo.equals(usuario.getCorreo()) && this.contrasena.equals(usuario.getContrasena().getContrasena())){
             System.out.println(usuario.toString());
        setMsn("Hola "+ usuario.getNombre() + " Bienvenido has iniciado Sesión" );
        saludo= "administrarCuentaIH";            
        break;
            }else {
                setMsn("Correo o contraseña incorrecta");
                saludo= "index";                    
          }    
        }
        return saludo;                
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
    
}
    

    

