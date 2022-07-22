/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unal.ciclo2grupo28clase15;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class Ventana extends JFrame implements ActionListener {

    JLabel etiqueta;
    JTextField texto;
    JButton boton;
    JTextArea area;
    JPasswordField pass;
    JCheckBox check;
    JRadioButton op1,op2,op3;
    ButtonGroup grupo;
    JComboBox combo;

    Ventana() {

        this.setLayout(new FlowLayout());//Layout
        this.setTitle("Mi ventana en Java Swing");
        this.setSize(300, 200);//
        this.setLocation(200, 300);
        this.setVisible(true);//
        etiqueta = new JLabel("Nombre:");
        texto = new JTextField("texto por defecto");//campo de texto
        pass = new JPasswordField(10);
        boton = new JButton("Guardar");//boton
        boton.addActionListener(this);
        area = new JTextArea(6, 50);
        area.setText("Ejemplo de texto enviado despues\na la area de texto.");
        area.setEditable(false);
        area.append("\n\tNOMBRE: \tMisael Fernando Perilla");
        area.insert("MENSAJE:", 0);
        check = new JCheckBox("Activar");
        check.setSelected(true);
        check.addActionListener(this);
        combo= new JComboBox();
        combo.addItem("A1");
        combo.addItem("A2");
        combo.addItem("B1");
        combo.addItem("C1");
        combo.addItem("C2");
        op1= new JRadioButton("Pequeño");
        op2= new JRadioButton("Mediano");
        op3= new JRadioButton("Grande");
        
        

        this.add(etiqueta);
        this.add(texto);
        this.add(pass);
        this.add(area);
        this.add(check);
        this.add(combo);
        grupo= new ButtonGroup();
        grupo.add(op1);
        grupo.add(op2);
        grupo.add(op3);
        
        this.add(op1);
        this.add(op2);
        this.add(op3);

        this.add(boton);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {//escuchar los botones
        if (e.getSource() == this.boton) {
            String clave = "";
            for (char c : this.pass.getPassword()) {
                clave = clave + c;
            }

            String txt = this.etiqueta.getText() + this.texto.getText()
                    + " : " + clave+" seleccionado->"+combo.getSelectedItem().toString();
            JOptionPane.showMessageDialog(rootPane, txt);
        } else {
            if (this.check.isSelected()) {
                this.area.setEditable(true);
            } else {
                this.area.setEditable(false);
            }
        }
    }

}
