package se.lexicon.model;

import java.util.Arrays;

public class Person {
    // Fields
    private static int sequencer = 0;
    private final int id;
    private String firstName;
    private String lastName;
    private Book[] borrowedBooks = new Book[0];

    //Constructors

    public Person(String firstName, String lastName) {
        this.id = getNextId();
        setFirstName(firstName);
        setLastName(lastName);
    }

    //Setters

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("Firstname cannot be null or empty");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("LastName cannot be null or empty");
        }
        this.lastName = lastName;
    }

    //Getters

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Book[] getBorrowedBooks() {
        return borrowedBooks;
    }

    //Methods

    private static int getNextId() {
        return ++sequencer;
    }

    public String getPersonInformation() {
        return "Person Information" + "\n" + "Person id: " + id + "\n" + "firstName: " + firstName + "\n" + "lastName: " + lastName + "\n" +
                "number of borrowedBooks: " + borrowedBooks.length+"\n";
    }

    public void loanBook(Book book) {

        if (book.isAvailable()) {
            book.setBorrower(this);

            Book[] newArrayOfBorrowedBooks = Arrays.copyOf(this.borrowedBooks, borrowedBooks.length + 1);
            newArrayOfBorrowedBooks[newArrayOfBorrowedBooks.length - 1] = book;
            borrowedBooks = newArrayOfBorrowedBooks;
        } else {
            throw new IllegalArgumentException("book is not available.");
        }

    }

    public void returnBook(Book book) { // Method to return a borrowed book
        // Book cannot be null
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null"); // Throw an exception if the provided book is null
        }

        // If book is not null
        // Create a new array to store the updated list of borrowed books
        Book[] newArray = new Book[borrowedBooks.length - 1]; // Create a new array with size one less than the current borrowedBooks array
        int counter = 0; // Counter to track the index of the new array

        // Iterate through the borrowedBooks array
        for (Book elementArray : borrowedBooks) { // Loop through each book in the borrowedBooks array
            // Check if the ID of the current book matches the ID of the book being returned
            if (elementArray.getId().equals(book.getId())) { // If the ID of the current book matches the ID of the book being returned
                book.setBorrower(null); // Reset the borrower of the returned book to null
                continue; // Skip adding the returned book to the new array
            }
            // If the IDs do not match, add the current book to the new array
            newArray[counter++] = elementArray; // Add the current book to the new array and increment the counter
        }

        // Update the borrowedBooks array to the new array
        borrowedBooks = newArray; // Assign the new array back to the borrowedBooks array, effectively removing the returned book
    }

    public void displayInfo() {
        System.out.println(getPersonInformation());
    }
}