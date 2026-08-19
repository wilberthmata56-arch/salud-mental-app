/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salud.mental.app;

/**
 *
 * @author Wilberth
 */
public class EstadoAnimo {
    private String nombre;
    private String categoria;

    public EstadoAnimo() {
    }

    public EstadoAnimo(String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public static EstadoAnimo obtenerPorEscala(int opcionEscala) {
        if (opcionEscala == 5) {
            return new EstadoAnimo("Feliz", "Positiva");
        } else if (opcionEscala == 4) {
            return new EstadoAnimo("Tranquilo", "Positiva");
        } else if (opcionEscala == 3) {
            return new EstadoAnimo("Triste", "Negativa");
        } else if (opcionEscala == 2) {
            return new EstadoAnimo("Ansioso", "Negativa");
        } else if (opcionEscala == 1) {
            return new EstadoAnimo("Enojado", "Negativa");
        } else {
            return null;
        }
    }
}
