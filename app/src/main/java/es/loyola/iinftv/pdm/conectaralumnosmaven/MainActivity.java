package es.loyola.iinftv.pdm.conectaralumnosmaven;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import es.loyola.iinftv.pdm.conectaralumnosmaven.adapter.AlumnoRecycleViewAdapter;
import es.loyola.iinftv.pdm.conectaralumnosmaven.dao.Alumno;
import es.loyola.iinftv.pdm.conectaralumnosmaven.dao.RespuestaAlumno;
import es.loyola.iinftv.pdm.conectaralumnosmaven.dao.RespuestaAlumnoImpl;
import es.loyola.iinftv.pdm.conectaralumnosmaven.services.APIServiceBuilder;
import es.loyola.iinftv.pdm.conectaralumnosmaven.services.AlumnosMavenApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    //private TextView mostrarResultado;

    private RecyclerView recyclerView;
    private AlumnosMavenApiInterface apiInterface;
    private List<Alumno> listaAlumnos;

    AlumnoRecycleViewAdapter alumnoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listaAlumnos = new LinkedList<Alumno>();
        setContentView(R.layout.activity_main);

        //mostrarResultado = findViewById(R.id.mostrarResultado); //Esto es para el TextView del activity_main.xml
        //mostrarResultado.setText("...");

        recyclerView = findViewById(R.id.recyclerView); // Esto es para el RecycleView del activity_main.xml

        // Crear el cliente que se va a conectar al servidor
        Retrofit retrofit = APIServiceBuilder.getClient();
        // Crea una instancia de la interfaz AlumnosMavenApiInterface
        apiInterface = retrofit.create(AlumnosMavenApiInterface.class);
        generarListadoAlumnos();
        recyclerView.setLayoutManager(new LinearLayoutManager(this )); //setLayoutManager sirve para cualquier widget de Android, para gestionar este tipo de formato
        alumnoAdapter = new AlumnoRecycleViewAdapter(listaAlumnos);
        recyclerView.setAdapter(alumnoAdapter);

    }

    private void generarListadoAlumnos()
    {
        // Hago la llamada al método getAlumnosJson de la api
        Call<RespuestaAlumnoImpl> call = apiInterface.getAlumnosJson();
        call.enqueue(new Callback<RespuestaAlumnoImpl>() {
            @Override
            public void onResponse(Call<RespuestaAlumnoImpl> call, Response<RespuestaAlumnoImpl> response) {
                if (response.isSuccessful() && response.body() != null)
                {
                    RespuestaAlumno respuestaAlumno = response.body();
                    String code = respuestaAlumno.getCode();
                    if (code.equalsIgnoreCase("Ok"))
                    {
                        listaAlumnos.clear();
                        listaAlumnos.addAll(respuestaAlumno.getResult());
                        //mostrarResultado.setText(listaAlumnos.toString());
                        alumnoAdapter.notifyDataSetChanged(); // notifica cualquier cambio registrado, el recyclerView se actualiza con los datos.

                    } else
                    {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
                    }
                } else
                {
                    Toast.makeText(MainActivity.this, "Error en la respuesta", Toast.LENGTH_LONG).show();
                }
            }

            public void onFailure(Call<RespuestaAlumnoImpl> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error en la llamada", Toast.LENGTH_LONG).show();
                Log.e("onFailure", "Error en la llamada2 "+ t.toString());
            }

        });

    }
}