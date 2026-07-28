/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salud.mental.app;

/**
 *
 * @author PC
 */
public class Reporte {
    private int cantidadRegistros;
    private String estadoMasFrecuente;
    private String fechaUltimoRegistro;

    public Reporte() {
    }

    public Reporte(int cantidadRegistros, String estadoMasFrecuente, String fechaUltimoRegistro) {
        this.cantidadRegistros = cantidadRegistros;
        this.estadoMasFrecuente = estadoMasFrecuente;
        this.fechaUltimoRegistro = fechaUltimoRegistro;
    }

    public int getCantidadRegistros() {
        return cantidadRegistros;
    }

    public void setCantidadRegistros(int cantidadRegistros) {
        this.cantidadRegistros = cantidadRegistros;
    }

    public String getEstadoMasFrecuente() {
        return estadoMasFrecuente;
    }

    public void setEstadoMasFrecuente(String estadoMasFrecuente) {
        this.estadoMasFrecuente = estadoMasFrecuente;
    }

    public String getFechaUltimoRegistro() {
        return fechaUltimoRegistro;
    }

    public void setFechaUltimoRegistro(String fechaUltimoRegistro) {
        this.fechaUltimoRegistro = fechaUltimoRegistro;
    }
    
    
}
