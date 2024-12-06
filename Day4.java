import java.io.*;
import java.util.*;

public class Day4 {
    public static void main(String[] args) {
        // part 1
        System.out.println(countXmas(makeWordSearch()));

        // part 2
        System.out.println(countXmas2(makeWordSearch()));
    }

    public static ArrayList<ArrayList<Character>> makeWordSearch(){
        ArrayList<ArrayList<Character>> wordSearch = new ArrayList<>();
        try {
            try (Scanner log = new Scanner(new File("input.txt"))) {
                while (log.hasNextLine()) {
                    String line = log.nextLine();
                    ArrayList<Character> li = new ArrayList<>();
                    for (int i = 0; i < line.length(); i++){
                        li.add(line.charAt(i));
                    }
                    wordSearch.add(li);
                }
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        return wordSearch;
    }

    public static int countXmas(ArrayList<ArrayList<Character>> map) {
        int count = 0;

        // case 1: horizontals
        for (ArrayList<Character> r : map){
            for (int c = 0; c < r.size()-3; c++){
                if (
                    (r.get(c) == 'X' && r.get(c+1) == 'M' && r.get(c+2) == 'A' && r.get(c+3) == 'S') ||
                    (r.get(c) == 'S' && r.get(c+1) == 'A' && r.get(c+2) == 'M' && r.get(c+3) == 'X')
                        
                ){
                    count++;
                }
            }
        }
        // case 2: verticals
        for (int r = 0; r < map.size()-3; r++){
            for (int c = 0; c < map.get(0).size(); c++){
                if (
                    (map.get(r).get(c) == 'X' && map.get(r+1).get(c) == 'M' && map.get(r+2).get(c) == 'A' && map.get(r+3).get(c) == 'S') ||
                    (map.get(r).get(c) == 'S' && map.get(r+1).get(c) == 'A' && map.get(r+2).get(c) == 'M' && map.get(r+3).get(c) == 'X')
                ){
                    count++;
                }
            }
        }

        //case 3: diagonals
        for (int r = 0; r < map.size()-3; r++){
            for (int c = 0; c < map.get(0).size()-3; c++){
                if (
                    (map.get(r).get(c) == 'X' && map.get(r+1).get(c+1) == 'M' && map.get(r+2).get(c+2) == 'A' && map.get(r+3).get(c+3) == 'S') ||
                    (map.get(r).get(c) == 'S' && map.get(r+1).get(c+1) == 'A' && map.get(r+2).get(c+2) == 'M' && map.get(r+3).get(c+3) == 'X')){
                        count++;
                    }
                   if ((map.get(r).get(c+3) == 'X' && map.get(r+1).get(c+2) == 'M' && map.get(r+2).get(c+1) == 'A' && map.get(r+3).get(c) == 'S') ||
                    (map.get(r).get(c+3) == 'S' && map.get(r+1).get(c+2) == 'A' && map.get(r+2).get(c+1) == 'M' && map.get(r+3).get(c) == 'X')){
                    count++;
                    }
                }
            }
            return count;

            
        }

        public static int countXmas2(ArrayList<ArrayList<Character>> map) {
            int count = 0;
            
            for (int r = 0; r < map.size()-2; r++){
                for (int c = 0; c < map.get(0).size()-2; c++){
                    if (map.get(r+1).get(c+1) == 'A' && 
                    (map.get(r).get(c) == 'M' || map.get(r).get(c) == 'S') &&
                    (map.get(r+2).get(c+2) != map.get(r).get(c) && (map.get(r+2).get(c+2) == 'M' || map.get(r+2).get(c+2) == 'S')) &&
                    (map.get(r).get(c+2) == 'M' || map.get(r).get(c+2) == 'S') &&
                    (map.get(r+2).get(c) != map.get(r).get(c+2) && (map.get(r+2).get(c) == 'M' || map.get(r+2).get(c) == 'S'))
                    ){
                        count++;
                    }
                }
                }
    
                return count;
            
        }

}