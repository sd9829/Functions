package functions;

/**
 * handles the cases without any constants of any object
 * of the type Function.
 * implements Function
 * @author Soumya Dayal
 * username: sd9829
 */
public class Variable implements Function {

    public static final Variable X = new Variable();

    /**
     * this method evaluates, or gives the final value of the function
     * after substituting the variables with the value x.
     * @param x: the value of x substituted.
     * @return the final value of the function (double: type)
     */
    @Override
    public double evaluate(double x) {
        return x;
    }


    /**
     * calculates and returns the derivative of the function that
     * is passed in, or calculates and returns the derivative of
     * the function with which it is called.
     * @return: the derivative (type: Function)
     */
    @Override
    public Function derivative() {
        Function result = new Constant(1);
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
    public double integral(double lowerLimit,
                           double upperLimit, double numTrap) {
        return (Math.pow(upperLimit,2)-Math.pow(lowerLimit,2))/2;
    }


    /**
     * checks if the function with which it is called is constant
     * ot not
     * @return: true if constant and false if not (type: boolean)
     */
    @Override
    public boolean isConstant() {
        return false;
    }

    /**
     * Returns the string form of all the functions as required
     * so it is clear for any user to use.
     * @return the string form of the functions.
     */
    @Override
    public String toString(){
        return "x";
    }
}
