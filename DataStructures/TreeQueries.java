package Practice.Tree;

/**
 * Created by gsrinivasagam on 11/22/2018.
 */
import java.io.*;
import java.util.*;
public class TreeQueries {
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader
                (new InputStreamReader(System.in));
        //System.out.println("enter n and q");
        PrintWriter pw=new PrintWriter(System.out);
        String f=br.readLine();
        String [] v=f.split(" ");
        int n=Integer.parseInt(v[0]);
        int q=Integer.parseInt(v[1]);
        long arr[]=new long[n];
        String fw=br.readLine();
        String sd[]=fw.split(" ");
        for(int i=0;i<n;i++)
            arr[i]=Long.parseLong(sd[i]);
        int numlevel=(int)(Math.log(n)/Math.log(2))+1;
        //System.out.println(numlevel);
        long suml[]=new long[numlevel];
        suml[0]=arr[0];
        // System.out.println(suml[0]);
        for(int i=1;i<numlevel;i++)
        {
            for(int j=(1<<i)-1;j<((1<<(i+1))-1)&&j<n;j++)
                suml[i]+=arr[j];
            //System.out.println(suml[i]);

        }
        while(q-->0)
        {   String dd=br.readLine();
            String ask[]=dd.split(" ");
            int check=Integer.parseInt(ask[0]);
            //System.out.println("check+"+check);
            int a=Integer.parseInt(ask[1]);
            int b=Integer.parseInt(ask[2]);
            if(check==1)
            {
                a=a-1;
                b=b-1;
                int start=(1<<b)-1;
                pw.println(arr[start+a]);
            }
            if(check==2)
            { long sum=0;
                for(int g=a-1;g<b;g++)
                    sum+=suml[g];
                pw.println(sum);}
            else  if(check==3){
                long val=Integer.parseInt(ask[3]);
                int start=1<<(b-1);
                suml[b-1]= suml[b-1]-arr[start-1+a-1]+val;
                //System.out.println(suml[b-1]);
                arr[start-1+a-1]=val;
            }
        }
        pw.close();
    }
}