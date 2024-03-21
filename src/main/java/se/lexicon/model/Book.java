package se.lexicon.model;

public class Book {
    // todo: needs completion
    // Fields
    private String id;
    private String title;
    private String author;
    private Boolean available;
    private Person borrower;
    //Constructors

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book(String title, String author, Person borrower) {
        this.title = title;
        this.author = author;
        setBorrower(borrower);
    }

    //Setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public void setBorrower(Person borrower) {
        this.borrower = borrower;
        this.available = false;
    }

    //Getters

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Boolean getAvailable() {
        return available;
    }

    public Person getBorrower() {
        return borrower;
    }

    //Methods
    public String getBookInformation(){
        return "ID: " + id + "\n" +
                "Author: " + author +", Title: " + title+  ", Avileble: " + available+ ", Borrower: " + borrower.getPersonInformation();

    }
}