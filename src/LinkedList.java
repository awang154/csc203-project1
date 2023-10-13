
public class LinkedList {
    private int length;
    private Node head;
    private Node tail;

    public LinkedList(Node head) {
        this.length = 1;
        this.head = head;
        this.tail = head;
    }

    public LinkedList() {
        this.length = 0;
        this.head = null;
        this.tail = null;
    }

    public int getLength() {
        return length;
    }

    public Node getHead() {
        return head;
    }

    public void append(int data){
        if (this.head == null) {
            this.head = new Node(data, null);
            this.tail = this.head;
            length = 1;
            return;
        }

        Node node = new Node(data,null);
        node.setNext(this.head);
        this.head = node;
        this.length += 1;
    }

    public void push(int data) {
        if (this.head == null) {
            this.head = new Node(data, null);
            this.tail = this.head;
            length = 1;
            return;
        }

        Node node = new Node(data,null);
        this.tail.setNext(node);
        this.tail = node;
        this.length += 1;
    }

    public int pop(){

        if (length <= 0) {
            this.head = null;
            this.tail = null;
            length = 0;
            return 0;
        }

        Node temp = this.head;
        this.head = this.head.getNext();
        this.length -= 1;

        return temp.getData();
    }

    public int peek() {
        if (this.head == null) return 0;
        return this.head.getData();
    }

    @Override
    public String toString() {
        if (this.length == 0) return "";
        Node temp = this.head;
        StringBuilder total = new StringBuilder();

        for (int i = 0; i < this.length; i++) {
            total.append(temp.getData());
            temp = temp.getNext();
        }

        return total.reverse().toString();
    }

    public static LinkedList ParseFromString(String string) {
        if (string.length() == 0) return new LinkedList();

        LinkedList over = new LinkedList(new Node(CharToInt(string.charAt(0)), null));

        for (int c = 1; c < string.length(); c++) {
            over.append(CharToInt(string.charAt(c)));
        }

        return over;
    }

    private static int CharToInt(char c) {
        return Integer.parseInt("" + c);
    }
}
