package pl.camp.it.book.store;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Mateusz");
        list.add("Janusz");
        list.add("Karol");

        List<String> copyList = new ArrayList<>(list);
        copyList.add("Wiesiek");

        System.out.println(list);
        System.out.println(copyList);
    }
}
