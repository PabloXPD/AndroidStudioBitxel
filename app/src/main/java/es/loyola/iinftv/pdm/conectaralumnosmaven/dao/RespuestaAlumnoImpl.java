package es.loyola.iinftv.pdm.conectaralumnosmaven.dao;

import java.util.List;

public class RespuestaAlumnoImpl implements RespuestaAlumno {
    private String code;
    private String message;
    private List<Alumno> result;


    @Override
    public List<Alumno> getResult() {
        return result;
    }


    @Override
    public void setResult(List<Alumno> result) {
        this.result = result;
    }


    @Override
    public String getCode() {
        return code;
    }


    @Override
    public void setCode(String code) {
        this.code = code;
    }


    @Override
    public String getMessage() {
        return message;
    }


    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}

