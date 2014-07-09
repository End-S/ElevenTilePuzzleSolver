import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: Robert
 * Date: 23/02/14
 * Time: 11:48
 * To change this template use File | Settings | File Templates.
 */
public class Search2 {
    Tiles tiles = new Tiles();
    private final HashMap<String, LinkedList<String>> tileList = new HashMap<>();

    /**
     *
     * @param start state
     * @param dest target state
     * @return Best route
     */
    public LinkedList<String> uniformCost (String start, String dest){
        LinkedList<String> route = new LinkedList<>();
        route.add(start);
        PriorityQueue pairs = new PriorityQueue();
        pairs.add(new Pair(0.0, route));
        while(true){
            System.out.println(pairs);
            if(pairs.size()==0)return null;
            Pair pair = (Pair)pairs.poll();//retrieve and remove the first element
            route = pair.getRoute();
            String last = route.getLast();
            if (last.equals(dest))return route;

            LinkedList<String> nextMoves = tiles.nextMove(last);
            for(String next:nextMoves){
                if(!route.contains(next)){ //deja vu check
                    LinkedList<String> nextRoute = new LinkedList<>(route);
                    nextRoute.addLast(next);
                    double distance = actualMoves(nextRoute);
                    pairs.add(new Pair(distance,nextRoute));
                }
            }
        }
    }

    /**
     *
     * @param start state
     * @param dest target state
     * @return Best route
     */
     public LinkedList<String> aStar(String start, String dest){
         LinkedList<String>route=new LinkedList<>();
         route.add(start);
         PriorityQueue pairs = new PriorityQueue();
         pairs.add(new Pair(estimateMoves(start, dest),route));
         while(true){
             //System.out.println(pairs);
             if (pairs.size()==0)return null;
             Pair pair = (Pair)pairs.poll();
             route=pair.getRoute();
             String last=route.getLast();
             if(last.equals(dest))return route;
             LinkedList<String>nextMoves=tiles.nextMove(last);
             for(String next: nextMoves){
                 if(!route.contains(next)){
                     LinkedList<String> nextMove = new LinkedList<String>(route);
                     nextMove.addLast(next);
                     int distance = actualMoves(nextMove);
                     distance+=estimateMoves(next, dest);
                     pairs.add(new Pair(distance,nextMove));
                 }
             }
         }
     }

    /**
     *
     * @param nextMove the next move
     * @return the current number of moves in nextMove
     */
    private int actualMoves(LinkedList<String> nextMove){
        int distance = nextMove.size()-1;
        return distance;
    }

    /**
     * Sums the locations of each letter tile into a HashMap for both start and dest Strings
     * e.g. For the start string; letter 'a' may be in locations 3,9&11 = [a],[23]
     * For the dest string; letter 'a' may be in location 3,5&2= [a],[10]
     * @param start the start position
     * @param dest the destination
     * @return an int of the estimated distance
     */
    private double estimateMoves(String start, String dest){
        int estimate = 0;
        ArrayList<Character> tileTypes = new ArrayList<>();
        HashMap<Character, Integer> startLetters = new HashMap<>();
        HashMap<Character, Integer> destLetters = new HashMap<>();
        for(char letter:start.toCharArray()){
            startLetters.put(letter,0);
            destLetters.put(letter, 0);
            if(!tileTypes.contains(letter)){
                tileTypes.add(letter);
            }
        }
        for(int i = 0; i<start.length();i++){
            startLetters.put(start.charAt(i),startLetters.get(start.charAt(i))+i);
            destLetters.put(dest.charAt(i),destLetters.get(dest.charAt(i))+i);
        }
        //For each possible tile letter get the moves required to get from start to target
        for(char letter:tileTypes){
            estimate+=gridMoves(startLetters.get(letter), destLetters.get(letter));
        }
        return estimate;
    }

    /**
     *
     * @param start The start position of the given tile
     * @param target The target position of the given tile
     * @return How many moves it takes to get from start to target
     */
    public int gridMoves(int start, int target){
        int count=0;
        while(start!=target){
            if(start<target){
                if(Math.abs(start-target)>=3){
                    start+=3;
                    count++;
                }else if(Math.abs(start-target)<3){
                    start++;
                    count++;
                }
            }
            if(start>target){
                if(Math.abs(start-target)>=3){
                    start-=3;
                    count++;
                }else if(Math.abs(start-target)<3){
                    start--;
                    count++;
                }
            }
        }
        return count;
    }

}