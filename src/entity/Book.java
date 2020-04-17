package entity;

public class Book {
	private static int CONT_ID = 0;
	private int id;
	private String name;
	private String tittle;
	private String[] type;
	
	public Book(int id, String name, String tittle, String[] type) {
		Book.CONT_ID = this.id = id;
		this.name = name;
		this.tittle = tittle;
		this.type = type;
		CONT_ID++;
	}

	public Book(String name, String tittle, String[] type) {
		id = CONT_ID++;
		this.name = name;
		this.tittle = tittle;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String[] getType() {
		return type;
	}

	public void setType(String[] type) {
		this.type = type;
	}

}
