package PhoneChess;

import java.util.HashMap;

public final class King extends ChessPiece implements Movement {

/**Knight movements
 * One horizontal, followed by two vertical
 * Or 
 * One vertical, followed by two horizontal
 * @param name
 */

public King(String name, PadNumber[][] thePad)
{
    if(name == null || name.isEmpty() == true)
        throw new IllegalArgumentException("Name cannot be null or empty");

    this.name = name;
    this.thePad = thePad;
    this.moves = new HashMap<>();
}

/***
 * Overriden method that defines each Piece's movement restrictions.
 */
@Override
boolean isValMove(PadNumber from, PadNumber to) {
	
	int row1 = from.getY();//rows
    int col1 = from.getX();//columns
    
    int row2 = to.getY();//rows
    int col2 = to.getX();//columns
    
    if( (Math.abs(row1-row2)==1 && col1==col2) || (Math.abs(col1-col2)==1 && row1==row2)
    		|| ((Math.abs(row1-row2)==1 && (Math.abs(col1-col2)==1) )))
    		{
    	return true;
    }
    return false;
}

}
