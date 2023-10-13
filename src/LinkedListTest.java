import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {

    @Test
    public void testSetHead() {
        LinkedList x = new LinkedList(new Node(5,null));
        x.append(6);
        assertEquals(x.getHead().getData(),6);
        assertEquals(x.getLength(),2);
    }
    @Test
    public void testPop(){
        LinkedList x = new LinkedList(new Node(5,null));
        x.append(6);
        assertEquals(x.pop(),6);
    }

    @Test
    public void testPush() {
        LinkedList x = new LinkedList();
        x.push(6);
        assertEquals(x.pop(),6);
        x.push(1);
        x.push(2);
        assertEquals(x.pop(), 1);
        assertEquals(x.pop(), 2);
        assertEquals(x.peek(), 0);
    }

    @Test
    public void testStringParsing() {
        String num = "748291234";
        LinkedList list = LinkedList.ParseFromString(num);
        assertEquals(list.toString(), "748291234");
    }


}
