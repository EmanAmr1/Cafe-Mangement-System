package dao;
import javax.swing.JOptionPane;


public class tables {
    
    public static void main(String[] args){
    try{
    String userTable = "create table user (id int AUTO_INCREMENT primary key,name varchar(200),email varchar(200),mobileNumber varchar(10),address varchar(200),password varchar(200),securityQuestion varchar(200),answer varchar(200),status varchar(20), UNIQUE(email))";
    String adminDetails = "insert into user(name,email,mobileNumber,address,password,securityQuestion,answer,status)values('Admin','admin@gmail.com',0123456789,'Egypt','admin','what primary school didi you attend?','ABC','true')";
    //String catgoryTable="create table category(id:int AUTO_INCREMENT primary key,name varchar(200))";
    DbOperations.setDataOrDelete(userTable, "User Tabel Created Successfully");
    DbOperations.setDataOrDelete(adminDetails, "Admin details added Successfully");
    //DbOperations.setDataOrDelete(catgoryTable, "Catgory Table Created Successfully");
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    }
}
