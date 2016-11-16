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
public class DiarioDietetico {
    
    public Desayuno desayuno;
    public Almuerzo almuerzo;
    public Cena cena;
    public Refrigerio refrigerio;
    public  int numeroCalorias;
    public String fecha;
    public String dia;
    
    public int dd;
    public int mm;
    public int aa;
    
    public DiarioDietetico(String f ,String d) {
        
        desayuno = new Desayuno();
        almuerzo = new Almuerzo();
        cena = new Cena();
        refrigerio = new Refrigerio();
        numeroCalorias = 0;
        fecha = f;
        dia = d;
    }
    
   

    public Almuerzo getAlmuerzo() {
        return almuerzo;
    }

    public Cena getCena() {
        return cena;
    }

    public Desayuno getDesayuno() {
        return desayuno;
    }

    public int getNumeroCalorias() {
        return numeroCalorias;
    }

    public Refrigerio getRefrigerio() {
        return refrigerio;
    }

    public void setAlmuerzo(Almuerzo almuerzo) {
        this.almuerzo = almuerzo;
    }

    public void setCena(Cena cena) {
        this.cena = cena;
    }

    public void setDesayuno(Desayuno desayuno) {
        this.desayuno = desayuno;
    }

    public void setNumeroCalorias(int numeroCalorias) {
        this.numeroCalorias = numeroCalorias;
    }
    
    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setRefrigerio(Refrigerio refrigerio) {
        this.refrigerio = refrigerio;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setAa(int aa) {
        this.aa = aa;
    }

    public void setDd(int dd) {
        this.dd = dd;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }
    
    public String getDia() {
        return dia;
    }

    public String getFecha() {
        return fecha;
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
    
}
