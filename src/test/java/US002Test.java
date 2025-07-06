import static org.junit.jupiter.api.Assertions.*;
import at.technikum.Board;
import at.technikum.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

    public class US002Test {
        private Board board;
        private Player playerX;
        private Player playerO;

        @BeforeEach
        public void setUp() {
            board = new Board();
            playerX = new Player('X');
            playerO = new Player('O');
        }

        @Test
        public void testEmptyBoardAtStart() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    assertTrue(board.isCellEmpty(i, j));
                }
            }
        }

        @Test
        public void testPlaceMarkerOnEmptyCell() {
            board.place(1, 1, playerX.getMarker());
            assertEquals('X', board.getCells(1, 1));
        }

        @Test
        public void testOccupiedCellAfterPlacement() {
            board.place(0, 2, playerO.getMarker());
            assertFalse(board.isCellEmpty(0, 2));
        }

        @Test
        public void testBoardPrintContainsMarkers() {
            board.place(0, 0, 'X');
            board.place(2, 2, 'O');

            ByteArrayOutputStream output = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(output));

            board.print();

            System.setOut(originalOut);
            String printed = output.toString();

            assertTrue(printed.contains("X"));
            assertTrue(printed.contains("O"));
            assertTrue(printed.contains("0 |"));
        }

        @Test
        public void testPlayerMarkerConsistency() {
            assertEquals('X', playerX.getMarker());
            assertEquals('O', playerO.getMarker());
        }
    }


