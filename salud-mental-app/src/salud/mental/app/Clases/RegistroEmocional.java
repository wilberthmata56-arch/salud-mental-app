/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salud.mental.app.Clases;

import javax.swing.JOptionPane;
import salud.mental.app.Clases.Usuario.Usuario;

/**
 *
 * @author Wilberth
 */
public class RegistroEmocional {

    private String fecha;
    private String estadoAnimo;
    private String nota;

    public RegistroEmocional() {
    }

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

    public static void registrarEstadoEmocional(Usuario usuario) {
        String menuDeEscala = " Registro Emocional  \n\n"
                + "Seleccione su estado de ánimo actual:\n"
                + "5. Feliz\n"
                + "4. Tranquilo\n"
                + "3. Triste\n"
                + "2. Ansioso\n"
                + "1. Enojado\n\n"
                + "Elija una opción (1-5):";

        String opcionTexto = JOptionPane.showInputDialog(menuDeEscala);
        if (opcionTexto == null) {
            return;
        }

        while (!ValidadorNumerico.esNumeroEntero(opcionTexto)) {
            opcionTexto = JOptionPane.showInputDialog("opcion no valida tiene que ser un número del 1 al 5. Elija una opción (1-5):");
            if (opcionTexto == null) {
                return;
            }
        }

        int opcionEscala = Integer.parseInt(opcionTexto);
        EstadoAnimo estadoSeleccionado = EstadoAnimo.obtenerPorEscala(opcionEscala);

        while (estadoSeleccionado == null) {
            opcionTexto = JOptionPane.showInputDialog("Opción no válida. Debe seleccionar un número del 1 al 5:");
            if (opcionTexto == null) {
                return;
            }
            if (ValidadorNumerico.esNumeroEntero(opcionTexto)) {
                opcionEscala = Integer.parseInt(opcionTexto);
                estadoSeleccionado = EstadoAnimo.obtenerPorEscala(opcionEscala);
            }
        }

        String fecha = JOptionPane.showInputDialog("Ingrese la fecha actual (ejemplo: 18/08/2026):");
        if (fecha == null) {
            return;
        }

        while (fecha.isEmpty()) {
            fecha = JOptionPane.showInputDialog("La fecha es requerida. Ingrese la fecha actual (ejemplo: 18/08/2026):");
            if (fecha == null) {
                return;
            }
        }

        String nota = JOptionPane.showInputDialog("Escriba una breve nota sobre cómo se siente hoy:");
        if (nota == null) {
            nota = "";
        }

        RegistroEmocional nuevoRegistro = new RegistroEmocional(fecha, estadoSeleccionado.getNombre(), nota);
        boolean guardadoConExito = usuario.getDiario().agregarRegistro(nuevoRegistro);

        if (guardadoConExito) {
            JOptionPane.showMessageDialog(null, "Estado registrado correctamente.\nCategoría asignada: " + estadoSeleccionado.getCategoria());
        } else {
            JOptionPane.showMessageDialog(null, "El diario está lleno (máximo alcanzado: 10 registros).");
        }
    }
}
