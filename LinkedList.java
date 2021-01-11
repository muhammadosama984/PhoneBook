/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonedirectory;

/**
 *
 * @author usamaasif
 */
class node<T>{
   T data;
   T name;
   node next;
   
   node(T v){
    data=v;
    //next=null;
   }
}
public class LinkedList<T> {
    node head;
    int count=0;
    public void insert(T v){
       count++;
       if(count<10){
        node n=new node(v);
       if (head==null){
       head=n;
       }
       else{
       node temp=head;
       while(temp.next!=null){
           temp=temp.next;
       }
       temp.next=n;
           
       }
       }
       else{System.out.println("resize table");
       }
    }
    public String toString(){
       String str="";
       node temp=head;
       
       while(temp!=null){
         str=str+temp.data+", ";
         temp=temp.next;
       }
       return str;
    }
}
