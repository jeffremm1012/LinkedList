public class LinkList {
    private Node head;

    public LinkList(){

    }
    public void addNode(int data){
        Node newNode = new Node(data);
        // Check if head is null
        if (head == null) {
            head = newNode;
        }

        else {
            // look for the the node pointing to null
            Node currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            // We now know currentNode is pointing to null = end of the list
            currentNode.setNext(newNode);
        }
    }
    public void addNodeFirst(int data) {

        Node newNode = new Node(data);

        newNode.setNext(head);
        this.setHead(newNode);
    }
    public void addToPosition(int pos,int data){
        Node newNode = new Node(data);

        if(pos ==0){
            addNodeFirst(data);
        }
        Node currentNode = head;
        //loop through list to find pos
        for(int i = 0; i<pos-1; i++){
            // Check to see if pos goes beyond end of list
            if(currentNode.getNext()!= null) {
                currentNode = currentNode.getNext();

            }
            else {
                break;
            }
        }
        //set pointers
        newNode.setNext(currentNode.getNext()); //one ahead of currentNode
        currentNode.setNext(newNode);// points towards newNode
    }
    public void delete(int data) {
        Node currentNode = head;
        while(currentNode != null) {
            if(currentNode == head) {
                currentNode = currentNode.getNext();
            }
                else {

                if (currentNode.getData() == data) {
                    currentNode.getPrevious().setNext(currentNode.getNext());
                    currentNode.getNext().setPrevious(currentNode.getPrevious());
                    break;
                } else {
                    currentNode = currentNode.getNext();

                }
            }


        }
    }


    public void changeData(int data, int newData){
        Node currentNode = head;
        while(currentNode.getNext() != null){
            if(currentNode.getData() == data){
                currentNode.setData(newData);
            }
            else {
                currentNode = currentNode.getNext();
            }
        }
    }

    public String toString() {
        String data = "";
        // look for the node pointing to null
        Node currentNode = head;
        while (currentNode.getNext() != null) {
            data = data + currentNode.getData() + ", ";
            currentNode = currentNode.getNext();
        }
        data = data + currentNode.getData();
        return data;
    }

    private Node getHead() {
        return head;
    }

    private void setHead(Node head) {
        this.head = head;
    }

}
