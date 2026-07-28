/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salud.mental.app;

/**
 *
 * @author facal
 */
public class DiarioEmocional {
    private RegistroEmocional[] registros;

    public DiarioEmocional() {
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
}
