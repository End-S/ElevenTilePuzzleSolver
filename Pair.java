import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Robert
 * Date: 23/02/14
 * Time: 13:30
 * To change this template use File | Settings | File Templates.
 */
public class Pair implements Comparable<Pair> {
    private double rank;
    private LinkedList<String> route;

    public double getRank(){
        return rank;
    }

    public LinkedList<String> getRoute(){
        return route;
    }

    Pair(double rank, LinkedList<String> route){
        this.rank=rank;
        this.route=route;
    }

    public int compareTo(Pair pair){
        if(rank>pair.getRank())return 1;
        else if(rank<pair.getRank()) return -1;
        else return 0;
    }

    public String toString(){
        return"("+String.format("%.2f", rank)+","+route+")";
    }
}
