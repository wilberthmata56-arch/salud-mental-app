/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salud.mental.app.Clases;

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
        switch (opcionEscala) {
            case 5:
                return new EstadoAnimo("Feliz", "Positiva");
            case 4:
                return new EstadoAnimo("Tranquilo", "Positiva");
            case 3:
                return new EstadoAnimo("Triste", "Negativa");
            case 2:
                return new EstadoAnimo("Ansioso", "Negativa");
            case 1:
                return new EstadoAnimo("Enojado", "Negativa");
            default:
                return null;
        }
    }
}
