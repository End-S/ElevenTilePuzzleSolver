import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Robert
 * Date: 26/02/14
 * Time: 14:11
 */
public class Print {
    /**
     * Formats and prints the route
     * @param route a linked list of the solution route
     */
    public void printRoute(LinkedList<String> route){
        int index = 0;
        int routeSize = route.size();
        for(int i=0;i<routeSize*4;i++){
            if(i>=0 && i<routeSize){
                System.out.print(route.get(index).substring(0, 3));
            }else if(i>=routeSize && i<routeSize*2){
                System.out.print(route.get(index).substring(3, 6));
            }else if(i>=routeSize*2 && i<routeSize*3){
                System.out.print(route.get(index).substring(6, 9));
            }else if(i>=routeSize*3 && i<routeSize*4){
                System.out.print(route.get(index).substring(9, 12));
            }
            System.out.print("  ");
            index++;
            if(index>=routeSize){
                index=0;
                System.out.println("");
            }
        }
    }

    /**
     * Formats and prints to file
     * @param start state for file name
     * @param end state for file name
     * @param route a linked list of the solution
     */
    public void printToFile(String start, String end, LinkedList<String> route){
        File file = new File(start+"2"+end+".txt");
        FileWriter writer = null;
        try {
            writer = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        PrintWriter output = new PrintWriter(writer);
        output.flush();
        int index = 0;
        int routeSize = route.size();
        for(int i=0;i<routeSize*4;i++){
            if(i>=0 && i<routeSize){
                output.print(route.get(index).substring(0, 3));
            }else if(i>=routeSize && i<routeSize*2){
                output.print(route.get(index).substring(3, 6));
            }else if(i>=routeSize*2 && i<routeSize*3){
                output.print(route.get(index).substring(6, 9));
            }else if(i>=routeSize*3 && i<routeSize*4){
                output.print(route.get(index).substring(9, 12));
            }
            output.print(" ");
            index++;
            if(index>=routeSize){
                index=0;
                output.println("");
            }
        }
        output.close();
    }
}
