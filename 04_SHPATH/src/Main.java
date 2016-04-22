/**
 * started April 20, 2016
 * completed
 * from http://www.spoj.com/problems/SHPATH
 *
 * You are given a list of cities. Each direct connection between two cities has its transportation cost
 * (an integer bigger than 0). The goal is to find the paths of minimum cost between pairs of cities. Assume that the
 * cost of each path (which is the sum of costs of all direct connections belongning to this path) is at most 200000.
 * The name of a city is a string containing characters a,...,z and is at most 10 characters long.
 */

import java.util.*;
import java.lang.*;

class Main {

    /**
     * Priority queue implements a min heap.  Comparator class will sort its members (doubles)
     * based on their second elements, the distance.
     */
    static HashMap<String, Integer> cities;
    static HashMap<Integer, ArrayList<Integer>> neighbors;
    static HashMap<String, Integer> edges;

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        int numCities = sc.nextInt();

        neighbors = new HashMap<>();
        for(int i=1; i<=numCities; i++) neighbors.put(i, new ArrayList<>());

        cities = new HashMap<>();
        edges = new HashMap<>();

        String cityName;
        int numOutEdges, end, length;
        for(int i=0; i<tests; i++){
           for(int j=1; j<=numCities; j++){

               cityName = sc.next();
               cities.put(cityName, j);         // can retrieve a city's number by its name

               numOutEdges = sc.nextInt();
               for(int k=0; k<numOutEdges; k++){

                   end = sc.nextInt();
                   length = sc.nextInt();
                   String edge = Integer.toString(j) + "-" +  Integer.toString(end);

                   neighbors.get(j).add(end);   // with a city's number, can get its neighbors
                   edges.put(edge, length);     // with a pair of cities, can get the edge length
               }
           }

            for(Integer neighbor: neighbors.keySet()){

                System.out.print(neighbor + " : ");
                System.out.println(neighbors.get(neighbor));
            }

            for(String city: cities.keySet()){

                System.out.print(city + " : ");
                System.out.println(cities.get(city));
            }

            for(String edge: edges.keySet()){

                System.out.print(edge + " : ");
                System.out.println(edges.get(edge));
            }

            String test = "0-2";
            System.out.println("Found " + edges.get(test));

           int first, last, total = sc.nextInt();
           for(int j=0; j<total; j++){

               String firstCity = sc.next(), lastCity = sc.next();
               first = cities.get(firstCity);
               last = cities.get(lastCity);

               System.out.println("The shortest path between " + firstCity + " and "
                       + lastCity + " is " + distance(first, last, numCities));
           }
        }
    }

    public static int distance(int start, int end, int size){

        Integer[] dist = new Integer[size];
        Arrays.fill(dist, 20000);
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(start);
        dist[start-1] = 0;

        int distance;
        while(!queue.isEmpty()){

            int current = queue.poll();

            System.out.println("current is " + current);

            for(Integer neighbor : neighbors.get(current)){

                String edge = Integer.toString(current) + "-" + Integer.toString(neighbor);

                System.out.println("Finding edge " + edge);
                distance = dist[current-1] + edges.get(edge);

                if(distance < dist[neighbor-1])

                    dist[neighbor-1] = distance;

                System.out.println("Distances");
                for(int i=0; i<size; i++) System.out.print(dist[i] + " ");
            }
        }

        return dist[end-1];
    }
}