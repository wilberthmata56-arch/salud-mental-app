/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salud.mental.app.Clases;

/**
 *
 * @author Wilberth
 */
public class ValidadorNumerico {

    public static boolean esNumeroEntero(String texto) {
        if (texto == null || texto.isEmpty()) {
            return false;
        }

        if (texto.length() > 9) {
            return false;
        }

        for (int i = 0; i < texto.length(); i++) {
            char elemento = texto.charAt(i);
            if (elemento < '0' || elemento > '9') {
                return false;
            }
        }

        return true;
    }
}
