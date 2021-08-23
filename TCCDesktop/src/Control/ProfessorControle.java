/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Professor;
import Model.NomeInvalidoException;
import Model.RfInvalidoException;
import Model.RgInvalidoException;
import Model.modelDAO.ProfessorDAO;
import java.sql.SQLException;

/**
 *
 * @author ottoj
 */
public class ProfessorControle {
    public void inserirAluno(int rf, int rg, String nome) throws SQLException{
        if(!(rf<=0)){
            if(!(rg<=0)){
                if(!(nome.trim().equals(""))){
                        Professor p=new Professor(rf, rg, nome);
                        ProfessorDAO pDAO= new ProfessorDAO();
                        pDAO.cadastrar(p);
                }else{
                    throw new NomeInvalidoException();
                }
            }else{
                throw new RgInvalidoException();
            }
        }else{
            throw new RfInvalidoException();
        }
    }
}
