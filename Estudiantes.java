/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_notas_estudiantes;

/**
 *
 * @author JuanPabloFrancoSolar
 */
public class Estudiantes {
    private String nombre;
    private String programa;
    private double nota;
    
    public Estudiantes(String nombre, String programa, double nota){
        
        this.nombre = nombre;
        this.programa = programa;
        this.nota = nota;
    }
    public String getnombre(){
        return nombre;
    }
    public String getprograma(){
        return programa;
    }
    public double getnota(){
        return nota;
    }
}
