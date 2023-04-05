package s5;

import java.util.HashMap;
import java.util.Map.Entry;

public class pr2 {
    public static void main(String[] args) {
        // Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. 
        //Отсортировать по убыванию популярности.

        
        HashMap<String, String> employees = new HashMap<>();
        employees.put("Иванов", "Иван");
        employees.put("Петрова", "Светлана");
        employees.put("Белова", "Кристина");
        employees.put("Мусина", "Анна");
        employees.put("Крутова", "Анна");
        employees.put("Юрин", "Иван");
        employees.put("Лыков", "Петр");
        employees.put("Чернов", "Павел");
        employees.put("Чернышов", "Петр");
        employees.put("Федорова", "Мария");
        employees.put("Светлова", "Марина");
        employees.put("Савина", "Мария");
        employees.put("Рыкова", "Мария");
        employees.put("Лугова", "Марина");
        employees.put("Владимирова", "Анна");
        employees.put("Мечников", "Иван");
        employees.put("Петин", "Петр");
        employees.put("Ежов", "Иван");

        HashMap<String, Integer> names = nameCount(employees);
        System.out.println(names);
        namesPrint(names);
    }

    public static HashMap<String, Integer> nameCount(HashMap<String, String> employees) {
        HashMap<String, Integer> names = new HashMap<>();
        for (Entry<String, String> pair1: employees.entrySet()){
            String name = pair1.getValue();
            if (names.containsKey(name)) 
                continue;
            Integer counter = 0;
            for (Entry<String, String> pair2: employees.entrySet()) {
                if (name.equals(pair2.getValue()))
                    counter ++;
            }
            names.put(name, counter);
        }

        return names;
    }

    public static void namesPrint(HashMap<String, Integer> names) {
        Entry<String, Integer> pairTemp = null;
        for (Entry<String, Integer> pair1: names.entrySet()) {
            pairTemp = pair1;
        }
            Entry<String, Integer> temp1 = pairTemp;
            Entry<String, Integer> temp2 = pairTemp;
            Integer max = temp1.getValue();
            for (Entry<String, Integer> pair2: names.entrySet()) {
                if (max < pair2.getValue()) {
                    temp2 = pair2;
                    max = temp2.getValue();
                    
                }
            }
            System.out.println(temp2);
            names.remove(temp2.getKey());
        try {
            namesPrint(names);
        }
        catch (Exception e) {}
    }
}
