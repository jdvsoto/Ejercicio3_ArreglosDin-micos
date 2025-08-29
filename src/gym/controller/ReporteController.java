package gym.controller;

import gym.model.*;
import gym.repo.GimnasioRepositorio;

/**
 * Controlador de reportes (sin impresiones).
 */
public class ReporteController {

    private GimnasioRepositorio repo;

    public ReporteController(GimnasioRepositorio repo) {
        this.repo = repo;
    }

    public Rutina rutinaMasPracticada() {
        Rutina mejor = null;
        int max = -1;
        for (Rutina r : repo.todasLasRutinas()) {
            int c = r.getMiembros().size();
            if (c > max) {
                max = c;
                mejor = r;
            }
        }
        return mejor;
    }

    public int totalRutinasActivas() {
        int c = 0;
        for (Rutina r : repo.todasLasRutinas()) {
            if (r.isActiva()) {
                c++;

            }
        }
        return c;
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
