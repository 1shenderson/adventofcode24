package uk.co.oneshenderson.dayone;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PartTwo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/scott/Repos/adventofcode2024/src/main/java/uk/co/oneshenderson/dayone/input.txt"));

        int total = 0;
        List<Integer> firstColumn = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            List<String> parts = Arrays.stream(line.split(" {3}")).toList();
            firstColumn.add(Integer.parseInt(parts.get(0)));
            Integer secondValue = Integer.parseInt(parts.get(1));
            if (countMap.containsKey(secondValue)) {
                countMap.put(secondValue, countMap.get(secondValue)+1);
            } else {
                countMap.put(secondValue, 1);
            }
        }

        for (Integer first : firstColumn) {
            if (countMap.containsKey(first)) {
                total += first * countMap.get(first);
            }
        }

        System.out.println(total);
    }
}