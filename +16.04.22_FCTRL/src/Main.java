/**
 * started April 22, 2016
 *
 * from http://www.spoj.com/problems/FCTRL
 *
 * For any positive integer N, Z(N) is the number of zeros at the end of the decimal form of number N!.
 * For every number N, output a single line containing the single non-negative integer Z(N).
 */

import java.util.*;
import java.lang.*;

class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt(), n;

        for(int i=0; i<tests; i++){

            n = sc.nextInt();
            System.out.println(Z(n));
        }
    }

    private static int Z(int n) {

        int i = 1, total = 0, numFactors;

        do{
            numFactors = (int)(n / Math.pow(5, i++));
            total += numFactors;

        } while(numFactors > 0);

        return total;
    }
}