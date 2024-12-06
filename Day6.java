import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6 {
    public static void main(String[] args) {
        // part 1
        System.out.println(countX(tracePath(makeMap())));
    }

    public static ArrayList<ArrayList<Character>> makeMap(){
        ArrayList<ArrayList<Character>> li = new ArrayList<>();
        try {
            try (Scanner log = new Scanner(new File("input.txt"))) {
                while (log.hasNextLine()) {
                    ArrayList<Character> a = new ArrayList<>();
                    String line = log.nextLine();
                    for (int i = 0; i < line.length(); i++){
                        a.add(line.charAt(i));
                   }
                   li.add(a);
                }
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        return li;
    }

    public static ArrayList<ArrayList<Character>> tracePath(ArrayList<ArrayList<Character>> map){
        int r = 0;
        int c = 0;
        char direction = '^';

        for (int i = 0; i < map.size(); i++){
            if (map.get(i).indexOf('^') != -1){
                r = i;
                c = map.get(i).indexOf('^');
                break;
            }
        }

        while (
            (direction == '^' && r >= 0) ||
            (direction == 'v' && r < map.size()) ||
            (direction == '<' && c >= 0) ||
            (direction == '>' && c < map.get(0).size())){

                if (direction == '^'){
                    if (map.get(r).get(c) == '#'){
                        r++;
                        direction = '>';
                    }
                    else {
                        map.get(r).set(c, 'X');
                        r--;
                    }
                }
                else if (direction == 'v'){
                    if (map.get(r).get(c) == '#'){
                        r--;
                        direction = '<';

                    }
                    else {
                        map.get(r).set(c, 'X');
                        r++;

                    }
                }
                else if (direction == '>'){
                    if (map.get(r).get(c) == '#'){
                        c--;
                        direction = 'v';

                    }
                    else {
                        map.get(r).set(c, 'X');
                        c++;

                    } 
                }
                else {
                    if (map.get(r).get(c) == '#'){
                        c++;
                        direction = '^';

                    }
                    else {
                        map.get(r).set(c, 'X');
                        c--;
                    }
                }
            }

        return map;
    }

    public static int countX(ArrayList<ArrayList<Character>> map){
        int count = 0;
        for (ArrayList<Character> li : map){
            for (char c : li){
                if (c == 'X') {
                    count++;
                }
                
            }
        }
        return count;
    }
}
