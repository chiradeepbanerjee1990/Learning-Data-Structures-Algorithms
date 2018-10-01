package LinkedList;

/**
 * Created by Chiradeep Banerjee
 * Email : chiradeep.banerjee72@gmail.com.
 */
public class Driver {


    public static void main(String args[]) {
        Object obj = new Object();
        synchronized (obj) {
            LinkedList<String> myLinkList = new LinkedList<String>();
            myLinkList.insertNodeAtBeginning("5");
            myLinkList.insertNodeAtBeginning("8");
            myLinkList.insertNodeAtBeginning("13");

            myLinkList.insertNodeAtEnd("130");

            myLinkList.insertNodeAtMiddle("50");

            System.out.println("LinkedList after adding all items");
            myLinkList.traverseList();

            try {
                myLinkList.removeNodeAtBeginning("13");
            } catch (NodeNotFoundException e) {
                e.printStackTrace();
            }

            System.out.println("\nLinkedList after removing first item by Data value");
            myLinkList.traverseList();
            System.out.println("\n==============");


            try {
                myLinkList.removeNodeAtBeginning("8");
            } catch (NodeNotFoundException e) {
                e.printStackTrace();
            }

            System.out.println("\nLinkedList after removing first item by Data value");
            myLinkList.traverseList();
            System.out.println("\n==============");

            try {
                myLinkList.removeNodeAtMiddle("130"); // 130 is not middle element. Exception will be thrown.
            } catch (NodeNotFoundException e) {
                e.printStackTrace();
            }

            System.out.println("\nLinkedList after trying to remove middle item by Data value & Exception thrown");
            myLinkList.traverseList();
            System.out.println("\n==============");

            try {
                myLinkList.removeNodeAtEnd("130");
            } catch (NodeNotFoundException e) {
                e.printStackTrace();
            }

            System.out.println("\nLinkedList after removing last item by Data value");
            myLinkList.traverseList();
            System.out.println("\n==============");

            try {
                myLinkList.removeNodeAtBeginning();
            } catch (AlreadyLinkedListEmpty alreadyLinkedListEmpty) {
                alreadyLinkedListEmpty.printStackTrace();
            }
            System.out.println("\nLinkedList after removing first node from the list");
            myLinkList.traverseList();
            System.out.println("\n==============");

            try {
                myLinkList.removeNodeAtEnd();
            } catch (AlreadyLinkedListEmpty alreadyLinkedListEmpty) {
                alreadyLinkedListEmpty.printStackTrace();
            }

            System.out.println("\nLinkedList after removing last node from the list");
            myLinkList.traverseList();
            System.out.println("\n==============");
        }
    }
}
