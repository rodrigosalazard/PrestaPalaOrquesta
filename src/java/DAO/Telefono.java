package DAO;
// Generated 13/04/2016 04:25:11 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Telefono generated by hbm2java
 */
public class Telefono  implements java.io.Serializable {


     private String correo;
     private Usuario usuario;
     private int telefono;

    public Telefono() {
    }

    public Telefono(Usuario usuario, int telefono) {
       this.usuario = usuario;
       this.telefono = telefono;
    }
   
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public int getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }




}


