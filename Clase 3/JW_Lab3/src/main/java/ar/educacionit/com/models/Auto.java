
package ar.educacionit.com.models;

public class Auto {

    private Long id;
    private String marca;
    private String modelo;

    public Auto(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public Auto(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
}
