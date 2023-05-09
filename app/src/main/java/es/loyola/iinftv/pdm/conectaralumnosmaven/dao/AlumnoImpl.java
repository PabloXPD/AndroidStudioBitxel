package es.loyola.iinftv.pdm.conectaralumnosmaven.dao;

import java.util.Objects;

public class AlumnoImpl implements Alumno{

    private Integer edad;
    private String nombre, titulacion, dni;

    public AlumnoImpl() {
    }
    public AlumnoImpl(String dni, String nombre, String titulacion, Integer edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.titulacion = titulacion;
        this.edad = edad;
    }

    @Override
    public String getDni() {
        return dni;
    }

    @Override
    public void setDni(String id) {
        this.dni = id;
    }

    @Override
    public Integer getEdad() {
        return edad;
    }

    @Override
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getTitulacion() {
        return titulacion;
    }

    @Override
    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlumnoImpl that = (AlumnoImpl) o;
        return Objects.equals(dni, that.dni) &&
                Objects.equals(edad, that.edad) &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(titulacion, that.titulacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, edad, nombre, titulacion);
    }

    @Override
    public String toString() {
        return "{" +
                "dni=" + dni +
                ", edad=" + edad +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + titulacion + '\'' +
                "}\n";
    }
}
