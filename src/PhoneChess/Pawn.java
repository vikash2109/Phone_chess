package PhoneChess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;

public final class Pawn extends ChessPiece implements Movement {

@Generated("SparkTools")
	private Pawn(Builder builder) {
		this.name = builder.name;
		this.moves = builder.moves;
		this.fullNumbers = builder.fullNumbers;
		this.movesFrom = builder.movesFrom;
		this.thePad = builder.thePad;
	}
/**Knight movements
 * One horizontal, followed by two vertical
 * Or 
 * One vertical, followed by two horizontal
 * @param name
 */

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
/**
 * Creates builder to build {@link Pawn}.
 * @return created builder
 */
@Generated("SparkTools")
public static Builder builder() {
	return new Builder();
}

/**
 * Builder to build {@link Pawn}.
 */
@Generated("SparkTools")
public static final class Builder {
	private String name;
	private HashMap<PadNumber, List<PadNumber>> moves;
	private Integer fullNumbers;
	private int[] movesFrom;
	private PadNumber[][] thePad;

	private Builder() {
	}

	public Builder withName(String name) {
		this.name = name;
		return this;
	}

	public Builder withMoves(HashMap<PadNumber, List<PadNumber>> moves) {
		this.moves = moves;
		return this;
	}

	public Builder withFullNumbers(Integer fullNumbers) {
		this.fullNumbers = fullNumbers;
		return this;
	}

	public Builder withMovesFrom(int[] movesFrom) {
		this.movesFrom = movesFrom;
		return this;
	}

	public Builder withThePad(PadNumber[][] thePad) {
		this.thePad = thePad;
		return this;
	}

	public Pawn build() {
		return new Pawn(this);
	}
}
}
