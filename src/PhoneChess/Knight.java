package PhoneChess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class Knight extends ChessPiece implements Movement {

/**Knight movements
 * One horizontal, followed by two vertical
 * Or 
 * One vertical, followed by two horizontal
 * @param name
 */

public Knight(String name, PadNumber[][] thePad)
{
    if(name == null || name.isEmpty() == true)
        throw new IllegalArgumentException("Name cannot be null or empty");

    this.name = name;
    this.thePad = thePad;
    this.moves = new HashMap<>();
}


private Integer fullNumbers = null;

@Override
public Integer findNumbers(PadNumber start, Integer digits) 
{	
    if(start == null || "*".equals(start.getNumber()) || "#".equals(start.getNumber()) ) { throw new IllegalArgumentException("Invalid start point"); }
    if(start.getNumberAsNumber() == 5) { return 0; } //Consider adding an 'allowSpecialChars' condition
    if(digits == 1) { return 1; };
    System.out.println(start.getNumber());
    //Init
    this.movesFrom = new int[thePad.length * thePad[0].length];
    for(int i = 0; i < this.movesFrom.length; i++)
        this.movesFrom[i] = -1;

    fullNumbers = 0;
    findNumbers(start, digits, 1);      
    return fullNumbers;
}

private void findNumbers(PadNumber start, Integer digits, Integer currentDigits)
{
    //Base condition
    if(currentDigits == digits)
    {
        //Reset
        currentDigits = 1; 
        fullNumbers++; 
        return; 
    }
    if(!this.moves.containsKey(start))
        allowedMoves(start);

    List<PadNumber> options = this.moves.get(start);
    if(options != null)
    {
        currentDigits++; //More digits to be got
        for(PadNumber option : options)
            findNumbers(option, digits, currentDigits);
    }
}

@Override
public boolean canMove(PadNumber from, PadNumber to) 
{
    //Is the moves list available?
    if(!this.moves.containsKey(from.getNumber()))
    {
        //No? Process.
        allowedMoves(from);
    }
    if(this.moves.get(from) != null)
    {
        for(PadNumber option : this.moves.get(from))
        {
            if(option.getNumber().equals(to.getNumber()))
                return true;
        }
    }
    return false;

}

/***
 * Overriden method that defines each Piece's movement restrictions.
 */
@Override
public List<PadNumber> allowedMoves(PadNumber from) 
{
    //First encounter
    if(this.moves == null)
        this.moves = new HashMap<>();


    if(this.moves.containsKey(from))
        return this.moves.get(from);
    else
    {
        List<PadNumber> found = new ArrayList<>();
        int row = from.getY();//rows
        int col = from.getX();//columns

        //Cases:
        //1. One horizontal move each way followed by two vertical moves each way
        if(col-1 >= 0 && row-2 >= 0)//valid
        {
            if(thePad[row-2][col-1].getNumber().equals("*") == false && 
                    thePad[row-2][col-1].getNumber().equals("#") == false)
            {
                found.add(thePad[row-2][col-1]);
                this.movesFrom[from.getNumberAsNumber()] = this.movesFrom[from.getNumberAsNumber()] + 1;
            }

        }
        if(col-1 >= 0 && row+2 < thePad.length)//valid
        {
            if(thePad[row+2][col-1].getNumber().equals("*") == false && 
                    thePad[row+2][col-1].getNumber().equals("#") == false)
            {
                found.add(thePad[row+2][col-1]);
                this.movesFrom[from.getNumberAsNumber()] = this.movesFrom[from.getNumberAsNumber()] + 1;
            }
        }
        if(col+1 < thePad[0].length && row+2 < thePad.length)//valid
        {
            if(thePad[row+2][col+1].getNumber().equals("*") == false && 
                    thePad[row+2][col+1].getNumber().equals("#") == false)
            {
                found.add(thePad[row+2][col+1]);
                this.movesFrom[from.getNumberAsNumber()] = this.movesFrom[from.getNumberAsNumber()] + 1;
            }
        }
        if(col+1 < thePad[0].length && row-2 >= 0)//valid
        {
            if(thePad[row-2][col+1].getNumber().equals("*") == false && 
                    thePad[row-2][col+1].getNumber().equals("#") == false)
            found.add(thePad[row-2][col+1]);
        }
        //Case 2. One vertical move each way follow by two horizontal moves each way

        if(col-2 >= 0 && row-1 >= 0)
        {
            if(thePad[row-1][col-2].getNumber().equals("*") == false && 
                    thePad[row-1][col-2].getNumber().equals("#") == false)
            found.add(thePad[row-1][col-2]);
        }
        if(col-2 >= 0 && row+1 < thePad.length)
        {
            if(thePad[row+1][col-2].getNumber().equals("*") == false && 
                    thePad[row+1][col-2].getNumber().equals("#") == false)
            found.add(thePad[row+1][col-2]);
        }

        if(col+2 < thePad[0].length && row-1 >= 0)
        {
            if(thePad[row-1][col+2].getNumber().equals("*") == false && 
                    thePad[row-1][col+2].getNumber().equals("#") == false)
            found.add(thePad[row-1][col+2]);
        }
        if(col+2 < thePad[0].length && row+1 < thePad.length)
        {
            if(thePad[row+1][col+2].getNumber().equals("*") == false && 
                    thePad[row+1][col+2].getNumber().equals("#") == false)
            found.add(thePad[row+1][col+2]);
        }

        if(found.size() > 0)
        {
            this.moves.put(from, found);
            this.movesFrom[from.getNumberAsNumber()] = found.size();
        }
        else
        {
            this.moves.put(from, null); //for example the Knight cannot move from 5 to anywhere
            this.movesFrom[from.getNumberAsNumber()] = 0;
        }
    }

    return this.moves.get(from);


}

@Override
public Integer countAllowedMoves(PadNumber from) 
{
    int start = from.getNumberAsNumber();

    if(movesFrom[start] != -1)
        return movesFrom[start];
    else
    {
        movesFrom[start] = allowedMoves(from).size();
    }
    return movesFrom[start];
}

@Override
public String toString()
{
    return this.name;
}

}
