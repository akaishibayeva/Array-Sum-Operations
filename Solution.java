import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'performOperations' function below.
     *
     * The function is expected to return a LONG_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER N --> 3
     *  2. INTEGER_ARRAY op --> op_i (size of the array)
     */

    public static List<Long> performOperations(int N, List<Integer> op) {
        // Write your code here
        List<Long> sum = new ArrayList<>();

        ArrayList<Integer> arr = new ArrayList<>();

        for ( int i = 1; i<= N; i++) {
            arr.add(i);
        }
        for ( int i = 0; i < op.size(); i++) {
            if (arr.contains(op.get(i))) {
                Collections.swap(arr,0,N-1);
            } else {
                arr.remove(N-1);
                arr.add(op.get(i));
            }

            long sumArr = 0;
            for (int j = 0; j < arr.size(); j++) {
                sumArr+=arr.get(j);
            }
            sum.add(sumArr);

        }
        return sum;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String input = bufferedReader.readLine().trim();

        int N = Integer.parseInt(input.split(" ")[0]);

        int M = Integer.parseInt(input.split(" ")[1]);


        List<Integer> op = new ArrayList<Integer>();

        for (int i = 0; i < M; i++) {
            String inp = bufferedReader.readLine().trim();
            op.add(Integer.parseInt(inp));
        }

        List<Long> result = Result.performOperations(N, op);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(result.get(i) + "\n");
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}