/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.CargaHInvalidaException;
import Model.CodInvalidoException;
import Model.Disciplina;
import Model.NomeInvalidoException;
import Model.modelDAO.DisciplinaDAO;
import java.sql.SQLException;

/**
 *
 * @author ottoj
 */
public class DisciplinaControle {
    public void inserirDisciplina(String cod, String nome, int cargaH) throws SQLException{
        if(!cod.trim().equals("")){
            if(!(nome.trim().equals(""))){
                if(cargaH>0){
                    Disciplina d =new Disciplina(cod, nome, cargaH);
                    DisciplinaDAO dDAO= new DisciplinaDAO();
                    dDAO.cadastrar(d);
                }else{
                    throw new CargaHInvalidaException();
                }
            }else{
                throw new NomeInvalidoException();
            }
        }else{
            throw new CodInvalidoException();
        }
    }
}
