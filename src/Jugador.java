import java.util.Random;

import javax.swing.JPanel;

public class Jugador {
    private final int TOTAL_CARTAS = 10;
    private final int MARGEN = 10;
    private final int DISTANCIA = 50;

    private Carta[] cartas = new Carta[TOTAL_CARTAS];

    private Random r = new Random();

    public void repartir() {
        /*
         * for (int i = 0; i < TOTAL_CARTAS; i++) {
         * carta[i] = new Carta(r);
         * }
         */

        int i = 0;
        for (Carta c : cartas) {
            cartas[i++] = new Carta(r);
        }
    }

    public void mostrar(JPanel pnl) {
        int i = 0;
        for (Carta c : cartas) {
            c.mostrar(pnl, MARGEN + i++ * DISTANCIA, MARGEN);
        }

        pnl.repaint();
    }
}
