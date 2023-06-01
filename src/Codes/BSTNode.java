/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zinei
 */
public class BSTNode {
    GNode node;
    BSTNode left;
    BSTNode right;
   
    
    double rating;
    int year;
    String name;
    String genre;
    
     Object[] nodes=new Object[4];
   
   
    BSTNode(String n, String g, int y , double r){
        name = n;
        genre = g;
        year = y;
        rating = r;
    }
    
    BSTNode(GNode node)
    {
        this.node=node;        
    }
}
