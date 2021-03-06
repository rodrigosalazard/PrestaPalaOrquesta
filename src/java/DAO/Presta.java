package DAO;
// Generated 26/04/2016 03:15:50 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * Presta generated by hbm2java
 */
public class Presta  implements java.io.Serializable {


     private String correo;
     private Articulo articulo;
     private Usuario usuario;
     private Date fechainicio;
     private Date fechafinal;
     private BigDecimal calificacion;

    public Presta() {
    }

    public Presta(Articulo articulo, Usuario usuario, Date fechainicio, Date fechafinal, BigDecimal calificacion) {
       this.articulo = articulo;
       this.usuario = usuario;
       this.fechainicio = fechainicio;
       this.fechafinal = fechafinal;
       this.calificacion = calificacion;
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
    public Date getFechainicio() {
        return this.fechainicio;
    }
    
    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }
    public Date getFechafinal() {
        return this.fechafinal;
    }
    
    public void setFechafinal(Date fechafinal) {
        this.fechafinal = fechafinal;
    }
    public BigDecimal getCalificacion() {
        return this.calificacion;
    }
    
    public void setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
    }




}


