package Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "schools")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 20)
    private String name;
    @Column(length = 20)
    private String director;

    // Связь с адресом
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<Child> children;

    public School() {
    }

    public School(String name, String director){
        this.name = name;
        this.director = director;
        this.address = new Address();
        children = new HashSet<>();
    }

    public void addChild(Child child){
        child.setSchool(this);
        children.add(child);
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }


    public Set<Child> getChildren() {
        return children;
    }

    public void setChildren(Set<Child> children) {
        this.children = children;
    }
}
