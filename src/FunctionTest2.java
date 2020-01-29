import functions.*;

/**
 * The first test function enters in a function where all the terms
 * are products of each other which gte multiplied to become a new
 * complicated function. All the methods are then implemented on
 * the function and the results are recorded.
 * @author soumya dayal
 * username: sd9829
 */

public class FunctionTest2 {

    public static void main(String[] args) {
        System.out.println("Testing starts....\n");

        Variable var = Variable.X;
        //creation of the function

        Function f = new Product(new Sum(new Constant(6),var),
                new Sum(new Product(new Constant(7),new Cosine(var))),
                new Constant(40),
                new Sum(new Product(new Constant(3),new Sine
                        (new Product(var,var))),new Constant(72)),
                new Sum(new Cosine(var), new Product(var,var)),
                new Product(new Constant(79),new Cosine(new Sine(var))));

        //printing out the string form of the function
        System.out.println("The function is: "+f.toString() + "\n");

        //evaluating the function with different values
        //at 0
        System.out.println("The value of the function at x=0: "
                +f.evaluate(0.0));
        //at 10
        System.out.println("The value of the function at x=10: "
                +f.evaluate(10.0));
        //at 15
        System.out.println("The value of the function at x=15: "
                +f.evaluate(15.0)+ "\n");

        //calculating the derivative of the function
        System.out.println("The derivative of the function is:"+
                f.derivative() + "\n");

        //calculating the integral with diffrent values of
        //lowerLimit, upperLimit and the number of Trapeziums
        //lowerLimit = 0, upperLimit = 10, number of Trap = 100
        System.out.println("The integral of the function is: "+
                f.integral(0.0,10.0,100.0));
        //lowerLimit = 10, upperLimit = 100, number of Trap = 1000
        System.out.println("The integral of the function is: "+
                f.integral(10.0,100.0,1000.0));
        //lowerLimit = 3, upperLimit = 5, number of Trap = 10000
        System.out.println("The integral of the function is: "+
                f.integral(3.0,5.0,10000.0)+ "\n");

        System.out.println("End of testing. All tests passed. Thank you.");



    }
}
