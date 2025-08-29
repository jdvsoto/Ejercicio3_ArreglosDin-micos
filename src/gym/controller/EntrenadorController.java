package gym.controller;

import gym.model.*;
import gym.repo.GimnasioRepositorio;
import java.util.List;

/**
 * Controlador de Entrenador (sin impresiones).
 */
public class EntrenadorController {

    private GimnasioRepositorio repo;

    public EntrenadorController(GimnasioRepositorio repo) {
        this.repo = repo;
    }

    public boolean crearEntrenador(String id, String nombre, String especialidad) {
        return repo.crearEntrenador(new Entrenador(id, nombre, especialidad));
    }

    public boolean actualizarEntrenador(String id, String nombre, String especialidad) {
        Entrenador e = repo.buscarEntrenadorPorId(id);
        if (e == null) {
            return false;
        }
        e.setNombreCompleto(nombre);
        e.setEspecialidad(especialidad);
        return repo.actualizarEntrenador(e);
    }

    public boolean eliminarEntrenador(String id) {
        Entrenador e = repo.buscarEntrenadorPorId(id);
        if (e == null) {
            return false;
        }
        for (Miembro m : e.getMiembros()) {
            m.removerEntrenador();
        }
        return repo.eliminarEntrenador(id);
    }

    public Entrenador buscarEntrenadorPorId(String id) {
        return repo.buscarEntrenadorPorId(id);
    }

    public java.util.List<Entrenador> buscarPorNombre(String texto) {
        return repo.buscarEntrenadorPorNombre(texto);
    }

    public List<Entrenador> listarEntrenadores() {
        return repo.todosLosEntrenadores();
    }

    public java.util.List<Miembro> listarMiembros(String entrenadorId) {
        Entrenador e = repo.buscarEntrenadorPorId(entrenadorId);
        if (e == null) {
            return new java.util.ArrayList<>();

        }
        return e.getMiembros();
    }

    public Entrenador entrenadorConMasAlumnos() {
        Entrenador mejor = null;
        int max = -1;
        for (Entrenador e : repo.todosLosEntrenadores()) {
            int c = e.contarAlumnos();
            if (c > max) {
                max = c;
                mejor = e;
            }
        }
        return mejor;
    }
}
