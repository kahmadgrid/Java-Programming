package Project_1_v2.model;

public class Book {

    public int bookId;
    public String title;
    public String author;
    public boolean isAvailable;

    public Book(int bookId, String title, String author){

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public void display(){

        System.out.println(bookId + " | " + title + " | " + author +
                " | Available: " + isAvailable);
    }

}

