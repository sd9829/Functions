package functions;

import java.util.ArrayList;

/**
 * handles the functions involving sum of two or more objects
 * of the type function.
 * implements Function
 * @author Soumya Dayal
 * username: sd9829
 */

public class Sum implements Function{

    private ArrayList<Function> sumTerms;
    private double num = 0;
    private double var = 0;

    public Sum(Function...terms){
        ArrayList<Function> copy = new ArrayList<>();
        for(Function i: terms){
            copy.add(i);
        }
        Constant constant =  new Constant(0);
        for(int j=0;j<copy.size();j++){
            Function f = copy.get(j);
            if(f.isConstant()){
                constant = new Constant(constant.evaluate(0)+f.evaluate(0)) ;
                this.num += f.evaluate(0);
                copy.remove(j);
                j--;
            }
            else{
                this.var+=1;
            }
        }
        if(constant.evaluate(0)!=0.0){
            copy.add(constant);
        }
        this.sumTerms = copy;
    }

    /**
     * this method evaluates, or gives the final value of the function
     * after substituting the variables with the value x.
     * @param x: the value of x substituted.
     * @return the final value of the function (double: type)
     */
    @Override
    public double evaluate(double x) {
        double result =0;
        for(Function f:this.sumTerms){
            result+=f.evaluate(x);
        }
        return result;
    }


    /**
     * calculates and returns the derivative of the function that
     * is passed in, or calculates and returns the derivative of
     * the function with which it is called.
     * @return: the derivative (type: Function)
     */
    @Override
    public Function derivative() {
        Function result = new Constant(this.var);
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
    public double integral(double lowerLimit, double upperLimit, double numTrap){
        double step = (upperLimit-lowerLimit)/numTrap;
        double result=0;
        for(double i=step; i <= upperLimit; i += step){
            result += (this.evaluate(i-step)+this.evaluate(i));
        }
        result *= step/2;
        return result;
//        double integral_constant = this.num*(upperLimit-lowerLimit);
//        double integral_variable = this.var*((Math.pow(upperLimit,2)-
//                Math.pow(lowerLimit,2))/2);
//        return integral_constant+integral_variable;
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
    public String toString() {
        String string = "";
        for(Function f:this.sumTerms){
            string += f + " + ";
        }
        string = string.substring(0, string.length()-2);
        return (this.isConstant())? string : "( " + string + ") ";

    }
}
