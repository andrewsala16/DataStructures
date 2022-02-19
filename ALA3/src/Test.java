import java.util.Random;
/**
 * Class to test Rational class
 * @author Andrew Sala
 * @version 1.0
 * Date of creation: Februray 18, 2021
 * Last Date Modified: Februrary 18, 2021
 */
public class Test {
    public static void main(String[] args) {
        Number[] numbers = new Number[10];
        Random r = new Random();
        numbers[0] = r.nextInt();
        numbers[1] = r.nextInt();

        numbers[2] = r.nextLong();
        numbers[3] = r.nextLong();

        numbers[4] = r.nextFloat();
        numbers[5] = r.nextFloat();

        numbers[6] = r.nextDouble();
        numbers[7] = r.nextDouble();

        numbers[8] = new Rational(r.nextInt(10), r.nextInt(10)+1);
        numbers[9] = new Rational(r.nextInt(10), r.nextInt(10)+1);

        System.out.printf("List of numbers:\n%-30s\t%-30s\t%-30s\n","Value", "Int Value", "Double Value");
        for (Number number : numbers) {
            System.out.printf("%-30s\t%-30d\t%-30.2f\n",number, number.intValue(), number.doubleValue());
        }

        Rational[] fractions = new Rational[8];
        for (int i = 0; i < fractions.length; i++) {
            fractions[i] = new Rational(r.nextInt(10), r.nextInt(10)+1);
        }

        System.out.printf("%nOriginal list of fractions:\n");
        for (Rational fraction : fractions) {
            System.out.println(fraction);
        }

        Rational sum = fractions[0].add(fractions[1]);
        Rational diff = fractions[2].sub(fractions[3]);
        Rational prod = fractions[4].mult(fractions[5]);
        Rational quot = fractions[6].div(fractions[7]);


        System.out.printf("%nOperations on fractions:\n");
        System.out.println(fractions[0] + " + " + fractions[1] + " = " + sum.toString());
        System.out.println(fractions[2] + " - " + fractions[3] + " = " + diff.toString());
        System.out.println(fractions[4] + " * " + fractions[5] + " = " + prod.toString());
        System.out.println(fractions[6] + " / " + fractions[7] + " = " + quot.toString());

        System.out.printf("%nSorted list of fractions:\n");
        java.util.Arrays.sort(fractions);
        for (Rational fraction : fractions) {
            System.out.println(fraction);
        }
    }
}
