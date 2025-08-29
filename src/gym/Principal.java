package gym;

import gym.controller.*;
import gym.model.*;
import gym.repo.GimnasioRepositorio;
import java.util.List;
import java.util.Scanner;

/**
 * Clase Principal: ÚNICA clase que imprime y lee de consola. Administra menús y
 * delega a controladores. No usa while(true)+break.
 */
public class Principal {

    private final Scanner scanner = new Scanner(System.in);
    private final GimnasioRepositorio repo = new GimnasioRepositorio();
    private final MiembroController miembroCtrl = new MiembroController(repo);
    private final EntrenadorController entrenadorCtrl = new EntrenadorController(repo);
    private final RutinaController rutinaCtrl = new RutinaController(repo);
    private final ReporteController reporteCtrl = new ReporteController(repo);
    private boolean activo = true;

    public static void main(String[] args) {
        new Principal().run();
    }

    private void run() {
        seedDatosDemo();
        while (activo) {
            mostrarMenuPrincipal();
            int op = leerEnteroEnRango("Elige una opción: ", 0, 4);
            manejarOpcionPrincipal(op);
        }
        System.out.println("¡Hasta luego!");
    }

    private void mostrarMenuPrincipal() {
        System.out.println("\n===== GESTION DE GIMNASIO =====");
        System.out.println("1. Miembros");
        System.out.println("2. Entrenadores");
        System.out.println("3. Rutinas");
        System.out.println("4. Reportes");
        System.out.println("0. Salir");
    }

    private void manejarOpcionPrincipal(int op) {
        if (op == 1) {
            manejarMenuMiembros(); 
        }else if (op == 2) {
            manejarMenuEntrenadores(); 
        }else if (op == 3) {
            manejarMenuRutinas(); 
        }else if (op == 4) {
            manejarMenuReportes(); 
        }else if (op == 0) {
            confirmarSalida();
        }
    }

    private void manejarMenuMiembros() {
        int op = -1;
        while (op != 0) {
            System.out.println("\n--- MENÚ MIEMBROS ---");
            System.out.println("1. Crear miembro");
            System.out.println("2. Actualizar miembro");
            System.out.println("3. Eliminar miembro");
            System.out.println("4. Buscar por ID");
            System.out.println("5. Buscar por nombre");
            System.out.println("6. Listar por membresía");
            System.out.println("7. Asignar entrenador");
            System.out.println("8. Remover entrenador");
            System.out.println("9. Asignar rutina");
            System.out.println("10. Remover rutina");
            System.out.println("11. Listar todos");
            System.out.println("0. Volver");
            op = leerEnteroEnRango("Opción: ", 0, 11);

            switch (op) {
                case 1:
                    crearMiembroUI();
                    break;
                case 2:
                    actualizarMiembroUI();
                    break;
                case 3:
                    eliminarMiembroUI();
                    break;
                case 4:
                    buscarMiembroIdUI();
                    break;
                case 5:
                    buscarMiembroNombreUI();
                    break;
                case 6:
                    listarPorMembresiaUI();
                    break;
                case 7:
                    asignarEntrenadorUI();
                    break;
                case 8:
                    removerEntrenadorUI();
                    break;
                case 9:
                    asignarRutinaUI();
                    break;
                case 10:
                    removerRutinaUI();
                    break;
                case 11:
                    listarMiembrosUI();
                    break;
                default:
                    // No hacer nada para 0 (volver) u opciones inválidas
                    break;
            }
        }
    }

