//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        TwoWheeler test = new Honda();
        test.run();

        // An ArrayList is a resizable array that can grow as needed.
        // It allows you to store elements and access them by index.
        ArrayList<String> cars = new ArrayList<>(); //ArrayList
        cars.add("Tata");
        cars.add("Honda");
        cars.add("Hyundai");
        cars.add("Suzuki");
        cars.add("Mahindra");
        System.out.println((cars));

        // A HashSet is a collection where every element is unique.
        // No duplicates are allowed.
        HashSet<String> carsSet = new HashSet<>(); //HashSet
        carsSet.add("Tata");
        carsSet.add("Honda");
        carsSet.add("Hyundai");
        carsSet.add("Hyundai"); //Duplicate
        carsSet.add("Suzuki");
        carsSet.add("Mahindra");
        System.out.println((carsSet));

        /* A HashMap stores key-value pairs
        which are great when you want to store values
        and find them by a key (like a name or ID): */
        HashMap<String, String> capitalCities = new HashMap<>(); //HashMap

        // Add keys and values (Country, City)
        capitalCities.put("India", "New Delhi");
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
        System.out.println(capitalCities);

        // An iterator is a way to loop through elements in a data structure.
        // Get an iterator for the ArrayList
        Iterator<String> it = cars.iterator();

        // Iterate through the list using the iterator
        while(it.hasNext())
        {
            System.out.println(it.next());
        }

    }
}
