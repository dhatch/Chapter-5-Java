/**
 * Assignment 5.2
 * @author David Hatch, Brian Eyring
 */
 
public class RationalTest {
    public static void main(String[] args) {
        Rational rational = new Rational(2,6);
        Rational otherRational = new Rational(1,4);
        System.out.println("2/6 compared to 1/4 "+rational.compareTo(otherRational));
        System.out.println("3/3 compared to 4/4 "+new Rational(3,3).compareTo(new Rational(4,4)));
        System.out.println("8/3 compared to 65/6 "+new Rational(8,3).compareTo(new Rational(65,6)));
    }
}