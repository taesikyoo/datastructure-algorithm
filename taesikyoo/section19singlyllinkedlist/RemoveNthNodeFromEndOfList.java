package section19singlyllinkedlist;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertHead(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        list.deleteNth(list.size - 2);
        System.out.println(list.toString());
    }

}
