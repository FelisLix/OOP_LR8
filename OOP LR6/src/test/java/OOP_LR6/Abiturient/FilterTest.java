package OOP_LR6.Abiturient;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class FilterTest {


    public static List<Abiturient> createList(){
        List<Abiturient> abiturients = new ArrayList<>();
        abiturients.add( new Abiturient(1, "Брик", "Йосип", "Яромирович", 2004, "680 AMSTERDAM AVE",14567842, 11.5));
        abiturients.add(new Abiturient(2,"Зноба","Йосип","Денисович", 2003,"560 BLAKE AVE",97634521, 8.4));
        abiturients.add( new Abiturient(3,"Гужва","Іоанн","Захарович",2004,"101 CLAY ST",24397164, 6.7));
        abiturients.add( new Abiturient(4,"Білинський","Царук","Радимович",1999,"17 LAKE RD",73649820, 4.9));
        abiturients.add(new Abiturient(5,"Кабаненко","Есфір","Пилипович",2002,"122 HILLSIDE AVE",55314608, 12.0));
        return abiturients;
    }

    @Test
    void abiturientsYearOfBirth() {
        Abiturient abiturient = new Abiturient();
        Filter filter = new Filter();
        abiturient.printAbiturients(filter.abiturientsYearOfBirth(createList()));
    }


    @Test
    void printDuplicatesTest(){
        AbiturientFunctions abiturientFunctions = new AbiturientFunctions();
        abiturientFunctions.printYearDuplicates(createList());
    }
}