package codingchallenge;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;

public class Printer {
    public String printUpTo(int n) {
        List<String> res = new ArrayList<>();
        res.add("0");

        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                res.add(String.valueOf(i));
            }
        }

        if (n < 0) {
            for (int i = -1; i >= n; i--) {
                res.add(String.valueOf(i));
            }
        }

        return String.join(",", res);
    }

    public void printArrayItems() {
        int[] arr = {1, 2, 3};
        for (int j : arr) {
            System.out.println(j);
        }
        System.out.println("Something wrong");
    }

    public void printArrayEvenItems() {
        int[] arr = {1, 2, 3, 5, 6, 7, 8, 9};
        for (int i : arr) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
        System.out.println("Something wrong");
    }

    public void isArrEmpty(String[] arr) {
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                System.out.println("Array is NOT empty");
                System.out.println("Array is " + arr[i]);
            } else
                System.out.println("Array is EMPTY");
        }
    }

    public boolean isArrContainsElem() {
        String str = "Thank you. Your order has been received.";
//        throw new RuntimeException();
        return true;
    }

    public String reversesStr(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++){
            result = str.charAt(i) + result;
        }
        return result;
    }
}
