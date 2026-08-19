/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salud.mental.app.Clases.Menus;
import javax.swing.JOptionPane;
import salud.mental.app.Clases.Reporte;
import salud.mental.app.Clases.RegistroEmocional;
import salud.mental.app.Clases.Consejo;
import salud.mental.app.Clases.Actividad;
import salud.mental.app.Clases.ValidadorNumerico;
import salud.mental.app.Clases.Usuario.Usuario;
/**
 *
 * @author PC
 */
public class MenuUsuario {
    public static void Menu_Usuario(Usuario usuario) {
        int opcion = 0;
        while (opcion != 6) {
            String menu = "menu de usuario  \n\n"
                    + "1. Registrar estado emocional\n"
                    + "2. Ver diario emocional\n"
                    + "3. Ver recomendacion del dia\n"
                    + "4. Ver reporte\n"
                    + "5. Editar perfil\n"
                    + "6. Cerrar sesion\n\n"
                    + "Elija una opcion   .";
            String texto = JOptionPane.showInputDialog(menu);
            if (texto == null) {
                texto = "6";
            }
            if (ValidadorNumerico.esNumeroEntero(texto)) {
                opcion = Integer.parseInt(texto);
            } else {
                opcion = -1;
            }
            if (opcion == 1) {
                RegistroEmocional.registrarEstadoEmocional(usuario);
            } else if (opcion == 2) {
                usuario.getDiario().mostrarDiario();
            } else if (opcion == 3) {
                RegistroEmocional[] registros = usuario.getDiario().obtenerRegistros();
                int cant = usuario.getDiario().contarRegistros();
                if (cant == 0) {
                    JOptionPane.showMessageDialog(null, "No hay registros para generar una recomendacion.");
                } else {
                    RegistroEmocional ultimo = registros[cant - 1];
                    Consejo consejo = new Consejo();
                    consejo.evaluarEmocion(ultimo);
                    Actividad actividad = consejo.obtenerActividadSugerida(ultimo);
                    JOptionPane.showMessageDialog(null,
                            "Consejo: " + consejo.getTexto() + "\n\n"
                            + "Actividad sugerida: " + actividad.getDescripcion());
                }
            } else if (opcion == 4) {
                Reporte reporte = new Reporte();
                reporte.generar(usuario.getDiario());
                JOptionPane.showMessageDialog(null, reporte.getResumen());
            } else if (opcion == 5) {
                usuario.actualizarDatos();
            } else if (opcion == 6) {
                JOptionPane.showMessageDialog(null, "cerrando sesion");
            } else {
                JOptionPane.showMessageDialog(null, "opcion no valida tiene que ser 1, 2, 3, 4, 5 o 6");
            }
        }
    }
}