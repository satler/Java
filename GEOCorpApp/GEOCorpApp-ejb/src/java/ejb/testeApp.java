/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import springgeo.teste;

/**
 *
 * @author satler
 */
@Stateless
public class testeApp implements testeAppRemote {

    private teste teste;
    @Override
    public boolean testaInsere() {
        
        teste = new teste();
        if ( teste.testar() ) 
            return true;
        else
        return false;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
