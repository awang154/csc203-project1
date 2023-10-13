public class Main {

    /**
     * The entry point of the program.
     * @param args Command line arguments. Should have exactly one argument: a file name.
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException(
                    "Illegal input");
        }
        String filePath = args[0];
        FileProcessor.processFile(filePath);
    }
    public static LinkedList add(LinkedList x, LinkedList y){
        LinkedList out = new LinkedList();

        int len = x.getLength();
        if (y.getLength() > len) len = y.getLength();

        int val;
        int carryOver = 0;

        for (int i = 0; i < len; i++){
            val = x.pop() + y.pop() + carryOver;
            if (val >= 10) {
                carryOver = 1;
                val %= 10;
            } else {
                carryOver = 0;
            }
            out.push(val);
        }

        if (carryOver > 0) out.push(1);

        return out;
    }

    public static LinkedList multi(LinkedList x, LinkedList y) {
        LinkedList sum = LinkedList.ParseFromString("0");
        Node x_node = x.getHead();
        Node y_node;
        for (int x_i = 0; x_i < x.getLength(); x_i++) {
            LinkedList add = new LinkedList();
            int carry = 0;
            int digit = 0;
            y_node = y.getHead();
            for (int y_i = 0; y_i < y.getLength(); y_i++) {
                digit = x_node.getData() * y_node.getData() + carry;
                carry = digit / 10;
                digit %= 10;

                add.push(digit);

                y_node = y_node.getNext();
            }
            if (carry != 0) {
                add.push(carry);
            }
            for (int zero = 0; zero < x_i; zero++) {
                add.append(0);
            }
            sum = add(sum, add);
            x_node = x_node.getNext();
        }
        return sum;
    }

    public static LinkedList expo(LinkedList x, int exp) {
        LinkedList product = new LinkedList(new Node(1, null));
        if (exp == 0) return product;
        if (exp == 1) return x;
        boolean is_even = exp % 2 == 0;
        int n = exp / 2;
        int i = 0;
        while (i < n) {
            product = multi(product, x); // compute x^(n/2)
            i++;
        }
        product = multi(product, product); // compute x^n
        return is_even ? product : multi(product, x); // compute x^(n+1) if n is odd
    }

}