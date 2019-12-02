package PhoneChess;

import java.util.HashMap;


public final class Knight extends ChessPiece implements Movement {


public Knight(String name, PadNumber[][] thePad)
{
    if(name == null || name.isEmpty() == true)
        throw new IllegalArgumentException("Name cannot be null or empty");

    this.name = name;
    this.thePad = thePad;
    this.moves = new HashMap<>();
}

@Override
boolean isValMove(PadNumber from, PadNumber to) {
	
	int row1 = from.getY();//rows
    int col1 = from.getX();//columns
    
    int row2 = to.getY();//rows
    int col2 = to.getX();//columns
    
    if( (Math.abs(row1-row2) == 2 && Math.abs(col1-col2)==1) || (Math.abs(row1-row2) == 1 && Math.abs(col1-col2)==2))
    		{
    	return true;
    }
    return false;
}

}

