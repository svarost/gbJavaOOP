package lesson3.homework;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyList<String> strLst = new MyList<>();
        strLst.add("Первый");
        strLst.add("Второй");
        strLst.add("Третий");
        strLst.add("Четверный");
        strLst.add("Пятый");

        System.out.println(strLst);
    }
}
