/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ottoj
 */
public class EmailInvalidoException extends RuntimeException{
    public String getMessage(){
        return "Email inválido";
    }
}
