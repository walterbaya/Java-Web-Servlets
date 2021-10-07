package manejoJavabeans;

import com.mycompany.ejemplojavabeans.beans.PersonaBean;

public class ManejoJavaBeans {

    public static void main(String[] args) {
        PersonaBean bean = new PersonaBean();
        bean.setNombre("Jose");
        bean.setEdad(28);
        System.out.println("Nombre: " + bean.getNombre() + " Edad: " + bean.getEdad());
    }
}
