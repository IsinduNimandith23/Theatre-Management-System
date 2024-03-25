public class Person {

    String name;
    String surname;
    String email;
    Person(String name, String surname, String email){

        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    void setName(){
        System.out.println(this.name + " is your Name");
    }

    void setSurname(){
        System.out.println(this.surname + "is your surname");
    }

    void setEmail(){
        System.out.println(this.email + "is your email");
    }
}