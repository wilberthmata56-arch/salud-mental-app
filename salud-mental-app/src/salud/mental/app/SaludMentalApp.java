/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package salud.mental.app;

import salud.mental.app.Clases.EstadoAnimo;
import salud.mental.app.Clases.RegistroEmocional;
import salud.mental.app.Clases.Usuario.Usuario;
import javax.swing.JOptionPane;
import salud.mental.app.Clases.Menus.MenuPrincipal;
import salud.mental.app.Clases.Usuario.UsuarioGestion;

/**
 *
 * @author Wilberth Mata Avellan, Steven Arias Novoa, Alejandro Artola
 * Manzanares, Fabian Calderon Alpizar
 */
public class SaludMentalApp {

    public static void main(String[] args) {
        UsuarioGestion usuarios = new UsuarioGestion();
        MenuPrincipal.Menu_Principal(usuarios);
    }

    public static void registrarEstadoEmocional(Usuario usuario) {
        String menuDeEscala = " Registro Emocional  \n\n"
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
