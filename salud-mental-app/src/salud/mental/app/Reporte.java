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

    public void generar(DiarioEmocional diario) {
        RegistroEmocional[] registros = diario.obtenerRegistros();
        int cantidad = diario.contarRegistros();
        this.cantidadRegistros = cantidad;
        if (cantidad == 0) {
            this.estadoMasFrecuente = "sin registros";
            this.fechaUltimoRegistro = "sin registros";
            return;
        }
        String[] nombres = {"Feliz", "Tranquilo", "Triste", "Ansioso", "Enojado"};
        int[] conteos = new int[5];
        for (int i = 0; i < cantidad; i++) {
            String animo = registros[i].getEstadoAnimo();
            for (int j = 0; j < nombres.length; j++) {
                if (animo.equalsIgnoreCase(nombres[j])) {
                    conteos[j] = conteos[j] + 1;
                }
            }
        }
        int posMayor = 0;
        for (int j = 1; j < conteos.length; j++) {
            if (conteos[j] > conteos[posMayor]) {
                posMayor = j;
            }
        }
        if (conteos[posMayor] == 0) {
            this.estadoMasFrecuente = "no determinado";
        } else {
            this.estadoMasFrecuente = nombres[posMayor];
        }
        this.fechaUltimoRegistro = registros[cantidad - 1].getFecha();
    }

    public String getResumen() {
        String resumen = "reporte del diario emocional\n\n"
                + "cantidad total de registros: " + this.cantidadRegistros + "\n"
                + "emocion mas frecuente: " + this.estadoMasFrecuente + "\n"
                + "fecha del ultimo registro: " + this.fechaUltimoRegistro;
        return resumen;
    }
}