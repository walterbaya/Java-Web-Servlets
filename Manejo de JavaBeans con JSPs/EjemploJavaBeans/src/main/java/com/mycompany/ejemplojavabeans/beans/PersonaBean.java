package com.mycompany.ejemplojavabeans.beans;

import java.io.Serializable;

//Es necesario importar la interfaz serializable
//por si va a viajar por la red la clase
//convierte el objeto en 1s y 0s para poder mandar los objetos por la red
public class PersonaBean implements Serializable{

    //los atributos deben ser privados en un javabean
    private String nombre;
    private int edad;

    //debe tener un constructor vacio
    public PersonaBean() {

    }

    public PersonaBean(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    //Por cada atributo hay que tener los metodos get y set
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
