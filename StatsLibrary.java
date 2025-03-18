import java.util.ArrayList;
import java.util.Scanner;
public class StatsLibrary {
    DataInput dataInput = new DataInput();



    public double mean(ArrayList<Integer> data){
        double mean;
        int sum = 0;
        int n = data.size(); 
        for (double numbers : data){
            sum += numbers;
        }
        mean = sum/n;
        return mean;  
    }

    public double variance(double mean, ArrayList<Integer> data){
        //This subtracts the mean
        ArrayList<Double> deviation = new ArrayList<>();
        ArrayList<Double> sqrdeviation = new ArrayList<>();
        for(double numbers : data){
            numbers = numbers - mean;
            deviation.add(numbers); 
        }
        //This Squares the subtracted values and adds them to the new array list
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
        //This finds the variance of your dataset
        int x = sqrdeviation.size() - 1;
        double variance = sqrsum/x;
        return variance;
    }
    //This finds the standard deviation
    public double standardDeviation(double variance){
        double stnddev = Math.sqrt(variance);
        return stnddev;
    }
    //Probability Axioms-------------------------------------------------------------------------------------------------

    //Independent and Dependent Intersections
    public String indOrDep(double A, double B, double ANB){
        //ANB = A * B
        double AB = A * B;
        if(ANB == AB){
            return "Independent";
        }else{
            return "Dependent";
        }
    }
    //Method to determine Independence
    public boolean checkInd(double A, double B, double ANB){
        double AB = A*B;
        if(ANB == AB){
            return true;
        } else{
            return false;
        }
    }
    //Method to determine Dependence
    public boolean checkDep(double A, double B, double ANB){
        double AB = A*B;
        if(ANB != AB){
            return true;
        }else{
            return false;
        }
    }
    //Exclusive or NonExclusive Union
    public double xor(double A, double B, double ANB){
        Scanner input = new Scanner(System.in);
        System.out.println("1.Exclusive or 2. Not exclusive?");
        int answer = input.nextInt();
        double or = 0;
        switch (answer){
            case 1:
                //XOR: A + B - 2 * ANB
                or = A + B -2 * ANB;
                break;
            case 2:
                //OR: A + B - ANB
                or = A + B - ANB;
                break;
            default:
                System.out.println("Invalid Choice");
        }
        return or;
    }
    //Combinational and Permutational methods--------------------------------------------------------------------------------------
    
    //factorial method
    public float factorial(int n){
        if(n == 0){
            return 1;
        } 
        float fact = n * factorial(n-1);
        return fact;
    }
    //Combination Formula
    public float combination(int n, int r){
        //numerator
        float num = factorial(n);
        //denominator
        float rr = factorial(r);
        float nn = factorial(n-r);
        float denom = rr * nn;
        float combination = num/denom;
        return combination;
    }
    //Permutation Formula
    public float permutation(int n, int r){
        float num = factorial(n);
        float denom = factorial(n-r);
        float permutation = num/denom;
        return permutation;
    }
    //Binomial Distribution Formulas-----------------------------------------------------------------------------------------

    //Combinational Binomial distribution
    public float combBinomial(int n, int r, double p){
        float comb = combination(n, r);
        double q = 1-p;
        p = Math.pow(p, r);
        q = Math.pow(q, n-r);
        double qp = p*q;
        float binomial = (float) (comb * qp);
        return binomial;

    }
    //Permutation Binomial distribution
    public float permBinomial(int n, int r, double p){
        float comb = permutation(n, r);
        double q = 1-p;
        p = Math.pow(p, r);
        q = Math.pow(q, n-r);
        double qp = p*q;
        float binomial = (float) (comb * qp);
        return binomial;

    }
    //Geometric Distributions
    public float geoDist(double p, int n){
        //P(Y=y)=(1-p)^(n-1)*p
        float geometric = (float) (Math.pow(1-p, n-1)*p);
        return geometric;
    }
    // Negative Geometric Distribution
    public float negGeoDist(double p, int n, int r){
        //P(Y=y) = (n-1, r-1)p^r(1-p)^(n-r)
        float comb = combination(n-1, r-1);
        float prob = (float) (Math.pow(p, r)*Math.pow(1-p, n-r));
        float negativeGeo = comb * prob;
        return negativeGeo;
    }
}   

