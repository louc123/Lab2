package tutorial.action;
import java.sql.*;

public class Book {
	private int isbn;
	private int authorID;
	private String title;
	private String publisher;
	private String publishDate;
	private double price;
	public Book(){
		
	}
	public void setIsbn(int isbn){
		this.isbn=isbn;
	}
	public int getIsbn(){
		return this.isbn;
	}
	public void setAuthorID(int authorID){
		this.authorID=authorID;
	}
	public int getAuthorID(){
		return this.authorID;
	}
	public void setTitle(String Title){
		this.title=Title;
	}
	public String getTitle(){
		return this.title;
	}
	public void setPublisher(String Publisher){
		this.publisher=Publisher;
	}
	public String getPublisher(){
		return this.publisher;
	}
	public void setPublishDate(String PublishDate){
		this.publishDate=PublishDate;
	}
	public String getPublishDate(){
		return this.publishDate;
	}
	public void setPrice(double Price){
		this.price=Price;
	}
	public double getPrice(){
		return this.price;
	}
}
