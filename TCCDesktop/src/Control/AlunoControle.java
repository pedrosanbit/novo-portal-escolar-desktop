/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Aluno;
import Model.EmailInvalidoException;
import Model.NomeInvalidoException;
import Model.RaInvalidoException;
import Model.RgInvalidoException;
import Model.modelDAO.AlunoDAO;
import java.sql.SQLException;
/**
 *
 * @author ottoj
 */
public class AlunoControle {
    public void inserirAluno(int ra, int rg, String nome, String email) throws SQLException{
        if(!(ra<=0)){
            if(!(rg<=0)){
                if(!(nome.trim().equals(""))){
                    if(!(email.trim()).equals("")){
                        Aluno al=new Aluno(ra, rg, nome, email);
                        AlunoDAO alDAO= new AlunoDAO();
                        alDAO.cadastrar(al);
                    }else{
                        throw new EmailInvalidoException();
                    }
                }else{
                    throw new NomeInvalidoException();
                }
            }else{
                throw new RgInvalidoException();
            }
        }else{
            throw new RaInvalidoException();
        }
    }
}
