import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
         
        int tc = sc.nextInt();
         
        for(int t=1; t<=tc; t++) {
            String str = sc.nextLine();
             
            String inputNum [] = sc.nextLine().split(" ");
             
            int sn = Integer.parseInt(inputNum[0]);
            int st = Integer.parseInt(inputNum[1]);
             
            String [] S = sc.nextLine().split(" ");
            String [] T = sc.nextLine().split(" ");
             
            int Q = sc.nextInt();
            String output = "";
             
            for(int q=0; q<Q; q++) {
                int year = sc.nextInt()-1;
                 
                if(q==Q-1) {
                    output += (S[year%sn] + T[year%st]);
                } else {
                    output += (S[year%sn] + T[year%st] + " ");
                }
            }
            System.out.printf("#%d %s%n",t,output);
             
        }
        sc.close();
    }
}