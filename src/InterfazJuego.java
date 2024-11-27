import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class InterfazJuego extends JFrame{
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


    public InterfazJuego(){
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

                tableroBingo[j][i] = new JLabel(String.valueOf(num));
                tableroBingo[j][i].setHorizontalAlignment(JLabel.CENTER);
                tableroBingo[j][i].setFont(new Font("Arial", Font.BOLD, 25));
                tableroBingo[j][i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                tableroBingo[j][i].setOpaque(true); // Para asegurar que el color de fondo sea visible
                tablero.add(tableroBingo[j][i]);
            }
        }

        infoGirar = new JPanel();
        bola = new Tombola();
        logicaBingo = new LogicaBingo();
        bolasJugadas = new ArrayList<>();
        infoGirar.setLayout(new BorderLayout());
        girar = new JButton("Girar");
        girar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bolasJugadas.add(bola.getNumeroTobola());
                System.out.println(bolasJugadas.getLast());
                ultimoTiro.setText(String.valueOf(bolasJugadas.getLast()));
                for(int i=0; i<5; i++){
                    for(int j=0; j<5; j++) {
                        if(logicaBingo.compararBolaTablero(tableroBingo[i][j], bolasJugadas.getLast())) {
                            tableroBingo[i][j].setBackground(Color.green);
                            tableroBingo[i][j].setOpaque(true);
                            VentanaPatron.patronVictoria[i][j] = 0;

                            for(int k = 0; k < VentanaPatron.patronVictoria.length; k++){
                                for(int m = 0; m < VentanaPatron.patronVictoria[k].length; m++) {
                                    System.out.print(VentanaPatron.patronVictoria[k][m] + " "); // Imprimimos cada elemento con un espacio
                                }
                                System.out.println(); // Nueva línea después de cada fila
                            }

                        }
                    }
                }
            }
        });

        // los numeros de abajo del tablero no se marcan verdes
        ultimoTiro = new JLabel();
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
}