    private void manejarMenuEntrenadores() {
        int op = -1;
        while (op != 0) {
            System.out.println("\n--- MENÚ ENTRENADORES ---");
            System.out.println("1. Crear entrenador");
            System.out.println("2. Actualizar entrenador");
            System.out.println("3. Eliminar entrenador");
            System.out.println("4. Buscar por ID");
            System.out.println("5. Buscar por nombre");
            System.out.println("6. Listar todos");
            System.out.println("7. Listar alumnos de un entrenador");
            System.out.println("8. Entrenador con más alumnos");
            System.out.println("0. Volver");
            op = leerEnteroEnRango("Opción: ", 0, 8);

            if (op == 1) {
                crearEntrenadorUI(); 
            }else if (op == 2) {
                actualizarEntrenadorUI(); 
            }else if (op == 3) {
                eliminarEntrenadorUI(); 
            }else if (op == 4) {
                buscarEntrenadorIdUI(); 
            }else if (op == 5) {
                buscarEntrenadorNombreUI(); 
            }else if (op == 6) {
                listarEntrenadoresUI(); 
            }else if (op == 7) {
                listarAlumnosDeEntrenadorUI(); 
            }else if (op == 8) {
                entrenadorConMasAlumnosUI();
            }
        }
    }

    private void manejarMenuRutinas() {
        int op = -1;
        while (op != 0) {
            System.out.println("\n--- MENÚ RUTINAS ---");
            System.out.println("1. Crear rutina");
            System.out.println("2. Actualizar rutina");
            System.out.println("3. Eliminar rutina");
            System.out.println("4. Buscar por ID");
            System.out.println("5. Buscar por nombre");
            System.out.println("6. Listar todas");
            System.out.println("7. Activar rutina");
            System.out.println("8. Desactivar rutina");
            System.out.println("9. Listar activas");
            System.out.println("10. Agregar ejercicio");
            System.out.println("11. Remover ejercicio");
            System.out.println("12. Listar miembros de una rutina");
            System.out.println("0. Volver");
            op = leerEnteroEnRango("Opción: ", 0, 12);

            if (op == 1) {
                crearRutinaUI(); 
            }else if (op == 2) {
                actualizarRutinaUI(); 
            }else if (op == 3) {
                eliminarRutinaUI(); 
            }else if (op == 4) {
                buscarRutinaIdUI(); 
            }else if (op == 5) {
                buscarRutinaNombreUI(); 
            }else if (op == 6) {
                listarRutinasUI(); 
            }else if (op == 7) {
                activarRutinaUI(); 
            }else if (op == 8) {
                desactivarRutinaUI(); 
            }else if (op == 9) {
                listarRutinasActivasUI(); 
            }else if (op == 10) {
                agregarEjercicioUI(); 
            }else if (op == 11) {
                removerEjercicioUI(); 
            }else if (op == 12) {
                listarMiembrosPorRutinaUI();
            }
        }
    }

    private void manejarMenuReportes() {
        int op = -1;
        while (op != 0) {
            System.out.println("\n--- MENÚ REPORTES ---");
            System.out.println("1. Rutina más practicada");
            System.out.println("2. Total de rutinas activas");
            System.out.println("3. Entrenador con más alumnos");
            System.out.println("0. Volver");
            op = leerEnteroEnRango("Opción: ", 0, 3);

            if (op == 1) {
                rutinaMasPracticadaUI(); 
            }else if (op == 2) {
                totalRutinasActivasUI(); 
            }else if (op == 3) {
                entrenadorConMasAlumnosUI();
            }
        }
    }

    private String leerLineaNoVacia(String prompt) {
        System.out.print(prompt);
        String s = scanner.nextLine().trim();
        while (s.isEmpty()) {
            System.out.print("No puede estar vacío. Intenta de nuevo: ");
            s = scanner.nextLine().trim();
        }
        return s;
    }

