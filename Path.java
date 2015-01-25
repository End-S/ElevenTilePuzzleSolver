import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Robert
 * Date: 23/02/14
 * Time: 13:30
 * Keeps track of each explored path
 */
public class Path implements Comparable<Path> {
    private double rank;
    private LinkedList<String> route;

    /**
     * The current rank of this particular path
     * @return current rank
     */
    public double getRank(){
        return rank;
    }

    /**
     * Route of this path
     * @return route
     */
    public LinkedList<String> getRoute(){
        return route;
    }

    /**
     *
     * @param rank, starting rank
     * @param route, starting route
     */
    Path(double rank, LinkedList<String> route){
        this.rank=rank;
        this.route=route;
    }

    /**
     * Compares two paths, choosing the one with the best rank
     * Called by the Priority Queue object
     * @param path, a path
     * @return a number corresponding to how the paths compare
     */
    public int compareTo(Path path){
        if(rank> path.getRank())return 1;
        else if(rank< path.getRank()) return -1;
        else return 0;
    }

    public String toString(){
        return"("+String.format("%.2f", rank)+","+route+")";
    }
}
