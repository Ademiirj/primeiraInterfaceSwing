/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Exemplo1 extends JFrame {

    private JLabel lblTitulo, lblIdade, lblNome, lblTime, lblResultado;
    private JTextField edtNome, edtIdade;
    private JComboBox boxTime;
    private String[] boxTimesItems = {"Escolha um time","Corinthians", "Palmeiras", "Santos", "São Paulo"};

    public Exemplo1() {
        setTitle("Registro de torcedor");

        //ajuste do tamanho e layout
        setPreferredSize(new Dimension(456, 277));
        setLayout(null); // aqui a definicao para utilizacao de layout absoluto

        instanciar(); // instancia componentes (objetos Swing);

        posicionar(); // configura as posices dos componentes;

        adicionar(); // adiciona componentes no frame

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
        pack(); // reorganiza os componentes (objetos) no frame
    }

    public void instanciar() {
        lblTitulo = new JLabel("Registro de torcedor");
        edtNome = new JTextField(5);
        edtIdade = new JTextField(5);
        lblIdade = new JLabel("Idade");
        lblNome = new JLabel("Nome");
        lblTime = new JLabel("Time");
        boxTime = new JComboBox(boxTimesItems);
        lblResultado = new JLabel();
    }

    public void posicionar() {
        //Configura a posicao dos objetos no frame
        // Setbounds( posicao x, posicao y, largura, algura )
        lblTitulo.setBounds(115, 15, 300, 20);
        lblNome.setBounds(15, 50, 100, 25);
        lblIdade.setBounds(15, 90, 100, 25);
        lblTime.setBounds(15, 135, 80, 25);
        edtNome.setBounds(55, 50, 375, 25);
        edtIdade.setBounds(55, 90, 200, 25);
        boxTime.setBounds(55, 135, 200, 25);
        lblResultado.setBounds(50, 160, 200, 25);
    }

    public void adicionar() {
        add(lblTitulo);
        add(edtNome);
        add(edtIdade);
        add(lblIdade);
        add(lblNome);
        add(lblTime);
        add(boxTime);
        add(lblResultado);

        boxTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostraTime();
            }
        });

    }

    private void mostraTime() {
        String time = (String) boxTime.getSelectedItem();
        String nome = edtNome.getText();
        String idade = edtIdade.getText();
        String resultado = nome + " - " + idade + " - " + formataTime(time);
        lblResultado.setText(resultado);

    }

    private String formataTime(String time) {
        if (time.equals("Corinthians")) {
            return "Corintiano";
        }
        if (time.equals("Santos")) {
            return "Santista";
        }
        if (time.equals("São Paulo")) {
            return "São Paulino";
        }
        if (time.equals("Palmeiras")) {
            return "Porco";
        } else {
            return "Sem time";
        }

    }

    public static void main(String[] args) {
        new Exemplo1();
    }

}
