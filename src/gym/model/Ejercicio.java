package gym.model;

/**
 * Modelo de dominio: Ejercicio de una rutina.
 */
public class Ejercicio {

    private String nombre;
    private int series;
    private int repeticiones;
    private String grupoMuscular;
    private int duracionMin;

    public Ejercicio(String nombre, int series, int repeticiones, String grupoMuscular, int duracionMin) {
        this.nombre = nombre;
        this.series = series;
        this.repeticiones = repeticiones;
        this.grupoMuscular = grupoMuscular;
        this.duracionMin = duracionMin;
    }

    public int cargaTotalEstimada() {
        return series * repeticiones;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSeries() {
        return series;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public int getDuracionMin() {
        return duracionMin;
    }

    @Override
    public String toString() {
        return "Ejercicio{nombre='" + nombre + "', series=" + series
                + ", repeticiones=" + repeticiones + ", grupo='" + grupoMuscular
                + "', duracionMin=" + duracionMin + ", carga=" + cargaTotalEstimada() + "}";
    }
}
