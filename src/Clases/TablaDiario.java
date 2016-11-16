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
public class TablaDiario {
    
    private String alimento;
    private String calorias;
    private String cantidad;

    public TablaDiario(String alimento, String calorias, String cantidad) {
        this.alimento = alimento;
        this.calorias = calorias;
        this.cantidad = cantidad;
    }

    public String getAlimento() {
        return alimento;
    }

    public String getCalorias() {
        return calorias;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    public void setCalorias(String calorias) {
        this.calorias = calorias;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
