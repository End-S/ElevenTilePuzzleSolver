import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Robert
 * Date: 18/02/14
 * Time: 10:22
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {
        Print printer = new Print();
        Search search1 = new Search();
        Search2 search2 = new Search2();
        String start = "db_aabdcdbdd";
        String dest = "bd_dbaadcbdd";
        //LinkedList<String> route = search1.depthFirst(start,dest,100);
        //LinkedList<String> route = search1.iterativeDeepening(start,dest);
        //LinkedList<String> route = search1.iterativeDeepening("OO     @|_||","O O |  @ |_|");//TRY ME!

        //LinkedList<String> route = search2.uniformCost(start,dest);
        LinkedList<String> route = search2.aStar(start,dest);
        printer.printToFile(start,dest,route);
    }
}
