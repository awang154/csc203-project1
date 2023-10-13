import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SampleTest {

    @Test
    void testMain() {
        assertThrows(IllegalArgumentException.class, () -> Main.main(new String[]{}));
        assertThrows(IllegalArgumentException.class, () -> Main.main(new String[]{"SampleInput.txt", "SampleInput.txt"}));
        assertDoesNotThrow(() -> Main.main(new String[]{"SampleInput.txt"}));
    }

    @Test
    void testAdd() {
        LinkedList x = LinkedList.ParseFromString("1111");
        LinkedList y = LinkedList.ParseFromString("1234");
        assertEquals("2345", Main.add(x, y).toString());

        x = LinkedList.ParseFromString("178346237894618736948173264791563");
        y = LinkedList.ParseFromString("39723658123651623945132746813294718635984712636");
        assertEquals("39723658123651802291370641432031666809249504199", Main.add(x, y).toString());

        x = LinkedList.ParseFromString("9999999999999999999");
        y = LinkedList.ParseFromString("1");
        assertEquals("10000000000000000000", Main.add(x, y).toString());
    }

    @Test
    void testMulti() {
        LinkedList x = LinkedList.ParseFromString("17");
        LinkedList y = LinkedList.ParseFromString("3");
        assertEquals("51", Main.multi(x, y).toString());

        x = LinkedList.ParseFromString("3");
        y = LinkedList.ParseFromString("17");
        assertEquals("51", Main.multi(x, y).toString());

        x = LinkedList.ParseFromString("189273478123461");
        y = LinkedList.ParseFromString("12341");
        assertEquals("2335823993521632201", Main.multi(x, y).toString());

        x = LinkedList.ParseFromString("8732978547892");
        y = LinkedList.ParseFromString("9785497815789");
        assertEquals("85456542505729358930266788", Main.multi(x, y).toString());
    }

    @Test
    void testExpo() {
        LinkedList x = LinkedList.ParseFromString("3");
        int exp = 0;

        assertEquals("1", Main.expo(x, exp).toString());

        exp = 1;
        assertEquals("3", Main.expo(x, exp).toString());

        exp = 3;
        assertEquals("27", Main.expo(x, exp).toString());

        exp = 2;
        assertEquals("9", Main.expo(x, exp).toString());

        exp = 4;
        assertEquals("81", Main.expo(x, exp).toString());

        exp = 5;
        assertEquals("243", Main.expo(x, exp).toString());

    }
}