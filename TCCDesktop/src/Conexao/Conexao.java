/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ottoj
 */
public class Conexao {
    public Connection getConnection() throws SQLException, ClassNotFoundException {    
       
        String driver = "com.mysql.cj.jdbc.Driver"; 
        String url = "jdbc:mysql://143.106.241.3:3306/cl19143";
        String usuario = "cl19143";
        String senha = "cl*21012004";
        try{
            Class.forName(driver);
            return DriverManager.getConnection(url, usuario, senha);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Erro de conexao", ex);
        }
   
    }
}
