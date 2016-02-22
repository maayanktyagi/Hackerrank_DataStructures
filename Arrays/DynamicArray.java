import java.io.*;
import java.util.*;

public class DynamicArray {

    public static void main(String[] args) {
       /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int q=input.nextInt();
        input.nextLine();
         
        int lastans=0;
        ArrayList<ArrayList<Integer>> dynamic_array=new ArrayList<ArrayList<Integer>>(n);
        /*creating n empty dynamic arrays*/
        for(int j=0;j<n;j++){
            ArrayList<Integer>nth_array=new ArrayList<Integer>();
            dynamic_array.add(j, nth_array);}
        for(int i=0;i<q;i++){
              String str=input.nextLine(); /*input each query as string.*/  
            int[] array= Arrays.stream(str.split(" ")).map(String::trim).mapToInt(Integer::parseInt).toArray();/*Converting string to array,*/
            int tf=array[0];    /*here tf is either 1 or 2*/
            int x=array[1];      
            int y=array[2];
            
            switch(tf){
             case 1:
                int a=(x^lastans)%n;
                dynamic_array.get(a).add(y);/*inserting y in 'a'th sequence of dynamic_array*/
                break;
             case 2:
                int b=((x^lastans)%n); /* in java "^" is xor operator . */
                int size=dynamic_array.get(b).size();    /*get the size of 'b'th sequence */
                int ans=dynamic_array.get(b).get(y%size);  
                System.out.println(ans);
                lastans=ans;
                break;
          }  
        }
     }
   }
