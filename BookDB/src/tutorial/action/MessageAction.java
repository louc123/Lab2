package tutorial.action;
import java.sql.*;
import java.util.*;

import com.opensymphony.xwork2.ActionSupport;
public class MessageAction extends ActionSupport{
	private int isbn;
	private Book book;
	private Author author;
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
	public void setAuthor(Author author){
		this.author=author;
	}
	public Author getAuthor(){
		return this.author;
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
                System.out.println("Succeeded connecting to the Database!Message");
            book=new Book();
            author=new Author();
            Statement statement = con.createStatement();
            String sql_1 = "select * from book where ISBN="+Integer.toString(isbn);
            ResultSet rs1=statement.executeQuery(sql_1);int author_id=0;
            while(rs1.next()){
            	book.setAuthorID(rs1.getInt("AuthorID"));
	        	book.setIsbn(rs1.getInt("ISBN"));
	        	book.setPrice(rs1.getDouble("Price"));
	        	book.setPublisher(rs1.getString("Publisher"));
	        	book.setPublishDate(rs1.getString("PublishDate"));
	        	book.setTitle(rs1.getString("Title"));
	        	author_id=rs1.getInt("AuthorID");
            }
            System.out.println(author_id);
            rs1.close();
            System.out.println(author_id);
            String sql_2="select * from author where AuthorID="+Integer.toString(author_id);
            ResultSet rs2=statement.executeQuery(sql_2);
            while(rs2.next()){
            	author.setAuthorID(author_id);
	            author.setAge(rs2.getString("Age"));
	            author.setName(rs2.getString("Name"));
	            author.setCountry(rs2.getString("Country"));
            }
            rs2.close();
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
