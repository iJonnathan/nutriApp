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
public class Fecha{
        
        private String dia;
        private String mes;
        private String anio;
        
        public Fecha ( String d, String m, String a){
            this.dia = d;
            this.mes = m;
            this.anio = a;
        }

        public String getAnio() {
            return anio;
        }

        public String getDia() {
            return dia;
        }

        public String getMes() {
            return mes;
        }

        public void setAnio(String anio) {
            this.anio = anio;
        }

        public void setDia(String dia) {
            this.dia = dia;
        }

        public void setMes(String mes) {
            this.mes = mes;
        }
        
        
    }