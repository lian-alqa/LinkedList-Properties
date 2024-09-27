public class Node {

    private int number;
    private Node next;


    Node (int number){
        this(number,null);
    }

    Node (int number , Node next){
            this.number=number;
            this.next=next;

    }


    public Node getNextNode(){// will get me the next node
        return next;
    }

    public int getNumber(){
        return number;
    }

    public void setNextNode(Node next){
        this.next=next;
    }

    public void setNumber(int number){
        this.number=number;
    }

}
