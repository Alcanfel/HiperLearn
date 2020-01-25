package Entities;

import javax.persistence.*;

@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 4)
    private String serial;
    @Column(length = 6)
    private String number;
    @Column(name = "issuedbywho",length = 200)
    private String issuedByWho;
    @Column(name = "placeofbirth", length = 200)
    private String placeOfBirth;

//    // Связь с человеком
//    @OneToOne
    @OneToOne(mappedBy = "passport")
    private Person person;

    // Связь с адресом
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    public Passport(){
    }

    public Passport(String serial, String number, String issuedByWho, String placeOfBirth){
        this.serial = serial;
        this.number = number;
        this.issuedByWho = issuedByWho;
        this.placeOfBirth = placeOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIssuedByWho() {
        return issuedByWho;
    }

    public void setIssuedByWho(String issuedByWho) {
        this.issuedByWho = issuedByWho;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "cерия = '" + serial + '\'' +
                ", номер = '" + number + '\'' +
                ", кем выдан = '" + issuedByWho + '\'' +
                ", место рождения = '" + placeOfBirth + '\'' +
                ";\nАдрес регистрации: " + address.toString();
    }
}
