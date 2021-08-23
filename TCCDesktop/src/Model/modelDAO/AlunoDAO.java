/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.modelDAO;

import Conexao.Conexao;
import Model.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author ottoj
 */
public class AlunoDAO {
    private Connection con= null;
    
    public void cadastrar(Aluno al){
        try{
            con= new Conexao().getConnection();
            String sql ="INSERT INTO AlunosTCC(raAluno, rgAluno, nomeAluno, emailAluno) VALUES(?, ?, ?, ?)";
            PreparedStatement stmt= con.prepareStatement(sql);
            stmt.setInt(1, al.getRa());
            stmt.setInt(2, al.getRg());
            stmt.setString(3, al.getNome());
            stmt.setString(4, al.getEmail());
            stmt.execute();
            stmt.close();
        }catch (SQLException ex) {
            System.out.println("Erro de conexão");
        }catch (ClassNotFoundException ex) {
           System.out.println("Erro de conexão");
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Não foi possível fechar a conexão");
            }
        }
    }
}
