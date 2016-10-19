package tutorial.action;
import java.sql.*;
import java.util.*;

import com.opensymphony.xwork2.ActionSupport;
public class AddAction extends ActionSupport{
	private Book book;
	private int authorid;
	private boolean flag;
	public void setFlag(boolean flag){
		this.flag=flag;
	}
	public boolean getFlag(){
		return this.flag;
	}
	public Book getBook(){
		return this.book;
	}
	public void setBook(Book book){
		this.book=book;
	}
	public void setAuthorid(int id){
		this.authorid=id;
	}
	public int getAuthorid(){
		return this.authorid;
	}
	public String execute(){
		flag=true;
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
                System.out.println("Succeeded connecting to the Database!Add");
            Statement statement = con.createStatement();
            String sql = "select * from author where AuthorID="+Integer.toString(authorid);
            ResultSet rs=statement.executeQuery(sql);System.out.println(sql);
            if(rs.next()){//作者存在
            	String s="insert into book(ISBN,Title,AuthorID,Publisher,PublishDate,Price) values('"+Integer.toString(book.getIsbn())+"','"+book.getTitle()+"','" + Integer.toString(authorid) +"','"+ book.getPublisher()+"','"+ book.getPublishDate()+"','"+book.getPrice() +"')";
            	System.out.println(s);statement.executeUpdate(s);
            }else{//不存在交给addauthoraction
            	rs.close();
            	con.close();
            	return NONE;
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
