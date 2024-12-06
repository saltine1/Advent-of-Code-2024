import java.io.*;
import java.util.*;

public class Day2 {
    public static void main(String[] args){
        // part 1
        System.out.println(numSafeReports(reportListMaker()));

        // part 2
        System.out.println(numDampenedSafeReports(reportListMaker()));
    }


    public static ArrayList<ArrayList<Integer>> reportListMaker(){
        ArrayList<ArrayList<Integer>> li = new ArrayList<>();
        String currNum = "";

        try {
            try (Scanner log = new Scanner(new File("input.txt"))) {
                while (log.hasNextLine()) {
                    ArrayList<Integer> report = new ArrayList<>();
                    String line = log.nextLine();
                    for(int i = 0; i < line.length(); i++){
                        if (line.charAt(i) != ' '){
                            currNum += line.charAt(i);
                        }
                        else {
                            report.add(Integer.valueOf(currNum));
                            currNum = "";
                        }
                    }
                    report.add(Integer.valueOf(currNum));
                    currNum = "";
                    li.add(report);
                }
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }

        return li;
    }

    public static int numSafeReports(ArrayList<ArrayList<Integer>> reports){
        int count = 0;
        for (ArrayList<Integer> report : reports){
            if (checkReport(report)){
                count++;
            }
        }
        return count;
    }

    public static boolean checkReport(ArrayList<Integer> report){

        boolean allPositive = true;

        for (int i = 0; i < report.size()-1; i++){
            if (Math.abs(report.get(i)-report.get(i+1))>3 || Math.abs(report.get(i)-report.get(i+1)) < 1){
                return false;
            }
            if (i == 0 && report.get(i)-report.get(i+1) < 0){
                allPositive = false;
            }
            if(allPositive != report.get(i)-report.get(i+1) > 0){
                return false;
            }

        }
        return true;
    } 

    public static ArrayList<ArrayList<Integer>> createOneRemovedReports(ArrayList<Integer> report){
        ArrayList<ArrayList<Integer>> li = new ArrayList<>();
        for(int i = 0; i < report.size(); i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < report.size(); j++){
                if (i!=j){
                    temp.add(report.get(j));
                }
            }
            li.add(temp);
        }
        return li;
    }
    // this is so gross man
    public static int numDampenedSafeReports(ArrayList<ArrayList<Integer>> reports){
        int count = 0;
        for (ArrayList<Integer> report : reports){
            ArrayList<ArrayList<Integer>> r = createOneRemovedReports(report);
                for(ArrayList<Integer> oneRemoved : r){
                    if (checkReport(oneRemoved)){
                        count++;
                        break;
                    }
                }
            
        }
        return count;
    }

}
