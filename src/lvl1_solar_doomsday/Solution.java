/*

//THIS SOLUTION IS WITH LISTS BUT THEY DON'T ACCEPT LISTS
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int[] solution(int area) {
        // Your code here

        int maxSizePanel = (int) Math.sqrt(area);//Max Square Panel
        if (maxSizePanel * maxSizePanel == area)
            return new int[]{maxSizePanel};//If fits a perfect square panel return only one

        List<Integer> listAreaPanels = new ArrayList<>();//Creating list

        listAreaPanels.add(maxSizePanel * maxSizePanel);

        int remainingArea = area - maxSizePanel * maxSizePanel;

        //Looking for other values below in the for
        for (int i = maxSizePanel - 1; i > 0; i--) {
            if (i * i <= remainingArea) {
                listAreaPanels.add(i * i);
                remainingArea = remainingArea - (i * i);
                if (remainingArea == 0) break;
                if (i == 1) i++;
            }
        }

        //List to Array
        int[] finalResult = new int[listAreaPanels.size()];
        for (int i = 0; i < listAreaPanels.size(); i++) {
            finalResult[i] = listAreaPanels.get(i);
        }

        return finalResult;
    }
}

*/
package lvl1_solar_doomsday;

public class Solution {
    public static int[] solution(int area) {
        // Your code here

        int maxSizePanel = (int) Math.sqrt(area);//Max Square Panel (Bigger)
        if (maxSizePanel * maxSizePanel == area)
            return new int[]{maxSizePanel*maxSizePanel};//If fits a perfect square panel return only one

        int[] listAreaPanels = new int[100];//Max 100
        listAreaPanels[0] = maxSizePanel * maxSizePanel;
        int nextIndexArray = 1;
        int remainingArea = area - maxSizePanel * maxSizePanel;

        //Looking for other values below in the for
        if (maxSizePanel == 1) maxSizePanel++;
        for (int i = maxSizePanel - 1; i > 0; i--) {
            if (i * i <= remainingArea) {
                listAreaPanels[nextIndexArray] = i * i;
                nextIndexArray++;
                remainingArea = remainingArea - (i * i);
                if (remainingArea == 0) break;
                if (i == 1) i++;
            }
        }
        int[] finalResult = new int[nextIndexArray];

        for (int i = 0; i < nextIndexArray; i++) {
            finalResult[i] = listAreaPanels[i];
        }

        return finalResult;
    }

    public static void main(String[] args) {

        int i = 0;

        while (i <= 100) {

            int[] x = solution(i);
            System.out.println("Numero testado: -> " + i);
            for (int n : x) {
                System.out.print(n + ",");
            }
            System.out.println();
            i++;
        }

    }
}