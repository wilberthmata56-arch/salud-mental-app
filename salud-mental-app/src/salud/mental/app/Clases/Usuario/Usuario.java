/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salud.mental.app.Clases.Usuario;

import javax.swing.JOptionPane;
import salud.mental.app.Clases.DiarioEmocional;
import salud.mental.app.Clases.ValidadorNumerico;
import salud.mental.app.Enum.ActualizarPerfil;

/**
 *
 * @author arias
 */
public class Usuario {

    private String nombre;
    private int edad;
    private String correo;
    private String contrasena;
    private DiarioEmocional diario;

    public Usuario() {
        this.diario = new DiarioEmocional();
    }

    public Usuario(String nombre, int edad, String correo, String contrasena) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.contrasena = contrasena;
        this.diario = new DiarioEmocional();
    }

    public boolean validarInicioSesion(String correo, String contrasena) {
        return this.correo.equals(correo.toLowerCase())
                && this.contrasena.equals(contrasena);
    }

    public void actualizarDatos(UsuarioGestion usuarios) {

        ActualizarPerfil[] opciones = ActualizarPerfil.values();

        int opcion = JOptionPane.showOptionDialog(
                null,
                "¿Qué dato desea editar?",
                "Editar perfil",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        switch (opcion) {

            case 0:
                String nuevoNombre = JOptionPane.showInputDialog(
                        null,
                        "Ingrese su nuevo nombre:"
                );

                if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
                    this.nombre = nuevoNombre;
                }
                break;

            case 1:
                String nuevaEdad = JOptionPane.showInputDialog(
                        null,
                        "Ingrese su nueva edad:"
                );

                if (nuevaEdad != null && !nuevaEdad.isEmpty()) {
                    if (ValidadorNumerico.esNumeroEntero(nuevaEdad)) {
                        this.edad = Integer.parseInt(nuevaEdad);
                    } else {
                        JOptionPane.showMessageDialog(null, "La edad tiene que ser un numero entero positivo");
                    }
                }
                break;

            case 2:
                String nuevoCorreo = JOptionPane.showInputDialog(
                        null,
                        "Ingrese su nuevo correo:"
                );

                if (nuevoCorreo != null && !nuevoCorreo.isEmpty()) {
                    Usuario existente = usuarios.buscarUsuario(nuevoCorreo);
                    if (existente != null && existente != this) {
                        JOptionPane.showMessageDialog(null, "El correo ya existe");
                    } else {
                        this.correo = nuevoCorreo.toLowerCase();
                    }
                }
                break;

            case 3:
                String nuevaContrasena = JOptionPane.showInputDialog(
                        null,
                        "Ingrese su nueva contraseña:"
                );

                if (nuevaContrasena != null && !nuevaContrasena.isEmpty()) {
                    this.contrasena = nuevaContrasena;
                }
                break;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public DiarioEmocional getDiario() {
        return diario;
    }

    public void setDiario(DiarioEmocional diario) {
        this.diario = diario;
    }
}
