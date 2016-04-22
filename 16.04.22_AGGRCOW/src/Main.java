/**
 * started April 21, 2016
 * finished April 22, 2016
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

    static ArrayList<Integer> emptyStalls;

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);

        int stalls, cows, tests = sc.nextInt();
        for(int i=0; i<tests; i++){

            emptyStalls = new ArrayList<>();
            stalls = sc.nextInt(); cows = sc.nextInt();

            for(int j=0; j<stalls; j++)
                emptyStalls.add(sc.nextInt());

            emptyStalls.sort((Integer o1, Integer o2) -> o1-o2);

            System.out.println(getMaxMin(emptyStalls, cows));
        }
    }


    /**
     *  Algorithm does a binary search for the max minimum distance between stalls
     * (1) define the bounds of the search as the first and last stall
     * (2) choose a midpoint
     * (3) evaluate the stalls greedily (i.e. choose the first stall, then add the
     * midpoint value until either (a) no more cows are left or (b) all the stalls are
     * filled and there are cows left).
     * (4) reevaluate the bounds and search again
     *
     * @param stalls
     * @param numCows
     * @return
     */
    public static int getMaxMin(ArrayList<Integer> stalls, int numCows){

        int hi, lo, min, max, target, lastVal, nextVal, answer = 0;          // min and max are stall bounds
        int[] stallAssignment = new int[numCows];                   // lo and hi are search bounds
        boolean success;

        lo = min = stalls.get(0);
        hi = max = stalls.get(stalls.size()-1);

        while(lo < hi){

            target = lo + (hi-lo)/2;        // pick the midpoint of the array

            success = false;
            stallAssignment[0] = min;

            for(int i=1; i<numCows; i++){

                lastVal = stallAssignment[i-1];

                if((lastVal + target) > max) break;    // if there can't be more stalls

                nextVal = findNextHigher(stalls, lastVal, target);
                System.out.println("nextval is " + nextVal);

                if(nextVal == -1) break;                // if can't find any stalls higher than this
                if(i == numCows-1) success = true;      // if placed all cows, search for a higher

                stallAssignment[i] = nextVal;
            }

            if(success) { answer = target; lo = target + 1; }   // look move bounds higher
            else hi = target;                                   // move bounds lower
        }

        return answer;
    }

    /**
     * Searches the list of stalls for the next one higher than the current one plus the target min distance.
     *
     * @param elements
     * @param current
     * @param increment
     * @return
     * @throws IndexOutOfBoundsException
     */
    public static int findNextHigher(ArrayList<Integer> elements, int current, int increment)
            throws IndexOutOfBoundsException{

        int lo = 0, hi = elements.size()-1, mid, target = current+increment;

        while(lo < hi){

            mid = lo + (hi-lo)/2;

            //System.out.println(lo + " " + mid + " " + hi);
            if (elements.get(mid) <= target) lo = mid+1;
            else hi = mid;
        }

        return elements.get(hi);

//        int i = elements.indexOf(current);
//
//        try{ while(elements.get(++i) < current + increment) continue;}
//        catch(IndexOutOfBoundsException e) { return -1; }
//
//        return elements.get(i);
    }
}