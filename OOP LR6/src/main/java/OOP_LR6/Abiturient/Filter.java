package OOP_LR6.Abiturient;

import java.util.*;

public class Filter {

    //e) список років народження абітурієнтів в порядку зростання без повторів
    public List<Abiturient> abiturientsYearOfBirth(List<Abiturient> abiturients){
        SortedSet<Abiturient> abs = new TreeSet<>(Comparator.comparing(Abiturient::getYearOfBirth));
        abs.addAll(abiturients);
        return new ArrayList<>(abs);
    }

    // пошук елементів у колекції
    public Abiturient findAbiturient(List<Abiturient> abiturients, int ID){
        Abiturient res = new Abiturient();
        for (Abiturient abiturient : abiturients) {
            if (abiturient.getID() == ID) {
                res = abiturient;
            }
        }
        return res;
    }

    //a) список абітурієнтів із вказаним іменем, в порядку спадання середнього балу;
    public List<Abiturient> abiturientsName(List<Abiturient> abiturients, String name){
        List<Abiturient> abs = new ArrayList<>();
        abiturients.sort(Comparator.comparingDouble(Abiturient::getMark).reversed());
        for (Abiturient abiturient : abiturients) {
            if (abiturient.getName().equals(name)){
                abs.add(abiturient);
            }
        }
        return abs;
    }

    //b) список абітурієнтів, середній бал у яких вище заданого;
    public List<Abiturient> abiturientsMarkHigherThat(List<Abiturient> abiturients, double mark){
        List<Abiturient> abs = new ArrayList<>();
        for (Abiturient abiturient : abiturients) {
            if (abiturient.getMark() > mark){
                abs.add(abiturient);
            }
        }
        return abs;
    }

    //c) вибрати задане число n абітурієнтів, що мають найвищий середній бал.
    public List<Abiturient> abiturientsWithHigherMark(List<Abiturient> abiturients, int n){
        List<Abiturient> abs = new ArrayList<>();
        abiturients.sort(Comparator.comparingDouble(Abiturient::getMark).reversed());
        for (int i = 0; i < n; i++){
            abs.add(abiturients.get(i));
        }
        return abs;
    }

    //d) список абітурієнтів в порядку алфавіту за прізвищем, при збігу прізвищ – за іменами
    public List<Abiturient> printAlphabetOrder(List<Abiturient> abiturients){
        abiturients.sort(Comparator.comparing(Abiturient::getSurname).thenComparing(Abiturient::getName));
        return new ArrayList<>(abiturients);
    }
}



