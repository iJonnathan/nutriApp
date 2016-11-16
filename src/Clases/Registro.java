/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author iJona
 */
public class Registro {
    
    private String porcion;
    private String alimento;
    private int calorias;
    private String tiempo;
   
    public Registro(String porcion, String alimento, int calorias, String tiempo) {
        this.porcion = porcion;
        this.alimento = alimento;
        this.calorias = calorias;
        this.tiempo = tiempo;
    }
    
    
    
    
    private String fecha = "";
    private String Dia = "";
    private int dd;
    private int mm;
    private int aa;
     public void setAa(int aa) {
        this.aa = aa;
    }

    public void setDd(int dd) {
        this.dd = dd;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    public int getAa() {
        return aa;
    }

    public int getDd() {
        return dd;
    }

    public int getMm() {
        return mm;
    }

    public void setDia(String Dia) {
        this.Dia = Dia;
    }

    public String getDia() {
        return Dia;
    }
    

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }
    
    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
    
    public String getPorcion() {
        return porcion;
    }

    public String getAlimento() {
        return alimento;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setPorcion(String porcion) {
        this.porcion = porcion;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }
    
}
