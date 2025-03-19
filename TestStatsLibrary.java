import java.util.ArrayList;
public class TestStatsLibrary {
    public static void main(String[] args) {
        StatsLibrary stats = new StatsLibrary();
        DataInput data = new DataInput();
        ArrayList<Double> dataset = new ArrayList<>();
        dataset = data.dataInput();
        double mean = stats.mean(dataset);
        double variance = stats.variance(mean, dataset);
        double standardDev = stats.standardDeviation(variance);
        System.out.println("Mean: " + mean);
        System.out.println("Variance: " + variance);
        System.out.println("Standard Deviation: " + standardDev);

        System.out.println("A: .5, B: .3, ANB: .15, A and B are "+stats.indOrDep(0.5, 0.3, .15));
        System.out.println("A: .5, B: .2, ANB: .15, A and B are "+stats.indOrDep(.5, .2, .15));
        System.out.println(stats.xor(.5, .3, .15));
        System.out.println("Combinational formula: "+ stats.combination(5, 2));
        System.out.println("Permutation formula: " + stats.permutation(5, 2));
        System.out.println("Combinational Binomial Distribution: " + stats.combBinomial(5, 2, .3));
        System.out.println("Permutation Binomial Distribution: "+ stats.permBinomial(5, 2, .3));
        System.out.println("Geometric Distribution: " + stats.geoDist(.3, 5));
        System.out.println("Negative Geometric Distribution: " + stats.negGeoDist(.3, 5, 2));
    }
}
