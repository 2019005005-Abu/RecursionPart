import java.util.ArrayList;

class Recursion_part_3{
    public static void PrintPermutation(String str,String permutation) {
       if(str.length()==0){
        System.out.println(permutation);
        return;
       }
       for(int i=0;i<str.length();i++){
        char current_character=str.charAt(i);
       String newString=str.substring(0, i)+
        str.substring(i+1);
        PrintPermutation(newString,permutation+current_character);
       } 

    }
    //q-2:count total Path in a maze to move 
      //from (0,0) to (n,m)
     public static int countPaths(int i,int j,int n,int m){
      //base case
      if(i==n || j==m){
        return 0;
      }
      if(i==n-1 && j==m-1){
         return 1;
      }
      //mode downward
      int downPaths=countPaths(i+1, j, n, m);
      //move right;
      int rightPaths=countPaths(i, j+1, n, m);
      //totalPaths
      return downPaths+rightPaths;
     }
     // q-3 Palce Tiles of size 1xm in a floor of size nxm
     public static int PalceTitles(int n,int m){
      //basecase-1
       if(n==m){
         return 2;
       }
       //basecase-2
       if(n<m){
         return 1;
       }
      //verticall Place
      int VerticalePlacement=PalceTitles(n-m, m);
      //Horizontally
      int horizontalPlacement=PalceTitles(n-1,m);
      return VerticalePlacement+horizontalPlacement;
     }

       //q-4:Find  the number of ways in which you
        //can invite n people to your party,
        //single or in pairs
        public static int CallOfGuest(int n) {
         //base Case
         if(n<=1){
            return 1;
         }
         //single Call
          int ways_1=CallOfGuest(n-1);
         //Pair Call
         int ways_2=(n-1)*CallOfGuest(n-2);
         //total
          return ways_1+ways_2;
   }

      //Print all the subsets of a set of first n //natural numbers

       public static void  printsubset(ArrayList<Integer>subset) {
          for(int i=0;i<subset.size();i++){
            System.out.print(subset.get(i)+" ");
          }
          System.out.println();
       }
        public static void findSubset(int n,
        ArrayList<Integer>subSet){
         //basecase
          if(n==0){
            printsubset(subSet);
            return;
          }
         //add
         subSet.add(n);
         findSubset(n-1, subSet);
         //not will be add
         subSet.remove(subSet.size()-1);
         findSubset(n-1, subSet);
        }

   public static void main(String[] args) {
      // q-1:Print all permutations of String
       String str="abc";
       PrintPermutation(str, "");
      //q-2:count total Path in a maze to move 
      //from (0,0) to (n,m)
      int n=3,m=3;
      int totalPaths=countPaths(0, 0, n, m);
      System.out.println("Total-Paths"+" "+totalPaths);
      // q-3 Palce Tiles of size 1xm in a floor of size nxm
       int n1=4,m1=2;
       System.out.println("Place of Titles:"+""+PalceTitles(n1, m1));

       //q-4:Find  the number of ways in which you
        //can invite n people to your party,
        //single or in pairs
         int n2=4;
         System.out.println("There are"+" "+CallOfGuest(n2)+ "guees to call the guest");
         
         //Print all the subsets of a set of first n //natural numbers
         //time complexity-Big 0(2n)
         int n4=5;
         ArrayList<Integer>subset=new ArrayList<>();
          findSubset(n4, subset);
        

   }
}