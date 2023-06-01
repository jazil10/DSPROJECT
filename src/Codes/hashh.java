/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zinei
 */
public class hashh {
  HashNode[] Table;
String str = " ";
 int numofCollisions = 0;
 int numofOccupiedCells = 0;
 
 hashh(int s){
     int size=s+(s/3);
 int newSize = getPrime(size);

 Table=new HashNode[newSize];
 }
 
 hashh(){
     Table = new HashNode[10];
 }
 private int getPrime(int n) {
while(true) {
 if (isPrime(n)) return n;
n++;
 }
 }
 private boolean isPrime(int n) {
for (int i = 2; i <= n/2; i++) {
 if (n % i == 0) return false;
}
return true;
}
 public int Hash(int y){
 int r = y%Table.length;
 return r;
 }
 
 public int Rehash(int y, int i){
int rh = (Hash(y)+i)%Table.length;
        return rh;
}
public int QRehash(int y, int i){
    int rh = Hash(y+(i*i))%Table.length;
    return rh;
}
public int altrehash(int y, int i){
    int rh = 0;
    if(i%2==0){
        rh = (Hash(y)+i)%Table.length;
    }
    else{
         rh = Hash(y+(i*i))%Table.length;
    }
    return rh;
}
public void insert(GNode n){ 
HashNode hnode=new HashNode(n);
 int h = Hash(hnode.node.year);
 if(Table[h]==null){
     Table[h] = hnode;
 }
 else{
     int i = 1;
     while(Table[h]!= null){
         h = altrehash(hnode.node.year,i);
         i++;
         numofCollisions++;
     }
     Table[h] = hnode;
 }
 }
 
public String searchyear(int key) {

            int h = Hash(key);
            int x=0;
            do
            {
                if(Table[h].node.year!=key)
                {
                    h= Rehash(key,x);
                }
                else
                {
                    
                    str = str + Table[h].node.name +", "+ Table[h].node.genre+ ", "+ Table[h].node.year+ ", "+ Table[h].node.rating;
                    
                    return str;
                }
                
                x++;
            }while(x<Table.length);
        return null;
    }
 
 public void delete(int key, String nm) {
 //key = year
            int h = Hash(key);
            int x=0;
            do
            {
                if(Table[h].node.year==key && Table[h].node.name==nm)
                {
                    Table[h]=null;
                    
                }
                else if (Table[h].node.year!=key && nm!=Table[h].node.name)
                {
                    h= Rehash(key,x);
                }
                
                x++;
            }while(x<Table.length);
     
    }
 
 public void print(){
     for(int i=0; i<Table.length; i++){
         if(Table[i]!=null){
         System.out.println(""+ Table[i].node.name +", "+ Table[i].node.genre+ ", "+ Table[i].node.year+ ", "+ Table[i].node.rating);
     }
     else
     {
         System.out.println("null"); 
     }
 }
 }
}
