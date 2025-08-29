package gym.controller;

import gym.model.*;
import gym.repo.GimnasioRepositorio;
import java.util.List;

/**
 * Controlador de Rutina (sin impresiones).
 */
public class RutinaController {

    private GimnasioRepositorio repo;

    public RutinaController(GimnasioRepositorio repo) {
        this.repo = repo;
    }

    public boolean crearRutina(String id, String nombre, String nivel, boolean activa) {
        return repo.crearRutina(new Rutina(id, nombre, nivel, activa));
    }

    public boolean actualizarRutina(String id, String nombre, String nivel) {
        Rutina r = repo.buscarRutinaPorId(id);
        if (r == null) {
            return false;
        }
        r.setNombre(nombre);
        r.setNivel(nivel);
        return repo.actualizarRutina(r);
    }

    public boolean eliminarRutina(String id) {
        Rutina r = repo.buscarRutinaPorId(id);
        if (r == null) {
            return false;
        }
        for (Miembro m : r.getMiembros()) {
            m.removerRutina(r.getId());
        }
        return repo.eliminarRutina(id);
    }

    public Rutina buscarRutinaPorId(String id) {
        return repo.buscarRutinaPorId(id);
    }

    public java.util.List<Rutina> buscarPorNombre(String texto) {
        return repo.buscarRutinaPorNombre(texto);
    }

    public List<Rutina> listarRutinas() {
        return repo.todasLasRutinas();
    }

    public boolean activarRutina(String id) {
        Rutina r = repo.buscarRutinaPorId(id);
        if (r == null) {
            return false;
        
        }r.activar();
        return repo.actualizarRutina(r);
    }

    public boolean desactivarRutina(String id) {
        Rutina r = repo.buscarRutinaPorId(id);
        if (r == null) {
            return false;
        
        }r.desactivar();
        return repo.actualizarRutina(r);
    }

    public java.util.List<Rutina> listarActivas() {
        java.util.ArrayList<Rutina> res = new java.util.ArrayList<>();
        for (Rutina r : repo.todasLasRutinas()) {
            if (r.isActiva()) {
                res.add(r);
        
            }
        }return res;
    }

    public boolean agregarEjercicio(String rutinaId, String nombre, int series, int repeticiones, String grupo, int duracionMin) {
        Rutina r = repo.buscarRutinaPorId(rutinaId);
        if (r == null) {
            return false;
        }
        Ejercicio e = new Ejercicio(nombre, series, repeticiones, grupo, duracionMin);
        return r.agregarEjercicio(e) && repo.actualizarRutina(r);
    }

    public boolean removerEjercicio(String rutinaId, String nombre) {
        Rutina r = repo.buscarRutinaPorId(rutinaId);
        if (r == null) {
            return false;
        }
        boolean ok = r.removerEjercicio(nombre);
        return ok && repo.actualizarRutina(r);
    }

    public java.util.List<Miembro> listarMiembros(String rutinaId) {
        Rutina r = repo.buscarRutinaPorId(rutinaId);
        if (r == null) {
            return new java.util.ArrayList<>();
        
        }return r.getMiembros();
    }
}
