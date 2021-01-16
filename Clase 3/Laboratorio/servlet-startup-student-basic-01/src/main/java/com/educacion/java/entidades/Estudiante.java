package com.educacion.java.entidades;

import java.util.ArrayList;

public class Estudiante {

    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;
    private String ciudad;
    private String telefono;
    private String email;
    private String sexo;
    private String fechaDeNacimiento;
    private String graduado;
    private String titulo;

    public Estudiante() {
    }

    public Estudiante(String nombre, String apellido, String dni, String direccion, String ciudad, String telefono, String email, String sexo, String fechaDeNacimiento, String graduado, String titulo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.email = email;
        this.sexo = sexo;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.graduado = graduado;
        this.titulo = titulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getGraduado() {
        return graduado;
    }

    public void setGraduado(String graduado) {
        this.graduado = graduado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<String> getInformacion() {
        ArrayList<String> res = new ArrayList();
        res.add(this.nombre);
        res.add(this.apellido);
        res.add(this.dni);
        res.add(this.direccion);
        res.add(this.ciudad);
        res.add(this.telefono);
        res.add(this.email);
        res.add(this.sexo);
        res.add(this.fechaDeNacimiento);
        res.add(this.graduado);
        res.add(this.titulo);
        return res;
    }

}
