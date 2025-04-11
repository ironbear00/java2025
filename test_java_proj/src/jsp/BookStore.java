package jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

class Book
{
	private int book_id;
	private String book_name;
	private String publisher;
	private int price;

	public int getBookId() {return book_id;}
	public void setBookId(int book_id) {this.book_id=book_id;}
	public String getBookName() {return book_name;}
	public void setBookName(String book_name) {this.book_name=book_name;}
	public String getPublisher() {return publisher;}
	public void setPublisher(String publisher) {this.publisher=publisher;}
	public int getPrice() {return price;}
	public void setPrice(int price) {this.price=price;}

	@Override
	public String toString()
	{
		return String.format("%-5d %-20s %-15s %-7d", book_id, book_name, publisher, price);
	}
}

class Customer
{
	private int customer_id;
	private String customer_name;
	private String address;
	private String phone;
	
	public int getCustomerId() {return customer_id;}
	public void setCustomerId(int customer_id) {this.customer_id=customer_id;}
	public String getCustomerName() {return customer_name;}
	public void setCustomerName(String customer_name) {this.customer_name=customer_name;}
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address=address;}
	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone=phone;}

	@Override
	public String toString()
	{
		return String.format("%-5d %-10s %-20s %-15s", customer_id, customer_name, address, phone);
	}
}

class BookStore
{
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	public BookStore()
	{
		String url = "jdbc:oracle:thin:@localhost:1521/XE";
		String userId="c##madang";
		String pwd="c##madang";
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			System.out.println("데이터베이스 연결 준비 ...");
			con=DriverManager.getConnection(url, userId, pwd);
			System.out.println("데이터베이스 연결 성공");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	private ArrayList<Book> getBookList()
	{
		ArrayList<Book> bookList=new ArrayList<>();
		String query="SELECT * FROM Book";
		try
		{
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			
			while (rs.next()) 
			{
			    Book book=new Book();
			    book.setBookId(rs.getInt("bookid"));
			    book.setBookName(rs.getString("bookname"));
			    book.setPublisher(rs.getString("publisher"));
			    book.setPrice(rs.getInt("price"));
			    bookList.add(book);
			}
			rs.close();
			stmt.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return bookList;
	}
	
	private ArrayList<Customer> getCustomerList()
	{
		ArrayList<Customer> customerList=new ArrayList<>();
		String query="SELECT * FROM Customer";
		try
		{
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next())
			{
				Customer customer=new Customer();
				customer.setCustomerId(rs.getInt("custid"));
				customer.setCustomerName(rs.getString("name"));
				customer.setAddress(rs.getString("address"));
				customer.setPhone(rs.getString("phone"));
				customerList.add(customer);
			}
			rs.close();
			stmt.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return customerList;
	}
	
	private <T> void printDatas(ArrayList<T> list)
	{
		for(T item: list)
		{
			System.out.println(item);
		}
	}
	
	public static void main(String args[])
	{
		BookStore bs=new BookStore();
		
		//get data
		ArrayList<Book> books=bs.getBookList();
		ArrayList<Customer> customers=bs.getCustomerList();

		//close connection
		try
		{
		    bs.con.close();
		} 
		catch (SQLException e) 
		{
		    e.printStackTrace();
		}
		
		//print data
		bs.printDatas(books);
		System.out.println();
		bs.printDatas(customers);
	}
}
