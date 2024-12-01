package uk.co.oneshenderson.dayone;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PartOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/java/uk/co/oneshenderson/dayone/input.txt"));

        int total = 0;
        List<Integer> firstColumn = new ArrayList<>();
        List<Integer> secondColumn = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            List<String> parts = Arrays.stream(line.split(" {3}")).toList();
            firstColumn.add(Integer.parseInt(parts.get(0)));
            secondColumn.add(Integer.parseInt(parts.get(1)));
        }

        Collections.sort(firstColumn);
        Collections.sort(secondColumn);

        for (int i = 0; i < firstColumn.size(); i++) {
            if (firstColumn.get(i) < secondColumn.get(i)) {
                total += secondColumn.get(i) - firstColumn.get(i);
            } else {
                total += firstColumn.get(i) - secondColumn.get(i);
            }
        }

        System.out.println(total);
    }
}