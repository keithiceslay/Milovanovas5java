package s5;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;


public class pr1 {
    public static void main(String[] args) {
        // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
        Scanner scan = new Scanner(System.in);
        
        System.out.println("How many people do you wish to add?");
        Integer k = numberInput(scan);
        HashMap<Integer, String> phoneBook = new HashMap<>(k);
        for (int i = 0; i < k; i++){
            phoneBook = personInput(scan, phoneBook);
        }
        System.out.printf("Your phonebook: " + phoneBook);

        System.out.println("Do you wish to find someone in your phonebook?\n0: no\n1: yes");
        Integer choice = numberInput(scan);
        if (choice == 1) {
            System.out.println("Do you wish to search by the person's name or by their number?\n0: name\n1: number");
            choice = numberInput(scan);
            if (choice == 0){
                findByName(scan, phoneBook);
            }
            else if (choice == 1){
                findByNumber(scan, phoneBook);
            }

        }
        scan.close();
    }

    public static Integer numberInput(Scanner scan) {
        try {
            Integer k = scan.nextInt();
            return k;
        }
        catch (Exception e) {
            System.out.println("Please inpout a number");
            return numberInput(scan);
        }
    }

    public static HashMap<Integer, String> personInput(Scanner scan, HashMap<Integer, String> phoneBook) {
        String person = new String();
        Integer number;
        System.out.println("Inout the person's number");
        number = numberInput(scan);
        System.out.println("Input a name of the person you wish to add");
        scan.nextLine();
        person = scan.nextLine();
        phoneBook.put(number, person);
        return phoneBook;
    }

    public static void findByName(Scanner scan, HashMap<Integer, String> phoneBook) {
        System.out.println("Inout the person's name");
        scan.nextLine();
        String name = scan.nextLine();
        for (Entry<Integer, String> pair: phoneBook.entrySet()) {
            if(pair.getValue().equals(name))
                System.out.println(String.format("%d %s", pair.getKey(), pair.getValue()));
        }
    }

    public static void findByNumber(Scanner scan, HashMap<Integer, String> phoneBook) {
        System.out.println("Input the person's phonenumber");
        Integer number = numberInput(scan);
        System.out.println(number + "  " + phoneBook.get(number));
    }
}
