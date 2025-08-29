package gym.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Modelo de dominio: Rutina de ejercicios.
 */
public class Rutina {

    private String id;
    private String nombre;
    private String nivel;
    private boolean activa;
    private List<Ejercicio> ejercicios = new ArrayList<>();
    private List<Miembro> miembros = new ArrayList<>();

    public Rutina(String id, String nombre, String nivel, boolean activa) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.activa = activa;
    }

    public void activar() {
        this.activa = true;
    }

    public void desactivar() {
        this.activa = false;
    }

    public boolean agregarEjercicio(Ejercicio e) {
        if (e == null) {
            return false;
        }
        if (!ejercicios.contains(e)) {
            ejercicios.add(e);
            return true;
        }
        return false;
    }

    public boolean removerEjercicio(String nombre) {
        for (int i = 0; i < ejercicios.size(); i++) {
            if (ejercicios.get(i).getNombre().equalsIgnoreCase(nombre)) {
                ejercicios.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean registrarMiembro(Miembro m) {
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

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public boolean isActiva() {
        return activa;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public List<Miembro> getMiembros() {
        return miembros;
    }

    @Override
    public String toString() {
        return "Rutina{id='" + id + "', nombre='" + nombre + "', nivel='" + nivel
                + "', activa=" + activa + ", ejercicios=" + ejercicios.size()
                + ", miembros=" + miembros.size() + "}";
    }
}
