package DAO;
// Generated 13/04/2016 04:25:11 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * Partitura generated by hbm2java
 */
public class Partitura  implements java.io.Serializable {


     private BigDecimal idpartitura;
     private Articulo articulo;
     private String nombreautor;
     private String nombre;
     private String genero;
     private Date ano;
     private String tipo;

    public Partitura() {
    }

	
    public Partitura(BigDecimal idpartitura, Articulo articulo, String tipo) {
        this.idpartitura = idpartitura;
        this.articulo = articulo;
        this.tipo = tipo;
    }
    public Partitura(BigDecimal idpartitura, Articulo articulo, String nombreautor, String nombre, String genero, Date ano, String tipo) {
       this.idpartitura = idpartitura;
       this.articulo = articulo;
       this.nombreautor = nombreautor;
       this.nombre = nombre;
       this.genero = genero;
       this.ano = ano;
       this.tipo = tipo;
    }
   
    public BigDecimal getIdpartitura() {
        return this.idpartitura;
    }
    
    public void setIdpartitura(BigDecimal idpartitura) {
        this.idpartitura = idpartitura;
    }
    public Articulo getArticulo() {
        return this.articulo;
    }
    
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    public String getNombreautor() {
        return this.nombreautor;
    }
    
    public void setNombreautor(String nombreautor) {
        this.nombreautor = nombreautor;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getGenero() {
        return this.genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public Date getAno() {
        return this.ano;
    }
    
    public void setAno(Date ano) {
        this.ano = ano;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }




}


