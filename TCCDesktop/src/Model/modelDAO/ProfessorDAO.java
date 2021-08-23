/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.modelDAO;

import Conexao.Conexao;
import Model.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ottoj
 */
public class ProfessorDAO {
    Connection con= null;
    
    public void cadastrar(Professor p){
        try{
            con= new Conexao().getConnection();
            String sql ="INSERT INTO ProfessoresTCC(rfProfessor, rgProfessor, nomeProfessor) VALUES(?, ?, ?)";
            PreparedStatement stmt= con.prepareStatement(sql);
            stmt.setInt(1, p.getRf());
            stmt.setInt(2, p.getRg());
            stmt.setString(3, p.getNome());
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
