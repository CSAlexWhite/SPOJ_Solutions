/**
 * started April 20, 2016
 * from http://www.spoj.com/problems/KAMIL
 *
 * Kamil sometimes says T instead of K, but he never says K instead of T. Similarly he sometimes says D instead of G.
 * Instead of R he sometimes says L and sometimes F.
 *
 * Write a program which
 * - reads from standard input the words spoken by Kamil
 * - counts how many different words can that mean
 * - writes the outcome on standard output
 */

import java.util.*;
import java.lang.*;

class Main
{
    public static void main (String[] args) throws java.lang.Exception {
        HashMap<Character, Integer> dictionary = new HashMap<Character, Integer>()
        {{
            put('K', 2);
            put('G', 2);
            put('D', 2);
            put('R', 4);
            put('L', 2);
            put('F', 2);
        }};

        Scanner sc = new Scanner(System.in);
        char[] nameArray = sc.next().toCharArray();
        int total = 1;
        boolean used = false;
        for(char c : nameArray) {

            char upC = Character.toUpperCase(c);

            if (dictionary.containsKey(upC))
                if ((upC == 'F' || upC == 'L') && !used)
                    System.out.println(upC + " : " + dictionary.get(upC));
            if (upC == 'F' || upC == 'L') used = true;

            //if (dictionary.containsKey(upC)) total *= dictionary.get(upC);
        }

        System.out.println(total);
    }
}