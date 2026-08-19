/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salud.mental.app.Clases.Menus;

import javax.swing.JOptionPane;
import salud.mental.app.Clases.Reporte;
import salud.mental.app.Clases.Usuario.Usuario;

/**
 *
 * @author PC
 */
public class MenuUsuario {

    public static void Menu_Usuario(Usuario usuario) {
        int opcion = 0;
        while (opcion != 6) {
            String menu = "menu de usuario  \n\n"
                    + "1. Registrar estado emocional\n"
                    + "2. Ver diario emocional\n"
                    + "3. Ver recomendacion del dia\n"
                    + "4. Ver reporte\n"
                    + "5. Editar perfil\n"
                    + "6. Cerrar sesion\n\n"
                    + "Elija una opcion   .";
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
                usuario.actualizarDatos();
            } else if (opcion == 6) {
                JOptionPane.showMessageDialog(null, "cerrando sesion");
            } else {
                JOptionPane.showMessageDialog(null, "opcion no valida tiene que ser 1, 2, 3, 4, 5 o 6");
            }
        }
    }
}
