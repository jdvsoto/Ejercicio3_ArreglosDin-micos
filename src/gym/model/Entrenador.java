package gym.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Modelo de dominio: Entrenador del gimnasio.
 */
public class Entrenador {

    private String id;
    private String nombreCompleto;
    private String especialidad;
    private List<Miembro> miembros = new ArrayList<>();

    public Entrenador(String id, String nombreCompleto, String especialidad) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.especialidad = especialidad;
    }

    public boolean agregarMiembro(Miembro m) {
        if (m == null) {
            return false;
        }
        if (!miembros.contains(m)) {
            miembros.add(m);
            return true;
        }
        return false;
    }

    public boolean removerMiembro(String miembroId) {
        for (int i = 0; i < miembros.size(); i++) {
            if (miembros.get(i).getId().equals(miembroId)) {
                miembros.remove(i);
                return true;
            }
        }
        return false;
    }

    public int contarAlumnos() {
        return miembros.size();
    }

    public String getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Miembro> getMiembros() {
        return miembros;
    }

    @Override
    public String toString() {
        return "Entrenador{id='" + id + "', nombre='" + nombreCompleto + "', esp='" + especialidad
                + "', alumnos=" + miembros.size() + "}";
    }
}
