package DAO;
// Generated 13/04/2016 04:25:11 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Articulo generated by hbm2java
 */
public class Articulo  implements java.io.Serializable {


     private Integer idarticulo;
     private boolean disponible;
     private String descripcion;
     
     private Set libros = new HashSet(0);
     private Set instrumentos = new HashSet(0);
     private Set prestas = new HashSet(0);
     private Set musicas = new HashSet(0);
     private Set solicitas = new HashSet(0);
     private Estado estado;
     private Set accesorios = new HashSet(0);
     private Set partituras = new HashSet(0);
     private Set sonidos = new HashSet(0);

    public Articulo() {
    }

	
    public Articulo(Integer idarticulo, boolean disponible, String descripcion) {
        this.idarticulo = idarticulo;
        this.disponible = disponible;
        this.descripcion = descripcion;
    }
    public Articulo(Integer idarticulo, boolean disponible, String descripcion, byte[] imagen, Set libros, Set instrumentos, Set prestas, Set musicas, Set solicitas, Estado estado, Set accesorios, Set partituras, Set sonidos) {
       this.idarticulo = idarticulo;
       this.disponible = disponible;
       this.descripcion = descripcion;
       
       this.libros = libros;
       this.instrumentos = instrumentos;
       this.prestas = prestas;
       this.musicas = musicas;
       this.solicitas = solicitas;
       this.estado = estado;
       this.accesorios = accesorios;
       this.partituras = partituras;
       this.sonidos = sonidos;
    }
   
    public Integer getIdarticulo() {
        return this.idarticulo;
    }
    
    public void setIdarticulo(Integer idarticulo) {
        this.idarticulo = idarticulo;
    }
    public boolean isDisponible() {
        return this.disponible;
    }
    
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Set getLibros() {
        return this.libros;
    }
    
    public void setLibros(Set libros) {
        this.libros = libros;
    }
    public Set getInstrumentos() {
        return this.instrumentos;
    }
    
    public void setInstrumentos(Set instrumentos) {
        this.instrumentos = instrumentos;
    }
    public Set getPrestas() {
        return this.prestas;
    }
    
    public void setPrestas(Set prestas) {
        this.prestas = prestas;
    }
    public Set getMusicas() {
        return this.musicas;
    }
    
    public void setMusicas(Set musicas) {
        this.musicas = musicas;
    }
    public Set getSolicitas() {
        return this.solicitas;
    }
    
    public void setSolicitas(Set solicitas) {
        this.solicitas = solicitas;
    }
    public Estado getEstado() {
        return this.estado;
    }
    
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public Set getAccesorios() {
        return this.accesorios;
    }
    
    public void setAccesorios(Set accesorios) {
        this.accesorios = accesorios;
    }
    public Set getPartituras() {
        return this.partituras;
    }
    
    public void setPartituras(Set partituras) {
        this.partituras = partituras;
    }
    public Set getSonidos() {
        return this.sonidos;
    }
    
    public void setSonidos(Set sonidos) {
        this.sonidos = sonidos;
    }




}


