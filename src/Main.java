import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static ArrayList<String> arrList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean done = false;
        String menu = "";


        do{
            print();
            System.out.println("A - Add an item to the list");
            System.out.println("D - Delete an item from the list");
            System.out.println("I - Insert an item into the list");
            System.out.println("P - Print the list");
            System.out.println("Q - Quit the program");
            menu = SafeInput.getRegExString(in,"enter menu choice", "[AaDdIiPpQq]");
            if (menu.equalsIgnoreCase("A")){
                add(in);
            }
            else if (menu.equalsIgnoreCase("D")){
                delete(in);
            }
            else if (menu.equalsIgnoreCase("I")){
                insert(in);
            }
            else if (menu.equalsIgnoreCase("P")){
                print();
            }
            else if (menu.equalsIgnoreCase("Q")){
                done = quit(in);
            }

        }while(!done);
    }
    private static void add(Scanner in){
        String list = SafeInput.getNonZeroLenString(in, "Enter new list item");
        arrList.add(list);
    }
    private static void delete(Scanner in){
        int list = SafeInput.getRangedInt(in, "Enter list entry to delete", 1, arrList.size());
        arrList.remove(list - 1);
    }
    private static void insert(Scanner in){
        int list = SafeInput.getRangedInt(in, "Enter list number to insert", 1, arrList.size());
        String item = SafeInput.getNonZeroLenString(in, "Enter String to insert");
        arrList.add(list - 1, item);
    }
    private static void print(){
        String item = "";
        for (int i = 0; i < arrList.size(); i++ ) {

            item = arrList.get(i);
            System.out.println((i + 1) + ": " + item);
        }

    }
    private static boolean quit(Scanner in){
        boolean retVal = false;
        retVal = SafeInput.getYNConfirm(in,"Are you sure you want to exit");
        return retVal;
    }


}