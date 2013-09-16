/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package springgeo;

import org.arquitetura.interfaces.Musica;

/**
 *
 * @author Felipe
 */
public class AtireiOPauNoGato implements Musica {

    private static String[] letra = {
        "Atirei o páu no gato tô tô",
        "Mas o gato tô tô",
        "Não morreu reu reu",
        "Dona Chica cá",
        "Admirou-se se",
        "Do berro, do berro que o gato deu",
        "Miau !!!!!!"};

    public void cantar() {
        for (int i = 0; i < letra.length; i++) {
            System.out.println(letra[i]);
        }
    }
}
