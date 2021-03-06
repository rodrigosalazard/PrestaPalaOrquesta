package DAO;
// Generated 26/04/2016 03:15:50 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Solicita generated by hbm2java
 */
public class Solicita  implements java.io.Serializable {


     private String correo;
     private Articulo articulo;
     private Usuario usuario;
     private Date fecha;

    public Solicita() {
    }

    public Solicita(Articulo articulo, Usuario usuario, Date fecha) {
       this.articulo = articulo;
       this.usuario = usuario;
       this.fecha = fecha;
    }
   
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public Articulo getArticulo() {
        return this.articulo;
    }
    
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}


