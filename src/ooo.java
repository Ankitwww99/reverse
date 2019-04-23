import java.util.Scanner;

class Node{
    int data;       //what the data is
    Node next;      //self referencial address

    public Node() {
        data=0;
        next=null;
    }       // default constructor
    public Node(int data,Node next) {
        this.data=data;
        this.next=next;
    }   // paramerteised constructer

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
class MyLinkedList{
    Node Start;
    public MyLinkedList(){
        Start=null;
    }
    public boolean isEmpty(){
        if(Start==null)
            return true;
        else
            return false;
    }
    //insert at the last
    public void Insert(int tval){
        Node temp;
        Node newNode= new Node();
        newNode.setData(tval);
        temp=Start;
        if(temp==null){
            Start=newNode;
        }
        else{
            while (temp.getNext()!=null){
                temp=temp.getNext();
            }
            temp.setNext(newNode);
        }
    }
    public void InsertStart(int tval){
        Node newNode=new Node();
        newNode.setData(tval);
        newNode=Start.next;
        Start=newNode;
    }
    public void printlist(){
        Node temp=Start;
        while(temp!=null){
            System.out.println(temp.getData());
            temp=temp.next;
        }
    }
    public int count(){
        int c=0;
        Node temp=Start;
        while(temp.getNext()!=null){
            c++;
            temp=temp.next;
        }
        return c;
    }
    public void Insertpos(int tval,int pos){

        if(pos==1)
            InsertStart(tval);
        else if(pos==(count()+1)){
            Insert(tval);
        }
        if(pos>count()+1){
            System.out.println("invalid pos");
        }
        else {
            Node newNode=new Node();
            newNode.setData(tval);
            Node temp = Start;
            int c=1;
            while (c != pos - 1) {
                c++;
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }
    public void delsix(){
        Node temp=Start;
        while(temp!=null){
            if(temp.next.data%6==0){
               temp.next=temp.next.next;
            }
            temp=temp.next;
        }
        if(temp.data%6==0)
            temp=temp.next;
        printlist();
    }
    //scsc
    public void deletepos(int pos){
        if(pos==1)
            deleteStart();
        else if(pos==count()){
            deletelast();
        }
        else if(pos>count()){
            System.out.println("invalid pos");
        }
        else{
            Node temp = Start;
            int c=1;
            while (c !=pos-1) {
                c++;
                temp = temp.next;
            }
            //temp.next=temp.next.next;
            Node temp1=temp;
            temp1=temp.next;
            temp.next=temp1.next;
        }

    }
    public void deletelast(){
        Node temp = Start;
        int c=0;
        while (c !=count()- 1) {
            c++;
            temp = temp.next;
        }
        /*while(temp.next.next=null){
            temp=temp.next
            }
        */
        temp.next = null;

    }
    public void deleteStart(){
        Node temp=Start;
        temp=temp.next;
        Start=temp;
    }
    public void rev(){
        Node current;
        Node previous=null;
        Node mynext;
        current=Start;
        while(current!=null){
            mynext=current.next;
            current.next=previous;
            previous=current;
            current=mynext;
        }
        Start=previous;
        printlist();
        /*while(previous!=null){
            System.out.println(previous.data);
            previous=previous.next;
        }*/
    }


}
public class ooo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyLinkedList obj=new MyLinkedList();
        obj.Insert(18);
        obj.Insert(30);
        obj.Insert(40);
        obj.Insert(50);
        obj.Insert(60);
        obj.Insertpos(100,3);
        obj.printlist();
        /*System.out.println("after insertion");
        obj.printlist();
        obj.deletepos(3);
        System.out.println("after deletion");
        obj.printlist();*/
        System.out.println("reverse");
        obj.rev();
        /*System.out.println("delete six");
                obj.delsix();*/

    }
}