/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zinei
 */
public class GamesList {
    BSTByName bn = new BSTByName();
    BSTByYear by = new BSTByYear();
    AL a = new AL(50);
    hashh h = new hashh(50);
    GNode found;
    GNode head;
    GNode tail;
    int size=0;


    public void insert(String name,String g, int year, double r)
    {
        GNode N = new GNode(name,g,year,r);
        if(head==null)
        {
            head = N;
            tail = N;
            size++;
           
          
            bn.Insertbyname(head);
            by.Insertbyyear(N);

            a.add(head);
            h.insert(head);
            return;
        }
        else
        {
            tail.next = N;
            tail.next.prev= tail;
        }

        size++;
        
       
        bn.Insertbyname(tail.next); 
        by.Insertbyyear(tail.next);
        a.add(tail.next);
        h.insert(tail.next);    
        tail = N;
    }
    
public String lastesttoString(){
        String str = " ";
        for(GNode i = tail; i!=null; i=i.prev){
            str = str+"Name: "+ i.name+ ", year: "+i.year + ", genre:  "+ i.genre+ ", rating:  "+ i.rating+"\n";
            
        }
        return str;
    }


    public String toString()
    {
        GNode temp = head;
        String str="";
        while(temp!=null)
        {
            str=str+"game: "+temp.name+", genre: "+temp.genre+", Year: "+temp.year+", rating "+temp.rating+"\n";
            temp=temp.next;
        }
        return str;
    }


    public GNode find(String name)
    {
        GNode temp = head;
        while(temp!=null && !temp.name.equalsIgnoreCase(name))
        {
            temp=temp.next;
        }
        return temp;
    }

    public void remove(GNode del)
    {        
        if (head == null || del == null) 
        {
            return;
        }

        if (head == del) 
        {
            head = del.next;
        }

        if (del.next != null) 
        {
            del.next.prev = del.prev;
        }

        if (del.prev != null) 
        {
            del.prev.next = del.next;
        }

        return;
        
        
    }
    public void Delete(String v)
    {
          found = find(v);
        a.remove((ALNode)find(v).nodes[1]);  //ArrayList    
      
        remove(found);  //gameslist   
        bn.Delete(v); //bstname
        int year = found.year;
        by.Delete(year); //bstyear
        h.delete(year, v);//hashing
    }
    public int length()
    {
        return size;
    }
}