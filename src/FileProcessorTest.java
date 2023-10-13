import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {

    @Test
    void processFile() {
        assertThrows(IllegalArgumentException.class, () -> FileProcessor.processFile("BasicInput.tt"));
        assertDoesNotThrow(() -> FileProcessor.processFile("BasicInput.txt"));

    }
}