/**
 * started April 20, 2016
 * completed April 20, 2016
 * from http://www.spoj.com/problems/DOUGHNUT
 *
 * Output t lines containing word “yes” if Harry is capable of handling the task
 * or “no” if doughnuts would cause his spine crack.
 */

import java.util.*;
import java.lang.*;

class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int c, k, w;
        for(int i=0; i<3; i++){

            c = sc.nextInt();
            k = sc.nextInt();
            w = sc.nextInt();

            if(c*w <= k) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
