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

public class DiamondCollector {

    public static void main(String[] args) throws IOException {
        List<String> input = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("diamond.in"));

        String line;
        while((line = bufferedReader.readLine()) != null) {
            input.add(line);
        }
        bufferedReader.close();

        String[] nk = input.get(0).split(" ");
        int numDiamonds = Integer.parseInt(nk[0]);
        int maxSizeDiff = Integer.parseInt(nk[1]);

        List<Integer> diamonds = new ArrayList<>();
        for(int i = 1; i < numDiamonds + 1; i++) {
            diamonds.add(Integer.parseInt(input.get(i)));
        }

        Collections.sort(diamonds);

        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
        printWriter.println(getMaxDiamonds(diamonds, maxSizeDiff));
        printWriter.close();
    }

    public static Integer getMaxDiamonds(List<Integer> diamonds, int maxSizeDiff) {
        int maxDiamonds = 0;
        for(int startIndex = 0; startIndex < diamonds.size(); startIndex++) {
            int currentIndex = startIndex + 1;
            int currentMax = 1;

            while(currentIndex < diamonds.size() && diamonds.get(currentIndex) - diamonds.get(startIndex) <= maxSizeDiff) {
                currentMax += 1;
                currentIndex += 1;
            }
            maxDiamonds = Collections.max(Arrays.asList(maxDiamonds, currentMax));
        }
        return maxDiamonds;
    }
}