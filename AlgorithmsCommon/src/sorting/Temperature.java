package sorting;

public class Temperature implements Comparable<Temperature> {
    private final double degrees;

    public Temperature(double degrees) {
        if (Double.isNaN(degrees))
            throw new IllegalArgumentException();
        this.degrees = degrees;
    }

    public int compareTo(Temperature that) {
        double EPSILON = 0.1;
        if (this.degrees < that.degrees - EPSILON) return -1;
        if (this.degrees > that.degrees + EPSILON) return +1;
        return 0;
    }

    public static void main(String[] args) {
        Temperature t1 = new Temperature(12);
        Temperature t2 = new Temperature(11);
        System.out.println(t1.compareTo(t2));
    }
}
