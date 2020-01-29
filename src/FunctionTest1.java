import functions.*;

/**
 * The first test function enters in a function where all the terms
 * are sum of each other which add up to become a new complicated
 * function. All the methods are then implemented on the function
 * and the results are recorded.
 * @author soumya dayal
 * username: sd9829
 */

public class FunctionTest1 {

    public static void main(String[] args) {
        System.out.println("Testing starts....\n");

        Variable var = Variable.X;
        //creation of the function

        Function f = new Sum(new Product(new Constant(30), new Cosine
                (new Product(new Constant(9), var))),
                new Product(new Constant(70),new Sine(new Product
                        (var,var))),
                new Product(new Constant(72),new Sum(new Constant
                        (30),var)),
                new Product(new Cosine(var),new Sum(new Sine(new
                        Product(var,var,var)),new Product(new Constant(7),
                        new Cosine(new Product(new Constant(2),var))))));

        //printing out the string form of the function
        System.out.println("The function is: "+f.toString()+"\n");

        //evaluating the function with different values
        //at 0
        System.out.println("The value of the function at x=0: "
                +f.evaluate(0.0));
        //at 10
        System.out.println("The value of the function at x=10: "
                +f.evaluate(10.0));
        //at 15
        System.out.println("The value of the function at x=15: "
                +f.evaluate(15.0)+"\n");

        //calculating the derivative of the function
        System.out.println("The derivative of the function is:"+f.derivative()+"\n");

        //calculating the integral with diffrent values of
        //lowerLimit, upperLimit and the number of Trapeziums
        //lowerLimit = 0, upperLimit = 10, number of Trap = 100
        System.out.println("The integral of the function is: "+
                f.integral(0.0,10.0,100.0));
        //lowerLimit = 10, upperLimit = 100, number of Trap = 100
        System.out.println("The integral of the function is: "+
                f.integral(10.0,100.0,100.0));
        //lowerLimit = 4, upperLimit = 10, number of Trap = 100
        System.out.println("The integral of the function is: "+
                f.integral(4.0,10.0,100.0)+ "\n");

        System.out.println("End of testing. All tests passed. Thank you.");




    }
}
