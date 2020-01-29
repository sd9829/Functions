package functions;

import java.util.ArrayList;

/**
 * handles the functions involving products of two or more objects
 * of the type function.
 * implements Function
 * @author Soumya Dayal
 * username: sd9829
 */

public class Product implements Function {

    private ArrayList<Function> productTerms;
    private double num = 1;
    private double var = 0;

    public Product(Function...terms){
        this.productTerms = new ArrayList<>();
        for(Function i: terms){
            this.productTerms.add(i);
        }
        Constant constant =  new Constant(1);
        for(int j=0;j<this.productTerms.size();j++){
            Function f = this.productTerms.get(j);
            if(f.isConstant()){
                constant.value *= f.evaluate(0);
                this.num *= f.evaluate(0);
                this.productTerms.remove(j);
                j--;
            }
            else{
                this.var+=1;
            }
        }
        this.productTerms.add(constant);
    }


    /**
     * this method evaluates, or gives the final value of the function
     * after substituting the variables with the value x.
     * @param x: the value of x substituted.
     * @return the final value of the function (double: type)
     */
    @Override
    public double evaluate(double x) {
        double result =1;
        for(Function f:this.productTerms){
            result*=f.evaluate(x);
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
        ArrayList<Function> result = new ArrayList<>();
        for(int i=0;i<this.productTerms.size();i++){
            ArrayList<Function> copyList = new ArrayList<>(this.productTerms);
            Function[] res = new Function[copyList.size()];
            Function removed = copyList.remove(i);
            copyList.add(removed.derivative());
            res = copyList.toArray(res);
            result.add(new Product(res));
        }
        Function[] finalResult = new Function[result.size()];
        finalResult = result.toArray(finalResult);
        return new Sum(finalResult);

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
    public double integral(double lowerLimit, double upperLimit, double numTrap) {
        double step = (upperLimit-lowerLimit)/numTrap;
        double result=0;
        for(double i=step; i <= upperLimit; i += step){
            result += (this.evaluate(i-step)+this.evaluate(i));
        }
        result *= step/2;
        return result;
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
        String string = "";
        for(Function f:this.productTerms){
            string += f + " * ";
        }
        string = string.substring(0, string.length()-2);
        return (this.isConstant())? string : "( " + string + ") ";
    }
}
