/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package springgeo;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 * @author Felipe
 */
@Aspect
public class Plateia {

    public Plateia() { }

    @Pointcut("execution(* *.apresentar(..))")
    public void apresentacao() {}

    @Before("apresentacao()")
    public void sentar(){
        System.out.println("A platéia está sentando");
    }

    @Before("apresentacao()")
    public void desligarCelulares(){
        System.out.println("A platéia está desligando os celulares");
    }

    @AfterReturning("apresentacao()")
    public void aplaudir(){
        System.out.println("CLAP CLAP CLAP UHULL CLAP CLAP");
    }

    @AfterThrowing("apresentacao()")
    public void vaiar(){
        System.out.println("UUUUUU!! E FORA! E FORA! UUUUU!! ");
    }
}
