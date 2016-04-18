
package MB;

import Controlador.ContrasenaDaoHibernate;
import DAO.Contrasena;
import DAO.Usuario;
import java.util.List;


import javax.faces.bean.ManagedBean;


/**
 *
 * @author Rodrigo
 */
@ManagedBean

public class MBContrasena {
    private String correo;
    private String contrasena;
    
    private String msn;
    
    public MBContrasena(){
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
    
    public String inicioSesion(){
 
  List<Contrasena> listContrasena;
  ContrasenaDaoHibernate contrasenaDao = new ContrasenaDaoHibernate();
  listContrasena= contrasenaDao.findAll();
  String saludo = "";
        for (Contrasena contrasenaD : listContrasena) {
            System.out.println("AAA"+contrasenaD.toString());
         if(this.correo.equals(contrasenaD.getCorreo()) && this.contrasena.equals(contrasenaD.getContrasena()) ){
             System.out.println(contrasenaD.toString());
        setMsn("Hola " + contrasenaD.getCorreo());
        saludo= "administrarCuentaIH";            
        break;
            }else {
                setMsn("Nombre de usuario o contraseña incorrecta");
                saludo= "index";                    
          }    
        }
        return saludo;                
    }
    }


    
    

    

    

