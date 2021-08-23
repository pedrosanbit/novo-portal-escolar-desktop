/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.modelDAO;

import Conexao.Conexao;
import Model.Disciplina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ottoj
 */
public class DisciplinaDAO {
    private Connection con= null;
    
    public void cadastrar(Disciplina d){
        try{
            con= new Conexao().getConnection();
            String sql ="INSERT INTO DisciplinasTCC(codDisciplina, nomeDisciplina, cargaHoraria) VALUES(?, ?, ?)";
            PreparedStatement stmt= con.prepareStatement(sql);
            stmt.setString(1, d.getCod());
            stmt.setString(2, d.getNome());
            stmt.setInt(3, d.getCargaH());
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
