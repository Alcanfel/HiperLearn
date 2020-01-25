package Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "children")
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstname", length = 20)
    private String firstName;
    @Column(name = "lastname", length = 20)
    private String lastName;
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToMany
    @JoinTable(name = "parent_and_child", joinColumns = @JoinColumn(name = "child_id"), inverseJoinColumns = @JoinColumn(name = "person_id"))
    private Set<Person> persons = new HashSet<Person>();

    public void setId(int id) {
        this.id = id;
    }

    public Set<Person> getPersons() {
        return persons;
    }


    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public Child(){

    }

    @Override
    public String toString() {
        return  "имя = '" + firstName + '\'' +
                ", фамилия = '" + lastName + '\'' +
                ", возраст = " + age +
                ".";
    }

    public Child(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getInfoChildAndSchool(){
        return getId()+ " " + getFirstName() + " " + getLastName() + " " + getSchool().getId()  + " " +getSchool().getName();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
