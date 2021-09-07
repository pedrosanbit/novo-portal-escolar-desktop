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
import java.util.ArrayList;
/**
 *
 * @author ottoj
 */
public class AlunoControle {
    
    public ArrayList<Aluno> consultarAluno(String ra, String nome, String turma, String ordem){
        String sql="Select * from AlunosTCC a ";
        ArrayList<Aluno> lista= new ArrayList<>();
        AlunoDAO alDAO= new AlunoDAO();
        int op=0;
        
        if(!turma.trim().equals("")){
            sql=sql+" inner join AlunoTurmaTCC at where at.codTurma= ? and at.raAluno=a.raAluno";
            op++;  
        }
        
        if(!ra.trim().equals("")){
            if(op==0)
                sql=sql+" where a.raAluno= ? ";
            else if(op>0)
                sql=sql+" and a.raAluno= ? ";
            op++;
        }
        
        if(!nome.trim().equals("")){
            if(op==0)
                sql=sql+" where a.nomeAluno like ? ";
            else if(op>0)
                sql=sql+" and a.nomeAluno like ? ";
        }
        sql= sql+ordem;
        
        try{
            lista = alDAO.buscarAluno(sql, ra, nome, turma);
        }catch(ClassNotFoundException ex){
            System.out.println(ex.toString());
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return lista;
    }
    
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
