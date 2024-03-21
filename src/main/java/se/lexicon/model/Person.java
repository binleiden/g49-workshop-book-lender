package se.lexicon.model;

public class Person {
    // todo: needs completion
    // Fields
    private static int sequencer = 0;
    private final int id;
    private String firstName;
    private String lastName;

    //Constructors

    public Person(String firstName, String lastName) {
        this.id= getNextId();
        setFirstName(firstName);
        setLastName(lastName);
    }
    private static int getNextId(){
        return ++sequencer;
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

    //Methods
    public String getPersonInformation(){
        return "ID: " + id + "\n" +
                "Name: " + firstName +" " + lastName;

    }
    public void loanBook(){
        //todo: method
    }

    public void returnBook(){
        //todo: method
    }
}