import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTabbedPane tabbedPane1;
    private JTextField txtNombre;
    private JSpinner spiAsiento;
    private JComboBox cboTipo;
    private JButton btnAgregar;
    private JTextArea txtListado;
    private JButton btnAtender;
    private JTextField txtPasajero;
    private JButton btnPasajeroActual;
    private Cola cola1 = new Cola();

    public Ventana() {
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cola1.agregar(new Pasajero(
                            txtNombre.getText(),
                            Integer.parseInt(spiAsiento.getValue().toString()),
                            cboTipo.getSelectedItem().toString()));
                    JOptionPane.showMessageDialog(null, "Agregado correctamente");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                txtListado.setText(cola1.toString());
            }
        });

        btnAtender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Pasajero atendido = cola1.extraer();
                    atendido.setCheckin(true);
                    txtPasajero.setText("Atendido: " + atendido);
                    txtListado.setText(cola1.toString());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        btnPasajeroActual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    txtPasajero.setText("En atención: " + cola1.frente());
                    txtListado.setText(cola1.toString());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        // frame.pack();
        frame.setVisible(true);
    }
}