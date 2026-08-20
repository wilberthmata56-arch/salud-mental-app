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

        while (nombre.isEmpty()) {
            nombre = JOptionPane.showInputDialog(null, "El nombre no puede estar vacío. Ingrese su nombre:");
            if (nombre == null) {
                return false;
            }
        }

        String edadTexto = JOptionPane.showInputDialog(
                null,
                "Ingrese su edad:"
        );

        if (edadTexto == null) {
            return false;
        }

        while (!ValidadorNumerico.esNumeroEntero(edadTexto)) {
            edadTexto = JOptionPane.showInputDialog(null, "La edad tiene que ser un numero entero positivo. Ingrese su edad:");
            if (edadTexto == null) {
                return false;
            }
        }

        int edad = Integer.parseInt(edadTexto);

        String correo = JOptionPane.showInputDialog(
                null,
                "Ingrese su correo:"
        );

        if (correo == null) {
            return false;
        }

        while (correo.isEmpty()) {
            correo = JOptionPane.showInputDialog(null, "El correo no puede estar vacío. Ingrese su correo:");
            if (correo == null) {
                return false;
            }
        }

        while (!correo.contains("@")) {
            correo = JOptionPane.showInputDialog(null, "El correo debe contener un @. Ingrese su correo:");
            if (correo == null) {
                return false;
            }
        }

        correo = correo.toLowerCase();

        while (buscarUsuario(correo) != null) {
            correo = JOptionPane.showInputDialog(null, "El correo ya está registrado. Ingrese otro correo:");
            if (correo == null) {
                return false;
            }
            correo = correo.toLowerCase();
        }

        String contrasena = JOptionPane.showInputDialog(
                null,
                "Ingrese su contraseña:"
        );

        if (contrasena == null) {
            return false;
        }

        while (contrasena.isEmpty()) {
            contrasena = JOptionPane.showInputDialog(null, "La contraseña no puede estar vacía. Ingrese su contraseña:");
            if (contrasena == null) {
                return false;
            }
        }

        if (cantidadUsuarios >= usuarios.length) {
            JOptionPane.showMessageDialog(
                    null,
                    "No se pueden registrar más usuarios (límite alcanzado: 100)."
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
