package PhoneChess;

import java.util.HashMap;
import java.util.List;

public abstract class ChessPiece implements Movement {

protected String name = "";
protected HashMap<PadNumber, List<PadNumber>> moves = null;
protected Integer fullNumbers = 0;
protected int[] movesFrom = null;
protected PadNumber[][] thePad = null;
}
