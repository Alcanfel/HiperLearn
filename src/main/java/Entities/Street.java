package Entities;

import javax.persistence.*;

@Entity
@Table(name = "streets")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 200)
    private String name;
    @Column(name = "postcode")
    private int postCode;

//    @ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "township_id")
    private TownShip townShip;

//    // Связь с адресом
//    @OneToOne(mappedBy = "streets")
//    private Entities.Address address;
    public Street(){

    }

    public Street(String name, int postCode){
        this.name = name;
        this.postCode = postCode;
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

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public TownShip getTownShip() {
        return townShip;
    }

    public void setTownShip(TownShip townShip) {
        this.townShip = townShip;
    }

    @Override
    public String toString() {
        return name + '\'' +
                ", почтовый индекс = " + postCode;
    }
}
