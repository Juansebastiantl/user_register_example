/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.event.*;
import javax.swing.JOptionPane;
import view.View;
import model.Model;
import model.AdministratorSQL;

/**
 *
 * @author Juansebastiantl
 */
public class Control {
    private View obj_view;
    private Model obj_model;
    private AdministratorSQL obj_AdministratorSQL;
    private boolean confirmation;
    
    public Control(View obj_view, Model obj_model, AdministratorSQL obj_AdministratorSQL){
        
        this.obj_view = obj_view;
        this.obj_model = obj_model;
        this.obj_AdministratorSQL = obj_AdministratorSQL;
        start_view();
        confirmation = this.obj_AdministratorSQL.connect();
        this.obj_view.btnRegister.addActionListener(btn_register);
    }
    
    private void start_view (){
    obj_view.setVisible(true);
    obj_view.setLocationRelativeTo(null);
    for (int i=1; i<= 31; i++){
    obj_view.optionDay.addItem(String.valueOf(i));
       }
    for (int i=1900; i<= 2100; i++){
    obj_view.optionYear.addItem(String.valueOf(i));
       }
    }
    
    private void establish_user (){
        obj_model.setName(obj_view.txtName.getText());
        obj_model.setId(Integer.parseInt(obj_view.txtId.getText()));
        obj_model.setDate(obj_view.optionDay.getSelectedItem()+"-" +obj_view.optionMonth.getSelectedItem() + "-" + obj_view.optionYear.getSelectedItem());
    }
    
    ActionListener btn_register = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            if(confirmation){
            establish_user();
            obj_AdministratorSQL.register(obj_model.getName(), obj_model.getId(), obj_model.getDate());
            }
            else{
            JOptionPane.showMessageDialog(null, "Is not possible register the user because there is an error in the connecion database");
            }
        }
    };
    
}
