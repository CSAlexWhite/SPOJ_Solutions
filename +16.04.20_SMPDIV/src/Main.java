/**
 * started April 20, 2016
 * completed April 20, 2016
 * from http://www.spoj.com/problems/SMPDIV
 *
 * Print all integers ai such that ai is divisible by x and not divisible by y, where 1 < ai < n < 100000.
 */

import java.util.*;
import java.lang.*;

class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int n, x, y;
        for(int i=0; i<t; i++){

            n = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();

            for(int j=0; j<=n ; j+=x)
                if(j%y !=0) System.out.print(j + " ");

            System.out.println();
        }
    }
}