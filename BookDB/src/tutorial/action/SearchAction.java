package tutorial.action;
import java.sql.*;
import java.util.*;

import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport{
	private List<Book> books=new ArrayList<Book>();
	private String authorname;
	private List<Integer> ids=new ArrayList<Integer>();
	public void setAuthorname(String name){
		this.authorname=name;
	}
	public String getAuthorname(){
		return this.authorname;
	}
	public void setBooks(){
		
	}
	public List<Book> getBooks(){
		return this.books;
	}
	public void setIds(){
		
	}
	public List<Integer> getIds(){
		return this.ids;
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
                System.out.println("Succeeded connecting to the Database!Search");
            Statement statement = con.createStatement();
            String sql = "select * from author where Name=\""+authorname+"\"";
            ResultSet rs=statement.executeQuery(sql);     
            while(rs.next()){
            	ids.add(rs.getInt("AuthorID"));
            }rs.close();
            if(ids.isEmpty()){
            	return NONE;
            }
            for(int id:ids){
            	sql="select * from book where AuthorID="+Integer.toString(id);
            	ResultSet rs1=statement.executeQuery(sql);
            	while(rs1.next()){
            		Book b=new Book();
            		b.setIsbn(rs1.getInt("ISBN"));
            		b.setTitle(rs1.getString("Title"));
            		books.add(b);
            	}rs1.close();
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
