/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salud.mental.app;

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
