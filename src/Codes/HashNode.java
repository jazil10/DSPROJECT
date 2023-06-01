/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zinei
 */
public class HashNode {
    int hashcode;
    String str;
    BSTByName h;
    GNode node;
    
    public HashNode(GNode node)
    {
        this.node=node;        
    }
    
    public HashNode(int hashcode,String str)
    {
        this.hashcode=hashcode;
        this.str=str;
    }
}
