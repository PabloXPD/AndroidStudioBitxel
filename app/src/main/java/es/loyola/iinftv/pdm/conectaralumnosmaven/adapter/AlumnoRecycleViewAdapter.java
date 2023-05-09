package es.loyola.iinftv.pdm.conectaralumnosmaven.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

import es.loyola.iinftv.pdm.conectaralumnosmaven.R;
import es.loyola.iinftv.pdm.conectaralumnosmaven.dao.Alumno;

public class AlumnoRecycleViewAdapter extends RecyclerView.Adapter<AlumnoRecycleViewAdapter.AlumnoViewHolder> {

    private List<Alumno> alumnoList;

    public AlumnoRecycleViewAdapter(List<Alumno> listado) {
        alumnoList = listado;
    }

    @NonNull
    @Override
    public AlumnoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.alumno_item, parent, false);
        Log.i("onCreateViewHolder","Cargada la vista alumnoView");

        return new AlumnoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnoViewHolder holder, int position) {
        Alumno  currentAlumno = alumnoList.get(position);
        holder.bind(currentAlumno);
    }

    @Override
    public int getItemCount() {

        return alumnoList.size();
    }

    public class AlumnoViewHolder extends RecyclerView.ViewHolder {

        private TextView nombreAlumnoTextView;
        private TextView titulacionAlumnoTextView;
        private TextView dniAlumnoTextView;
        private TextView edadAlumnoTextView;
        public AlumnoViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreAlumnoTextView = itemView.findViewById(R.id.nombreAlumno);
            titulacionAlumnoTextView = itemView.findViewById(R.id.titulacionAlumno);
            dniAlumnoTextView = itemView.findViewById(R.id.dniAlumno);
            edadAlumnoTextView = itemView.findViewById(R.id.edadAlumno);
        }
        public void bind(Alumno currentAlumno) {
            nombreAlumnoTextView.setText(currentAlumno.getNombre());
            titulacionAlumnoTextView.setText(currentAlumno.getTitulacion());
            dniAlumnoTextView.setText(currentAlumno.getDni());
            edadAlumnoTextView.setText(currentAlumno.getEdad().toString());
        }
    }


}
