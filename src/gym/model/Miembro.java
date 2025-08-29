package gym.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Modelo de dominio: Miembro del gimnasio.
 */
public class Miembro {

    private String id;
    private String nombreCompleto;
    private TipoMembresia tipoMembresia;
    private boolean activo;
    private Entrenador entrenador;
    private List<Rutina> rutinas = new ArrayList<>();

    public Miembro(String id, String nombreCompleto, TipoMembresia tipoMembresia, boolean activo) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.tipoMembresia = tipoMembresia;
        this.activo = activo;
    }

    public void asignarEntrenador(Entrenador e) {
        this.entrenador = e;
    }

    public void removerEntrenador() {
        this.entrenador = null;
    }

    public boolean asignarRutina(Rutina r) {
        if (r == null || !r.isActiva()) {
            return false;
        }
        if (!rutinas.contains(r)) {
            rutinas.add(r);
            return true;
        }
        return false;
    }

    public boolean removerRutina(String rutinaId) {
        for (int i = 0; i < rutinas.size(); i++) {
            if (rutinas.get(i).getId().equals(rutinaId)) {
                rutinas.remove(i);
                return true;
            }
        }
        return false;
    }

    public String getId() {
        return id;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public TipoMembresia getTipoMembresia() {
        return tipoMembresia;
    }

    public void setTipoMembresia(TipoMembresia tipoMembresia) {
        this.tipoMembresia = tipoMembresia;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public List<Rutina> getRutinas() {
        return rutinas;
    }

    @Override
    public String toString() {
        String entrenadorId = (entrenador == null) ? "-" : entrenador.getId();
        return "Miembro{id='" + id + "', nombre='" + nombreCompleto + "', tipo=" + tipoMembresia
                + ", activo=" + activo + ", entrenadorId=" + entrenadorId + ", rutinas=" + rutinas.size() + "}";
    }
}
