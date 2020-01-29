package functions;

/**
 * This class creates the constants and performs all the methods on
 * it.
 * implements Function
 * @author Soumya Dayal
 * username: sd9829
 */

public class Constant implements Function {

    double value;

    public Constant(double a){
        this.value = a;
    }

    /**
     * this method evaluates, or gives the final value of the function
     * after substituting the variables with the value x.
     * @param x: the value of x substituted.
     * @return the final value of the function (double: type)
     */
    @Override
    public double evaluate(double x) {
        return this.value;
    }


    /**
     * calculates and returns the derivative of the function that
     * is passed in, or calculates and returns the derivative of
     * the function with which it is called.
     * @return: the derivative (type: Function)
     */
    @Override
    public Function derivative() {
        Function result = new Constant(0);
        return result;
    }

    /**
     * calculates and returns the integral of the function with which
     * it is called using the trapezoid rule.
     * @param lowerLimit: the lower limit when finding the integral.
     * @param upperLimit: the upper limit when finding the integral.
     * @param numTrap: the number of trapezoids the function graph
     *               gets divided into.
     * @return: the integral of the function (type: double)
     */
    @Override
    public double integral(double lowerLimit, double upperLimit,
                           double numTrap) {
        return this.value*(upperLimit-lowerLimit);
    }


    /**
     * checks if the function with which it is called is constant
     * ot not
     * @return: true if constant and false if not (type: boolean)
     */
    @Override
    public boolean isConstant() {
        return true;
    }

    /**
     * Returns the string form of all the functions as required
     * so it is clear for any user to use.
     * @return the string form of the functions.
     */
    @Override
    public String toString() {
        return Double.toString(this.value);
    }
}
