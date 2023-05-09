package es.loyola.iinftv.pdm.conectaralumnosmaven.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

import es.loyola.iinftv.pdm.conectaralumnosmaven.dao.Alumno;
import es.loyola.iinftv.pdm.conectaralumnosmaven.dao.AlumnoImpl;

public class AlumnoTypeAdapter implements JsonSerializer<Alumno>, JsonDeserializer<Alumno> {

    @Override
    public Alumno deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String nombre = jsonObject.get("nombre").getAsString();
        String titulacion = jsonObject.get("titulacion").getAsString();
        String dni = jsonObject.get("dni").getAsString();
        int edad = jsonObject.get("edad").getAsInt();


        return new AlumnoImpl( dni,  nombre,  titulacion,  edad);
    }

    @Override
    public JsonElement serialize(Alumno src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("nombre", src.getNombre());
        jsonObject.addProperty("titulacion", src.getTitulacion());
        jsonObject.addProperty("dni", src.getDni());
        jsonObject.addProperty("edad", src.getEdad());

        return jsonObject;
    }
}
