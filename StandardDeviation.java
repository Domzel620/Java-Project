import java.util.ArrayList;
import java.util.Scanner;
public class StandardDeviation {
    ArrayList<Integer> dataset = new ArrayList<>();
    ArrayList<Double> deviation = new ArrayList<>();
    ArrayList<Double> sqrdeviation = new ArrayList<>();
    

    public void mean(){
        
        variance(mean);
    }

    public void variance(double mean){
        //This subtracts the mean
        for(double numbers : dataset){
            numbers = numbers - mean;
            deviation.add(numbers); 
        }
        //This Prints the new values
        System.out.println("\n" + "\n" + "This id your dataset after subtracting the mean: ");
        for(double num : deviation){
            System.out.print(num + ", ");
        }
        //This Squares the subtracted values and adds them to the new array list
        System.out.println("");
        System.out.println("\n" + "\n" + "These are your values after squaring them: ");
        for(double num : deviation){
            num = Math.pow(num, 2);
            sqrdeviation.add(num);
            System.out.print(num + ", ");
        }
        //This adds the squared values together
        double sqrsum = 0;
        for(double num : sqrdeviation){
            sqrsum += num;
        }
        
        System.out.println("\n" + "\n" + "This is the sum of your squared values: " + sqrsum);
        //This finds the variance of your dataset
        int x = sqrdeviation.size() - 1;
        double variance = sqrsum/x;
        System.out.println("The Variance of your dataset is: " + variance);

        double stnddev = Math.sqrt(variance);
        System.out.println("The Standard Deviation of your dataset is: " + stnddev);
    }
    public static void main(String[] args) {
        StandardDeviation obj = new StandardDeviation();
        obj.dataInput();
        obj.mean();
    }
}

