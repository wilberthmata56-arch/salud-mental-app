/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salud.mental.app.Clases;

import salud.mental.app.Clases.RegistroEmocional;

/**
 *
 * @author facal
 */
public class Consejo {

    private String texto;
    private String categoria;

    public Consejo() {
    }

    public Consejo(String texto, String categoria) {
        this.texto = texto;
        this.categoria = categoria;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void evaluarEmocion(RegistroEmocional registro) {
        if (registro == null) {
            String textoVacio = "No hay registro para evaluar el dia de hoy.";
            String categoriaVacia = "Sin Categoria";
            this.setTexto(textoVacio);
            this.setCategoria(categoriaVacia);
            return;
        }

        String animo = registro.getEstadoAnimo();

        if (animo.equalsIgnoreCase("Triste") || animo.equalsIgnoreCase("Ansioso")) {
            String textoConsejo = "Tomate un descanso de algunos y realiza respiraciones profundas ";
            String categoriaConsejo = "Relajacion y Calma";
            this.setTexto(textoConsejo);
            this.setCategoria(categoriaConsejo);
        } else if (animo.equalsIgnoreCase("Enojado")) {
            String textoConsejo = "Sal a caminar al aire libre, escucha musica suave o alguna cancion que te haga sentir bien ";
            String categoriaConsejo = "Manejo del estres";
            this.setTexto(textoConsejo);
            this.setCategoria(categoriaConsejo);
        } else {
            String textoConsejo = "Espero que tu dia siga asi aprovecha tu buena energia para contunuar con tu bienestar mental ";
            String categoriaConsejo = "Bienestar General";
            this.setTexto(textoConsejo);
            this.setCategoria(categoriaConsejo);
        }
    }

    public Actividad obtenerActividadSugerida(RegistroEmocional registro) {
        if (registro == null) {
            Actividad actividadVacia = new Actividad("Sin actividad asignada", "Sin Categoria");
            return actividadVacia;
        }

        String animo = registro.getEstadoAnimo();
        Actividad actividadRecomendada = null;

        if (animo.equalsIgnoreCase("Triste") || animo.equalsIgnoreCase("Ansioso")) {
            String descripcion = "Realizar ejercicio de respiracion .";
            String categoria = "Relajacion y calma";
            actividadRecomendada = new Actividad(descripcion, categoria);
        } else if (animo.equalsIgnoreCase("Enojado")) {
            String descripcion = "Caminar al aire libre y pensar con cabeza fria antes de tomar decisiones ";
            String categoria = "Manejo del estres ";
            actividadRecomendada = new Actividad(descripcion, categoria);
        } else {
            String descripcion = "cuentame tres cosas positivas que te sucedieron hoy.";
            String categoria = "Bienestar General";
            actividadRecomendada = new Actividad(descripcion, categoria);
        }

        return actividadRecomendada;
    }
}
