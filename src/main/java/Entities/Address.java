package Entities;

import javax.persistence.*;

@Entity
@Table(name ="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String country;

    @Column(length = 100)
    private String region;

    @Column(length = 100)
    private String city;

    // Связь с улицей
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "street_id", referencedColumnName = "id")
    private Street street;

    @Column(length = 100)
    private String house;

    @Column(length = 100)
    private String room;

    @OneToOne(mappedBy = "address")
    private Passport passport;

    @OneToOne(mappedBy = "address")
    private School school;

//    @OneToOne(mappedBy = "address")
//    private Child child;


    public Address(){

    }

    public Address(String country, String region, String city, Street street, String house, String room) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.house = house;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "страна = '" + country + '\'' +
                ", регион = '" + region + '\'' +
                ", город = '" + city + '\'' +
                ", улица = " + street.toString() +
                ", дом = '" + house + '\'' +
                ", квартира = '" + room + '\''+
                ";";
    }
}
