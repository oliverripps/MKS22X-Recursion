import java.util.ArrayList;
public class recursion{

    public static double squareRoot(double num, double g, double t){
      if(num==0){//making sure 0 is accounted for because would throw error in % calculation
        return 0.0;
      }
      if((Math.abs((num-g*g) / num) <= t)){//checking if close enough
        return g;
      }
      else{//if not close enough, average the guess with the number/guess and rerun that guess
        double guess=(((num/g) + g)/2);
        return squareRoot(num,guess,t);
      }
    }
    public static double sqrt(double n, double tolerance){//calls helper function
      return squareRoot(n,n/2,tolerance);
      }

    public static int fib(int n){//calls helper function
      return fib(n,0,1);
    }

    public static int fib(int n,int prev, int pprev){
      if (n == 0){//first term is 0
        return 0;
      }
      if (n == 1){//return fib value accumulated
        return pprev;
      }

      return fib(n - 1, pprev, prev + pprev);//recal recursivly
   }

    public static void makeAllSumsHelp(int n, int currsum, ArrayList<Integer> sums){
      if(n==0){//once it reaches 0, just add 0
        sums.add(currsum);
      }
      else{
        makeAllSumsHelp(n-1, n+currsum, sums);//add the current number and decreases n for that branch
        makeAllSumsHelp(n-1, currsum, sums);//dont add the current number and decreases n for that branch
      }
    }

    public static ArrayList<Integer> makeAllSums(int n){
      ArrayList<Integer> nums = new ArrayList<Integer>(0);
      makeAllSumsHelp(n,0,nums);//calls helper with n as top numberto be sumed, currsum as 0, and array list as line before
      return nums;//returns stringed array list with added sums
  }


  public static boolean closeEnough(double a, double b){
    if(a==0.0 && b==0.0)return true;
    if(a==0.0)return b < 0.00000000001;
    if(b==0.0)return a < 0.00000000001;
    return Math.abs(a-b)/a < 0.0001;//This is the normal % difference allowed

}


  public static void testFib(int testcase){
    recursion r = new recursion();
    int[] input = {0,1,2,3,5,30};
    int[] output ={0,1,1,2,5,832040};
    int max = input.length;
    if(testcase < input.length){
      int in = input[testcase];
      try{

        int ans = r.fib(in);
        int correct = output[testcase];
        if(ans == correct){
          System.out.println("PASS test fib "+in+". "+correct);
        }
        else{
          System.out.println("FAIL test fib"+in+". "+ans+" vs "+correct);

        }
      }catch(IllegalArgumentException n){
        if(in < 0){
          System.out.println("PASS test fib"+in+" IllegalArgumentException");
        }else{
          System.out.println(" FAIL IllegalArgumentException in test case:"+in);
        }
      }catch(Exception e){
        System.out.println(" FAIL Some exception in test case:"+in);
      }
    }
  }


  //testcase must be a valid index of your input/output array
  public static void testSqrt(int testcase){
    recursion r = new recursion();
    double[] input = {0.0,1.0, 2.0, 4.0, 7.0};
    double[] output = {0.0,1.0,1.4142135623730951,2.0,2.6457513110645907};
    int max = input.length;
    if(testcase < input.length){
      double in = input[testcase];
      try{
        double ans = r.sqrt(in,.00001);
        double correct = Math.sqrt(in);
        if(closeEnough(ans,correct)){
          System.out.println("PASS test sqrt "+in+" "+ans);
        }
        else{
          System.out.println("FAIL test sqrt "+in+" "+ans+" vs "+correct);

        }
      }catch(IllegalArgumentException n){
        if(in < 0){
          System.out.println("PASS test sqrt"+in+" IllegalArgumentException");
        }else{
          System.out.println(" FAIL IllegalArgumentException in test case:"+in);
        }
      }catch(Exception e){
        System.out.println(" FAIL Some exception in test case:"+in);
      }
    }
  }


    public static void main(String[] args){ //testing each function
      testSqrt(3);
      //testFib(5);

}
}
