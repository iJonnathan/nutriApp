/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iJona
 */
public class Desayuno {
    
    private ArrayList<Registro> registros;
    
            
    public Desayuno() {
        registros = new ArrayList<>();
    }

    public void setRegistros(ArrayList<Registro> registros) {
        this.registros = registros;
    }

    public ArrayList<Registro> getRegistros() {
        return registros;
    }
    
    public void agregarRegistro(Registro registro){
        this.registros.add(registro);
    }
     
}
