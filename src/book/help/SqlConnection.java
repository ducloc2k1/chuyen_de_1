/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.help;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class SqlConnection {
    public static Connection getConn(){
        try {
            return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=book_management","sa","1234$");
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ResultSet executeQuery(String sql, Object... params) {
        Connection conn = SqlConnection.getConn();
        try {
            CallableStatement cs = conn.prepareCall(sql);
            if (params.length > 0) {
                int i = 1;
                for (Object p : params) {
                    cs.setObject(i, p);
                    i++;
                }
            }
            return cs.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static int executeUpdate(String sql, Object... params) {
        Connection conn = SqlConnection.getConn();
        try {
            CallableStatement cs = conn.prepareCall(sql);
            if (params.length > 0) {
                int i = 1;
                for (Object p : params) {
                    cs.setObject(i, p);
                    i++;
                }
            }
            return cs.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }
    
    public static void main(String[] args) {
        SqlConnection.getConn();
    }
}
