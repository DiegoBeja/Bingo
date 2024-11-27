import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class VentanaPatron extends JFrame{
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
            String archivoNombre = "C:\\Users\\bombo\\IdeaProjects\\Bingo\\src\\Patrones\\patron" + (i + 1) + ".png";
            ImageIcon imagPatrones = new ImageIcon(archivoNombre);

            // Redimensionar la imagen
            Image img = imagPatrones.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
            ImageIcon imagenPatrones = new ImageIcon(img);

            // Crear un panel para cada imagen y botón
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new BorderLayout());

            // Crear el JLabel con la imagen
            JLabel etiquetaImagen = new JLabel(imagenPatrones);
            etiquetaImagen.setHorizontalAlignment(SwingConstants.CENTER);

            JPanel botonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 5)); // FlowLayout centrado
            JButton botonSeleccionar = new JButton("Patron" + (i+1));
            botonSeleccionar.setFocusable(false); // Evitar que se muestre el enfoque
            botonSeleccionar.setFont(new Font("Arial", Font.PLAIN, 10)); // Fuente pequeña
            botonSeleccionar.setMargin(new Insets(0, 0, 0, 0)); // Márgenes internos ajustados

            botonSeleccionar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String actionCommand = e.getActionCommand().replaceAll("[^\\d]", "");
                    patronVictoria= Patrones.getPatron(Integer.parseInt(actionCommand) - 1);
                    for(int i = 0; i < patronVictoria.length; i++){
                        for(int j = 0; j < patronVictoria[i].length; j++) {
                            System.out.print(patronVictoria[i][j] + " "); // Imprimimos cada elemento con un espacio
                        }
                        System.out.println(); // Nueva línea después de cada fila
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
        panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Centrado y con espaciado

        // Configuración del JTextField
        tiradasTombola = new JTextField(15); // Ancho moderado
        tiradasTombola.setEnabled(false);
        tiradasTombola.setFont(new Font("Arial", Font.PLAIN, 14));
        panelInferior.add(tiradasTombola);

        // Configuración del botón "JUGAR"
        jugar = new JButton("JUGAR");
        jugar.setEnabled(false);
        jugar.setFont(new Font("Arial", Font.BOLD, 14));
        jugar.setPreferredSize(new Dimension(100, 30)); // Tamaño moderado
        panelInferior.add(jugar);

        // Agregar el panel inferior a la parte inferior del JFrame con un pequeño margen
        JPanel contenedorInferior = new JPanel(new BorderLayout());
        contenedorInferior.add(panelInferior, BorderLayout.CENTER); // Centrado
        contenedorInferior.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50)); // Márgenes ajustados (reduce el espacio inferior)

        add(contenedorInferior, BorderLayout.SOUTH);

        setVisible(true);

        jugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                InterfazJuego Bingo = new InterfazJuego();
                Bingo.setVisible(true);
            }
        });
    }


}
