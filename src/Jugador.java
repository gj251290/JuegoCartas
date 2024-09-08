import javax.swing.JPanel;
import java.util.Arrays;
import java.util.Random;

public class Jugador {
    private final int TOTAL_CARTAS = 10;
    private final int MARGEN = 10;
    private final int DISTANCIA = 50;

    private Carta[] cartas = new Carta[TOTAL_CARTAS];
    private Random r = new Random();

    public void repartir() {
        for (int i = 0; i < TOTAL_CARTAS; i++) {
            cartas[i] = new Carta(r);
        }
    }

    public void mostrar(JPanel pnl) {
        pnl.removeAll();
        int i = 0;
        for (Carta c : cartas) {
            c.mostrar(pnl, MARGEN + i++ * DISTANCIA, MARGEN); // mostrar carta no tapada
        }
        pnl.repaint();
    }

    public String getGrupos() {
        String mensaje = "No se encontraron grupos";
        int[] contadores = new int[NombreCarta.values().length];

        for (Carta c : cartas) {
            contadores[c.getNombre().ordinal()]++;
        }

        boolean hayGrupos = false;
        for (int i = 0; i < contadores.length; i++) {
            if (contadores[i] >= 2) {
                if (!hayGrupos) {
                    hayGrupos = true;
                    mensaje = "Los grupos que se encontraron fueron:\n";
                }
                mensaje += Grupo.values()[contadores[i]] + " de " + NombreCarta.values()[i] + "\n";
            }
        }

        return mensaje;
    }

    public String detectarEscalera() {
        Arrays.sort(cartas, (c1, c2) -> c1.getNombre().ordinal() - c2.getNombre().ordinal());
        for (int i = 0; i < TOTAL_CARTAS - 3; i++) {
            if (cartas[i].getPinta() == cartas[i + 1].getPinta() &&
                    cartas[i].getPinta() == cartas[i + 2].getPinta() &&
                    cartas[i].getPinta() == cartas[i + 3].getPinta() &&
                    cartas[i + 1].getNombre().ordinal() == cartas[i].getNombre().ordinal() + 1 &&
                    cartas[i + 2].getNombre().ordinal() == cartas[i].getNombre().ordinal() + 2 &&
                    cartas[i + 3].getNombre().ordinal() == cartas[i].getNombre().ordinal() + 3) {
                return "Escalera de " + cartas[i].getPinta() + " formada por " + cartas[i].getNombre() + " a "
                        + cartas[i + 3].getNombre();
            }
        }
        return "No se encontró escalera";
    }

    public int calcularPuntaje() {
        int puntaje = 0;
        for (Carta c : cartas) {
            puntaje += c.obtenerValor();
        }
        return puntaje;
    }
}
