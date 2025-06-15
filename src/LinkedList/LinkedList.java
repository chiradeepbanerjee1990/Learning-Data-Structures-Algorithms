package LinkedList;

/**
 * Created by Chiradeep Banerjee
 * Email : chiradeep.banerjee72@gmail.com.
 */
public class LinkedList<T extends Comparable<T>> implements List<T> {

    Node<T> rootNode;

    @Override
    public void insertNodeAtBeginning(T data) {
        if(rootNode == null){
            rootNode = new Node(data);
            rootNode.setNextNode(null);
        }else{
           Node<T> newNode = new Node(data);
           Node<T> currentNode = rootNode;
           rootNode = newNode;
           rootNode.setNextNode(currentNode);
        }
    }

    @Override
    public void insertNodeAtEnd(T data) {
        Node<T> currentRootNode = rootNode;
        while(currentRootNode.getNextNode() != null){
            currentRootNode = currentRootNode.getNextNode();
        }
        Node<T> lastNode = new Node(data);
        currentRootNode.setNextNode(lastNode);
        lastNode.setNextNode(null);

    }

    @Override
    public void insertNodeAtMiddle(T data) {
        Node<T> middleNode = new Node(data);

        Node currentNode, nextNode;
        currentNode = rootNode;
        nextNode = rootNode;

        //Only one node
        if(currentNode.getNextNode() == null  && nextNode.getNextNode() == null){
            currentNode.setNextNode(middleNode);
            middleNode.setNextNode(null);
        }

        //Increment first pointer by 1 and next pointer by 2
        while(nextNode.getNextNode() !=null && nextNode.getNextNode().getNextNode() !=null){
            currentNode = currentNode.getNextNode();
            nextNode = nextNode.getNextNode().getNextNode();
        }

        middleNode.setNextNode(currentNode.getNextNode());
        currentNode.setNextNode(middleNode);

    }

    @Override
    public void removeNodeAtBeginning(T data) throws NodeNotFoundException {
        Node<T> currentNode = rootNode;
        if(rootNode.getNextNode() == null && rootNode.getData() == data){
            rootNode = null;
            currentNode = null;
        }else
            if(rootNode.getData() == data){
            rootNode = rootNode.getNextNode();
            currentNode = null;
        }else{
                throw new NodeNotFoundException("\nNode not found Exception");
            }

    }

    @Override
    public void removeNodeAtEnd(T data) throws NodeNotFoundException {
        Node<T> currentNode = rootNode;
        Node<T> previousNode = rootNode;
        if(rootNode.getNextNode() == null && rootNode.getData() == data){
            rootNode = null;
            currentNode = null;
        }

        while(currentNode.getNextNode() !=null){
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();

        }

        if(currentNode.getData() == data) {
            currentNode = null;
            previousNode.setNextNode(null);
        }else{
           throw new NodeNotFoundException("\nNode not found Exception");
        }



    }

    @Override
    public void removeNodeAtBeginning() throws AlreadyLinkedListEmpty {
        Node<T> currentNode = rootNode;

        if(currentNode.getNextNode() == null && currentNode == null){
            throw new AlreadyLinkedListEmpty("ALready the list is empty. Cant remove any item");
        }else
            if(currentNode.getNextNode() == null){
                rootNode = null;
                currentNode = null;
            }

        rootNode = currentNode.getNextNode();
        currentNode = null;



    }

    @Override
    public void removeNodeAtEnd() throws AlreadyLinkedListEmpty {
        Node<T> currentNode = rootNode;
        Node<T> prevNode = rootNode;

        if(currentNode.getNextNode() == null && currentNode == null){
            throw new AlreadyLinkedListEmpty("ALready the list is empty. Cant remove any item");
        }else
            if(currentNode.getNextNode() == null){
            rootNode = null;
            currentNode = null;
            return;
        }

        while(currentNode.getNextNode()!=null){
            prevNode = currentNode;
            currentNode = currentNode.getNextNode();

        }

        prevNode.setNextNode(null);
        currentNode = null;
    }

    @Override
    public void removeNodeAtMiddle(T data) throws NodeNotFoundException {
        Node<T> currentNode = rootNode;
        Node<T> nextNode = rootNode;
        Node<T> prevNode = rootNode;


        //Only one node
        if(currentNode.getNextNode() == null && currentNode.getData() == data){
            currentNode.setNextNode(null);
            currentNode = null;
        }

        //Increment first pointer by 1 and next pointer by 2
        while(nextNode.getNextNode() !=null && nextNode.getNextNode().getNextNode() !=null){
            prevNode = currentNode;
            currentNode = currentNode.getNextNode();
            nextNode = nextNode.getNextNode().getNextNode();
        }

        if(prevNode.getData() == data) {
            prevNode.setNextNode(currentNode.getNextNode());
            currentNode.setNextNode(null);
            currentNode = null;
        }else{
            throw new NodeNotFoundException("\nNode not found Exception");
        }
    }


    @Override
    public void traverseList() {
        Node<T> currentRootNode = rootNode;
        while(rootNode != null){
            System.out.print("\tItems: ");
            System.out.print(rootNode.getData());
            rootNode = rootNode.getNextNode();

        }

        rootNode = currentRootNode;
    }

    @Override
    public int size() {
        int size = 0;

        if(rootNode == null) return size;
        while(rootNode.getNextNode() !=null){
                ++size;
                rootNode = rootNode.getNextNode();
        }
        return size;
    }
}
