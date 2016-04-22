import java.util.Comparator;

/**
 * Created by alexw on 4/20/2016.
 */
public class PathComparator implements Comparator<Neighbor> {

    public int compare(Neighbor x, Neighbor y){

        return y.distance - x.distance;
    }
}
