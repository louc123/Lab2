package tutorial.action;
import java.sql.*;
import java.util.*;

import com.opensymphony.xwork2.ActionSupport;

public class RemoveAction extends ActionSupport{
	private int isbn;
	public void setIsbn(int isbn){
		this.isbn=isbn;
	}
	public int getIsbn(){
		return this.isbn;
	}
	public String execute(){
		Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_lab2bookdb";
        String user = "3ojyljmw2x";
        String password = "2jkl4325jimk4x5x5jx0m313hlj5h3442ikwk3ik";
        /*String url = "jdbc:mysql://localhost:3306/BookDB";
        String user = "root";
        String password = "louc123mysql";*/
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            Statement statement = con.createStatement();
            String sql = "delete from book where ISBN="+Integer.toString(isbn);
            statement.executeUpdate(sql);     
		     con.close();
        }catch(ClassNotFoundException e) {   
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();  
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
		return SUCCESS;
	}
}
