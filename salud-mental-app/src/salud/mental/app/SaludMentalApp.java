/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package salud.mental.app;
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
}