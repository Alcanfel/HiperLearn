package Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "township")
public class TownShip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 200)
    private String name;

//    @OneToMany(cascade = CascadeType.ALL)
//    @OneToMany(mappedBy = "Entities.TownShip", cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "townShip", cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<Street> streets;

    public TownShip(){

    }

    public TownShip(String name){
        this.name = name;
        streets = new HashSet<Street>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Street> getStreets() {
        return streets;
    }

    public void setStreets(Set<Street> streets) {
        this.streets = streets;
    }

    public void addStreet(Street street){
        streets.add(street);
    }

    @Override
    public String toString() {
        return name;
    }
}
