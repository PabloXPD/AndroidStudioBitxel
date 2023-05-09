package es.loyola.iinftv.pdm.conectaralumnosmaven.dao;

import java.util.List;

public interface RespuestaAlumno {
    List<Alumno> getResult();

    void setResult(List<Alumno> result);

    String getCode();

    void setCode(String code);

    String getMessage();

    void setMessage(String message);
}
