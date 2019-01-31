public class recursion{
    /*You may write additional private methods */

    /*Recursively find the sqrt using Newton's approximation
     *tolerance is the allowed percent error the squared answer is away from n.
     *precondition: n is non-negative

    */
    public static double sqrt(double n, double tolerance){
      public static double isCloseEnough(double guess, double num){
        return (Math.abs(guess*guess-num) < Math.abs(num * 0.0001));
      }

      public static double squareRoot(double num, double g){
        if(isCloseEnough(g,num)){
          return g;
        }
        else{
          double guess=((num/g + g)/2);
          squareRoot(num,guess);
        }
      }
    }

    /*Recursively find the n'th fibbonaci number in linear time
     *fib(0) = 1; fib(1) = 1; fib(5) = 5
     *precondition: n is non-negative
     */
    public static int fib(int n){

    }

    /*As Per classwork*/
    public static ArrayList<Integer> makeAllSums(){
    }

}
