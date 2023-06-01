/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zinei
 */
public class BSTByYear {
     hashh h;
    BSTNode head;
    BSTNode root;
    BSTNode temp;
    String str=" ";


 public void Insertbyyear(GNode node) 
    {
        BSTNode N = new BSTNode(node);        
        if (root == null) 
        {
            root = N;
        } 
        else 
        {
            BSTNode N2 = root;
            BSTNode N3 = root;
            while (N2!=null) 
            {
                N3= N2;
                if (N.node.year<N2.node.year) 
                {
                    N2 = N2.left;
                } 
                else 
                {
                    N2 = N2.right;
                }
            }
            if(N3.node.year<N.node.year) 
            {
                N3.right=N;
                
            }
            else 
            {
                N3.left=N;
                             
            }
        }
        node.nodes[0]=N;
    }
     public String LNRByYear(){
         return TraverseByYear(root);
    }
    
    public String TraverseByYear( BSTNode m){
        if(m==null){
            return null;
        }
        else{
            TraverseByYear(m.left);
         
           str = str + "Name: "+ m.node.name + " Year: "+ m.node.year + " Genre: "+ m.node.genre+" Rating: "+ m.node.rating+"\n";
           
           TraverseByYear(m.right);
           return str;
        }
        
    }
    
    public BSTNode[] findD(int nm) 
    { 
        if(root ==null){
            System.out.println("Tree is empty!");
            return null;
        }
        else{
            BSTNode curr = root;
            BSTNode parent = null;
            BSTNode[] nodes = new BSTNode[2];
            while(curr!=null && curr.node.year!=nm){
                parent = curr;
                if(nm<(curr.node.year)){
                    curr = curr.left;
                }
                else{
                    curr= curr.right;
                }
            }
            nodes[0]=parent;
            nodes[1] = curr;
            return nodes;
            
        }
    }
    
    public BSTNode delete(BSTNode root,int key)
    {        
        //System.out.println("\n"+del.node.name);
        BSTNode parent = null;
        BSTNode curr = root;
        while (curr != null && curr.node.year!=key)
        {
            parent = curr;
            if (key < curr.node.year) 
            {
                curr = curr.left;
            }
            else 
            {
                curr = curr.right;
            }            
        }

        if (curr == null) 
        {
            return root;
        }
        if (curr.left == null && curr.right == null)
        {
            if (curr != root)
            {
                if (parent.left == curr) 
                {
                    parent.left = null;
                }
                else 
                {
                    parent.right = null;
                }
            }
            else 
            {
                root = null;
            }
        }

        else if (curr.left != null && curr.right != null)
        {
            BSTNode minofright= getMinimumKey(curr.right);
            int val = minofright.node.year;
            String name=minofright.node.name;
            double rating=minofright.node.rating;
            String genre=minofright.node.genre;
            delete(root, minofright.node.year);
            curr.node.year = val;
            curr.node.name=name;
            curr.node.rating=rating;
            curr.node.genre= genre;
        }
        else 
        {
            BSTNode child = (curr.left != null)? curr.left: curr.right;
            if (curr != root)
            {
                if (curr == parent.left) 
                {
                    parent.left = child;
                }
                else 
                {
                    parent.right = child;
                }
            }
            else 
            {
                root = child;
            }
        }
 
        return root;
        
    }
    public static BSTNode getMinimumKey(BSTNode curr)
    {
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
    int minValue(BSTNode root)
    {
        int minv = root.node.year;
        while (root.left != null)
        {
            minv = root.left.node.year;
            root = root.left;
        }
        return minv;
    }
    
    public void Delete(int nm){
        BSTNode[] nodes = findD(nm);
        if(nodes[1] == null){
            System.out.println("Value not found!");
        }
        else if(nodes[1].left==null && nodes[1].right==null){
            DeleteNoChild(nodes[1],nodes[0]);
        }
        
        else if(nodes[1].left==null && nodes[1].right != null || nodes[1].right==null && nodes[1].left != null){
            DeleteOneChild(nodes[1],nodes[0]);
        }
        else{
            BSTNode[] newNodes = Minimum(nodes[1]);
            nodes[1].node.name = newNodes[1].node.name;
            if(newNodes[1].left==null && newNodes[1].right==null){
            DeleteNoChild(newNodes[1],newNodes[0]);
        }
        
        else if(newNodes[1].left==null && newNodes[1].right != null || newNodes[1].right==null && newNodes[1].left != null){
            DeleteOneChild(newNodes[1],newNodes[0]);
        }
        }
        
        
        
    }
    
    public void DeleteNoChild(BSTNode t,BSTNode p){
         if(p==null){
           root = null;
       }
        else if(p.left == t){
            p.left = null;
        }
        else{
            p.right = null;
        }
    }
    
    public void DeleteOneChild(BSTNode t,BSTNode p){
        if(p==null){
            if(t.left != null){
                root = t.left;
            }
            else{
                root = t.right;
            }
        }
        else if(p.left == t){
            if(t.left != null){
                p.left = t.left;
        }
            else{
                p.left = t.right;
            }
        }
        else{
            if(t.left != null){
                p.right = t.left;
        }
            else{
                p.right = t.right;
            }
        }
    }
    
     public BSTNode[] Minimum(BSTNode t) {
         BSTNode[] nodes = new BSTNode[2];
         if(root==null){
             System.out.println("Tree is empty!");
             return null;
         }
         else{
             BSTNode curr = t.right;
            BSTNode minimum = t;
            BSTNode parentMin = t;
            while(curr!=null){
                parentMin = minimum;
                minimum = curr;
                curr = curr.left;
            }
            nodes[0] = parentMin;
            nodes[1] = minimum;
            return nodes;
         }
     }
}
