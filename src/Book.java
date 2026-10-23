import java.time.Year;
public class Book {
    private long id;
    private String title;
    private String author;
    private int year;
    public Book() {
    }
    public Book(long id, String title, String author, int year) {
        setId(id);
        setTitle(title);
        setAuthor(author);
        setYear(year);
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Автор не может быть пустым");
        }
        this.author = author;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        if (year < 0 || year > Year.now().getValue()) {
            throw new IllegalArgumentException("Некорректный год: " + year);
        }
        this.year = year;
    }
    public String getDescription() {
        return "\"" + title + "\" — " + author + " (" + year + ")";
    }
    @Override
    public String toString() {
        return getDescription();
    }
}