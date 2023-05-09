package es.loyola.iinftv.pdm.conectaralumnosmaven.dao;

public interface Alumno {
    String getDni();

    void setDni(String dni);

    Integer getEdad();

    void setEdad(Integer edad);

    String getNombre();

    void setNombre(String nombre);

    String getTitulacion();

    void setTitulacion(String titulacion);
}
