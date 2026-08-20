/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salud.mental.app.Clases.Menus;

import javax.swing.JOptionPane;
import salud.mental.app.Clases.Usuario.Usuario;
import salud.mental.app.Clases.Usuario.UsuarioGestion;
import salud.mental.app.Clases.ValidadorNumerico;

/**
 *
 * @author PC
 */
public class MenuPrincipal {

    public static void Menu_Principal(UsuarioGestion usuarios) {
        int opcion = 0;
        while (opcion != 3) {
            String menu = "sistema de salud mental  \n\n"
                    + "1. Registrar usuario\n"
                    + "2. Iniciar sesion\n"
                    + "3. Salir del sistema\n\n"
                    + "Elija una opcion";
            String texto = JOptionPane.showInputDialog(menu);
            if (texto == null) {
                texto = "3";
            }
            if (ValidadorNumerico.esNumeroEntero(texto)) {
                opcion = Integer.parseInt(texto);
            } else {
                opcion = -1;
            }
            if (opcion == 1) {
                usuarios.registro();
            } else if (opcion == 2) {
                Usuario usuario = usuarios.inicioSesion();

                if (usuario != null) {
                    MenuUsuario.Menu_Usuario(usuario, usuarios);
                }
            } else if (opcion == 3) {
                JOptionPane.showMessageDialog(null, "saliendo del sistema :p");
            } else {
                JOptionPane.showMessageDialog(null, "opcion no valida tiene que ser 1, 2 o 3");
            }
        }
    }
}
