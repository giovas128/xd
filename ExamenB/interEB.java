package ExamenB;

import EB.ExamenB;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interEB extends JFrame implements ActionListener {

    private JTextField txtTamano, txtAgregar;
    private JTextArea areaPilaA, areaPilaB, areaPilaC, areaUnion;
    private JButton btnLlenar, btnAgregar, btnMostrar, btnUnion1, btnUnion2, btnUnion3;
    private int[] pilaA, pilaB, pilaC;
    private int topeA = 0, topeB = 0, topeC = 0;

    public interEB() {
        setTitle("Interfaz Examen B");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700);
        setLocationRelativeTo(null);
        JPanel ventana = new JPanel();
        ventana.setBackground(new Color(2, 204, 15));
        ventana.setLayout(null);

        JLabel lblTitulo = new JLabel("EXAMEN B");
        lblTitulo.setBounds(180, 20, 200, 40);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        ventana.add(lblTitulo);

        JLabel lblTamano = new JLabel("Tamaño de la pila:");
        lblTamano.setBounds(50, 80, 120, 20);
        ventana.add(lblTamano);

        txtTamano = new JTextField();
        txtTamano.setBounds(180, 80, 80, 30);
        ventana.add(txtTamano);

        btnLlenar = new JButton("LLENAR");
        btnLlenar.setBounds(280, 80, 100, 30);
        btnLlenar.addActionListener(this);
        ventana.add(btnLlenar);

        JLabel lblAgregar = new JLabel("Agregar valor:");
        lblAgregar.setBounds(50, 130, 120, 20);
        ventana.add(lblAgregar);

        txtAgregar = new JTextField();
        txtAgregar.setBounds(180, 130, 80, 30);
        ventana.add(txtAgregar);

        btnAgregar = new JButton("AGREGAR");
        btnAgregar.setBounds(280, 130, 100, 30);
        btnAgregar.addActionListener(this);
        ventana.add(btnAgregar);

        btnMostrar = new JButton("MOSTRAR");
        btnMostrar.setBounds(50, 180, 150, 30);
        btnMostrar.addActionListener(this);
        ventana.add(btnMostrar);

        btnUnion1 = new JButton("UNIÓN 1");
        btnUnion1.setBounds(220, 180, 150, 30);
        btnUnion1.addActionListener(this);
        ventana.add(btnUnion1);

        btnUnion2 = new JButton("UNIÓN 2");
        btnUnion2.setBounds(50, 230, 150, 30);
        btnUnion2.addActionListener(this);
        ventana.add(btnUnion2);

        btnUnion3 = new JButton("UNIÓN 3");
        btnUnion3.setBounds(220, 230, 150, 30);
        btnUnion3.addActionListener(this);
        ventana.add(btnUnion3);

        areaPilaA = new JTextArea();
        areaPilaA.setEditable(false);
        JScrollPane scrollA = new JScrollPane(areaPilaA);
        scrollA.setBounds(50, 280, 100, 300);
        ventana.add(scrollA);

        areaPilaB = new JTextArea();
        areaPilaB.setEditable(false);
        JScrollPane scrollB = new JScrollPane(areaPilaB);
        scrollB.setBounds(160, 280, 100, 300);
        ventana.add(scrollB);

        areaPilaC = new JTextArea();
        areaPilaC.setEditable(false);
        JScrollPane scrollC = new JScrollPane(areaPilaC);
        scrollC.setBounds(270, 280, 100, 300);
        ventana.add(scrollC);

        areaUnion = new JTextArea();
        areaUnion.setEditable(false);
        JScrollPane scrollUnion = new JScrollPane(areaUnion);
        scrollUnion.setBounds(380, 280, 100, 300);
        ventana.add(scrollUnion);

        add(ventana);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLlenar) {
            try {
                int tamanoPila = Integer.parseInt(txtTamano.getText());
                pilaA = new int[tamanoPila];
                pilaB = new int[tamanoPila];
                pilaC = new int[tamanoPila];
                ExamenB.llenarPilas(tamanoPila);
                areaUnion.setText("Pilas llenadas exitosamente.");
            } catch (NumberFormatException ex) {
                areaUnion.setText("ERROR: Tamaño inválido.");
            }
        } else if (e.getSource() == btnAgregar) {
            try {
                int valor = Integer.parseInt(txtAgregar.getText());
                ExamenB.agregarValor(valor);
                areaUnion.setText("Valor agregado correctamente.");
            } catch (NumberFormatException ex) {
                areaUnion.setText("ERROR: Valor inválido.");
            }
        } else if (e.getSource() == btnMostrar) {
            areaPilaA.setText(ExamenB.mostrarPila("Pila A", pilaA, topeA));
            areaPilaB.setText(ExamenB.mostrarPila("Pila B", pilaB, topeB));
            areaPilaC.setText(ExamenB.mostrarPila("Pila C", pilaC, topeC));
        } else if (e.getSource() == btnUnion1) {
            int[] union = ExamenB.union1();
            areaUnion.setText("Unión 1 (A + B + C):\n" + ExamenB.mostrarUnion(union));
        } else if (e.getSource() == btnUnion2) {
            int[] union = ExamenB.union2();
            areaUnion.setText("Unión 2 (Intercalado):\n" + ExamenB.mostrarUnion(union));
        } else if (e.getSource() == btnUnion3) {
            int[] union = ExamenB.union3();
            areaUnion.setText("Unión 3 (Suma):\n" + ExamenB.mostrarUnion(union));
        }
    }

    public static void main(String[] args) {
        new interEB();
    }
}
