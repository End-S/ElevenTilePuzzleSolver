import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Robert
 * Date: 18/02/14
 * Time: 18:22
 */
public class Tiles {
    String tiles;


    public Tiles(){
    }


    /**
     * This finds the next possible moves based on a set of tiles
     * @param tiles the string of tiles
     * @return all the possibles moves that can be made with the string of tiles
     */
    public LinkedList nextMove(String tiles){
        LinkedList<String> possibleMoves = new LinkedList<>();
        this.tiles=tiles;
        int space = tiles.indexOf("_");
        if(space>2){
            possibleMoves.add(swap(space-3,space,tiles));
        }
        if (space%3!=0){
            possibleMoves.add(swap(space-1,space,tiles));
        }
        if (space%3!=2){
            possibleMoves.add(swap(space+1,space,tiles));
        }
        if (space<9){
            possibleMoves.add(swap(space+3,space,tiles));
        }
        tiles = swap(4,space,tiles);//del
        return possibleMoves;
    }

    /**
     * Swaps two elements in an array
     * @param el1 first element
     * @param el2 second element
     * @param tiles the string of tiles
     * @return a new string containing the swapped tiles
     */
    public String swap(int el1, int el2, String tiles){
        char[]letters=tiles.toCharArray();
        char temp = letters[el1];
        letters[el1]= letters[el2];
        letters[el2] = temp;
        return new String(letters);
    }

}
