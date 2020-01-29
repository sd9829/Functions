package functions;

/**
 * This creates the sine functions as needed and performs all
 * the methods that are required on it.
 * @author Soumya Dayal
 * username: sd9829
 */

public class Sine implements Function {

    private Function function ;

    public Sine(Function f){
        this.function = f;
    }

    /**
     * this method evaluates, or gives the final value of the function
     * after substituting the variables with the value x.
     * @param x: the value of x substituted.
     * @return the final value of the function (double: type)
     */
    @Override
    public double evaluate(double x) {
        return Math.sin(this.function.evaluate(x));
    }


    /**
     * calculates and returns the derivative of the function that
     * is passed in, or calculates and returns the derivative of
     * the function with which it is called.
     * @return: the derivative (type: Function)
     */
    @Override
    public Function derivative() {
        Function result = new Product(new Cosine(this.function),this.function.derivative());
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
        double step = (upperLimit-lowerLimit)/numTrap;
        double result=0;
        for(double i=step; i <= upperLimit; i += step){
            result += (this.evaluate(i-step)+this.evaluate(i));
        }
        result *= step/2;
        return result;
    }

    /**
     * Returns the string form of all the functions as required
     * so it is clear for any user to use.
     * @return the string form of the functions.
     */
    @Override
    public String toString() {
        return "Sine ( " + this.function + " )";
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
}
