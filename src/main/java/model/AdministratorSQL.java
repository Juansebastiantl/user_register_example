/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Juansebastiantl
 */
public class AdministratorSQL {
    private Connection obj_connection;
    private String user = "root";
    private String passw = "1234";
    private String url = "jdbc:mysql://localhost:3306";
    private String database = "db_miercoles";
    public boolean connect(){
        try {
        obj_connection = DriverManager.getConnection(url+"/"+database, user, passw);
        JOptionPane.showMessageDialog(null, "Succesful connection");
        return true;
        } catch(SQLException err) {
                JOptionPane.showMessageDialog(null, err);
                return false;
        }
        
    }
    
    public void register(String name, int id, String date){
        try {
        String instruction = "INSERT INTO users VALUES('"+ name +"', "+ id + ",'"+ date +" ')";
        obj_connection.prepareStatement(instruction).execute();
        JOptionPane.showMessageDialog(null, "User Registered");
        } catch (SQLException err){
          JOptionPane.showMessageDialog(null, err);
        }
    }
}
