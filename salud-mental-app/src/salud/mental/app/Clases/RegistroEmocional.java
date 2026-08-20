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

        String mesTexto = JOptionPane.showInputDialog("Ingrese el mes 1 a 12 ");
        if (mesTexto == null) {
            return;
        }
        int mes = ValidadorNumerico.esNumeroEntero(mesTexto) ? Integer.parseInt(mesTexto) : -1;
        while (mes < 1 || mes > 12) {
            mesTexto = JOptionPane.showInputDialog("El mes debe ser entre 1 y 12 ");
            if (mesTexto == null) {
                return;
            }
            mes = ValidadorNumerico.esNumeroEntero(mesTexto) ? Integer.parseInt(mesTexto) : -1;
        }

        int diaMaximo;
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            diaMaximo = 30;
        } else if (mes == 2) {
            diaMaximo = 28;
        } else {
            diaMaximo = 31;
        }

        String diaTexto = JOptionPane.showInputDialog("Ingrese el día 1 a " + diaMaximo);
        if (diaTexto == null) {
            return;
        }
        int dia = ValidadorNumerico.esNumeroEntero(diaTexto) ? Integer.parseInt(diaTexto) : -1;
        while (dia < 1 || dia > diaMaximo) {
            diaTexto = JOptionPane.showInputDialog("El día debe ser un número entre 1 y " + diaMaximo );
            if (diaTexto == null) {
                return;
            }
            dia = ValidadorNumerico.esNumeroEntero(diaTexto) ? Integer.parseInt(diaTexto) : -1;
        }

        String yearTexto = JOptionPane.showInputDialog("Ingrese el año ");
        if (yearTexto == null) {
            return;
        }
        while (!ValidadorNumerico.esNumeroEntero(yearTexto)) {
            yearTexto = JOptionPane.showInputDialog("El año debe ser un número");
            if (yearTexto == null) {
                return;
            }
        }

        String fecha = diaTexto + "/" + mesTexto + "/" + yearTexto;

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
