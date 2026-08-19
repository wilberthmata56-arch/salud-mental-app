/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salud.mental.app;
import javax.swing.JOptionPane;
/**
 *
 * @author facal
 */
public class DiarioEmocional {
    private RegistroEmocional[] registros;

    public DiarioEmocional() {
        this.registros = new RegistroEmocional[10];
    }

    public DiarioEmocional(RegistroEmocional[] registros) {
        this.registros = registros;
    }

    public RegistroEmocional[] getRegistros() {
        return registros;
    }

    public void setRegistros(RegistroEmocional[] registros) {
        this.registros = registros;
    }
        
    public RegistroEmocional[] obtenerRegistros() {
        return registros;
    }

    public boolean agregarRegistro(RegistroEmocional nuevoRegistro) {
        if (this.registros == null) {
            this.registros = new RegistroEmocional[10];
        }

        for (int indice = 0; indice < this.registros.length; indice++) {
            if (this.registros[indice] == null) {
                this.registros[indice] = nuevoRegistro;
                return true;
            }
        }
        return false;
    }
    
    public int contarRegistros() {
        if (registros == null) {
            return 0;
        }

        int contador = 0;
        for (int i = 0; i < registros.length; i++) {
            if (registros[i] != null) {
                int incremento = contador + 1;
                contador = incremento;
            }
        }
        return contador;
    }

    public void mostrarDiario() {
        if (registros == null) {
            String mensajeVacio = "No hay registros cargados en el diario emocional.";
            JOptionPane.showMessageDialog(null, mensajeVacio);
            return;
        }

        int cantidad = this.contarRegistros();
        if (cantidad == 0) {
            String mensajeSinDatos = "El diario emocional no tiene registros aun.";
            JOptionPane.showMessageDialog(null, mensajeSinDatos);
            return;
        }

        String reporte = "=== DIARIO EMOCIONAL ===\n\n";

        for (int i = 0; i < registros.length; i++) {
            RegistroEmocional registroActual = registros[i];

            if (registroActual != null) {
                String fecha = registroActual.getFecha();
                String animo = registroActual.getEstadoAnimo();
                String nota = registroActual.getNota();

                String linea = "Fecha: " + fecha + " | Animo: " + animo + " | Nota: " + nota + "\n";
                reporte = reporte + linea;
            }
        }

        JOptionPane.showMessageDialog(null, reporte);
    }
}
