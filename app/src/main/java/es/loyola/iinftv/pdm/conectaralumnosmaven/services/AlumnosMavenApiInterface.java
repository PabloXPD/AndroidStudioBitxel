package es.loyola.iinftv.pdm.conectaralumnosmaven.services;

import es.loyola.iinftv.pdm.conectaralumnosmaven.dao.RespuestaAlumno;
import es.loyola.iinftv.pdm.conectaralumnosmaven.dao.RespuestaAlumnoImpl;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AlumnosMavenApiInterface {

    @GET("getAlumnosJson")
    Call<RespuestaAlumnoImpl> getAlumnosJson();

    @POST("filtraAlumnosPorEdad")
    Call<RespuestaAlumno> filtraAlumnosPorEdad(@Query("edad") int edad);

    @POST("filtraAlumnosPorTitulacion")
    Call<RespuestaAlumno> filtraAlumnosPorTitulacion(@Query("titulacion") String titulacion);

}
