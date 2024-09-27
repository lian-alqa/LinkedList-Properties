public class DoubleNode {



    private DoubleNode prev;
    private DoubleNode next;
    private int value;


    DoubleNode(int value){
        this(value,null,null);
    }

    DoubleNode(int value , DoubleNode next , DoubleNode prev){
        this.value=value;
        this.next=next;
        this.prev=prev;
    }


    public void setNextDoubleNode(DoubleNode next){
        this.next=next;
    }

    public DoubleNode getNextDoubleNode(){
        return next;
    }
    public DoubleNode getPrevDoubleNode(){
        return prev;
    }

    public void setPrevDoubleNode(DoubleNode prev) {
    this.prev=prev;
    }

    public void setValue(int value){
        this.value=value;
    }

    public int getvalue(){
        return value;
    }

}
