package logic;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import jsonManager.JsonManager;
import entity.Book;

public class Logic {
	
	private ArrayList<Book> books;
	private String[] aux = {"Fantasia", "Suspensso", "Horror", "Accion"};
	
	public Logic() {
		books = new ArrayList<Book>();
	}
	
	public ArrayList<Book> getBooks() {
		return books;
	}
	
	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	
	public void run() {
//		try {
//			JsonManager.writer(books);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		try {
			books = JsonManager.read();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Book book : books) {
			System.out.println(book.getId() + " " + book.getName());
		}
		books.add(new Book("S.k", "IT", aux));
		for (Book book : books) {
			System.out.println(book.getId());
		}
		try {
			JsonManager.writer(books);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		Logic logic = new Logic();
		logic.run();
	}

}
