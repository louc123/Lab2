package tutorial.action;
import java.sql.*;
import java.util.*;

import com.opensymphony.xwork2.ActionSupport;
public class ListAction extends ActionSupport{
	private List<Book> list=new ArrayList<Book>();
	public List<Book> getList(){
		return this.list;
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
                System.out.println("Succeeded connecting to the Database!List");
         
            Statement statement = con.createStatement();
            String sql = "select * from book";
            ResultSet rs=statement.executeQuery(sql);     
            while(rs.next()){
            	Book p=new Book();
            	p.setAuthorID(rs.getInt("AuthorID"));
            	p.setIsbn(rs.getInt("ISBN"));
            	p.setPrice(rs.getDouble("Price"));
            	p.setPublisher(rs.getString("Publisher"));
            	p.setPublishDate(rs.getString("PublishDate"));
            	p.setTitle(rs.getString("Title"));
            	list.add(p);
            }rs.close();
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
