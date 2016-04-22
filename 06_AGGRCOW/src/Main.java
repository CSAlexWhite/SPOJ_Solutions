/**
 * started April 21, 2016
 * from http://www.spoj.com/problems/GNYRO9F
 *
 * Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The stalls are located along a
 * straight line at positions x1,...,xN (0 <= xi <= 1,000,000,000).  His C (2 <= C <= N) cows don't like this
 * barn layout and become aggressive towards each other once put into a stall. To prevent the cows from
 * hurting each other, FJ want to assign the cows to the stalls, such that the minimum distance between any
 * two of them is as large as possible. What is the largest minimum distance?
 */

import java.util.*;
import java.lang.*;

class Main {

    static int maxiMin;
    static ArrayList<Integer> emptyStalls;

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();

        int stalls, cows;
        for(int i=0; i<tests; i++){

            emptyStalls = new ArrayList<>();
            stalls = sc.nextInt();
            cows = sc.nextInt();

            for(int j=0; j<stalls; j++) {

                int next = sc.nextInt();
                emptyStalls.add(next);
            }

//            System.out.println("Test " + i);
//            System.out.println(stalls + " stalls, " + cows + " cows");
//            System.out.print("Stalls at: ");
//            for(Integer elt : emptyStalls) System.out.print(elt + " ");

            emptyStalls.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });

            //for(Integer elt : emptyStalls) System.out.print(elt + " ");

            //System.out.println("\n" + "Max Min is " + getMaxMin(emptyStalls, cows) + "\n");
            System.out.println(getMaxMin(emptyStalls, cows));
        }
    }

    public static int getMaxMin(ArrayList<Integer> stalls, int numCows){

        int min, max, answer = 0;

        int lo = min = stalls.get(0);
        int hi = max = stalls.get(stalls.size()-1);
        int[] stallAssignment = new int[numCows];

        /**
         * Algorithm does a binary search for the max minimum.
         * (1) define the bounds of the search as the first and last stall
         * (2) choose a midpoint
         * (3) evaluate the stalls greedily (i.e. choose the first stall, then add the
         * midpoint value until either (a) no more cows are left or (b) all the stalls are
         * filled and there are cows left).
         * (4) reevaluate the bounds and search again
         */
        while(lo < hi){

            int target = lo + (hi-lo)/2;

            boolean success = false;
            Arrays.fill(stallAssignment, 0);
            stallAssignment[0] = min;

            for(int i=1; i<numCows; i++){

                if((stallAssignment[i-1] + target) > max){

//                    System.out.println("IMPOSSIBLE: Next should be above " + (stallAssignment[i-1] + target) + " and below " + max);
                    break;
                }

                int valueToAssign = findNextHigher(stalls, stallAssignment[i-1], target); // next one higher...

                if(valueToAssign == -1) break;
                stallAssignment[i] = valueToAssign;
                if(i == numCows-1) success = true;      // if placed all cows, search left

//                System.out.print("Target distance is " + target + " : ");
//                for(Integer elt : stallAssignment) System.out.print(elt + " ");
//                System.out.println();
            }

            if(success) {

                answer = target;
                lo = target + 1;
            }
            else hi = target;
        }

        return answer;
    }

    public static int findNextHigher(ArrayList<Integer> elements, int current, int increment) throws IndexOutOfBoundsException{

        int i = elements.indexOf(current);

        try{ while(elements.get(++i) < current + increment) continue;}
        catch(IndexOutOfBoundsException e){return -1;}

        return elements.get(i);
    }
}