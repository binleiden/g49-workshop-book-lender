package se.lexicon.model;

import java.util.UUID;

public class Book {
    // Fields
    private String id;
    private String title;
    private String author;
    private Boolean available;
    private Person borrower;
    //Constructors

    public Book(String title, String author) {
        this.id = generateBookId();
        setAuthor(author);
        setTitle(title);
        setBorrower(null);
    }

    public Book(String title, String author, Person borrower) {
        this(title, author);
        this.id = generateBookId();
        setBorrower(borrower);
    }

    //Setters

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty");
        }
        this.author = author;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public void setBorrower(Person borrower) {
        this.borrower = borrower;
        this.available = (borrower == null);

    }

    //Getters

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Boolean isAvailable() {
        return available;
    } //Boolean use is insted of set and get.

    public Person getBorrower() {
        return borrower;
    }

    //Methods
    public String getBookInformation() {

        String bookInfo = "BookInformation" +"\n" +"ID: " + id + "\n" +"Title: " + title +"\n" + "Available: " + available+"\n";
        if (borrower == null) {
            bookInfo = bookInfo + "Not borrowed" +"\n";
        } else {
            bookInfo = bookInfo + "Borrower" + borrower.getPersonInformation()+"\n";
        }

        return bookInfo;
    }

    private String generateBookId() {
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}