/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.CodInvalidoException;
import Model.Curso;
import Model.NomeInvalidoException;
import Model.modelDAO.CursoDAO;
import java.sql.SQLException;
/**
 *
 * @author ottoj
 */
public class CursoControle {
    public void inserirCurso(int cod, String nome) throws SQLException{
        //if para verificar cod ja cadastrado
        if(cod>0){
            if(!(nome.trim().equals(""))){
                Curso c =new Curso(cod, nome);
                CursoDAO cDAO= new CursoDAO();
                cDAO.cadastrar(c);
            }else{
                throw new NomeInvalidoException();
            }
        }else{
            throw new CodInvalidoException();
        }
    }
}
