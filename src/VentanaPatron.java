import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class VentanaPatron extends JFrame implements Mensaje{
    private JPanel panelPrincipal;
    private JLabel instrucciones;
    private JTextField tiradasTombola;
    private JButton jugar;
    private Map<JButton, String> botones;
    static int[][] patronVictoria;

    public VentanaPatron(){

        setTitle("Bingo");
        setSize(1300, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        instrucciones = new JLabel("Seleccione un patron e ingrese las tiradas de tombola");
        instrucciones.setFont(new Font("Arial", Font.PLAIN, 18));
        add(instrucciones, BorderLayout.NORTH);

        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(0, 7, 0, 0));

        add(panelPrincipal);

        botones = new HashMap<>();

        for (int i = 0; i < 38; i++) {
            String archivoNombre = "C:\\Users\\bombo\\Desktop\\Bingo\\Bingo\\src\\Patrones\\patron" + (i + 1) + ".png";
            ImageIcon imagPatrones = new ImageIcon(archivoNombre);

            Image img = imagPatrones.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon imagenPatrones = new ImageIcon(img);

            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new BorderLayout());

            JLabel etiquetaImagen = new JLabel(imagenPatrones);
            etiquetaImagen.setHorizontalAlignment(SwingConstants.CENTER);

            JPanel botonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 5));
            JButton botonSeleccionar = new JButton("Patron" + (i+1));
            botonSeleccionar.setFocusable(false);
            botonSeleccionar.setFont(new Font("Arial", Font.PLAIN, 10));
            botonSeleccionar.setMargin(new Insets(0, 0, 0, 0));

            botonSeleccionar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String actionCommand = e.getActionCommand().replaceAll("[^\\d]", "");
                    patronVictoria= Patrones.getPatron(Integer.parseInt(actionCommand) - 1);
                    for(int i = 0; i < patronVictoria.length; i++){
                        for(int j = 0; j < patronVictoria[i].length; j++) {
                            System.out.print(patronVictoria[i][j] + " ");
                        }
                        System.out.println();
                    }
                    tiradasTombola.setEnabled(true);
                    jugar.setEnabled(true);
                }
            });

            botones.put(botonSeleccionar, archivoNombre);

            botonPanel.add(botonSeleccionar);

            itemPanel.add(etiquetaImagen, BorderLayout.CENTER);
            itemPanel.add(botonPanel, BorderLayout.SOUTH);

            panelPrincipal.add(itemPanel);
        }

        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        tiradasTombola = new JTextField(15);
        tiradasTombola.setEnabled(false);
        tiradasTombola.setFont(new Font("Arial", Font.PLAIN, 14));
        panelInferior.add(tiradasTombola);

        jugar = new JButton("JUGAR");
        jugar.setEnabled(false);
        jugar.setFont(new Font("Arial", Font.BOLD, 14));
        jugar.setPreferredSize(new Dimension(100, 30));
        panelInferior.add(jugar);

        JPanel contenedorInferior = new JPanel(new BorderLayout());
        contenedorInferior.add(panelInferior, BorderLayout.CENTER);
        contenedorInferior.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        add(contenedorInferior, BorderLayout.SOUTH);

        setVisible(true);

        jugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Integer.parseInt(tiradasTombola.getText()) < 5 || Integer.parseInt(tiradasTombola.getText()) > 75){
                    mensaje("Ingrese un valor entre 5 y 75", "Bingo/src/multiplicar.png");
                    tiradasTombola.setText("");
                }else{
                    int tiradas = Integer.parseInt(tiradasTombola.getText());

                    dispose();
                    InterfazJuego Bingo = new InterfazJuego(tiradas);
                    Bingo.setVisible(true);
                }

            }
        });
    }

    @Override
    public void mensaje(String mensaje, String icono){
        ImageIcon bingo = new ImageIcon(icono);
        Image imgBingo = bingo.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon bingoEscalado = new ImageIcon(imgBingo);
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE, bingoEscalado);
    }

}
