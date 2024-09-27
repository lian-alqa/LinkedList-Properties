public class LinkedList {


    private Node head;
    private DoubleNode doubleNodeHead;

    LinkedList(Node head) {
        this.head = head;
    }

    LinkedList(DoubleNode doubleNodeHead) {
        this.doubleNodeHead = doubleNodeHead;
    }//this will initalize the head of a double node


    LinkedList() {// this will give the values null
        doubleNodeHead = null;
        head = null;
    }

    public DoubleNode getDoubleNodeHead() {
        return doubleNodeHead;
    }

    public void setDoubleNodeHead(DoubleNode doubleNodeHead) {
        this.doubleNodeHead = doubleNodeHead;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getHead() {
        return head;
    }

    public boolean isEmpty() {// this method will check whether we have nodes or the linked list doesn't exist
        return head == null;
    }


    public void deleteNodes(int n, int m) {
        Node pointer = head, temp = head;
        int counter1 = 1, counter2 = 1;


        if (n <= 0 || m < 0) {
            System.out.println("Invalid values for n or m.");
            return;
        }

        if (m == 0) {
            head = null; // because we didn't skip any values so we will remove all of them
            return;
        }


        if (!isEmpty()) {

            while (pointer.getNextNode() != null) {

                if (counter1 % m == 0) {// anything divisible by m means we skipped the needed nodes

                    temp = pointer;// renew the pointer everytime so that we can start counting the nodes that we'll skip from the new pointer
                    while (counter2 <= n & temp.getNextNode() != null) {
                        temp = temp.getNextNode();
                        counter2++;
                    }// will move to the last of the n nodes that want to be deleted


                    pointer.setNextNode(temp.getNextNode());// will change the reference to remove the rest of the nodes

                    counter2 = 1;// to reinitatlize it back to it's original value which is one

                }
                counter1++;// to keep count of the nodes we went through in the arryalist

                if (pointer.getNextNode() != null)// we will check that this next value won't be null
                    pointer = pointer.getNextNode();

            }
        } else
            System.out.println("==============================================\nThere is no linked list to implement this operation on\n==============================================");

    }


    public void swapNodes(int k) {

        Node pointer = head, beforeLast = null, beforeFirst = null, lastNode = null, firstNode = null, afterFirst = null, afterLast = null;
        int size = findSize();


        //beforeLast, after last and last is basically the kth node from the end
        // first node is the kth node from the beginning

        if (k <= 0 || k > size) {// k ==0 meaning they don't want to swap a kth value with this as fot less than which means they had entered a negative value
            System.out.println("The value input is invalid choose a value that is valid ");
            // and k> size means the value u have inputted is larger than the size so i can't swap
            return;
        }

        if (size == 1)
            return;// we won't be implementing any swapping in this case cuz we only have one node

        if (!isEmpty()) {

            for (int i = 1; i <= size; i++) {// this loop's job is to find the nodes we want to swap

                if (i == (k - 1)) {// to find the kth first value u want to swap
                    beforeFirst = pointer;
                }

                if (i == k) {// to find the first node and the one after it
                    firstNode = pointer;
                    afterFirst = pointer.getNextNode();
                }

                if (i == (size - k + 1)) {
                    lastNode = pointer;
                    afterLast = lastNode.getNextNode();
                }

                if (i == (size - k)) {// the one before the last
                    beforeLast = pointer;// however if it doesn't execute this statement this means the last node is the first and before is null
                }
                pointer = pointer.getNextNode();

            }


            // first case

            if (k - size == 0) {// this means if i wanted to swap the first with the last when the size is the same as the k

                if (k == 2) {// if it was two then we will implement this way
                    head = firstNode;
                    firstNode.setNextNode(lastNode);
                    lastNode.setNextNode(null);
                    return;

                } else {// if it was more than two nodes we will implement this way
                    head = firstNode;
                    firstNode.setNextNode(afterLast);
                    beforeFirst.setNextNode(lastNode);
                    lastNode.setNextNode(null);
                }
            }


            //case 1

            else if (k == 1) {// meaning i want to swap the first node with the last node (similar to case one however it's when i want k=1 instead of k=size)

                if (size == 2) {// if the size 2 this is the case for it
                    head = lastNode;
                    lastNode.setNextNode(firstNode);
                    firstNode.setNextNode(null);
                } else {// meaning any other size except for two

                    head = lastNode;
                    lastNode.setNextNode(afterFirst);
                    beforeLast.setNextNode(firstNode);
                    firstNode.setNextNode(null);
                }

            }


            // case 2

            else if (k == size - k + 1) {// that means the first node and the last node are the same which means we have targeted the middle value so we won't swap nothing
                return;
            }


            // case 3

            else if (afterFirst == lastNode) {// this means the two nodes which is the first and the last node are beside each other

                beforeFirst.setNextNode(lastNode);
                lastNode.setNextNode(firstNode);
                firstNode.setNextNode(afterLast);
            }


            // case 3

            else if (afterLast == firstNode) {// similar to the previous statment however it's the opposite when the end is before the first
                beforeLast.setNextNode(firstNode);
                firstNode.setNextNode(lastNode);
                lastNode.setNextNode(afterFirst);
            }


            // normal swapping 5th case

            else {
                beforeFirst.setNextNode(lastNode);
                lastNode.setNextNode(afterFirst);
                beforeLast.setNextNode(firstNode);
                firstNode.setNextNode(afterLast);

            }

        } else
            System.out.println("==============================================\nThere is no linked list to implement this operation on\n==============================================");


    }


    public void sortedIntersect(LinkedList linkedList1, LinkedList linkedList2) {// case what is the value repeated more than once


        if (linkedList1.isEmpty() & linkedList2.isEmpty()) {
            System.out.println("both of your linked lists are empty...");
            return;
        }
        Node pointer1 = linkedList1.getHead();
        Node pointer2 = linkedList2.getHead();

        //this means there is a linked list that exists
        while (pointer1 != null & pointer2 != null) {


            if (pointer1.getNumber() == pointer2.getNumber()) {
                createNodes(new Node(pointer1.getNumber()));
                pointer2 = pointer2.getNextNode();
                pointer1 = pointer1.getNextNode();

            } else if (pointer2.getNumber() > pointer1.getNumber())
                pointer1 = pointer1.getNextNode();// to see if the nest value is smaller or ewual to pointer 1


            else if (pointer1.getNumber() > pointer2.getNumber())
                pointer2 = pointer2.getNextNode();

        }

    }

    public void createNodes(Node node) {// this method will create a nodes and reference them to each other
        Node pointer = head;// the temp will have the ame pointer

        if (head == null) {
            head = node;// that means the node that will be inserted will be the first node
        } else {// that means there are more nodes so we will insert after the last node

            while (pointer.getNextNode() != null) {
                pointer = pointer.getNextNode();
            }// this will reach the last node

            pointer.setNextNode(node);

        }
    }

    public void createDoubleNodes(DoubleNode doubleNode) {// this method will create a nodes and reference them to each other
        DoubleNode pointer = doubleNodeHead;// the temp will have the ame pointer

        if (doubleNodeHead == null) {
            doubleNodeHead = doubleNode;// this means if i don't have a head in the double nodes i'll insert this doubleNode as a head
        } else {// that means there are Double nodes  that already exist so we will insert after the last node

            while (pointer.getNextDoubleNode() != null) {// we'll get tot the last double node
                pointer = pointer.getNextDoubleNode();
            }// this will reach the last node

            pointer.setNextDoubleNode(doubleNode);// the current last double node will have a reference to the new double node
            doubleNode.setPrevDoubleNode(pointer);// also the new double node will have a reference to the last double node as the previous node

        }
    }

    public int findSize() {// this method will help me find the size of the linked list (as in how many nodes it has)
        Node pointer = head;
        int size = 0;
        while (pointer != null) {
            size++;
            pointer = pointer.getNextNode();
        }
        return size;

    }

    public int findSizeDoublNode() {// this method will help me find the size of the linked list (as in how many nodes it has)
        DoubleNode pointer = doubleNodeHead;
        int size = 0;
        while (pointer != null) {
            size++;
            pointer = pointer.getNextDoubleNode();
        }
        return size;

    }


    public void bubbleSort() {
        Node currNode = head;
        int len = findSize();
        int itr = 0;
        boolean swapped;

        // Iterating over the whole linked list
        while (itr < len) {
            Node traverseNode = head;
            Node prevNode = head;
            swapped = false;

            while (traverseNode.getNextNode() != null) {

                // Temporary pointer to store the next
                // pointer of traverseNode
                Node ptr = traverseNode.getNextNode();
                if (traverseNode.getNumber() > ptr.getNumber()) {
                    swapped = true;
                    if (traverseNode == head) {

                        // Performing swap operations and
                        // updating the head of the linked
                        // list
                        traverseNode.setNextNode(ptr.getNextNode());
                        ptr.setNextNode(traverseNode);
                        prevNode = ptr;
                        head = prevNode;
                    } else {

                        // Performing swap operation
                        traverseNode.setNextNode(ptr.getNextNode());
                        ptr.setNextNode(traverseNode);
                        prevNode.setNextNode(ptr);
                        prevNode = ptr;
                    }
                    continue;
                }
                prevNode = traverseNode;
                traverseNode = traverseNode.getNextNode();
            }

            // If no swap occurred, break the loop
            if (!swapped) {
                break;
            }

            itr++;
        }

        // Returning the head of the linked list

    }


    public void sortDoubleLinkedList() {
        int size = findSizeDoublNode();

        DoubleNode pointer2 = getDoubleNodeHead();
        DoubleNode previousNode = pointer2;


        if (size <= 2) {// this has a different swapping technique than the rest

            if (size == 0) {
                System.out.println("Can't implement sorting because the linked list doesn't exist");
                return;
            } else if (size == 1) {// because we won't have the anything to sort it with
                return;
            } else if (pointer2.getNextDoubleNode().getvalue() > pointer2.getvalue())// meaning the second node has a greater value which means no sorting is needed
                return;

            else {//second option is if the second node has a smaller value than the one before it

                DoubleNode current = pointer2.getNextDoubleNode();
                current.setPrevDoubleNode(null);
                current.setNextDoubleNode(previousNode);
                previousNode.setPrevDoubleNode(current);
                previousNode.setNextDoubleNode(null);
                doubleNodeHead = current;
            }

        }


        // if the size isn't two we will implement something else


        else {

            pointer2=pointer2.getNextDoubleNode();
            for (int i = 1; i < size ; i++) {// this will move one by one kind of like a counter of the size of the array



                if (pointer2.getvalue()>pointer2.getPrevDoubleNode().getvalue()){
                    pointer2=pointer2.getNextDoubleNode();
                }


                else{// thie means we will need swapping
                    DoubleNode updatedNode = pointer2.getNextDoubleNode();// this will be the pointer right after the node that i want to start swapping with

                    while (pointer2.getPrevDoubleNode() != null && pointer2.getvalue() < pointer2.getPrevDoubleNode().getvalue()) {// in here i'll do a loop that will keep on swapping values from pointer
                            DoubleNode prev = pointer2.getPrevDoubleNode();

                            if (pointer2.getNextDoubleNode() == null) {

                                DoubleNode TheRestOfNodes = prev.getPrevDoubleNode();
                                TheRestOfNodes.setNextDoubleNode(pointer2);
                                pointer2.setNextDoubleNode(prev);
                                prev.setPrevDoubleNode(pointer2);
                                prev.setNextDoubleNode(null);
                                doubleNodeHead = TheRestOfNodes;
                            }

                            else if (pointer2.getPrevDoubleNode() == doubleNodeHead) {// here becasue the value u want to swap is the head so swapping will be diff

                                DoubleNode TheRestOfNodes = pointer2.getNextDoubleNode();// we got the rest of the nodes
                                pointer2.setPrevDoubleNode(null);
                                pointer2.setNextDoubleNode(prev);
                                prev.setPrevDoubleNode(pointer2);
                                prev.setNextDoubleNode(TheRestOfNodes);
                                doubleNodeHead = pointer2;

                            } else {
                                DoubleNode pre = pointer2.getPrevDoubleNode();
                                DoubleNode TherestOfTheLinkPre = pre.getPrevDoubleNode();
                                DoubleNode TherestOfTheLlinkPost = pointer2.getNextDoubleNode();
                                TherestOfTheLinkPre.setNextDoubleNode(pointer2);
                                pointer2.setPrevDoubleNode(TherestOfTheLinkPre);
                                pointer2.setNextDoubleNode(pre);
                                pre.setPrevDoubleNode(pointer2);
                                pre.setPrevDoubleNode(TherestOfTheLlinkPost);
                                TherestOfTheLlinkPost.setPrevDoubleNode(pre);

                            }





                    }

                    pointer2 = updatedNode;


                }


            }

        }

    }

}


























