package tutorial.action;
import java.sql.*;
import java.util.*;

import com.opensymphony.xwork2.ActionSupport;
public class AddauthorAction extends ActionSupport{
	private Author author;
	private int authorid;
	private Book book;
	private boolean flag;
	private int isbn;
	public void setIsbn(int isbn){
		this.isbn=isbn;
	}
	public int getIsbn(){
		return this.isbn;
	}
	public void setFlag(boolean flag){
		this.flag=flag;
	}
	public boolean getFlag(){
		return this.flag;
	}
	public void setAuthorid(int id){
		this.authorid=id;
	}
	public int getAuthorid(){
		return this.authorid;
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
        author.setAuthorID(authorid);
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!Addauthor");
            Statement statement = con.createStatement();
            if(flag){//执行添加图书
	            String sql = "insert into author(AuthorID,Name,Age,Country) values('"+Integer.toString(author.getAuthorID())+"','"+author.getName()+"','"+author.getAge()+"','"+author.getCountry()+"')";
	            statement.executeUpdate(sql);System.out.println(sql);
	            String s="insert into book(ISBN,Title,AuthorID,Publisher,PublishDate,Price) values('"+Integer.toString(book.getIsbn())+"','"+book.getTitle()+"','" + Integer.toString(author.getAuthorID()) +"','"+ book.getPublisher()+"','"+ book.getPublishDate()+"','"+book.getPrice() +"')";
	            System.out.println(s);System.out.println(s);
	            statement.executeUpdate(s);
            }else{//执行修改图书
            	String sql = "insert into author(AuthorID,Name,Age,Country) values('"+Integer.toString(author.getAuthorID())+"','"+author.getName()+"','"+author.getAge()+"','"+author.getCountry()+"')";
	            statement.executeUpdate(sql);System.out.println(sql);
            	String s="Update book set AuthorID="+Integer.toString(authorid)+",Publisher='"+book.getPublisher()+"',PublishDate='"+book.getPublishDate()+"',Price='"+book.getPrice()+"' where ISBN="+Integer.toString(isbn);
            	statement.executeUpdate(s);System.out.println(s);
            }
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
