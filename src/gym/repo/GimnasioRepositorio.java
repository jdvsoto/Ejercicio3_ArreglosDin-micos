package gym.repo;

import gym.model.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio en memoria con listas dinámicas maestras.
 */
public class GimnasioRepositorio {

    private List<Miembro> miembros = new ArrayList<>();
    private List<Entrenador> entrenadores = new ArrayList<>();
    private List<Rutina> rutinas = new ArrayList<>();

    public boolean crearMiembro(Miembro m) {
        if (m == null || buscarMiembroPorId(m.getId()) != null) {
            return false;
        }
        miembros.add(m);
        return true;
    }

    public boolean actualizarMiembro(Miembro m) {
        if (m == null) {
            return false;
        }
        for (int i = 0; i < miembros.size(); i++) {
            if (miembros.get(i).getId().equals(m.getId())) {
                miembros.set(i, m);
                return true;
            }
        }
        return false;
    }

    public Miembro buscarMiembroPorId(String id) {
        for (Miembro mi : miembros) {
            if (mi.getId().equals(id)) {
                return mi;
            }
        }
        return null;
    }

    public boolean eliminarMiembro(String id) {
        for (int i = 0; i < miembros.size(); i++) {
            if (miembros.get(i).getId().equals(id)) {
                miembros.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Miembro> buscarMiembroPorNombre(String texto) {
        List<Miembro> res = new ArrayList<>();
        for (Miembro mi : miembros) {
            if (mi.getNombreCompleto().toLowerCase().contains(texto.toLowerCase())) {
                res.add(mi);
            }
        }
        return res;
    }

    public boolean crearEntrenador(Entrenador e) {
        if (e == null || buscarEntrenadorPorId(e.getId()) != null) {
            return false;
        }
        entrenadores.add(e);
        return true;
    }

    public boolean actualizarEntrenador(Entrenador e) {
        if (e == null) {
            return false;
        }
        for (int i = 0; i < entrenadores.size(); i++) {
            if (entrenadores.get(i).getId().equals(e.getId())) {
                entrenadores.set(i, e);
                return true;
            }
        }
        return false;
    }

    public Entrenador buscarEntrenadorPorId(String id) {
        for (Entrenador en : entrenadores) {
            if (en.getId().equals(id)) {
                return en;
            }
        }
        return null;
    }

    public boolean eliminarEntrenador(String id) {
        for (int i = 0; i < entrenadores.size(); i++) {
            if (entrenadores.get(i).getId().equals(id)) {
                entrenadores.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Entrenador> buscarEntrenadorPorNombre(String texto) {
        List<Entrenador> res = new ArrayList<>();
        for (Entrenador en : entrenadores) {
            if (en.getNombreCompleto().toLowerCase().contains(texto.toLowerCase())) {
                res.add(en);
            }
        }
        return res;
    }

    public boolean crearRutina(Rutina r) {
        if (r == null || buscarRutinaPorId(r.getId()) != null) {
            return false;
        }
        rutinas.add(r);
        return true;
    }

    public boolean actualizarRutina(Rutina r) {
        if (r == null) {
            return false;
        }
        for (int i = 0; i < rutinas.size(); i++) {
            if (rutinas.get(i).getId().equals(r.getId())) {
                rutinas.set(i, r);
                return true;
            }
        }
        return false;
    }

    public Rutina buscarRutinaPorId(String id) {
        for (Rutina ru : rutinas) {
            if (ru.getId().equals(id)) {
                return ru;
            }
        }
        return null;
    }

    public boolean eliminarRutina(String id) {
        for (int i = 0; i < rutinas.size(); i++) {
            if (rutinas.get(i).getId().equals(id)) {
                rutinas.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Rutina> buscarRutinaPorNombre(String texto) {
        List<Rutina> res = new ArrayList<>();
        for (Rutina ru : rutinas) {
            if (ru.getNombre().toLowerCase().contains(texto.toLowerCase())) {
                res.add(ru);
            }
        }
        return res;
    }

    public List<Rutina> todasLasRutinas() {
        return new ArrayList<>(rutinas);
    }

    public List<Entrenador> todosLosEntrenadores() {
        return new ArrayList<>(entrenadores);
    }

    public List<Miembro> todosLosMiembros() {
        return new ArrayList<>(miembros);
    }
}
