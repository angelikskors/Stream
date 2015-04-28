package ua.org.oa.angelikskors;

public class LibraryString {
	private String author;
	private String name;
	private int year;

	public LibraryString(String author, String name, int year) {

		setAuthor(author);
		setName(name);
		setYear(year);
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "LibraryString{" +
				"author='" + author + '\'' +
				", name='" + name + '\'' +
				", year=" + year +
				'}';
	}
}
