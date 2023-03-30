package ex06_el;

public class Book {
	private String author;
	private String title;
	private int price;
	
	
	public Book(String author, String title, int price) {
		super();
		this.author = author;
		this.title = title;
		this.price = price;
	}
	
	public Book() {
		// 디폴트 생성자는 위에 처럼 받아 오는것이 있으면 무조건 써줘야 한다
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
