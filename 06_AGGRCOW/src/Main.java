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
    static ArrayList<Short> emptyStalls;

    public static void main (String[] args) throws java.lang.Exception
    {
        emptyStalls = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();

        int stalls, cows;
        for(int i=0; i<tests; i++){

            stalls = sc.nextInt();
            cows = sc.nextInt();

            for(int j=0; j<stalls; j++) {

                short next = sc.nextShort();
                emptyStalls.add(next);
            }

            emptyStalls.sort(new Comparator<Short>() {
                @Override
                public int compare(Short o1, Short o2) {
                    return o1-o2;
                }
            });

            System.out.println(emptyStalls);

            placeCow(cows, 100000, (short) -1, 0);

            System.out.println("The minimum is " + maxiMin);
        }
    }

    public static void placeCow(int cowsLeft, int minDistance, short lastStall, int lastPosition){

        if((cowsLeft == 0)){setMaxiMin(minDistance); return;}

        for(int i=0; i<emptyStalls.size() - lastPosition; i++){

            short nextStall = emptyStalls.get(i);

            //System.out.println("The last position is : " + lastPosition);
            System.out.println("The last stall is : " + lastStall);
            System.out.println("The next stall is : " + nextStall);

            if(!(lastStall == -1))
                if((nextStall - lastStall) < minDistance) minDistance = (nextStall - lastStall);

            System.out.println("The maximin distance is " + maxiMin);
            lastStall = nextStall;

            placeCow(cowsLeft-1,  minDistance, lastStall, lastPosition+1);
        }
    }

    public static void setMaxiMin(int minDistance){

        if (minDistance > maxiMin) maxiMin = minDistance;
    }
}