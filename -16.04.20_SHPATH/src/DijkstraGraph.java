import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by alexw on 4/20/2016.
 */
public class DijkstraGraph {

    ArrayList<PriorityQueue<Neighbor>> list;

    public DijkstraGraph(){

        list = new ArrayList<>();
    }

    public int insertNode(){

        list.add(new PriorityQueue<>(0, new PathComparator()));
        return getSize();
    }

    public void insertNeighbor(int index, Neighbor neighbor){

        list.get(index).add(neighbor);
    }

    public int getNumNeighbors(int index){

        return list.get(index).size();
    }
    public Neighbor getNextNeighbor(int index){

        return list.get(index).remove();
    }

    public PriorityQueue<Neighbor> getAllNeighbors(int index){

        return list.get(index);
    }

    public int getSize(){

        return list.size();
    }

    public int shortestPath(int index1, int index2){

        int[] dist = new int[getSize()];
        int[] prev = new int[getSize()];
        PriorityQueue<Neighbor> queue = new PriorityQueue<>(0, new PathComparator());

        for(int i=0; i<getSize(); i++){

            if(i != index1){


            }
        }

        return 5;
    }
}
