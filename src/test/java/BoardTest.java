import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardTest {
    @Test
    public void should_die_when_alone() {
        Board b = new Board();
        b.setCell(new GameCell(1,1));

        b.tick();

        assertFalse(b.isAlive(1,1));

    }

    @Test
    public void should_survice_when_accompanied_by_two_cells() {
        Board b = new Board();
        b.setCell(new GameCell(0,0));
        b.setCell(new GameCell(0,1));
        b.setCell(new GameCell(1,0));

        b.tick();

        assertTrue(b.isAlive(0,0));
    }

@Test
    public void should_survice_when_accompanied_by_three_cells() {
        Board b = new Board();
        b.setCell(new GameCell(0,0));
        b.setCell(new GameCell(0,1));
        b.setCell(new GameCell(0,2));
        b.setCell(new GameCell(1,1));

        b.tick();

        assertTrue(b.isAlive(0,1));
    }

    @Test
    public void should_be_born_if_dead_and_surrounded_by_three_alive_cells() {
        Board b = new Board();
        b.setCell(new GameCell(0,0));
        b.setCell(new GameCell(0,1));
        b.setCell(new GameCell(0,2));
        b.setCell(new GameCell(1,1));

        assertFalse(b.isAlive(1, 0));
        assertFalse(b.isAlive(1, 2));

        b.tick();

        assertTrue(b.isAlive(1,0));
        assertTrue(b.isAlive(1,2));
    }

    @Test
    public void should_be_born_if_dead_and_surrounded_by_three_alive_cells_without_count_2() {
        Board b = new Board();
        b.setCell(new GameCell(0,1));
        b.setCell(new GameCell(2,0));
        b.setCell(new GameCell(2,2));

        assertFalse(b.isAlive(1, 1));

        b.tick();

        assertTrue(b.isAlive(1,1));
    }

//    @Test
//    @Ignore
//    public void should_not_be_born_if_dead_and_surrounded_by_three_alive_cells_but_outside_of_board() {
//        Board b = new Board();
//        b.setCell(new GameCell(0,0));
//        b.setCell(new GameCell(0,1));
//        b.setCell(new GameCell(0,2));
//
//        assertFalse(b.isAlive(-1, 1));
//
//        b.tick();
//
//        assertFalse(b.isAlive(-1,1));
//    }


    @Test
    public void should_die_by_underpopulation() {
        Board b = new Board();
        b.setCell(new GameCell(0,1));
        b.setCell(new GameCell(1,1));

        b.tick();

        assertFalse(b.isAlive(1,1));
    }

    @Test
    public void should_die_by_overpopulation() {

        Board b = new Board();
        b.setCell(new GameCell(0,0));
        b.setCell(new GameCell(0,2));
        b.setCell(new GameCell(2,0));
        b.setCell(new GameCell(2,2));

        b.setCell(new GameCell(1,1));

        b.tick();

        assertFalse(b.isAlive(1,1));
    }


    @Test
    public void should_start_all_dead() {
        Board b = new Board();

        b.tick();

        assertFalse(b.isAlive(0,0));
        assertFalse(b.isAlive(0,1));
        assertFalse(b.isAlive(0,2));
        assertFalse(b.isAlive(1,0));
        assertFalse(b.isAlive(1,1));
        assertFalse(b.isAlive(1,2));
        assertFalse(b.isAlive(2,0));
        assertFalse(b.isAlive(2,1));
        assertFalse(b.isAlive(2,3));

    }
}
