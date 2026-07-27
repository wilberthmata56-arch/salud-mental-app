/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salud.mental.app;

/**
 *
 * @author Wilberth
 */
public class RegistroEmocional {
    private String fecha;
    private String estadoAnimo;
    private String nota;

    public RegistroEmocional(String fecha, String estadoAnimo, String nota) {
        this.fecha = fecha;
        this.estadoAnimo = estadoAnimo;
        this.nota = nota;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEstadoAnimo() {
        return estadoAnimo;
    }

    public String getNota() {
        return nota;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setEstadoAnimo(String estadoAnimo) {
        this.estadoAnimo = estadoAnimo;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
}
