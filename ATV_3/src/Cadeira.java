import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Queue;

public class Cadeira extends JFrame {

    private JTextField txtParticipantes;
    private JTextField txtBatidas;
    private JTextArea txtResultado;
    private JButton btnIniciar;

    public Cadeira() {
        setTitle("Jogo da Cadeira Musical Virtual");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Components
        add(new JLabel("Número de Participantes:"));
        txtParticipantes = new JTextField(10);
        add(txtParticipantes);

        add(new JLabel("Número de Batidas (k):"));
        txtBatidas = new JTextField(10);
        add(txtBatidas);

        btnIniciar = new JButton("Iniciar Jogo");
        add(btnIniciar);

        txtResultado = new JTextArea(10, 30);
        txtResultado.setEditable(false);
        add(new JScrollPane(txtResultado));

        // action
        btnIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iniciarJogo();
            }
        });
    }

    private void iniciarJogo() {
        txtResultado.setText("");  

        try {
            int n = Integer.parseInt(txtParticipantes.getText());
            int k = Integer.parseInt(txtBatidas.getText());

            if (n <= 0 || k <= 0) {
                JOptionPane.showMessageDialog(this, "Valores devem ser maiores que zero.");
                return;
            }

            Queue<Integer> fila = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                fila.add(i);
            }

            while (fila.size() > 1) {
                for (int i = 1; i < k; i++) {
                    int participante = fila.poll();
                    fila.add(participante);
                }
                int eliminado = fila.poll();
                txtResultado.append("Participante eliminado: " + eliminado + "\n");
            }

            int vencedor = fila.poll();
            txtResultado.append("O vencedor é o participante número: " + vencedor);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira números válidos.");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Cadeira gui = new Cadeira();
            gui.setVisible(true);
        });
    }
}

