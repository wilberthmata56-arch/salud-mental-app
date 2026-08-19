/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package salud.mental.app;
import javax.swing.JOptionPane;
/**
 *
 * @author Wilberth Mata Avellan, Steven Arias Novoa, Alejandro Artola Manzanares, Fabian Calderon Alpizar
 */
public class SaludMentalApp {
    public static void main(String[] args) {
        Menu_Principal();
    }
    public static void Menu_Principal() {
        int opcion = 0;
        while (opcion != 3) {
            String menu = "sistema de salud mental  \n\n"
                    + "1.Registrar usuario\n"
                    + "2.Iniciar sesion\n"
                    + "3.Salir del sistema\n\n"
                    + "elija una opcion   .";
            String texto = JOptionPane.showInputDialog(menu);
            if (texto == null) {
                texto = "3";
            }
            opcion = Integer.parseInt(texto);
            if (opcion == 1) {
                JOptionPane.showMessageDialog(null, "Aqui debe ir la logica: Registrar usuario");
            } else if (opcion == 2) {
                JOptionPane.showMessageDialog(null, "Aqui debe ir la logica: Iniciar sesion");
            } else if (opcion == 3) {
                JOptionPane.showMessageDialog(null, "saliendo del sistema :p");
            } else {
                JOptionPane.showMessageDialog(null, "opcion no valida tiene que ser 1, 2 o 3");
            }
        }
    }
    public static void Menu_Usuario(Usuario usuario) {
        int opcion = 0;
        while (opcion != 6) {
            String menu = "menu de usuario  \n\n"
                    + "1.Registrar estado emocional\n"
                    + "2.Ver diario emocional\n"
                    + "3.Ver recomendacion del dia\n"
                    + "4.Ver reporte\n"
                    + "5.Editar perfil\n"
                    + "6.Cerrar sesion\n\n"
                    + "elija una opcion   .";
            String texto = JOptionPane.showInputDialog(menu);
            if (texto == null) {
                texto = "6";
            }
            opcion = Integer.parseInt(texto);
            if (opcion == 1) {
                JOptionPane.showMessageDialog(null, "Aqui debe ir la logica: Registrar estado emocional");
            } else if (opcion == 2) {
                JOptionPane.showMessageDialog(null, "Aqui debe ir la logica: Ver diario emocional");
            } else if (opcion == 3) {
                JOptionPane.showMessageDialog(null, "Aqui debe ir la logica: Ver recomendacion del dia");
            } else if (opcion == 4) {
                Reporte reporte = new Reporte();
                reporte.generar(usuario.getDiario());
                JOptionPane.showMessageDialog(null, reporte.getResumen());
            } else if (opcion == 5) {
                JOptionPane.showMessageDialog(null, "Aqui debe ir la logica: Editar perfil");
            } else if (opcion == 6) {
                JOptionPane.showMessageDialog(null, "cerrando sesion");
            } else {
                JOptionPane.showMessageDialog(null, "opcion no valida tiene que ser 1, 2, 3, 4, 5 o 6");
            }
        }
    }
    
    public static void registrarEstadoEmocional(Usuario usuario) {
        String menuDeEscala= " Registro Emocional  \n\n"
                + "Seleccione su estado de ánimo actual:\n"
                + "5. Feliz\n"
                + "4. Tranquilo\n"
                + "3. Triste\n"
                + "2. Ansioso\n"
                + "1. Enojado\n\n"
                + "Elija una opción (1-5):";

        String opcionTexto = JOptionPane.showInputDialog(menuDeEscala);
        if (opcionTexto == null) {
            return;
        }

        int opcionEscala = Integer.parseInt(opcionTexto);
        EstadoAnimo estadoSeleccionado = EstadoAnimo.obtenerPorEscala(opcionEscala);

        if (estadoSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Opción no válida. Debe seleccionar un número del 1 al 5.");
            return;
        }

        String fecha = JOptionPane.showInputDialog("Ingrese la fecha actual (ejemplo: 18/08/2026):");
        if (fecha == null || fecha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La fecha es requerida para realizar el registro.");
            return;
        }

        String nota = JOptionPane.showInputDialog("Escriba una breve nota sobre cómo se siente hoy:");
        if (nota == null) {
            nota = "";
        }

        RegistroEmocional nuevoRegistro = new RegistroEmocional(fecha, estadoSeleccionado.getNombre(), nota);
        boolean guardadoConExito = usuario.getDiario().agregarRegistro(nuevoRegistro);

        if (guardadoConExito) {
            JOptionPane.showMessageDialog(null, "Estado registrado correctamente.\nCategoría asignada: " + estadoSeleccionado.getCategoria());
        } else {
            JOptionPane.showMessageDialog(null, "El diario está lleno (máximo alcanzado: 10 registros).");
        }
    }
}