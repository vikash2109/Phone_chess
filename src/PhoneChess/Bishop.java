package PhoneChess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class Bishop extends ChessPiece implements Movement {

/**Knight movements
 * One horizontal, followed by two vertical
 * Or 
 * One vertical, followed by two horizontal
 * @param name
 */

public Bishop(String name, PadNumber[][] thePad)
{
    if(name == null || name.isEmpty() == true)
        throw new IllegalArgumentException("Name cannot be null or empty");

    this.name = name;
    this.thePad = thePad;
    this.moves = new HashMap<>();
}


private Integer fullNumbers = null;
/***
 * Overriden method that defines each Piece's movement restrictions.
 */
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
        if(from.getNumberAsNumber() == 0)
        {

                found.add(thePad[0][1]);
                found.add(thePad[1][1]);
                found.add(thePad[2][1]);
                this.movesFrom[from.getNumberAsNumber()] = this.movesFrom[from.getNumberAsNumber()] + 3;


        }
        if(from.getNumberAsNumber() == 1 )
        {
                found.add(thePad[0][1]);
                found.add(thePad[0][2]);
                found.add(thePad[1][0]);
                found.add(thePad[2][0]);
                this.movesFrom[from.getNumberAsNumber()] = this.movesFrom[from.getNumberAsNumber()] + 4;


        }
        if(from.getNumberAsNumber() == 4 )
        {

                found.add(thePad[1][1]);
                found.add(thePad[1][2]);
                found.add(thePad[0][0]);
                found.add(thePad[2][0]);
                this.movesFrom[from.getNumberAsNumber()] = this.movesFrom[from.getNumberAsNumber()] + 4;


        }
        if(from.getNumberAsNumber() == 7 )
        {

                found.add(thePad[2][1]);
                found.add(thePad[2][2]);
                found.add(thePad[1][0]);
                found.add(thePad[0][0]);
                this.movesFrom[from.getNumberAsNumber()] = this.movesFrom[from.getNumberAsNumber()] + 4;


        }
        if(from.getNumberAsNumber() == 2 )
        {

                found.add(thePad[0][0]);
                found.add(thePad[0][2]);
                found.add(thePad[1][1]);
                found.add(thePad[2][1]);
                found.add(thePad[3][1]);
                this.movesFrom[from.getNumberAsNumber()] = this.movesFrom[from.getNumberAsNumber()] + 5;


        }
        if(from.getNumberAsNumber() == 5 )
        {

        	found.add(thePad[1][0]);
            found.add(thePad[1][2]);
            found.add(thePad[0][1]);
            found.add(thePad[2][1]);
            found.add(thePad[3][1]);
            this.movesFrom[from.getNumberAsNumber()] = this.movesFrom[from.getNumberAsNumber()] + 5;


        }
        if(from.getNumberAsNumber() == 8 )
        {

        	found.add(thePad[2][0]);
            found.add(thePad[2][2]);
            found.add(thePad[1][1]);
            found.add(thePad[0][1]);
            found.add(thePad[3][1]);
                this.movesFrom[from.getNumberAsNumber()] = this.movesFrom[from.getNumberAsNumber()] + 5;


        }
        if(from.getNumberAsNumber() == 3 )
        {

                found.add(thePad[0][0]);
                found.add(thePad[0][1]);
                found.add(thePad[1][2]);
                found.add(thePad[2][2]);
                this.movesFrom[from.getNumberAsNumber()] = this.movesFrom[from.getNumberAsNumber()] + 4;


        }
        if(from.getNumberAsNumber() == 6 )
        {

        	found.add(thePad[1][0]);
            found.add(thePad[1][1]);
            found.add(thePad[0][2]);
            found.add(thePad[2][2]);
                this.movesFrom[from.getNumberAsNumber()] = this.movesFrom[from.getNumberAsNumber()] + 4;


        }
        if(from.getNumberAsNumber() == 9 )
        {

        	found.add(thePad[2][0]);
            found.add(thePad[2][1]);
            found.add(thePad[1][2]);
            found.add(thePad[0][2]);
                this.movesFrom[from.getNumberAsNumber()] = this.movesFrom[from.getNumberAsNumber()] + 4;


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

}
