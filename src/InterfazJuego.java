import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class InterfazJuego extends JFrame implements Mensaje{
    private JPanel panelBingo;
    private JPanel tablero;
    private JPanel historial;
    private JPanel infoGirar;
    private JLabel[][] tableroBingo;
    private JButton girar;
    private JLabel[][] tableroHistorial;
    private JLabel ultimoTiro;
    private Tombola bola;
    private List<Integer> bolasJugadas;
    private LogicaBingo logicaBingo;
    private int tiradasRestantes;

    public InterfazJuego(int tiradasVentana){
        this.tiradasRestantes = tiradasVentana;

        setTitle("Bingo");
        setSize(1300, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        tablero = new JPanel();
        tablero.setLayout(new GridLayout(6, 5, 0, 0));
        Random rd = new Random();
        tableroBingo = new JLabel[6][5];
        String[] letras = {"B", "I", "N", "G", "O"};
        for (int i = 0; i < 5; i++) {
            tableroBingo[0][i] = new JLabel(letras[i]);
            tableroBingo[0][i].setHorizontalAlignment(JLabel.CENTER);
            tableroBingo[0][i].setFont(new Font("Arial", Font.BOLD, 25));
            tableroBingo[0][i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            tablero.add(tableroBingo[0][i]);
        }

        Set<Integer>[] usados = new HashSet[5];
        for (int i = 0; i < 5; i++) {
            usados[i] = new HashSet<>();
        }

        for (int j = 1; j < 6; j++) { // filas
            for (int i = 0; i < 5; i++) { // columnas
                int maxRandom = 15 * (i + 1);
                int minRandom = 15 * i + 1;
                int num;
                do {
                    num = rd.nextInt(maxRandom - minRandom + 1) + minRandom;
                } while (usados[i].contains(num));
                usados[i].add(num);

                if(i == 2 && j == 3){
                    tableroBingo[j][i] = new JLabel("Free");
                    tableroBingo[j][i].setHorizontalAlignment(JLabel.CENTER);
                    tableroBingo[j][i].setFont(new Font("Arial", Font.BOLD, 25));
                    tableroBingo[j][i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    tableroBingo[j][i].setOpaque(true);
                    tablero.add(tableroBingo[j][i]);
                } else{
                    tableroBingo[j][i] = new JLabel(String.valueOf(num));
                    tableroBingo[j][i].setHorizontalAlignment(JLabel.CENTER);
                    tableroBingo[j][i].setFont(new Font("Arial", Font.BOLD, 25));
                    tableroBingo[j][i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    tableroBingo[j][i].setOpaque(true);
                    tablero.add(tableroBingo[j][i]);
                }
            }
        }

        infoGirar = new JPanel();
        infoGirar.setBackground(new Color(245, 245, 245));
        infoGirar.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 2));
        bola = new Tombola();
        logicaBingo = new LogicaBingo();
        bolasJugadas = new ArrayList<>();
        infoGirar.setLayout(new BorderLayout());
        girar = new JButton("Girar");
        girar.setFont(new Font("Arial", Font.BOLD, 20));
        girar.setBackground(new Color(166, 164, 164));
        girar.setForeground(Color.WHITE);
        girar.setFocusPainted(false);
        girar.setPreferredSize(new Dimension(120, 40));

        girar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bolasJugadas.add(bola.getNumeroTobola());
                System.out.println(bolasJugadas.get(bolasJugadas.size() - 1));
                ultimoTiro.setText(String.valueOf(bolasJugadas.get(bolasJugadas.size() - 1)));
                for(int i=1; i<6; i++){
                    for(int j=0; j<5; j++) {
                        if(logicaBingo.compararBolaTablero(tableroBingo[i][j], bolasJugadas.get(bolasJugadas.size() - 1))) {
                            tableroBingo[i][j].setBackground(Color.green);
                            tableroBingo[i][j].setOpaque(true);
                            VentanaPatron.patronVictoria[i-1][j] = 0;

                            for(int k = 0; k < VentanaPatron.patronVictoria.length; k++){
                                for(int m = 0; m < VentanaPatron.patronVictoria[k].length; m++) {
                                    System.out.print(VentanaPatron.patronVictoria[k][m] + " ");
                                }
                                System.out.println();
                            }

                        }
                    }
                }
                tiradasRestantes--;
                if(logicaBingo.verificarVictoria()){
                    mensaje("GANASTE", "src/bingoIcono.png");
                    dispose();
                } else if(!logicaBingo.verificarVictoria() && tiradasRestantes <= 0){
                    mensaje("PERDISTE", "src/multiplicar.png");
                    dispose();
                }
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 16; j++) {
                        if (tableroHistorial[i][j].getText().equals(String.valueOf(bolasJugadas.getLast()))) {
                            tableroHistorial[i][j].setBackground(new Color(235, 157, 148));
                        }
                    }
                }
                System.out.println("tiradas restantes: "+tiradasRestantes);
            }
        });

        ultimoTiro = new JLabel();
        ultimoTiro.setFont(new Font("Arial", Font.BOLD, 18));
        ultimoTiro.setHorizontalAlignment(JLabel.CENTER);
        ultimoTiro.setOpaque(true);
        ultimoTiro.setBackground(new Color(240, 240, 240));
        ultimoTiro.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
        infoGirar.add(girar, BorderLayout.SOUTH);
        infoGirar.add(ultimoTiro, BorderLayout.CENTER);

        historial = new JPanel();
        historial.setLayout(new GridLayout(5, 16, 0, 0));
        tableroHistorial = new JLabel[5][16];
        int numero = 1;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 16; j++){
                tableroHistorial[i][j] = new JLabel();
                tableroHistorial[i][j].setHorizontalAlignment(JLabel.CENTER);
                tableroHistorial[i][j].setFont(new Font("Arial", Font.BOLD, 18));
                tableroHistorial[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));

                if(j == 0){
                    tableroHistorial[i][j].setText(letras[i]);
                    tableroHistorial[i][j].setOpaque(true);
                    tableroHistorial[i][j].setBackground(Color.gray);
                } else{
                    tableroHistorial[i][j].setText(String.valueOf(numero));
                    tableroHistorial[i][j].setOpaque(true);
                    numero++;
                }
                historial.add(tableroHistorial[i][j]);
            }
        }

        add(tablero, BorderLayout.CENTER);
        add(historial, BorderLayout.SOUTH);
        add(infoGirar, BorderLayout.EAST);


        setVisible(true);
    }

    @Override
    public void mensaje(String mensaje, String icono){
        ImageIcon bingo = new ImageIcon(icono);
        Image imgBingo = bingo.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon bingoEscalado = new ImageIcon(imgBingo);
        JOptionPane.showMessageDialog(null, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE, bingoEscalado);
    }
}
