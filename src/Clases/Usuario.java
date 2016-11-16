/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Enumeraciones.TipoActividadFisica;
import Enumeraciones.EstadoNutricional;
import Enumeraciones.Sexo;
import CapaLogica.ManejoDeFecha;
import CapaLogica.ManejoDelUsuario;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

/**
 *
 * @author iJona
 */

public class Usuario {
    
    private String nombre;
    private String id;
    private String pass;
    private Fecha fecha;
    private int edad;
    private Sexo sexo;
    private double peso;
    private double talla;
    private TipoActividadFisica tipoActividadFisica;
    private int tiempoActvFisica;
    private int requerimientoEnergetico;
    private EstadoNutricional estadoNutricionalActual;
    public Stack<DiarioDietetico>  Diarios;
    public String url;

    public Usuario(String nombre,String id,String pass, String d, String m,String a, Sexo sexo, double peso, double talla, int tiempoActvFisica, TipoActividadFisica tipoActv) {
        this.nombre = nombre;
        this.id = id;
        this.pass = pass;
        this.fecha = new Fecha (d,m,a);
        this.sexo = sexo;
        this.peso = peso;
        this.talla = talla;
        this.tipoActividadFisica = tipoActv;
        this.tiempoActvFisica = tiempoActvFisica;
        this.estadoNutricionalActual = ManejoDelUsuario.calcularEstadoNutricional(this);
        this.requerimientoEnergetico = ManejoDelUsuario.calcularGastoEnergetico(this);
        this.edad = ManejoDeFecha.calcularEdad(d, m, a);
        this.Diarios =  new Stack<DiarioDietetico>();
        this.url = "";
    }
    
    public Usuario(){}
    
    public void agregarDiario(DiarioDietetico d) {
        this.Diarios.push(d);
        
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
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the fecha
     */
    public Fecha getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the sexo
     */
    public Sexo getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the talla
     */
    public double getTalla() {
        return talla;
    }

    /**
     * @param talla the talla to set
     */
    public void setTalla(double talla) {
        this.talla = talla;
    }

    /**
     * @return the tipoActividadFisica
     */
    public TipoActividadFisica getTipoActividadFisica() {
        return tipoActividadFisica;
    }

    /**
     * @param tipoActividadFisica the tipoActividadFisica to set
     */
    public void setTipoActividadFisica(TipoActividadFisica tipoActividadFisica) {
        this.tipoActividadFisica = tipoActividadFisica;
    }

    /**
     * @return the tiempoActvFisica
     */
    public int getTiempoActvFisica() {
        return tiempoActvFisica;
    }

    /**
     * @param tiempoActvFisica the tiempoActvFisica to set
     */
    public void setTiempoActvFisica(int tiempoActvFisica) {
        this.tiempoActvFisica = tiempoActvFisica;
    }

    /**
     * @return the requerimientoEnergetico
     */
    public int getRequerimientoEnergetico() {
        return requerimientoEnergetico;
    }

    /**
     * @param requerimientoEnergetico the requerimientoEnergetico to set
     */
    public void setRequerimientoEnergetico(int requerimientoEnergetico) {
        this.requerimientoEnergetico = requerimientoEnergetico;
    }

    /**
     * @return the estadoNutricionalActual
     */
    public EstadoNutricional getEstadoNutricionalActual() {
        return estadoNutricionalActual;
    }

    /**
     * @param estadoNutricionalActual the estadoNutricionalActual to set
     */
    public void setEstadoNutricionalActual(EstadoNutricional estadoNutricionalActual) {
        this.estadoNutricionalActual = estadoNutricionalActual;
    }

    public void setDiarios(Stack<DiarioDietetico> Diarios) {
        this.Diarios = Diarios;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Stack<DiarioDietetico> getDiarios() {
        return Diarios;
    }

    public String getUrl() {
        return url;
    }
}
