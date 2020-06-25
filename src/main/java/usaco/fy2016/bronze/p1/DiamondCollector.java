package main.java.usaco.fy2016.bronze.p1;

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

/*
    Bessie the cow, always a fan of shiny objects, has taken up a hobby of mining diamonds in her spare time! She has
    collected N diamonds (N≤1000) of varying sizes, and she wants to arrange some of them in a display case in the barn.
    Since Bessie wants the diamonds in the case to be relatively similar in size, she decides that she will not include
    two diamonds in the case if their sizes differ by more than K (two diamonds can be displayed together in the case if
    their sizes differ by exactly K). Given K, please help Bessie determine the maximum number of diamonds she can
    display in the case.

    INPUT FORMAT (file diamond.in):
    The first line of the input file contains N and K (0≤K≤10,000). The next N lines each contain an integer giving the
    size of one of the diamonds. All sizes will be positive and will not exceed 10,000.
    OUTPUT FORMAT (file diamond.out):
    Output a single positive integer, telling the maximum number of diamonds that Bessie can showcase.
    SAMPLE INPUT:
    5 3
    1
    6
    4
    3
    1
    SAMPLE OUTPUT:
    4
    _____________________________________________________________________________________
    Notes

    [1, 1, 3, 4, 6]

    consider [1, 5, 8, 9, 10] as edge case (maxSizeDiff=3)

    recursive solution
    1 -> 5
    |   \
    1   5 -> 8 -> 9 -> 10
                        4

    max(1, 4) = 4
 */
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
