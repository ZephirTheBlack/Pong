/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kevin
 */
public class Hilo extends Thread {

    private final TableroJuego lamina;

    public Hilo(TableroJuego lamina) {
        this.lamina = lamina;
    }

    @Override
    public void run() {
        while (!Pelota.finJuego) {
            lamina.repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
            lamina.repaint();
        }
    }
}
