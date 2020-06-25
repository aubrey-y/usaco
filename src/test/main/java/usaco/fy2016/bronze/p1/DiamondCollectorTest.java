package test.main.java.usaco.fy2016.bronze.p1;

import main.java.usaco.fy2016.bronze.p1.DiamondCollector;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DiamondCollectorTest {

    private static final String IN_FILENAME = "diamond.in";

    private static final String OUT_FILENAME = "diamond.out";

    public static void main(String[] args) {
        executeTestCase(Arrays.asList("5 3", "1", "6", "4", "3", "1"), Collections.singletonList("4"));
        executeTestCase(Arrays.asList("5 3", "1", "10", "9", "8", "5"), Collections.singletonList("3"));
        executeTestCase(Collections.singletonList("0 0"), Collections.singletonList("0"));
        executeTestCase(Arrays.asList("1 0", "1"), Collections.singletonList("1"));
        executeTestCase(Arrays.asList("5 0", "1", "1", "1", "1", "1"), Collections.singletonList("5"));
        executeTestCase(Arrays.asList("5 0", "1", "2", "3", "4", "5"), Collections.singletonList("1"));
        executeTestCase(Arrays.asList("5 1", "1", "2", "3", "4", "5"), Collections.singletonList("2"));
        executeTestCase(Arrays.asList("5 1", "1", "3", "5", "7", "9"), Collections.singletonList("1"));
        executeTestCase(Arrays.asList("11 1", "1", "2", "4", "5", "7", "8", "9", "10", "11", "12", "12"), Collections.singletonList("3"));
    }

    public static void executeTestCase(List<String> input, List<String> expectedOutput) {
        try {
            printToIn(IN_FILENAME, input);

            DiamondCollector.main(null);

            BufferedReader bufferedReader = new BufferedReader(new FileReader(OUT_FILENAME));
            List<String> output = new ArrayList<>();

            String line;
            while((line = bufferedReader.readLine()) != null) {
                output.add(line);
            }
            bufferedReader.close();

            assert output.size() == expectedOutput.size();

            for(int i = 0; i < output.size(); i++) {
                assert output.get(i).equals(expectedOutput.get(i));
            }

            System.out.println(String.format("Case %s passed ✓", input));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printToIn(String fileName, List<String> lines) throws IOException {
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        for(String s: lines) {
            printWriter.println(s);
        }
        printWriter.close();
    }
}
