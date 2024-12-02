package uk.co.oneshenderson.daytwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PartTwo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/java/uk/co/oneshenderson/daytwo/input.txt"));

        int safeReports = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            List<String> report = Arrays.stream(line.split(" ")).toList();

            if (isReportSafe(report, false)) {
                safeReports++;
            }
        }

        System.out.println(safeReports);
    }

    private static boolean isReportSafe(List<String> report, boolean problemDampenerApplied) {
        boolean increasing = Integer.parseInt(report.get(0)) < Integer.parseInt(report.get(1));
        for (int i = 1; i < report.size(); i++) {
            int firstLevel = increasing ? i - 1 : i;
            int secondLevel = increasing ? i : i - 1;
            if (compareLevels(Integer.parseInt(report.get(firstLevel)), Integer.parseInt(report.get(secondLevel)))) {
                if (problemDampenerApplied) {
                    // problem dampener applied, so if the dampener didn't work return false
                    return false;
                }

                for (int j = 0; j < report.size(); j++) {
                    List<String> fixedReport = new ArrayList<>(report);
                    fixedReport.remove(j);

                    if (isReportSafe(fixedReport, true)) {
                        return true;
                    }
                }

                return false;
            }
        }

        return true;
    }

    private static boolean compareLevels(Integer firstLevel, Integer secondLevel) {
        return secondLevel - firstLevel <= 0 || secondLevel - firstLevel >= 4;
    }
}