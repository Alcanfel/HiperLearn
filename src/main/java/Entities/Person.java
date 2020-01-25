package Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstname",length = 20)
    private String firstName;
    @Column(name = "lastname",length = 20)
    private String lastName;
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id", referencedColumnName = "id")
    private Passport passport;

    @ManyToMany
    @JoinTable(name = "parent_and_child", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "child_id"))
    private Set<Child> children = new HashSet<Child>();

    public Set<Child> getChildren() {
        return children;
    }

    public void setChildren(Set<Child> children) {
        this.children = children;
    }

    public void addChild(Child child){
        children.add(child);
    }


    public Person(){

    }

    public Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.passport = new Passport();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    public void setPassport(Passport passport) {
        this.passport = passport;
    }
    public Passport getPassport() {
        return passport;
    }

    @Override
    public String toString() {
        return "Имя = '" + firstName + '\'' +
                ", Фамилия = '" + lastName + '\'' +
                ", Возраст = " + age +
                ";\nПаспортные данные: " + passport.toString() +
                ";\nДети: " + children.toString();
    }
}
