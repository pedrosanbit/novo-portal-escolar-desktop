/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Conexao.Conexao;
import Model.Turma;
/**
 *
 * @author ottoj
 */
public class TurmaDAO {
    Connection con= null;
    
    public void cadastrar(Turma t){
        try{
            con= new Conexao().getConnection();
            String sql ="INSERT INTO TurmasTCC(codTurma, periodo, curso, nomeTurma) VALUES(?, ?, ?, ?)";
            PreparedStatement stmt= con.prepareStatement(sql);
            stmt.setString(1, t.getCod());
            stmt.setInt(2, t.getPeriodo());  
            stmt.setInt(3, t.getCurso());
            stmt.setString(4, t.getNome());
            stmt.execute();
            stmt.close();
        }
        catch (SQLException ex) {
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