    private int leerEnteroEnRango(String prompt, int min, int max) {
        System.out.print(prompt);
        while (true) {
            String s = scanner.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v < min || v > max) {
                    System.out.print("Fuera de rango [" + min + "-" + max + "]. Intenta de nuevo: "); 
                }else {
                    return v;
                }
            } catch (NumberFormatException ex) {
                System.out.print("Debe ser un número entero. Intenta de nuevo: ");
            }
        }
    }

    private boolean leerBooleano(String prompt) {
        System.out.print(prompt + " (s/n): ");
        String s = scanner.nextLine().trim().toLowerCase();
        while (!s.equals("s") && !s.equals("n")) {
            System.out.print("Responde 's' o 'n': ");
            s = scanner.nextLine().trim().toLowerCase();
        }
        return s.equals("s");
    }

    private void confirmarSalida() {
        boolean salir = leerBooleano("¿Seguro que deseas salir?");
        if (salir) {
            activo = false;
    
        }}

    // --- UI Miembros ---
    private void crearMiembroUI() {
        System.out.println("— Crear Miembro —");
        String id = leerLineaNoVacia("ID: ");
        String nombre = leerLineaNoVacia("Nombre completo: ");
        System.out.println("Tipo de membresía: 1=BASICA, 2=PREMIUM, 3=VIP");
        int t = leerEnteroEnRango("Opción: ", 1, 3);
        TipoMembresia tipo = (t == 1 ? TipoMembresia.BASICA : t == 2 ? TipoMembresia.PREMIUM : TipoMembresia.VIP);
        boolean activo = leerBooleano("¿Activo?");
        boolean ok = miembroCtrl.crearMiembro(id, nombre, tipo, activo);
        System.out.println(ok ? "Miembro creado." : "No se pudo crear (ID repetido o datos inválidos).");
    }

    private void actualizarMiembroUI() {
        System.out.println("— Actualizar Miembro —");
        String id = leerLineaNoVacia("ID existente: ");
        String nombre = leerLineaNoVacia("Nuevo nombre: ");
        System.out.println("Nuevo tipo: 1=BASICA, 2=PREMIUM, 3=VIP");
        int t = leerEnteroEnRango("Opción: ", 1, 3);
        TipoMembresia tipo = (t == 1 ? TipoMembresia.BASICA : t == 2 ? TipoMembresia.PREMIUM : TipoMembresia.VIP);
        boolean activo = leerBooleano("¿Activo?");
        boolean ok = miembroCtrl.actualizarMiembro(id, nombre, tipo, activo);
        System.out.println(ok ? "Miembro actualizado." : "No existe el miembro.");
    }

    private void eliminarMiembroUI() {
        System.out.println("— Eliminar Miembro —");
        String id = leerLineaNoVacia("ID: ");
        boolean ok = miembroCtrl.eliminarMiembro(id);
        System.out.println(ok ? "Miembro eliminado." : "No existe el miembro.");
    }

    private void buscarMiembroIdUI() {
        System.out.println("— Buscar Miembro por ID —");
        String id = leerLineaNoVacia("ID: ");
        Miembro m = miembroCtrl.buscarMiembroPorId(id);
        System.out.println(m != null ? m.toString() : "No existe.");
    }

    private void buscarMiembroNombreUI() {
        System.out.println("— Buscar Miembro por nombre —");
        String txt = leerLineaNoVacia("Texto: ");
        List<Miembro> lista = miembroCtrl.buscarPorNombre(txt);
        for (Miembro m : lista) {
            System.out.println(m.toString());
        }
        if (lista.isEmpty()) {
            System.out.println("(sin resultados)");
        }
    }

    private void listarPorMembresiaUI() {
        System.out.println("— Listar Miembros por tipo —");
        System.out.println("Tipo: 1=BASICA, 2=PREMIUM, 3=VIP");
        int t = leerEnteroEnRango("Opción: ", 1, 3);
        TipoMembresia tipo = (t == 1 ? TipoMembresia.BASICA : t == 2 ? TipoMembresia.PREMIUM : TipoMembresia.VIP);
        List<Miembro> lista = miembroCtrl.listarPorMembresia(tipo);
        for (Miembro m : lista) {
            System.out.println(m.toString());
        }
        if (lista.isEmpty()) {
            System.out.println("(sin resultados)");
        }
    }

    private void asignarEntrenadorUI() {
        System.out.println("— Asignar Entrenador a Miembro —");
        String miembroId = leerLineaNoVacia("Miembro ID: ");
        String entrenadorId = leerLineaNoVacia("Entrenador ID: ");
        boolean ok = miembroCtrl.asignarEntrenador(miembroId, entrenadorId);
        System.out.println(ok ? "Entrenador asignado." : "Error (IDs inválidos).");
    }

    private void removerEntrenadorUI() {
        System.out.println("— Remover Entrenador de Miembro —");
        String miembroId = leerLineaNoVacia("Miembro ID: ");
        boolean ok = miembroCtrl.removerEntrenador(miembroId);
        System.out.println(ok ? "Entrenador removido." : "Error (miembro/entrenador no válido).");
    }

    private void asignarRutinaUI() {
        System.out.println("— Asignar Rutina a Miembro —");
        String miembroId = leerLineaNoVacia("Miembro ID: ");
        String rutinaId = leerLineaNoVacia("Rutina ID: ");
        boolean ok = miembroCtrl.asignarRutina(miembroId, rutinaId);
        System.out.println(ok ? "Rutina asignada." : "Error (IDs inválidos o rutina inactiva).");
    }

    private void removerRutinaUI() {
        System.out.println("— Remover Rutina de Miembro —");
        String miembroId = leerLineaNoVacia("Miembro ID: ");
        String rutinaId = leerLineaNoVacia("Rutina ID: ");
        boolean ok = miembroCtrl.removerRutina(miembroId, rutinaId);
        System.out.println(ok ? "Rutina removida." : "Error (IDs inválidos).");
    }

    private void listarMiembrosUI() {
        System.out.println("— Listado de Miembros —");
        List<Miembro> lista = miembroCtrl.listarTodos();
        for (Miembro m : lista) {
            System.out.println(m.toString());
        }
        if (lista.isEmpty()) {
            System.out.println("(sin resultados)");
        }
    }

    private void crearEntrenadorUI() {
        System.out.println("— Crear Entrenador —");
        String id = leerLineaNoVacia("ID: ");
        String nombre = leerLineaNoVacia("Nombre completo: ");
        String esp = leerLineaNoVacia("Especialidad: ");
        boolean ok = entrenadorCtrl.crearEntrenador(id, nombre, esp);
        System.out.println(ok ? "Entrenador creado." : "No se pudo crear (ID repetido o datos inválidos).");
    }

    private void actualizarEntrenadorUI() {
        System.out.println("— Actualizar Entrenador —");
        String id = leerLineaNoVacia("ID existente: ");
        String nombre = leerLineaNoVacia("Nuevo nombre: ");
        String esp = leerLineaNoVacia("Nueva especialidad: ");
        boolean ok = entrenadorCtrl.actualizarEntrenador(id, nombre, esp);
        System.out.println(ok ? "Entrenador actualizado." : "No existe el entrenador.");
    }

    private void eliminarEntrenadorUI() {
        System.out.println("— Eliminar Entrenador —");
        String id = leerLineaNoVacia("ID: ");
        boolean ok = entrenadorCtrl.eliminarEntrenador(id);
        System.out.println(ok ? "Entrenador eliminado." : "No existe el entrenador.");
    }

    private void buscarEntrenadorIdUI() {
        System.out.println("— Buscar Entrenador por ID —");
        String id = leerLineaNoVacia("ID: ");
        Entrenador e = entrenadorCtrl.buscarEntrenadorPorId(id);
        System.out.println(e != null ? e.toString() : "No existe.");
    }

    private void buscarEntrenadorNombreUI() {
        System.out.println("— Buscar Entrenador por nombre —");
        String txt = leerLineaNoVacia("Texto: ");
        List<Entrenador> lista = entrenadorCtrl.buscarPorNombre(txt);
        for (Entrenador e : lista) {
            System.out.println(e.toString());
        }
        if (lista.isEmpty()) {
            System.out.println("(sin resultados)");
        }
    }

    private void listarEntrenadoresUI() {
        System.out.println("— Listado de Entrenadores —");
        List<Entrenador> lista = entrenadorCtrl.listarEntrenadores();
        for (Entrenador e : lista) {
            System.out.println(e.toString());
        }
        if (lista.isEmpty()) {
            System.out.println("(sin resultados)");
        }
    }

    private void listarAlumnosDeEntrenadorUI() {
        System.out.println("— Listar alumnos por Entrenador —");
        String id = leerLineaNoVacia("Entrenador ID: ");
        List<Miembro> lista = entrenadorCtrl.listarMiembros(id);
        for (Miembro m : lista) {
            System.out.println(m.toString());
        }
        if (lista.isEmpty()) {
            System.out.println("(sin resultados o entrenador inexistente)");
        }
    }

    private void entrenadorConMasAlumnosUI() {
        Entrenador e = entrenadorCtrl.entrenadorConMasAlumnos();
        System.out.println(e != null ? "Entrenador con más alumnos: " + e.toString() : "No hay entrenadores.");
    }

    private void crearRutinaUI() {
        System.out.println("— Crear Rutina —");
        String id = leerLineaNoVacia("ID: ");
        String nombre = leerLineaNoVacia("Nombre: ");
        String nivel = leerLineaNoVacia("Nivel (Inicial/Intermedio/Avanzado): ");
        boolean activa = leerBooleano("¿Activa?");
        boolean ok = rutinaCtrl.crearRutina(id, nombre, nivel, activa);
        System.out.println(ok ? "Rutina creada." : "No se pudo crear (ID repetido o datos inválidos).");
    }

    private void actualizarRutinaUI() {
        System.out.println("— Actualizar Rutina —");
        String id = leerLineaNoVacia("ID existente: ");
        String nombre = leerLineaNoVacia("Nuevo nombre: ");
        String nivel = leerLineaNoVacia("Nuevo nivel: ");
        boolean ok = rutinaCtrl.actualizarRutina(id, nombre, nivel);
        System.out.println(ok ? "Rutina actualizada." : "No existe la rutina.");
    }

    private void eliminarRutinaUI() {
        System.out.println("— Eliminar Rutina —");
        String id = leerLineaNoVacia("ID: ");
        boolean ok = rutinaCtrl.eliminarRutina(id);
        System.out.println(ok ? "Rutina eliminada." : "No existe la rutina.");
    }

    private void buscarRutinaIdUI() {
        System.out.println("— Buscar Rutina por ID —");
        String id = leerLineaNoVacia("ID: ");
        Rutina r = rutinaCtrl.buscarRutinaPorId(id);
        System.out.println(r != null ? r.toString() : "No existe.");
    }

    private void buscarRutinaNombreUI() {
        System.out.println("— Buscar Rutina por nombre —");
        String txt = leerLineaNoVacia("Texto: ");
        List<Rutina> lista = rutinaCtrl.buscarPorNombre(txt);
        for (Rutina r : lista) {
            System.out.println(r.toString());
        }
        if (lista.isEmpty()) {
            System.out.println("(sin resultados)");
        }
    }

    private void listarRutinasUI() {
        System.out.println("— Listado de Rutinas —");
        List<Rutina> lista = rutinaCtrl.listarRutinas();
        for (Rutina r : lista) {
            System.out.println(r.toString());
        }
        if (lista.isEmpty()) {
            System.out.println("(sin resultados)");
        }
    }

    private void activarRutinaUI() {
        System.out.println("— Activar Rutina —");
        String id = leerLineaNoVacia("ID: ");
        boolean ok = rutinaCtrl.activarRutina(id);
        System.out.println(ok ? "Rutina activada." : "No existe la rutina.");
    }

    private void desactivarRutinaUI() {
        System.out.println("— Desactivar Rutina —");
        String id = leerLineaNoVacia("ID: ");
        boolean ok = rutinaCtrl.desactivarRutina(id);
        System.out.println(ok ? "Rutina desactivada." : "No existe la rutina.");
    }

    private void listarRutinasActivasUI() {
        System.out.println("— Rutinas Activas —");
        List<Rutina> lista = rutinaCtrl.listarActivas();
        for (Rutina r : lista) {
            System.out.println(r.toString());
        }
        if (lista.isEmpty()) {
            System.out.println("(sin resultados)");
        }
    }

    private void agregarEjercicioUI() {
        System.out.println("— Agregar Ejercicio a Rutina —");
        String rutinaId = leerLineaNoVacia("Rutina ID: ");
        String nombre = leerLineaNoVacia("Nombre ejercicio: ");
        int series = leerEnteroEnRango("Series: ", 1, 100);
        int rep = leerEnteroEnRango("Repeticiones: ", 1, 1000);
        String grupo = leerLineaNoVacia("Grupo muscular: ");
        int dur = leerEnteroEnRango("Duración (min): ", 0, 600);
        boolean ok = rutinaCtrl.agregarEjercicio(rutinaId, nombre, series, rep, grupo, dur);
        System.out.println(ok ? "Ejercicio agregado." : "Error (rutina inexistente).");
    }

    private void removerEjercicioUI() {
        System.out.println("— Remover Ejercicio de Rutina —");
        String rutinaId = leerLineaNoVacia("Rutina ID: ");
        String nombre = leerLineaNoVacia("Nombre ejercicio: ");
        boolean ok = rutinaCtrl.removerEjercicio(rutinaId, nombre);
        System.out.println(ok ? "Ejercicio removido." : "Error (rutina inexistente o ejercicio no encontrado).");
    }

    private void listarMiembrosPorRutinaUI() {
        System.out.println("— Listar Miembros por Rutina —");
        String rutinaId = leerLineaNoVacia("Rutina ID: ");
        List<Miembro> lista = rutinaCtrl.listarMiembros(rutinaId);
        for (Miembro m : lista) {
            System.out.println(m.toString());
        }
        if (lista.isEmpty()) {
            System.out.println("(sin resultados o rutina inexistente)");
        }
    }

    private void rutinaMasPracticadaUI() {
        Rutina r = reporteCtrl.rutinaMasPracticada();
        System.out.println(r != null ? "Rutina más practicada: " + r.toString() : "No hay rutinas.");
    }

    private void totalRutinasActivasUI() {
        int c = reporteCtrl.totalRutinasActivas();
        System.out.println("Total de rutinas activas: " + c);
    }

    private void seedDatosDemo() {
        entrenadorCtrl.crearEntrenador("E1", "Ana López", "Fuerza");
        entrenadorCtrl.crearEntrenador("E2", "Luis Pérez", "Cardio");
        miembroCtrl.crearMiembro("M1", "Carlos Ruiz", TipoMembresia.BASICA, true);
        miembroCtrl.crearMiembro("M2", "María Díaz", TipoMembresia.PREMIUM, true);
        miembroCtrl.crearMiembro("M3", "Juan Gómez", TipoMembresia.VIP, false);
        rutinaCtrl.crearRutina("R1", "Full Body", "Inicial", true);
        rutinaCtrl.crearRutina("R2", "HIIT", "Intermedio", true);
        rutinaCtrl.crearRutina("R3", "Hipertrofia", "Avanzado", false);
        miembroCtrl.asignarEntrenador("M1", "E1");
        miembroCtrl.asignarEntrenador("M2", "E2");
        miembroCtrl.asignarRutina("M1", "R1");
        miembroCtrl.asignarRutina("M2", "R2");
        rutinaCtrl.agregarEjercicio("R1", "Sentadillas", 4, 12, "Piernas", 10);
        rutinaCtrl.agregarEjercicio("R1", "Press banca", 4, 10, "Pecho", 10);
        rutinaCtrl.agregarEjercicio("R2", "Burpees", 5, 15, "Cuerpo completo", 12);
    }
}
