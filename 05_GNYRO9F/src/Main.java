/**
 * started April 21, 2016
 * from http://www.spoj.com/problems/GNYRO9F
 *
 * Write a program which takes as input integers n and k and returns the number of bit strings x of n bits (out of 2?)
 * that satisfy AdjBC(x) = k. For example, for 5 bit strings, there are 6 ways of getting AdjBC(x) = 2:
 * 11100, 01110, 00111, 10111, 11101, 11011
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