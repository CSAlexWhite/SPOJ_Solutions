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

        int test = 3;
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