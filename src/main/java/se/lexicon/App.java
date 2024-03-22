package se.lexicon;


import se.lexicon.model.Book;
import se.lexicon.model.Person;

public class App {
    public static void main(String[] args) {

        // Create a book instance
        Book book1 = new Book("Learn how to fly", "John Carter");
        Book book2 = new Book("100 things to do", "Ragnar Svennson");

        // Display book information
        //System.out.println("Book information:");
        System.out.println(book1.getBookInformation());
        System.out.println(book2.getBookInformation());
        System.out.println();

        // Create a person instance
        Person person1 = new Person("Daniel", "Petersson");

        // Display person information
        System.out.println(person1.getPersonInformation());
        System.out.println();

        // Loan a book to the person
        person1.loanBook(book1);
        person1.loanBook(book2);

        // Display person information after borrowing a book
        System.out.println("Information after borrowing a book:");
        System.out.println(person1.getPersonInformation());
        System.out.println();

        // Display book information after borrowing a book
        //System.out.println("Book information:");
        System.out.println(book1.getBookInformation());
        System.out.println(book2.getBookInformation());
        System.out.println();


        // Return the borrowed book
        person1.returnBook(book1);

        // Display person information after returning the book
        System.out.println("Information after returning the book:");
        System.out.println(person1.getPersonInformation());

    }

}
