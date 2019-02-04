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

   public boolean groupSum(int start, int[] nums, int target) {
     if(target==0){
       return true;
     }
     if(start==nums.length){
       return false;
     }
     return groupSum(start+1,nums,target-nums[start]) || groupSum(start+1,nums,target);
   }


    public static void makeAllSumsHelp(int n, int currsum, ArrayList<Integer> sums){
      if(n==0){
        sums.add(currsum);
      }
      else{
        makeAllSumsHelp(n-1, n+currsum, sums);//add the current number
        makeAllSumsHelp(n-1, currsum, sums);//dont add the current number
      }
    }




    public static ArrayList<Integer> makeAllSums(int n){
      ArrayList<Integer> nums = new ArrayList<Integer>(0);
      makeAllSumsHelp(n,0,nums);
      return nums;
  }




    public static void main(String[] args){
      System.out.println("Testing square root...");
      System.out.println("Should print around 8: " + sqrt(64,.01));
      System.out.println("Should print around 9: " + sqrt(81,.01));
      System.out.println("Should print around 26: " + sqrt(676,.01));
      System.out.println("Testing fibbonaci...");
      System.out.println("Should print 0: " + fib(0));
      System.out.println("Should print 5: " + fib(5));
      System.out.println("Should print 55: " + fib(10));
      System.out.println("Should print [1, 0]: " + makeAllSums(1));
      System.out.println("Should print [3, 2, 1, 0]: " + makeAllSums(2));
      System.out.println("Should print [15, 14, 13, 12, 12, 11, 10, 9, 11, 10, 9, 8, 8, 7, 6, 5, 10, 9, 8, 7, 7, 6, 5, 4, 6, 5, 4, 3, 3, 2, 1, 0]: " + makeAllSums(5));


    }

}
