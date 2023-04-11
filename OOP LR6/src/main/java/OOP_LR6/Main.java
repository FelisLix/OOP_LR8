package OOP_LR6;

import OOP_LR6.Abiturient.Abiturient;
import OOP_LR6.Abiturient.AbiturientFunctions;
import OOP_LR6.Abiturient.Filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private Scanner scanner;

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        scanner = new Scanner(System.in);
        Filter filter = new Filter();
        IO io = new IO();
        Abiturient abiturient = new Abiturient();
        AbiturientFunctions functions = new AbiturientFunctions();


        List<Abiturient> abiturients = createList();
        int o;
        while ((o = menu()) != 0){
            switch (o){
                case 1 -> abiturient.printAbiturients(abiturients);
                case 2 -> abiturients = functions.addNewAbiturient(abiturients);
                case 3 -> abiturients = functions.deleteAbiturient(abiturients);
                case 4 -> functions.printAbiturientsName(abiturients);
                case 5 -> functions.printAbiturientsMarkHigherThen(abiturients);
                case 6 -> functions.printAbiturientsWithHigherMark(abiturients);
                case 7 -> abiturient.printAbiturients(filter.printAlphabetOrder(abiturients));
                case 8 -> functions.writeObjectsInFileJSON(abiturients);
                case 9 -> abiturient.printAbiturients(io.readObjectsJSON());
                case 10 ->functions.printAbiturientByID(abiturients);
                case 11 ->abiturient.printAbiturients(filter.abiturientsYearOfBirth(abiturients));
                case 12 ->functions.printYearDuplicates(abiturients);
            }
        }
    }

    public static List<Abiturient> createList(){
        List<Abiturient> abiturients = new ArrayList<>();
        abiturients.add( new Abiturient(1, "Брик", "Йосип", "Яромирович", 2004, "680 AMSTERDAM AVE",14567842, 11.5));
        abiturients.add(new Abiturient(2,"Зноба","Йосип","Денисович", 2003,"560 BLAKE AVE",97634521, 8.4));
        abiturients.add( new Abiturient(3,"Гужва","Іоанн","Захарович",2004,"101 CLAY ST",24397164, 6.7));
        abiturients.add( new Abiturient(4,"Білинський","Царук","Радимович",1999,"17 LAKE RD",73649820, 4.9));
        abiturients.add(new Abiturient(5,"Кабаненко","Есфір","Пилипович",2002,"122 HILLSIDE AVE",55314608, 12.0));
        return abiturients;
    }

    public int menu(){
        System.out.println("""
                |0.  |Exit
                |1.  |Показати список абітурієнтів;
                |2.  |Додати нового абітурієнта;
                |3.  |Видалити абітурієнта;
                |4.  |Список абітурієнтів із вказаним іменем, в порядку спадання середнього балу;
                |5.  |Список абітурієнтів, середній бал у яких вище заданого;
                |6.  |Вибрати задане число n абітурієнтів, що мають найвищий середній бал.
                |7.  |Список абітурієнтів в порядку алфавіту за прізвищем, при збігу прізвищ – за іменами;
                |8.  |Записати список у файл JSON;
                |9.  |Показати список у файлі JSON;
                |10. |Показати абітурієнта;
                |11. |Показати список років народження абітурієнтів в порядку зростання без повторів;
                |12. |Показати кількість абітурієнтів кожного року народження;
                """);
        int res = scanner.nextInt();
        scanner.nextLine();
        return res;
    }
}