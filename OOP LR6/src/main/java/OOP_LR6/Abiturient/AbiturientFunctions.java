package OOP_LR6.Abiturient;

import OOP_LR6.IO;

import java.util.*;

public class AbiturientFunctions {

    private Scanner scanner;
    private final Abiturient abiturient = new Abiturient();
    private final IO io = new IO();
    private final Filter filter = new Filter();


    //a) список абітурієнтів із вказаним іменем, в порядку спадання середнього балу;
    public void printAbiturientsName(List<Abiturient> abiturients){
        scanner = new Scanner(System.in);
        System.out.println("Ім’я: ");
        String name = scanner.nextLine();
        abiturient.printAbiturients(filter.abiturientsName(abiturients, name));
    }

    //f) визначити кількість абітурієнтів кожного року народження.
    public void printYearDuplicates(List<Abiturient> abiturients){
        List<Integer> absYear = new ArrayList<>();
        for (Abiturient abiturient1 : abiturients){
            absYear.add(abiturient1.getYearOfBirth());
        }
        Set<Integer> abs = new HashSet<>(absYear);
        for (Integer year : abs) {
            System.out.println(year + ": " + Collections.frequency(absYear, year));
        }
    }

    //b) список абітурієнтів, середній бал у яких вище заданого;
    public void printAbiturientsMarkHigherThen(List<Abiturient> abiturients){
        scanner = new Scanner(System.in);
        System.out.println("Середній бал: ");
        int mark = scanner.nextInt();
        abiturient.printAbiturients(filter.abiturientsMarkHigherThat(abiturients, mark));
    }

    //c) вибрати задане число n абітурієнтів, що мають найвищий середній бал.
    public void printAbiturientsWithHigherMark(List<Abiturient> abiturients) {
        scanner = new Scanner(System.in);
        System.out.println("Число n абітурієнтів:");
        int n = scanner.nextInt();
        abiturient.printAbiturients(filter.abiturientsWithHigherMark(abiturients, n));

    }

    //файлові операції введення-виведення
    public void writeObjectsInFileJSON(List<Abiturient> abiturients) {
        io.writeObjectsJSON(abiturients);
        System.out.println("Записано!");
    }

    //файлові операції введення-виведення
    public List<Abiturient> addNewAbiturient(List<Abiturient> abiturients){
        scanner = new Scanner(System.in);

        System.out.println("ID: ");
        int ID = scanner.nextInt();

        System.out.println("Прізвище: ");
        String surname = scanner.nextLine();

        System.out.println("Ім'я: ");
        String name = scanner.nextLine();

        System.out.println("По батькові: ");
        String fName = scanner.nextLine();

        System.out.println("Рік народження: ");
        int year = scanner.nextInt();

        System.out.println("Адреса: ");
        String address = scanner.nextLine();

        System.out.println("Телефон: ");
        int phone = scanner.nextInt();

        System.out.println("Середній бал: ");
        double mark = scanner.nextDouble();

        System.out.println("Записано!");
        return abiturient.addNew(abiturients, new Abiturient(ID, surname, name, fName, year, address, phone, mark));
    }

    //вилучення знайденого об'єкта
    public List<Abiturient> deleteAbiturient(List<Abiturient> abiturients){
        scanner = new Scanner(System.in);
        System.out.println("ID:");
        int index = scanner.nextInt();
        System.out.println("Видалено!");
        return abiturient.delete(abiturients, index);
    }

    // пошук елементів у колекції
    public void printAbiturientByID(List<Abiturient> abiturients){
        scanner = new Scanner(System.in);
        System.out.println("ID: ");
        int id = scanner.nextInt();
        System.out.println(filter.findAbiturient(abiturients, id));
    }

}
