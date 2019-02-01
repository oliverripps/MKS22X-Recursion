public class recursion{
    /*You may write additional private methods */

    /*Recursively find the sqrt using Newton's approximation
     *tolerance is the allowed percent error the squared answer is away from n.
     *precondition: n is non-negative

    */
    public static double isCloseEnough(double guess, double num, double tolerance){
      if(num==0){
        return (guess==0);
      }
      return ((Math.abs(guess*guess-num)/num) <= tolerance);
    }

    public static double squareRoot(double num, double g, double t){
      if(isCloseEnough(g,num,t)){
        return g;
      }
      else{
        double guess=((num/g + g)/2);
        squareRoot(num,guess,t);
      }
    }
    public static double sqrt(double n, double tolerance){
      return squareRoot(n,n/2,tolerance);
      }


    /*Recursively find the n'th fibbonaci number in linear time
     *fib(0) = 1; fib(1) = 1; fib(5) = 5
     *precondition: n is non-negative
     */
    /*public static int fib(int n){

    }*/

    /*As Per classwork*/
    /*public static ArrayList<Integer> makeAllSums(){
    }*/


    public static void main(String[] args){
      System.out.println(sqrt(64,.01));



    }

}
