package PhoneChess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;

public final class Pawn extends ChessPiece implements Movement {


public Pawn(String name, PadNumber[][] thePad)
{
    if(name == null || name.isEmpty() == true)
        throw new IllegalArgumentException("Name cannot be null or empty");

    this.name = name;
    this.thePad = thePad;
    this.moves = new HashMap<>();
}
@Override
public Integer findNumbers(PadNumber start, Integer digits) 
{	
    if(start == null || "*".equals(start.getNumber()) || "#".equals(start.getNumber()) ) { throw new IllegalArgumentException("Invalid start point"); }
    
    if(digits == 1) { return 1; };
    //System.out.println(start.getNumber());
    //Init

    int row = start.getY();//rows
    int col = start.getX();//columns
    fullNumbers = 0;
    if (row == 0) {
    	fullNumbers = findCount(thePad[0][col] , digits);
    } else if( row == 1) {
    	fullNumbers = findCount(thePad[0][col] , digits - 1 );
    }
    
  
    else if(row == 2) {
	fullNumbers += findCount(thePad[0][col] ,  digits - 1  )  ;
	if(digits > 1) {
		fullNumbers += findCount(thePad[0][col] ,  digits - 2);
	}
}
    if(row == 3) {
   
	fullNumbers += findCount(thePad[0][col] ,  digits - 2) ;
	if(digits >= 1) {
		fullNumbers += findCount(thePad[0][col] ,  digits - 3);
	}
}
    return fullNumbers;
}

public Integer findCount(PadNumber start, Integer digits) {
	if(digits <= 0) {
		return 1;
	}
	PhoneChess phoneChess = new PhoneChess(thePad, "Queen");
	return phoneChess.findPossibleDigits(start, digits);
}
}
