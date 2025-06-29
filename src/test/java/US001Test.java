import at.technikum.Board;
import at.technikum.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class US001Test {
    private Board board;
    private Player player;

    @BeforeEach
    public void setUp() {
        board = new Board();
        player = new Player('X');
    }

    @Test
    public void testPlaceMarkerOnEmptyCell() {
        assertTrue(board.isCellEmpty(0, 0));
        board.place(0, 0, player.getMarker());
        assertFalse(board.isCellEmpty(0, 0));
        assertEquals('X', board.getCells(0, 0));
    }

    @Test
    public void testRejectPlacementOnOccupiedCell() {
        board.place(1, 1, player.getMarker());
        assertFalse(board.isCellEmpty(1, 1));
    }

    @Test
    public void testInitialBoardIsEmpty() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(board.isCellEmpty(i, j));
            }
        }
    }
}