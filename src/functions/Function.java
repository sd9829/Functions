package functions;

/**
 * Interface Function: creates the methods that are to be implemented
 * by all the classes that implement it.
 * @author Soumya Dayal
 * username: sd9829
 */
public interface Function {

    /**
     * this method evaluates, or gives the final value of the function
     * after substituting the variables with the value x.
     * @param x: the value of x substituted.
     * @return the final value of the function (double: type)
     */
    public double evaluate(double x);

    /**
     * Returns the string form of all the functions as required
     * so it is clear for any user to use.
     * @return the string form of the functions.
     */
    public String toString();

    /**
     * calculates and returns the derivative of the function that
     * is passed in, or calculates and returns the derivative of
     * the function with which it is called.
     * @return: the derivative (type: Function)
     */
    public Function derivative();

    /**
     * calculates and returns the integral of the function with which
     * it is called using the trapezoid rule.
     * @param lowerLimit: the lower limit when finding the integral.
     * @param upperLimit: the upper limit when finding the integral.
     * @param numTrap: the number of trapezoids the function graph
     *               gets divided into.
     * @return: the integral of the function (type: double)
     */
    public double integral(double lowerLimit, double upperLimit,
                           double numTrap);

    /**
     * checks if the function with which it is called is constant
     * ot not
     * @return: true if constant and false if not (type: boolean)
     */
    public boolean isConstant();


}
