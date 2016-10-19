package tutorial.action;

public class Author {
	private int authorID;
	private String name;
	private String age;
	private String country;
	public Author(){
		
	}
	public void setAuthorID(int authorID){
		this.authorID=authorID;
	}
	public int getAuthorID(){
		return this.authorID;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	public void setAge(String age){
		this.age=age;
	}
	public String getAge(){
		return this.age;
	}
	public void setCountry(String country){
		this.country=country;
	}
	public String getCountry(){
		return this.country;
	}
}
