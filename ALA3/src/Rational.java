/**
 * Abstract class to model Rational diagram from Number class
 * @author Andrew Sala
 * @version 1.0
 * Date of creation: Februray 18, 2021
 * Last Date Modified: Februrary 18, 2021
 */
public class Rational extends Number
        implements Comparable<Rational>{
    // members
    private int numerator, denominator;

    /***
     * Default constructor
     * Initializes numerator to int 0
     * Initializes denominator to int 0
     */
    public Rational(){
        numerator = 0;
        denominator = 1;
    }

    /***
     * Constructor with two parameters
     * @param n for the numerator of a fraction
     * @param d for the denominator of a fraction
     */
    public Rational(int n, int d){
        numerator = n;
        denominator = d;
    }

    /**
     * Getter for numerator of a fraction
     * no parameters
     * @return the value of data member numerator
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Setter for numerator of a fraction
     * @param numerator to set the data member numerator
     * no return
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * Getter for denominator of a fraction
     * no parameters
     * @return the value of data member denominator
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Setter for denominator of a fraction
     * @param denominator to set the data member denominator
     * no return
     */
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    /**
     * Method to get the fraction information
     * no parameters
     * @return fraction in string form
     */
    @Override
    public String toString() {
        if (numerator == 0){
            return "0";
        }
        if (denominator == 1){
            return String.valueOf(numerator);
        }
        if (denominator < 0){
            numerator *= -1;
            denominator *= -1;
        }
        if (numerator == denominator){
            return "1";
        }
        return numerator + "/" + denominator;
    }


    /**
     * Method to add two fractions
     * @param r represents the fraction being added to another
     * @return the sum of two fractions
     */
    public Rational add(Rational r){
        int d = this.denominator * r.denominator;
        int n = this.numerator * r.denominator +
                this.denominator * r.numerator;
        Rational sum = new Rational(n, d);
        sum.reduce();
        return sum;
    }

    /**
     * Method to subtract two fractions
     * @param r represents the fraction being subtracted from another
     * @return the difference between two fractions
     */
    public Rational sub(Rational r){
        int d = this.denominator * r.denominator;
        int n = this.numerator * r.denominator -
                this.denominator * r.numerator;
        Rational diff = new Rational(n, d);
        diff.reduce();
        return diff;
    }

    /**
     * Method to multiply two fractions
     * @param r represents the fraction being multiplied by another
     * @return the product of two fractions
     */
    public Rational mult(Rational r){
        int d = this.denominator * r.denominator;
        int n = this.numerator * r.numerator;
        Rational prod = new Rational(n, d);
        prod.reduce();
        return prod;
    }

    /**
     * Method to divide two fractions
     * @param r represents the fraction being divded by another
     * @return the quotient of two fractions
     */
    public Rational div(Rational r){
        int d = this.denominator * r.numerator;
        int n = this.numerator * r.denominator;
        Rational quot = new Rational(n, d);
        quot.reduce();
        return quot;
    }


    /**
     * Method to find greatest common divisor of fraction
     * no parameters
     * @return greatest common divisor
     */
    private int gcd(){
        int g = 1;
        for (int i = 2; i < numerator || i < denominator ; i++) {
            if(numerator % i == 0 && denominator % i == 0){
                g = i;
            }
        }
        return g;
    }

    /**
     * Method to reduce fraction using greatest common divisor
     * no parameters
     */
    public void reduce(){
        int g = gcd();
        numerator /= g;
        denominator /= g;
    }

    /**
     * Abstract method from class number representing integer
     * no parameters
     * @return nearest integer equivalent to fraction
     */
    public int intValue(){ return numerator / denominator; }

    /**
     * Abstract method from class number representing long
     * no parameters
     * @return nearest long equivalent to fraction
     */
    public long longValue(){ return (long) numerator / denominator; }

    /**
     * Abstract method from class number representing float
     * no parameters
     * @return nearest float equivalent to fraction
     */
    public float floatValue(){ return (float)numerator / denominator; }

    /**
     * Abstract method from class number representing double
     * no parameters
     * @return nearest double equivalent to fraction
     */
    public double doubleValue(){ return (double)numerator / denominator; }

    /**
     * Abstract method to compare two fractions
     * @param r fraction being compared to
     * @return integer representing if fractions are equal or not
     */
    public int compareTo(Rational r){
        if(this.doubleValue() == r.doubleValue()){
            return 0;
        }
        else if(this.doubleValue() > r.doubleValue()){
            return 1;
        }
        else{
            return -1;
        }
    }


}
