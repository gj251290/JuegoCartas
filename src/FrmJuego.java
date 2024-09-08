import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmJuego extends JFrame {
    private JButton btnRepartir;
    private JButton btnVerificar;
    private JButton btnEscalera;
    private JButton btnPuntaje;
    private JPanel pnlJugador1;
    private JPanel pnlJugador2;
    private JTabbedPane tpJugadores;

    Jugador jugador1 = new Jugador();
    Jugador jugador2 = new Jugador();

    public FrmJuego() {
        btnRepartir = new JButton();
        btnVerificar = new JButton();
        btnEscalera = new JButton();
        btnPuntaje = new JButton();
        tpJugadores = new JTabbedPane();
        pnlJugador1 = new JPanel();
        pnlJugador2 = new JPanel();

        setSize(600, 300);
        setTitle("Juego de Cartas");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pnlJugador1.setBackground(new Color(153, 255, 51));
        pnlJugador1.setLayout(null);
        pnlJugador2.setBackground(new Color(0, 255, 255));
        pnlJugador2.setLayout(null);

        tpJugadores.setBounds(10, 40, 550, 170);
        tpJugadores.addTab("Martín Estrada Contreras", pnlJugador1);
        tpJugadores.addTab("Raul Vidal", pnlJugador2);

        btnRepartir.setBounds(10, 10, 100, 25);
        btnRepartir.setText("Repartir");
        btnRepartir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnRepartirClick(evt);
            }
        });

        btnVerificar.setBounds(120, 10, 100, 25);
        btnVerificar.setText("Verificar");
        btnVerificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnVerificarClick(evt);
            }
        });

        btnEscalera.setBounds(230, 10, 100, 25);
        btnEscalera.setText("Escalera");
        btnEscalera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnEscaleraClick(evt);
            }
        });

        btnPuntaje.setBounds(340, 10, 100, 25);
        btnPuntaje.setText("Puntaje");
        btnPuntaje.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnPuntajeClick(evt);
            }
        });

        getContentPane().setLayout(null);
        getContentPane().add(tpJugadores);
        getContentPane().add(btnRepartir);
        getContentPane().add(btnVerificar);
        getContentPane().add(btnEscalera);
        getContentPane().add(btnPuntaje);
    }

    private void btnRepartirClick(ActionEvent evt) {
        jugador1.repartir();
        jugador1.mostrar(pnlJugador1);

        jugador2.repartir();
        jugador2.mostrar(pnlJugador2);
    }

    private void btnVerificarClick(ActionEvent evt) {
        int pestañaescogida = tpJugadores.getSelectedIndex();

        switch (pestañaescogida) {
            case 0:
                JOptionPane.showMessageDialog(null, jugador1.getGrupos());
                break;
            case 1:
                JOptionPane.showMessageDialog(null, jugador2.getGrupos());
                break;
        }
    }

    private void btnEscaleraClick(ActionEvent evt) {
        int pestañaescogida = tpJugadores.getSelectedIndex();

        switch (pestañaescogida) {
            case 0:
                JOptionPane.showMessageDialog(null, jugador1.detectarEscalera());
                break;
            case 1:
                JOptionPane.showMessageDialog(null, jugador2.detectarEscalera());
                break;
        }
    }

    private void btnPuntajeClick(ActionEvent evt) {
        int puntajeJugador1 = jugador1.calcularPuntaje();
        int puntajeJugador2 = jugador2.calcularPuntaje();
        JOptionPane.showMessageDialog(null,
                "Puntaje Jugador 1: " + puntajeJugador1 + "\nPuntaje Jugador 2: " + puntajeJugador2);
    }
}
