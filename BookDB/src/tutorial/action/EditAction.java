package tutorial.action;
import java.sql.*;
import java.util.*;

import com.opensymphony.xwork2.ActionSupport;

public class EditAction extends ActionSupport{
	private Book book;
	private int isbn;
	private boolean flag;
	private int authorid;
	public void setAuthorid(int id){
		this.authorid=id;
	}
	public int getAuthorid(){
		return this.authorid;
	}
	public void setFlag(boolean flag){
		this.flag=flag;
	}
	public boolean getFlag(){
		return this.flag;
	}
	public void setIsbn(int isbn){
		this.isbn=isbn;
	}
	public int getIsbn(){
		return this.isbn;
	}
	public void setBook(Book book){
		this.book=book;
	}
	public Book getBook(){
		return this.book;
	}
	public String execute(){
		flag=false;
		Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_lab2bookdb";
        String user = "3ojyljmw2x";
        String password = "2jkl4325jimk4x5x5jx0m313hlj5h3442ikwk3ik";
        /*String url = "jdbc:mysql://localhost:3306/BookDB";
        String user = "root";
        String password = "louc123mysql";*/
        authorid=book.getAuthorID();
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!Edit");
            else
            	System.out.println("ddddd");
            Statement statement = con.createStatement();System.out.println(isbn);
            String sql = "select * from author where AuthorID="+Integer.toString(book.getAuthorID());
            ResultSet rs=statement.executeQuery(sql);System.out.println(sql);
            if(rs.next()){//如果作者已存在
            	String s="Update book set AuthorID="+Integer.toString(book.getAuthorID())+",Publisher='"+book.getPublisher()+"',PublishDate='"+book.getPublishDate()+"',Price='"+book.getPrice()+"' where ISBN="+Integer.toString(isbn);
            	statement.executeUpdate(s);System.out.println(s);
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
