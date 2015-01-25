import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Robert
 * Date: 19/02/14
 * Time: 11:05
 */
public class Search {
    Tiles tiles = new Tiles();
    private final HashMap<String, LinkedList<String>> tileList = new HashMap<>();

    /**
     * Depth First Search
     * @param start state
     * @param dest target state
     * @param depth depth allowed
     * @return a route
     */
    public LinkedList<String> depthFirst(String start, String dest, int depth){
        tileList.put(start, tiles.nextMove(start));

        if(depth == 0){
            return null;
        }else if(start.equals(dest)){
            LinkedList<String> route = new LinkedList<>();
            route.add(dest);
            return route;
        }else{
            LinkedList<String> nextMoves = tileList.get(start);
            for(String next : nextMoves){

                LinkedList<String> route = depthFirst(next, dest, depth - 1);

                if(route != null){
                    System.out.println("Adding : " + start +" ....depth : "+depth);
                    route.addFirst(start);
                    return route;
                }
            }
        }
        return null;
    }

    /**
     * Iterative Deepening
     * @param start state
     * @param dest state
     * @return a route
     */
    public LinkedList<String> iterativeDeepening(String start, String dest) {
        for (int depth = 1; true; depth++) // doubtful termination
        {
            tileList.clear();
            LinkedList<String> route = depthFirst(start, dest, depth);
            if (route != null) {
                return route;
            }

        }
    }
}