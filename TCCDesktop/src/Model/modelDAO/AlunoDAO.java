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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author ottoj
 */
public class AlunoDAO {
    private Connection con= null;
    
    public ArrayList<Aluno> buscarAluno(String sql, String ra, String nome, String turma) throws SQLException, ClassNotFoundException  {
        ResultSet rs = null;
        int op=1;
        ArrayList<Aluno> lista = new ArrayList();
        try{
            con = new Conexao().getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            if(!turma.trim().equals("")){
                stmt.setString(op, turma);
                op++;
            }
            if(!ra.trim().equals("")){
                stmt.setString(op, ra);
                op++;
            }
            if(!nome.trim().equals("")){
                nome=nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
                stmt.setString(op, "%"+nome+"%");
            }
            rs = stmt.executeQuery();
            while (rs.next()){
                int raL = rs.getInt("raAluno");
                int rgL = rs.getInt("rgAluno");
                String nomeL = rs.getString("nomeAluno");           
                Aluno al = new Aluno(raL, rgL, nomeL, "");
                lista.add(al);
            }
            stmt.close();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        finally{
            con.close();
        }
        return lista;
    }
    
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
