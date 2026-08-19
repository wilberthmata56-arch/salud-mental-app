/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salud.mental.app.Clases.Usuario;

import javax.swing.JOptionPane;
import salud.mental.app.Clases.ValidadorNumerico;

/**
 *
 * @author PC
 */
public class UsuarioGestion {

    private Usuario[] usuarios;
    private int cantidadUsuarios;

    public UsuarioGestion() {
        usuarios = new Usuario[100];
        cantidadUsuarios = 0;
    }

    public boolean registro() {

        String nombre = JOptionPane.showInputDialog(
                null,
                "Ingrese su nombre:"
        );

        if (nombre == null) {
            return false;
        }

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "El nombre no puede estar vacío."
            );
            return false;
        }

        String edadTexto = JOptionPane.showInputDialog(
                null,
                "Ingrese su edad:"
        );

        if (edadTexto == null) {
            return false;
        }

        if (!ValidadorNumerico.esNumeroEntero(edadTexto)) {
            JOptionPane.showMessageDialog(
                    null,
                    "La edad tiene que ser un numoero entero positivo"
            );
            return false;
        }

        int edad = Integer.parseInt(edadTexto);

        String correo = JOptionPane.showInputDialog(
                null,
                "Ingrese su correo:"
        );

        if (correo == null) {
            return false;
        }

        String contrasena = JOptionPane.showInputDialog(
                null,
                "Ingrese su contraseña:"
        );

        if (contrasena == null) {
            return false;
        }

        if (cantidadUsuarios >= usuarios.length) {
            return false;
        }

        if (buscarUsuario(correo) != null) {
            JOptionPane.showMessageDialog(
                    null,
                    "El correo ya está registrado."
            );
            return false;
        }

        usuarios[cantidadUsuarios] = new Usuario(
                nombre,
                edad,
                correo,
                contrasena
        );

        cantidadUsuarios++;

        JOptionPane.showMessageDialog(
                null,
                "Usuario registrado correctamente."
        );

        return true;
    }

    public Usuario validarInicioSesion(String correo, String contrasena) {

        for (int i = 0; i < cantidadUsuarios; i++) {

            if (usuarios[i].validarInicioSesion(correo, contrasena)) {
                return usuarios[i];
            }
        }

        return null;
    }

    public Usuario buscarUsuario(String correo) {

        for (int i = 0; i < cantidadUsuarios; i++) {

            if (usuarios[i].getCorreo().equalsIgnoreCase(correo)) {
                return usuarios[i];
            }
        }

        return null;
    }

    public Usuario inicioSesion() {

        String correo = JOptionPane.showInputDialog(
                null,
                "Ingrese su correo:"
        );

        if (correo == null) {
            return null;
        }

        String contrasena = JOptionPane.showInputDialog(
                null,
                "Ingrese su contraseña:"
        );

        if (contrasena == null) {
            return null;
        }

        Usuario usuario = validarInicioSesion(correo, contrasena);

        if (usuario != null) {
            JOptionPane.showMessageDialog(
                    null,
                    "Inicio de sesión exitoso.\n"
                    + "Bienvenido, " + usuario.getNombre()
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Correo o contraseña incorrectos."
            );
        }

        return usuario;
    }
}
