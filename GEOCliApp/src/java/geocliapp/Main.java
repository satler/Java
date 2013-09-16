/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geocliapp;

import ejb.testeAppRemote;
import javax.ejb.EJB;

/**
 *
 * @author satler
 */
public class Main {
    @EJB
    private static testeAppRemote testeApp;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (  testeApp.testaInsere())
            System.out.println("Inseriu");
        else
            System.err.println("nada");
    }
}
