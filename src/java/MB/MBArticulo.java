/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import Controlador.ArticuloDaoHibernate;
import DAO.Articulo;
import java.io.File;
import java.util.List;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author fernando
 */
@ManagedBean

public class MBArticulo {
    
    private Integer idarticulo;
    private boolean disponible;
    private String descripcion;
    private String categoria;
    private File imagen;
    private String msn;
    /**
     * Creates a new instance of MBArticulo
     */
    public MBArticulo() {
    }

    /**
     * @return the idarticulo
     */
    public Integer getIdArticulo() {
        return idarticulo;
    }

    /**
     * @param idarticulo the idArticulo to set
     */
    public void setIdArticulo(Integer idarticulo) {
        this.idarticulo = idarticulo;
    }

    /**
     * @return the disponible
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * @param disponible the disponible to set
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * @return the descripción
     */
    public String getDescripcion() {
        return descripcion;
    }
    
 /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @param descripcion the descripción to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    
    public File getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(File imagen) {
        this.imagen = imagen;
    }
    
     public String getArticulos() {
        ArticuloDaoHibernate articuloDAO = new ArticuloDaoHibernate();
        List<Articulo> lista = articuloDAO.findAll();
        for (Articulo temp : lista) {
            if (this.idarticulo.equals((temp.getIdarticulo()))) {
                this.disponible = temp.isDisponible();
                this.descripcion = temp.getDescripcion();
                break;
            }

        }
        return "administrarCuenta2IH";
    }

    public void guarda() {
        Articulo tmp = new Articulo();
        
        
        try {
            tmp.setIdarticulo(idarticulo);
            tmp.setDisponible(disponible);
            tmp.setDescripcion(descripcion);
            

            ArticuloDaoHibernate articuloDAO = new ArticuloDaoHibernate();
            articuloDAO.save(tmp);
            
            setMsn("El articulo se ha creado satisfactoriamente");
        } catch (Exception e) {

            System.out.println("Hubo un error al intentar crear el articulo" + e);
        }
    }
    
    
  /**  public String inicioSesion(){

  List<Articulo> listUsuario;
  UsuarioDaoHibernate usuarioDao = new UsuarioDaoHibernate();
  listUsuario= usuarioDao.findAll();
  String saludo = "";
        for (Articulo usuario : listUsuario) {
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
     * @return 
    */
    
    public String eliminarArticulo(){
        ArticuloDaoHibernate articuloDAO = new ArticuloDaoHibernate();
        List<Articulo> lista = articuloDAO.findAll();
        for (Articulo temp:  lista) {
            if (this.idarticulo.equals((temp.getIdarticulo()))) {
                articuloDAO.delete(temp);
                break;
            }
                setMsn("El artículo ha sido eliminado");    
        }
        return "index";
    }

    /**
     * @return the imagen
     */
    
}
   
