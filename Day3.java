import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Day3 {
    public static void main(String[] args) {
        // part 1
        System.out.println(multiply(findPairs()));
        
        // part 2
        removeDisabledPairs(findPairs());
    }

    public static ArrayList<String> findPairs(){
        String regex = "mul\\(([0-9]+),([0-9]+)\\)";
        Pattern pattern = Pattern.compile(regex);
        ArrayList<String> li = new ArrayList<>();
        
        try {
            try (Scanner log = new Scanner(new File("input.txt"))) {
                while (log.hasNextLine()) {
                    String line = log.nextLine();
                    Matcher str = pattern.matcher(line);
                    while(str.find()){
                        li.add(str.group().substring(3)+str.start());
                    }
                    }
                }
            }
        
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        return li;
    }

    public static int multiply(ArrayList<String> li){
        int count = 0;
        for (String pair : li){
            count += Integer.valueOf(pair.substring(1, pair.indexOf(","))) * Integer.valueOf(pair.substring(pair.indexOf(",") + 1, pair.indexOf(")")));
        }

        return count;
    }

    public static void removeDisabledPairs(ArrayList<String> li){
        ArrayList<Integer> doList = new ArrayList<>();
        doList.add(0);
        ArrayList<Integer> dontList = new ArrayList<>();
        boolean isOn = true;

        try {
            try (Scanner log = new Scanner(new File("input.txt"))) {
                while (log.hasNextLine()) {
                    String line = log.nextLine();
                    for (int i = 0; i < line.length()-6; i++){
                        if (line.substring(i, i+7).equals("don't()")){
                            dontList.add(i);
                        }
                    }
                    for (int i = 0; i < line.length() - 3; i++){
                        if (line.substring(i, i+4).equals("do()")){
                            doList.add(i);
                        }
                    }
                }
            }
        }
        
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }

        System.out.println(doList);
        System.out.println(dontList);

    }
}






