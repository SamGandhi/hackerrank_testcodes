import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LongestCommonSubsequence {

    // Complete the longestCommonSubsequence function below.
    static int[] longestCommonSubsequence(int[] a, int[] b) {

        int temp[][] = new int[a.length + 1][b.length + 1];
        int max = 0;
        List<Integer> lst = new ArrayList<Integer>();

        for(int i=1; i < temp.length; i++){
            for(int j=1; j < temp[i].length; j++){
                if(a[i-1] == b[j-1]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                    
                }
                else
                {
                    temp[i][j] = Math.max(temp[i][j-1],temp[i-1][j]);
                }
                if(temp[i][j] > max){
                    max = temp[i][j];
                }
            }
        }

        /*System.out.print( "    ");
        for (int i=0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
        System.out.print("  ");
        for(int i=0; i < temp.length; i++){
            for(int j=0; j < temp[i].length; j++){
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
            if (i<a.length) { System.out.print(a[i] + " "); };
        }
        */
        int i=temp.length-1, j=temp[i].length-1;
        //System.out.println("____________________________" + i + " " + j);
        
        while(i>0 && j>0){
            if(temp[i][j] == temp[i][j-1]) {
                //System.out.println( "temp[" + i + "][" + j + "]" + a[i-1] + " " + b[j-1] + " Move V");
                j--;
            }
            else if (temp[i][j] == temp[i-1][j]) {
                //System.out.println( "temp[" + i + "][" + j + "]" + a[i-1] + " " + b[j-1] + " Move H");
                i--;
            } else {
                //System.out.println( "temp[" + i + "][" + j + "]" + a[i-1] + " " + b[j-1] + " Move D");
                lst.add(a[i-1]);
                i--;
                j--;

            }
        }
        System.out.println();

        int size = lst.size();
        int[] result = new int[size];
        Integer[] temp1 = lst.toArray(new Integer[size]);
        for (int n = size-1,s=0; n >=0; n--,s++) {
            result[s] = temp1[n];
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int bItem = Integer.parseInt(bItems[i]);
            b[i] = bItem;
        }

        int[] result = longestCommonSubsequence(a, b);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
