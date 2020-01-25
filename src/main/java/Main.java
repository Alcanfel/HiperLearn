import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Добавление данных
//        Util.addData();

        // вывод все информации о человеке
        Util.printPerson();

        // реализовать возможность через консоль для конкретного ребенка, изменить у него учебное учреждение.
        // При вводе, должна выводиться подсказка,
        // об учебном учреждение в районе проживания
        Util.changeSchoolForChild();
    }
}
