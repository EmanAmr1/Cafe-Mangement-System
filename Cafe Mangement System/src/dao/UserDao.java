
package dao;
import javax.swing.JOptionPane;
import model.User;
import java.sql.*;

public class UserDao {
    
    
    
    public static void save(User user){
    
    String query = "insert into user(name,email,mobileNumber,address,password,securityQuestion,answer,status) values('"+user.getName()+"','"+user.getEmail()+"','"+user.getMobileNmber()+"','"+user.getAddress()+"','"+user.getPassword()+"','"+user.getSecurityQestion()+"','"+user.getAnswer()+"','"+user.getStatus()+"')";
    DbOperations.setDataOrDelete(query, "Registered Successfully! Wait for Admin Approval!");
     }
    
    
    
    public static User login(String email, String password){
    
    User user = new User();
    try{
    ResultSet rs = DbOperations.getData("select *from user where email='"+email+"' and password='"+password+"'");
    while(rs.next())
    {
      user = new User();
      user.setStatus(rs.getString("status"));// inside the getString is the column name.
    }
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    return user;
    }
    public static User getSecurityQuestion(String email)
    {User user= null;
    try{
    
    ResultSet rs=DbOperations.getData("select *from user where email = '" + email + "'");
    while(rs.next()){
        user = new User();
        user.setSecurityQestion(rs.getString("securityQuestion"));
        user.setAnswer(rs.getString("answer"));
        
    }
        
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    }
    return user;
    }
    
    public static void Update(String email,String newPassword)
    {String query ="Update user set password = '" + newPassword + "' where email='" + email+ "'";
    DbOperations.setDataOrDelete(query,"Password changed succesfully");
    }
}
