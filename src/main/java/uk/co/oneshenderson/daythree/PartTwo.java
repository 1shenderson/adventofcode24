package uk.co.oneshenderson.daythree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartTwo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/java/uk/co/oneshenderson/daythree/input.txt"));

        Pattern MUL_REGEX = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)|don't\\(\\)|do\\(\\)");

        int total = 0;
        boolean instructionsEnabled = true;
        while (scanner.hasNextLine()) {
            String program = scanner.nextLine();
            Matcher m = MUL_REGEX.matcher(program);

            while (m.find()) {
                String s = m.group();

                if (s.equals("do()")) {
                    instructionsEnabled = true;
                } else if (s.equals("don't()")) {
                    instructionsEnabled = false;
                }
                else {
                    if (instructionsEnabled) {
                        System.out.println(s);
                        String parsed = s.replace("mul(", "").replace(")", "");
                        List<String> numbers = Arrays.stream(parsed.split(",")).toList();

                        total += (Integer.parseInt(numbers.get(0)) * Integer.parseInt(numbers.get(1)));
                    }
                }
            }
        }

        System.out.println(total);
    }
}