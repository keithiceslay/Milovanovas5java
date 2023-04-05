package s5;

import java.util.HashMap;
import java.util.Scanner;

public class pr3 {
    public static void main(String[] args) {
        //Реализовать алгоритм пирамидальной сортировки (HeapSort).
        HashMap <Integer, Integer> arr = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("How long do you wish for your array to be?");
        Integer k = scanNumber(scan);
        for (Integer i = 0; i < k; i++) {
            System.out.println("Input a number");
            arr.put(i, scanNumber(scan));
        }
        sort(arr);
        System.out.println(arr);
        scan.close();
    }

        private static Integer scanNumber(Scanner scan) {
            try {
                Integer k = scan.nextInt();
                return k;
            }
            catch (Exception e) {
                System.out.println("Please inpout a number");
                return scanNumber(scan);
            }
    }

        public static void sort(HashMap<Integer, Integer> arr) {
            Integer n = arr.size();
            for (int i = n - 2; i >= 0; i--)
                heapify(arr, n, i);
            int j = 0;
            for (int i = n - 1; i > 0; i--) {
                int temp = arr.get(j);
                arr.put(j, arr.get(i));
                arr.put(j, temp);
                j++;
            }
        }

        private static void heapify(HashMap<Integer, Integer> arr, Integer n, int i) {
            int lar = i;
            int l = i + 1;
            int r = i + 2;

            if (l < n && arr.get(l) > arr.get(lar)) 
                lar = l;
            if (r < n && arr.get(r) > arr.get(lar))
                lar = r;
            if (lar != i) {
                int swap = arr.get(i);
                arr.put(i, arr.get(lar));
                arr.put(lar, swap);
                heapify(arr, n, lar);
            }
        }
}
