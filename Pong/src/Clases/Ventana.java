/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Clases.Hilo;
import javax.swing.JFrame;

/**
 *
 * @author kevin
 */
public class Ventana extends JFrame {

    private final int ancho = 800, alto = 500;
    private TableroJuego lamina;
    Pelota p=new Pelota();
    private Hilo hilo;

    public Ventana() {
        setTitle("Pong");
        setSize(ancho, alto);
        setLocationRelativeTo(null);//colocando la ventana en el centro
        setResizable(false);
        lamina = new TableroJuego();
        add(lamina);
        addKeyListener(new EventoTeclado());
        new Hilo(lamina).start();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hilo=new Hilo(lamina);
        hilo.start();

    }
}
