package LinkedList;

/**
 * Created by Chiradeep Banerjee
 * Email : chiradeep.banerjee72@gmail.com.
 */
public interface List<T> {

    void insertNodeAtBeginning(T data);

    void insertNodeAtEnd(T data);

    void insertNodeAtMiddle(T data);

    void removeNodeAtBeginning(T data) throws NodeNotFoundException;

    void removeNodeAtEnd(T data) throws NodeNotFoundException;

    void removeNodeAtBeginning() throws  AlreadyLinkedListEmpty;

    void removeNodeAtEnd() throws  AlreadyLinkedListEmpty;

    void removeNodeAtMiddle(T data) throws NodeNotFoundException;

    void traverseList();

    int size();

}
