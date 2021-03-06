package Clases;

import java.applet.AudioClip;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import obtenerRecursos.Audio;

/**
 *
 * @author kevin
 */
public class Pelota {

    private double x;
    private static double y;
    private double dx = 1, dy = 1;
    private static final int TAMX = 15;
    private static final int TAMY = 15;

    private Integer score1 = 0, score2 = 0;
    public static boolean finJuego = false;

    Audio audio = new Audio();
    AudioClip rebote_1 = audio.getAudio("/recursos/rebote_pelota1.wav");
    AudioClip rebote_2 = audio.getAudio("/recursos/rebote_pelota2.wav");
    AudioClip falta = audio.getAudio("/recursos/falta.wav");

    public Pelota() {
        this.x = x;
        this.y = y;
    }

    public Rectangle2D getPelota() {
        return new Rectangle2D.Double(x, y, TAMX, TAMY);
    }

    public void mover(Rectangle limites, boolean colisionR1, boolean colisionR2) {
        x += dx;
        y += dy;
        if (colisionR1) {
            dx = -dx;
            x = 25;
            rebote_1.play();
        }
        if (colisionR2) {
            dx = -dx;
            x = 755;
            rebote_1.play();
        }

        if (x < limites.getMinX()) {
            score2++; //el puntaje del jugador2 aumenta en uno

            x = limites.getCenterX();
            y = limites.getCenterY();
            dx = -dx;
            falta.play();
        }
        if (y < limites.getMinY()) {

            y = limites.getMinY();

            dy = -dy;
            rebote_2.play();
        }
        if (x > limites.getMaxX()) {
            score1++; //el puntaje del jugador1 aumenta en uno

            x = limites.getCenterX();
            y = limites.getCenterY();
            dx = -dx;
            audio.getAudio("/recursos/falta.wav").play();
        }
        if (y + TAMY > limites.getMaxY()) {
            y = limites.getMaxY() - TAMY;
            dy = -dy;
            rebote_2.play();
        }
        if (x < 0) {
            dx = -dx;
        }
        if (y < 0) {
            dy = -dy;
        }

    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }
}
