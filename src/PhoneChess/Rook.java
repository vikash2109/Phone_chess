package PhoneChess;

import java.util.HashMap;


public final class Rook extends ChessPiece implements Movement {

/**Knight movements
 * One horizontal, followed by two vertical
 * Or 
 * One vertical, followed by two horizontal
 * @param name
 */

public Rook(String name, PadNumber[][] thePad)
{
    if(name == null || name.isEmpty() == true)
        throw new IllegalArgumentException("Name cannot be null or empty");

    this.name = name;
    this.thePad = thePad;
    this.moves = new HashMap<>();
}


//private Integer fullNumbers = null;
/***
 * Overriden method that defines each Piece's movement restrictions.
 */

@Override
boolean isValMove(PadNumber from, PadNumber to) {
	
	int row1 = from.getY();//rows
    int col1 = from.getX();//columns
    
    int row2 = to.getY();//rows
    int col2 = to.getX();//columns
    
    if( col1==col2 || row1==row2)
    		{
    	return true;
    }
    return false;
}

}