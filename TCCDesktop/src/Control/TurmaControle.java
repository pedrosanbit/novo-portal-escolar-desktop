/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.CodInvalidoException;
import Model.CursoInvalidoException;
import Model.NomeInvalidoException;
import Model.PeriodoInvalidoException;
import Model.Turma;
import Model.modelDAO.TurmaDAO;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author ottoj
 */
public class TurmaControle {
    public void inserirTurma(String cod, int periodo, int curso, String nome) throws SQLException{
        //if para ver se num de curso ja nao esta cadastrado
        if(!cod.trim().equals("")){
            if(periodo>= Calendar.getInstance().get(Calendar.YEAR)){
                if(curso>0){
                    if(!nome.trim().equals("")){
                        Turma t= new Turma(cod, periodo, curso, nome);
                        TurmaDAO tDAO= new TurmaDAO();
                        tDAO.cadastrar(t);
                    }else
                        throw new NomeInvalidoException();
                }else
                    throw new CursoInvalidoException();
            }else
                throw new PeriodoInvalidoException();
        }else
            throw new CodInvalidoException();
    }
}
