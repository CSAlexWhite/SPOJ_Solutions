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
        int tests = sc.nextInt();

        int test, bits, targetCount;
        for(int i=0; i<tests; i++){

            test = sc.nextInt();
            bits = sc.nextInt();
            targetCount = sc.nextInt();



            System.out.println();
        }
    }

    int count(int bitstring){

        return 0;
    }
}

/**
 Thoughts:
 1. Brute force: find generate all bitstrings of length n, select those that fit the criteria.  Can generate these
 simply by counting from (2^(n-1))-1 to (2^n)-1

 2. Better? Generate strings based on criteria. Pairs are adjacent bits.  Start with two, then add two more separated
 by a 0, or one more directly adjacent, e.g. 11011 vs. 11100.  Then move these pairs around... then fill in gaps, e.g.
 11101.  Implementation much more difficult.  Counting is easy, however, it's O(2^n)! So we're never going to figure out
 2^100...

 Which is easier? Which is faster?

 */