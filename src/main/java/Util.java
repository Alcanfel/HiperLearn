import Dao.AddressDao;
import Dao.ChildDao;
import Dao.PersonDao;
import Dao.SchoolDao;
import Entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Util {
    static public void addData(){
        //Добавление района и улиц
        AddressDao addressDao = new AddressDao();
        TownShip motoviliha = new TownShip("Мотовилихинский");
        TownShip orgo = new TownShip(" Оржоникидзевкий");
        TownShip akadem = new TownShip("Академический");
        Street novg = new Street("Новгородская", 590123);
        Street franko = new Street("Ивана Франко", 590123);
        Street gog = new Street("Гоголя", 590139);
        Street pushkina = new Street("Пушкина", 590222);
        Street mehr = new Street("Анатолия Мехренцева", 600121);
        Street sham = new Street("Шаманова", 600113);

        motoviliha.addStreet(novg);
        motoviliha.addStreet(franko);
        novg.setTownShip(motoviliha);
        franko.setTownShip(motoviliha);


        orgo.addStreet(gog);
        orgo.addStreet(pushkina);
        gog.setTownShip(orgo);
        pushkina.setTownShip(orgo);

        akadem.addStreet(mehr);
        akadem.addStreet(sham);
        mehr.setTownShip(akadem);
        sham.setTownShip(akadem);

        addressDao.save(motoviliha);
        addressDao.save(orgo);
        addressDao.save(akadem);


        // Добавление школы и ребенка
        SchoolService schoolService = new SchoolService();

        //Добавили 3 школы (2 в Перми 1 в ЕКБ)
        School schoolPkk = new School("ПКК №1", "Валиев М.Б.");
        School schoolGimnaziyaSeven = new School("Гимназия 7", "Айдаров Ю.Р");
        School schoolFifty = new School("Школа 50", "Якубович А.В.");
        School schoolSeven = new School("Школа 7", "Рублюк И.В.");

        //Добавили адрес и привязали к школе
        Address addressPkk = new Address();
        addressPkk.setCountry("Россия");
        addressPkk.setCity("Пермь");
        addressPkk.setStreet(franko);
        addressPkk.setHouse("20");
        addressPkk.setRegion("Пермский край");
        schoolPkk.setAddress(addressPkk);

        Address addressGimnaziyaSeven = new Address();
        addressGimnaziyaSeven.setCountry("Россия");
        addressGimnaziyaSeven.setCity("Пермь");
        addressGimnaziyaSeven.setStreet(novg);
        addressGimnaziyaSeven.setHouse("30");
        schoolGimnaziyaSeven.setAddress(addressGimnaziyaSeven);

        Address addressFifty = new Address();
        addressFifty.setCountry("Россия");
        addressFifty.setCity("Екатеринбург");
        addressFifty.setStreet(mehr);
        addressFifty.setHouse("30");
        schoolFifty.setAddress(addressFifty);

        Address addressSeven = new Address();
        addressSeven.setCountry("Россия");
        addressSeven.setCity("Екатеринбург");
        addressSeven.setStreet(sham);
        addressSeven.setHouse("40");
        schoolSeven.setAddress(addressSeven);

        //Создали ребенка и привязали к школе
        ChildDao childDao = new ChildDao();
        Child childBalabanov = new Child("Николай","Балабанов", 10 );
        childBalabanov.setSchool(schoolPkk); // заполняем школу для ребенка
        schoolPkk.addChild(childBalabanov); // Добавляем ребенка в школу

        Child childVasilev = new Child("Маргарита","Васильева", 11 );
        childVasilev.setSchool(schoolGimnaziyaSeven); // заполняем школу для ребенка
        schoolGimnaziyaSeven.addChild(childVasilev); // Добавляем ребенка в школу

        Child childGorbunov= new Child("Лера","Горбунова", 10 );
        childGorbunov.setSchool(schoolFifty); // заполняем школу для ребенка
        schoolFifty.addChild(childGorbunov); // Добавляем ребенка в школу

        Child childGorbunovTwo = new Child("Олег","Горбунов", 12 );
        childGorbunovTwo.setSchool(schoolFifty); // заполняем школу для ребенка
        schoolFifty.addChild(childGorbunovTwo); // Добавляем ребенка в школу

        schoolService.saveSchool(schoolPkk);
        schoolService.saveSchool(schoolGimnaziyaSeven);
        schoolService.saveSchool(schoolFifty);
        schoolService.saveSchool(schoolSeven);

        // Добавление человека и паспорта, ребенка в конце записываем в БД
        PersonDao personDao = new PersonDao();
        Person personBalabanov = new Person("Алескей", "Балабанов", 60);
        Person personVasilev = new Person("Роман", "Васильев", 40);
        Person personGorbunov= new Person("Олег", "Горбунов", 50);
        Person personNekrasova = new Person("Анастасия","Некрасова", 31);
        Passport passportBalabnov = new Passport("1111","555555","Отделом УФМС ...", "Пермь");
        Address addressBalabanov = new Address();
        addressBalabanov.setHouse("30");
        addressBalabanov.setCity("Пермь");
        addressBalabanov.setCountry("Россия");
        addressBalabanov.setRoom("17");
        addressBalabanov.setRegion("Пермский край");
        addressBalabanov.setStreet(novg);
        passportBalabnov.setAddress(addressBalabanov);

        Passport passportVasilev = new Passport("2222","666666","Отделом УФМС ....", "Пермь");
        Address addressVasilev = new Address();
        addressVasilev.setHouse("40");
        addressVasilev.setCity("Пермь");
        addressVasilev.setCountry("Россия");
        addressVasilev.setStreet(franko);
        addressVasilev.setRoom("24");
        addressVasilev.setRegion("Пермский край");
        passportVasilev.setAddress(addressVasilev);


        Passport passportGorbunov = new Passport("3333","777777","Отделом УФМС ...", "Екатеринбург");
        Address addressGorbunov = new Address();
        addressGorbunov.setHouse("50");
        addressGorbunov.setCity("Екатеринбург");
        addressGorbunov.setCountry("Россия");
        addressGorbunov.setStreet(mehr);
        addressGorbunov.setRoom("45");
        addressGorbunov.setRegion("Свердловская область");
        passportGorbunov.setAddress(addressGorbunov);


        Passport passportNekrasova = new Passport("4444","888888","Отделом УФМС ...", "Екатеринбург");
        Address addressNekrasova = new Address();
        addressNekrasova.setHouse("50");
        addressNekrasova.setCity("Екатеринбург");
        addressNekrasova.setCountry("Россия");
        addressNekrasova.setStreet(franko);
        addressNekrasova.setRegion("Сверловская область");
        addressNekrasova.setRoom("45");
        passportNekrasova.setAddress(addressNekrasova);



        personBalabanov.setPassport(passportBalabnov);
        personBalabanov.addChild(childBalabanov);
        childBalabanov.setAddress(addressBalabanov);
        childDao.update(childBalabanov);

        personVasilev.setPassport(passportVasilev);
        personVasilev.addChild(childVasilev);
        childVasilev.setAddress(addressVasilev);
        childDao.update(childVasilev);

        personGorbunov.setPassport(passportGorbunov);
        personGorbunov.addChild(childGorbunov);
        personGorbunov.addChild(childGorbunovTwo);
        childGorbunov.setAddress(addressGorbunov);
        childGorbunovTwo.setAddress(addressGorbunov);
        childDao.update(childGorbunov);
        childDao.update(childGorbunovTwo);

        personNekrasova.setPassport(passportNekrasova);
        personNekrasova.addChild(childGorbunov);
        personNekrasova.addChild(childGorbunovTwo);


        personDao.save(personBalabanov);
        personDao.save(personGorbunov);
        personDao.save(personVasilev);
        personDao.save(personNekrasova);
    }

    static public void printPerson(){
        System.out.println("Вывод информации о человеке");
        PersonDao personDao = new PersonDao();
        for (Person person: personDao.findAllPerson()
             ) {
            System.out.println(person.toString());
            System.out.println();
        }
    }

    static public void changeSchoolForChild(){
        ChildDao childDao = new ChildDao();
        List<Child> childList = childDao.findAllChild();
        for (Child child: childList
             ) {
            System.out.println(child.getInfoChildAndSchool());
        }
        System.out.println("1) Укажите ID ребенка для изменения школы;\n2) Введите quit для выхода;");
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext("quit")){
            Child child = childDao.findById(Integer.parseInt(sc.nextLine()));
            System.out.println(String.format("Ребёнок %s %s обучается в школе \"%s\", проживает в районе %s",
                    child.getFirstName(),
                    child.getLastName(),
                    child.getSchool().getName(),
                    child.getAddress().getStreet().getTownShip().getName()));

            SchoolDao schoolDao = new SchoolDao();
            List<School> schoolList = schoolDao.findAllSchool();
//            System.out.println(schoolList);

            for (School school: schoolList
                 ) {
                if (school.getAddress().getStreet().getTownShip().getName().equals(child.getAddress().getStreet().getTownShip().getName())
                        && !school.getName().equals(child.getSchool().getName()))
                {
                    System.out.println(String.format("В районе проживания %s имеется школа id=%s  %s ",child.getAddress().getStreet().getTownShip().getName(),school.getId(),school.getName()));
                }
                }

            Scanner sc2 = new Scanner(System.in);
            System.out.println("3) Выберите id школы для изменения:");
            School schoolNew = schoolDao.findById(sc2.nextInt());
            child.setSchool(schoolNew);
            childDao.update(child);

            List<Child> childListTwo = childDao.findAllChild();
            for (Child childNew: childListTwo
            ) {
                System.out.println(childNew.getInfoChildAndSchool());
            }
            }


        }
    }
