import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NodeTest {
    @Test
    public void testSetData() {
        Node a = new Node(10, null);
        Node b = new Node (-5, null);
        a.setData(5);
        assertEquals(a.getData(),5);
        a.setData(9);
        assertEquals(a.getData(), 9);
        assertNull(a.getNext());
        a.setNext(b);
        assertEquals(a.getNext(), b);
    }
}
