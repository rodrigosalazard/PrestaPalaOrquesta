/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import Controlador.AccesorioDaoHibernate;
import Controlador.ArticuloDaoHibernate;
import Controlador.InstrumentoDaoHibernate;
import Controlador.LibroDaoHibernate;
import Controlador.MusicaDaoHibernate;
import Controlador.SonidoDaoHibernate;
import DAO.Accesorio;
import DAO.Articulo;
import DAO.Instrumento;
import DAO.Libro;
import DAO.Musica;
import DAO.Sonido;
import java.io.File;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
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
    //Libro
    private Integer idlibro;
    private String editoriallibro;
    private String nombreautorlibro;
    private String nombrelibro;
    private String generolibro;
    private Integer anolibro;
    //Accesorio
    private Integer idaccesorio;
    private String tipoaccesorio;
    private String nombreaccesorio;
    private String marcaaccesorio;
    //Istrumento
    private Integer idinstrumento;
    private Integer anoinstrumento;
    private String marcainstrumento;
    private String tipoinstrumento;
    private String nombreinstrumento;
    //Musica
    private Integer idmusica;
    private String autormusica;
    private String generomusica;
    private Integer anomusica;
    private String formatomusica;
    //Sonido
    private Integer idsonido;
    private String nombresonido;
    private String tiposonido;
    private Double potenciasonido;
    private String marcasonido;
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
        Libro tmp1 = new Libro();
        Accesorio tmp2 = new Accesorio();
        Instrumento tmp3 = new Instrumento();
        Musica tmp4 = new Musica();
        Sonido tmp5 = new Sonido();
                
        try {
            tmp.setIdarticulo(idarticulo);
            tmp.setDisponible(disponible);
            tmp.setDescripcion(descripcion);
            System.out.println(categoria);
            
            ArticuloDaoHibernate articuloDAO = new ArticuloDaoHibernate();
            articuloDAO.save(tmp);
            
            //Libro
            LibroDaoHibernate libroDAO = new LibroDaoHibernate();
            tmp1.setArticulo(tmp);
            tmp1.setIdlibro(idlibro);
            tmp1.setEditorial(editoriallibro);
            tmp1.setNombreautor(nombreautorlibro);
            tmp1.setNombre(nombrelibro);
            tmp1.setGenero(generolibro);
            tmp1.setAno(anolibro);
            libroDAO.save(tmp1);
            //Accesorio
            AccesorioDaoHibernate accesorioDAO = new AccesorioDaoHibernate();
            tmp2.setArticulo(tmp);
            tmp2.setIdaccesorio(idaccesorio);
            tmp2.setNombre(nombreaccesorio);
            tmp2.setMarca(marcaaccesorio);
            tmp2.setTipo(tipoaccesorio);
            accesorioDAO.save(tmp2);
            //Instrumento
            InstrumentoDaoHibernate instrumentoDAO = new InstrumentoDaoHibernate();
            tmp3.setArticulo(tmp);
            tmp3.setIdinstrumento(idinstrumento);
            tmp3.setNombreinstrumento(nombreinstrumento);
            tmp3.setMarca(marcainstrumento);
            tmp3.setAno(anoinstrumento);
            tmp3.setTipo(tipoinstrumento);
            instrumentoDAO.save(tmp3);
            //Musica
            MusicaDaoHibernate musicaDAO = new MusicaDaoHibernate();
            tmp4.setArticulo(tmp);
            tmp4.setIdmusica(idmusica);
            tmp4.setAutor(autormusica);
            tmp4.setFormato(formatomusica);
            tmp4.setGenero(generomusica);
            tmp4.setAno(anomusica);
            musicaDAO.save(tmp4);
            //Sonido
            SonidoDaoHibernate sonidoDAO = new SonidoDaoHibernate();
            tmp5.setArticulo(tmp);
            tmp5.setIdsonido(idsonido);
            tmp5.setNombre(nombresonido);
            tmp5.setMarca(marcasonido);
            tmp5.setPotencia(potenciasonido);
            tmp5.setTipo(tiposonido);
            sonidoDAO.save(tmp5);
            
            
           //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Tu articulo se ha subido satisfactoriamente"));
            setMsn("El articulo se ha creado satisfactoriamente");
        } catch (Exception e) {

            System.out.println("Hubo un error al intentar crear el articulo" + e);
        }
    }
    
    
 
    
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
     * @return the idlibro
     */
    public Integer getIdlibro() {
        return idlibro;
    }

    /**
     * @param idlibro the idlibro to set
     */
    public void setIdlibro(Integer idlibro) {
        this.idlibro = idlibro;
    }

    /**
     * @return the editoriallibro
     */
    public String getEditoriallibro() {
        return editoriallibro;
    }

    /**
     * @param editoriallibro the editoriallibro to set
     */
    public void setEditoriallibro(String editoriallibro) {
        this.editoriallibro = editoriallibro;
    }

    /**
     * @return the nombreautorlibro
     */
    public String getNombreautorlibro() {
        return nombreautorlibro;
    }

    /**
     * @param nombreautorlibro the nombreautorlibro to set
     */
    public void setNombreautorlibro(String nombreautorlibro) {
        this.nombreautorlibro = nombreautorlibro;
    }

    /**
     * @return the nombrelibro
     */
    public String getNombrelibro() {
        return nombrelibro;
    }

    /**
     * @param nombrelibro the nombrelibro to set
     */
    public void setNombrelibro(String nombrelibro) {
        this.nombrelibro = nombrelibro;
    }

    /**
     * @return the generolibro
     */
    public String getGenerolibro() {
        return generolibro;
    }

    /**
     * @param generolibro the generolibro to set
     */
    public void setGenerolibro(String generolibro) {
        this.generolibro = generolibro;
    }

    /**
     * @return the ano
     */
    public Integer getAnolibro() {
        return anolibro;
    }

    /**
     * @param ano the ano to set
     */
    public void setAnolibro(Integer ano) {
        this.anolibro = ano;
    }

    /**
     * @return the idaccesorio
     */
    public Integer getIdaccesorio() {
        return idaccesorio;
    }

    /**
     * @param idaccesorio the idaccesorio to set
     */
    public void setIdaccesorio(Integer idaccesorio) {
        this.idaccesorio = idaccesorio;
    }

    /**
     * @return the tipoaccesorio
     */
    public String getTipoaccesorio() {
        return tipoaccesorio;
    }

    /**
     * @param tipoaccesorio the tipoaccesorio to set
     */
    public void setTipoaccesorio(String tipoaccesorio) {
        this.tipoaccesorio = tipoaccesorio;
    }

    /**
     * @return the nombreaccesorio
     */
    public String getNombreaccesorio() {
        return nombreaccesorio;
    }

    /**
     * @param nombreaccesorio the nombreaccesorio to set
     */
    public void setNombreaccesorio(String nombreaccesorio) {
        this.nombreaccesorio = nombreaccesorio;
    }

    /**
     * @return the marcaaccesorio
     */
    public String getMarcaaccesorio() {
        return marcaaccesorio;
    }

    /**
     * @param marcaaccesorio the marcaaccesorio to set
     */
    public void setMarcaaccesorio(String marcaaccesorio) {
        this.marcaaccesorio = marcaaccesorio;
    }

    /**
     * @return the idinstrumento
     */
    public Integer getIdinstrumento() {
        return idinstrumento;
    }

    /**
     * @param idinstrumento the idinstrumento to set
     */
    public void setIdinstrumento(Integer idinstrumento) {
        this.idinstrumento = idinstrumento;
    }

    /**
     * @return the anoinstrumento
     */
    public Integer getAnoinstrumento() {
        return anoinstrumento;
    }

    /**
     * @param anoinstrumento the anoinstrumento to set
     */
    public void setAnoinstrumento(Integer anoinstrumento) {
        this.anoinstrumento = anoinstrumento;
    }

    /**
     * @return the marcainstrumento
     */
    public String getMarcainstrumento() {
        return marcainstrumento;
    }

    /**
     * @param marcainstrumento the marcainstrumento to set
     */
    public void setMarcainstrumento(String marcainstrumento) {
        this.marcainstrumento = marcainstrumento;
    }

    /**
     * @return the tipoinstrumento
     */
    public String getTipoinstrumento() {
        return tipoinstrumento;
    }

    /**
     * @param tipoinstrumento the tipoinstrumento to set
     */
    public void setTipoinstrumento(String tipoinstrumento) {
        this.tipoinstrumento = tipoinstrumento;
    }

    /**
     * @return the nombreinstrumento
     */
    public String getNombreinstrumento() {
        return nombreinstrumento;
    }

    /**
     * @param nombreinstrumento the nombreinstrumento to set
     */
    public void setNombreinstrumento(String nombreinstrumento) {
        this.nombreinstrumento = nombreinstrumento;
    }

    /**
     * @return the idmusica
     */
    public Integer getIdmusica() {
        return idmusica;
    }

    /**
     * @param idmusica the idmusica to set
     */
    public void setIdmusica(Integer idmusica) {
        this.idmusica = idmusica;
    }

    /**
     * @return the autormusica
     */
    public String getAutormusica() {
        return autormusica;
    }

    /**
     * @param autormusica the autormusica to set
     */
    public void setAutormusica(String autormusica) {
        this.autormusica = autormusica;
    }

    /**
     * @return the generomusica
     */
    public String getGeneromusica() {
        return generomusica;
    }

    /**
     * @param generomusica the generomusica to set
     */
    public void setGeneromusica(String generomusica) {
        this.generomusica = generomusica;
    }

    /**
     * @return the anomusica
     */
    public Integer getAnomusica() {
        return anomusica;
    }

    /**
     * @param anomusica the anomusica to set
     */
    public void setAnomusica(Integer anomusica) {
        this.anomusica = anomusica;
    }

    /**
     * @return the formatomusica
     */
    public String getFormatomusica() {
        return formatomusica;
    }

    /**
     * @param formatomusica the formatomusica to set
     */
    public void setFormatomusica(String formatomusica) {
        this.formatomusica = formatomusica;
    }

    /**
     * @return the idsonido
     */
    public Integer getIdsonido() {
        return idsonido;
    }

    /**
     * @param idsonido the idsonido to set
     */
    public void setIdsonido(Integer idsonido) {
        this.idsonido = idsonido;
    }

    /**
     * @return the nombresonido
     */
    public String getNombresonido() {
        return nombresonido;
    }

    /**
     * @param nombresonido the nombresonido to set
     */
    public void setNombresonido(String nombresonido) {
        this.nombresonido = nombresonido;
    }

    /**
     * @return the tiposonido
     */
    public String getTiposonido() {
        return tiposonido;
    }

    /**
     * @param tiposonido the tiposonido to set
     */
    public void setTiposonido(String tiposonido) {
        this.tiposonido = tiposonido;
    }

    /**
     * @return the potenciasonido
     */
    public Double getPotenciasonido() {
        return potenciasonido;
    }

    /**
     * @param potenciasonido the potenciasonido to set
     */
    public void setPotenciasonido(Double potenciasonido) {
        this.potenciasonido = potenciasonido;
    }

    /**
     * @return the marcasonido
     */
    public String getMarcasonido() {
        return marcasonido;
    }

    /**
     * @param marcasonido the marcasonido to set
     */
    public void setMarcasonido(String marcasonido) {
        this.marcasonido = marcasonido;
    }

    /**
     * @return the imagen
     */
    
}
   
