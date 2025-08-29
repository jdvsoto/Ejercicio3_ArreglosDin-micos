package gym.controller;

import gym.model.*;
import gym.repo.GimnasioRepositorio;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador de Miembro (sin impresiones).
 */
public class MiembroController {

    private GimnasioRepositorio repo;

    public MiembroController(GimnasioRepositorio repo) {
        this.repo = repo;
    }

    public boolean crearMiembro(String id, String nombre, TipoMembresia tipo, boolean activo) {
        Miembro m = new Miembro(id, nombre, tipo, activo);
        return repo.crearMiembro(m);
    }

    public boolean actualizarMiembro(String id, String nombre, TipoMembresia tipo, boolean activo) {
        Miembro m = repo.buscarMiembroPorId(id);
        if (m == null) {
            return false;
        }
        m.setNombreCompleto(nombre);
        m.setTipoMembresia(tipo);
        m.setActivo(activo);
        return repo.actualizarMiembro(m);
    }

    public boolean eliminarMiembro(String id) {
        Miembro m = repo.buscarMiembroPorId(id);
        if (m == null) {
            return false;
        }
        Entrenador e = m.getEntrenador();
        if (e != null) {
            e.removerMiembro(m.getId());
        }
        java.util.ArrayList<Rutina> copia = new java.util.ArrayList<>(m.getRutinas());
        for (Rutina r : copia) {
            r.removerMiembro(m.getId());
        }
        return repo.eliminarMiembro(id);
    }

    public Miembro buscarMiembroPorId(String id) {
        return repo.buscarMiembroPorId(id);
    }

    public List<Miembro> buscarPorNombre(String texto) {
        return repo.buscarMiembroPorNombre(texto);
    }

    public List<Miembro> listarPorMembresia(TipoMembresia tipo) {
        List<Miembro> res = new ArrayList<>();
        for (Miembro m : repo.todosLosMiembros()) {
            if (m.getTipoMembresia() == tipo) {
                res.add(m);
            }
        }
        return res;
    }

    public boolean asignarEntrenador(String miembroId, String entrenadorId) {
        Miembro m = repo.buscarMiembroPorId(miembroId);
        Entrenador e = repo.buscarEntrenadorPorId(entrenadorId);
        if (m == null || e == null) {
            return false;
        }
        Entrenador anterior = m.getEntrenador();
        if (anterior != null && !anterior.getId().equals(e.getId())) {
            anterior.removerMiembro(m.getId());
        }
        m.asignarEntrenador(e);
        return e.agregarMiembro(m);
    }

    public boolean removerEntrenador(String miembroId) {
        Miembro m = repo.buscarMiembroPorId(miembroId);
        if (m == null) {
            return false;
        }
        Entrenador e = m.getEntrenador();
        if (e != null) {
            e.removerMiembro(miembroId);
            m.removerEntrenador();
            return true;
        }
        return false;
    }

    public boolean asignarRutina(String miembroId, String rutinaId) {
        Miembro m = repo.buscarMiembroPorId(miembroId);
        Rutina r = repo.buscarRutinaPorId(rutinaId);
        if (m == null || r == null || !r.isActiva()) {
            return false;
        }
        boolean ok1 = m.asignarRutina(r);
        boolean ok2 = r.registrarMiembro(m);
        return ok1 && ok2;
    }

    public boolean removerRutina(String miembroId, String rutinaId) {
        Miembro m = repo.buscarMiembroPorId(miembroId);
        Rutina r = repo.buscarRutinaPorId(rutinaId);
        if (m == null || r == null) {
            return false;
        }
        boolean ok1 = m.removerRutina(rutinaId);
        boolean ok2 = r.removerMiembro(miembroId);
        return ok1 && ok2;
    }

    public List<Miembro> listarTodos() {
        return repo.todosLosMiembros();
    }
}
