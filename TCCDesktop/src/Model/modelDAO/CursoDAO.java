/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.modelDAO;

import Conexao.Conexao;
import Model.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author ottoj
 */
public class CursoDAO {
    private Connection con= null;
    
    public void cadastrar(Curso c){
        try{
            con= new Conexao().getConnection();
            String sql ="INSERT INTO CursosTCC(codCurso, nomeCurso) VALUES(?, ?)";
            PreparedStatement stmt= con.prepareStatement(sql);
            stmt.setInt(1, c.getCod());
            stmt.setString(2, c.getNome());
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
