
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zinei
 */
public class AL {
    ALNode[] arr;
    int index=-1;  
    Scanner sc=new Scanner(System.in);
  
    
    public AL()
    {
        arr=new ALNode[10];        
    }
    public AL(int size)
    {
        arr=new ALNode[size];        
    }
    
    
    public void add(GNode node)
    {
        ALNode n=new ALNode(node);
        if(index==arr.length-1)
        {
            resize();                            
        }
        if(index==-1)
        {
            arr[0]=n;
            index++;
        }
        else
        {               
            arr[index+1]=n;
            index++;
                     
        } 
        node.nodes[1]=n;
    }                    
    
    public  void remove(ALNode node)
    {
        int foundindex=-1;
        for(int i=0;i<arr.length;i++)
        {
            if(node==arr[i])
            {
              foundindex=i;  
            }
        }
        ALNode arr2[]=new ALNode[arr.length-1];  
        for(int i=0;i<foundindex;i++)
        {
            arr2[i]=arr[i];
        }
        for(int i=foundindex;i<arr2.length;i++)
        {
            arr2[i]=arr[i+1];
        }
        arr=arr2;
        index--;
    }
    
 
    
    public String nameSearch(String pat)
    {     
        String[] array=new String[50];
        int j=0;
        int ch=-1;
        for(int i=0;i<=index;i++)
        {            
            if(pat.length()<=arr[i].node.name.length())
            {    
                
                if(search(pat,arr[i].node.name)==true)
                {
                   
                    String a = "["+j+"] "+arr[i].node.name+";  "+arr[i].node.year+"; "+arr[i].node.genre + "; " + arr[i].node.rating;
                   
                    j++;
                    return a;
                }
                
            }
            
        }
        return null;
       
    }
    public final static int d = 256; 
    
    public boolean search(String pat, String txt)
    {        
        int q=101;
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0;
        int t = 0;
        int h = 1;      
        for (i = 0; i < M-1; i++)
        {
            h = (h*d)%q;
        }
        for (i = 0; i < M; i++)
        {
            p = (d*p + pat.charAt(i))%q;
            t = (d*t + txt.charAt(i))%q;
        }
        for (i = 0; i <= N - M; i++)
        {
            if ( p == t )
            {
                for (j = 0; j < M; j++)
                {
                    if (txt.charAt(i+j) != pat.charAt(j))
                        break;
                }
                if (j == M)
                {
                    return true;
                }
                    
            }
            if ( i < N-M )
            {
                t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+M))%q;
                if (t < 0)
                t = (t + q);
            }
        }
        return false;
    }
    
    public String toString()
    {
        String str="";
        for(int i=0; i<=index;i++)
        str=str+ " Name: "+arr[i].node.name+", genre: "+ arr[i].node.genre+", year:"+ arr[i].node.year +", rating: "+arr[i].node.rating +"\n";
        return str;
    }           
    
    public void trim()
    {
        ALNode[] arr2=(ALNode[])new Comparable[index+1];
        for(int i=0;i<arr.length;i++)
        {
            arr2[i]=arr[i];
        }
        arr=arr2;
    }
    
    public void resize()
    {
        ALNode[] arr2=(ALNode[])new Comparable[arr.length*2];
        for(int i=0;i<arr.length;i++)
        {
            arr2[i]=arr[i];
        } 
        arr=arr2;
    }
   
    public void clear()
    {
        arr=null;
    }          
}
