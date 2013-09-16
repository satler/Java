/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package springgeo;

import org.arquitetura.interfaces.Competidor;
import org.arquitetura.interfaces.Musica;

/**
 *
 * @author Felipe
 */
public class Cantor implements Competidor {

    private Musica musica;

    public Cantor() {
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
    }

    public void apresentar() {
        musica.cantar();
    }
}
