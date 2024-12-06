import java.io.*;
import java.util.*;

public class Day1{
    public static void main(String args[]){

        // part 1
        ArrayList<Integer> li1 = listMaker(1);
        ArrayList<Integer> li2 = listMaker(2);

        System.out.println(distance(li1, li2));

        // part 2
        Map<Integer, Integer> map1 = mapMaker(1);
        Map<Integer, Integer> map2 = mapMaker(2);

        System.out.println(similarity(map1, map2));

        
    }
    

    public static ArrayList<Integer> listMaker(int listNumber){
        ArrayList<Integer> li = new ArrayList<>();
        try {
            try (Scanner log = new Scanner(new File("input.txt"))) {
                while (log.hasNextLine()) {
                    if (listNumber == 1) {
                        li.add(Integer.valueOf(log.nextLine().substring(0, 5)));
                    }
                    else {
                        li.add(Integer.valueOf(log.nextLine().substring(8, 13)));
                    }
                }
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }

        Collections.sort(li);
        return li;
    }

    public static int distance(ArrayList<Integer> li1, ArrayList<Integer> li2){
        int total = 0;

        for (int i = 0; i < li1.size(); i++){
            total += Math.abs(li1.get(i)-li2.get(i));
        }

        return total;
    }

    public static Map<Integer, Integer> mapMaker(int listNumber){
        Map<Integer, Integer> map = new HashMap<>();
        Integer currNum;
        try {
            try (Scanner log = new Scanner(new File("input.txt"))) {
                
                while (log.hasNextLine()) {
                    if (listNumber == 1) {
                        currNum = Integer.valueOf(log.nextLine().substring(0, 5));
                        if (map.get(currNum) == null){
                            map.put(currNum, 0);
                        }
                        map.put(currNum, map.get(currNum)+1);
                    }
                    else {
                        currNum = Integer.valueOf(log.nextLine().substring(8, 13));
                        if (map.get(currNum) == null){
                            map.put(currNum, 0);
                        }
                        map.put(currNum, map.get(currNum)+1);
                    }
                }
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }


        return map;
    }

    public static int similarity(Map<Integer, Integer> map1, Map<Integer, Integer> map2){
        int total = 0;
        int val1;
        int val2;

        for (Integer key : map1.keySet()){
            val1 = map1.get(key);
            
            if (map2.get(key) == null){
                val2 = 0;
            }
            else {
                val2 = map2.get(key);
            }
            total += key * val1 * val2;
        }

        return total;
    }
}