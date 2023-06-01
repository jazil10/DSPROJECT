/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zinei
 */
public class GNode {

    GNode top;
    double rating;
    int year;
    String name;
    String genre;
    Object[] nodes=new Object[4];
   
    GNode next, prev;
    GNode(String n){
        name = n;
    }
    GNode(){
        
    }
    GNode(String n, String g, int y, double r){
        year=y;
        name=n;
        genre=g;
        rating=r;
        
    }

    
}
