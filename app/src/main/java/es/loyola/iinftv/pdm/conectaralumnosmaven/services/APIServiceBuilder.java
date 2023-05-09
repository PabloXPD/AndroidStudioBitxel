package es.loyola.iinftv.pdm.conectaralumnosmaven.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.loyola.iinftv.pdm.conectaralumnosmaven.adapter.AlumnoTypeAdapter;
import es.loyola.iinftv.pdm.conectaralumnosmaven.dao.Alumno;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIServiceBuilder {

    private static Retrofit retrofit;

    private static final String BASE_URL = "http://10.0.2.2:8086/AlumnosMaven-0.0.2/"; // 10.0.2.2 es como localhost, pero no se puede usar localhost

    public static Retrofit getClient()
    {
        if (retrofit == null)
        {
            // Para poder interceptar las conexiones
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY); // Quiero interceptar el cuerpo

            // Crear el interceptor de OkHttpClient para poder registrar el uso de la red
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();


            // Para que haga bien el parseado de Alumno
            Gson gson = new GsonBuilder().registerTypeAdapter(Alumno.class, new AlumnoTypeAdapter()).create(); // Contruir objeto Gson
            GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);

            // Construccion con gson personaizado de retrofit
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(gsonConverterFactory).client(client).build();

            // Construccion basica de retrofit
            //retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;

    }
}
