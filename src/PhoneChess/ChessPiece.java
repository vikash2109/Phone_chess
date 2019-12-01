package PhoneChess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class ChessPiece implements Movement {

protected String name = "";
protected HashMap<PadNumber, List<PadNumber>> moves = null;
protected Integer fullNumbers = 0;
protected int[] movesFrom = null;
protected PadNumber[][] thePad = null;

public Integer findNumbers(PadNumber start, Integer digits) 
{	
    if(start == null || "*".equals(start.getNumber()) || "#".equals(start.getNumber()) ) { throw new IllegalArgumentException("Invalid start point"); }
    
    if(digits == 1) { return 1; };
    //System.out.println(start.getNumber());
    //Init
    this.movesFrom = new int[thePad.length * thePad[0].length];
    for(int i = 0; i < this.movesFrom.length; i++)
        this.movesFrom[i] = -1;

    fullNumbers = 0;
    ArrayList<String> list = new ArrayList<>();
    list.add(start.getNumber()) ;
    findNumbers(start, digits, 1,list);      
    return fullNumbers;
}

private void findNumbers(PadNumber start, Integer digits, Integer currentDigits, ArrayList<String> num )
{
    //Base condition
    if(currentDigits == digits)
    {
    	System.out.println(num);
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
        for(PadNumber option : options) {
        	num.add(option.getNumber());
        
            findNumbers(option, digits, currentDigits,num);
            num.remove(num.size()-1);
    }}
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
        for(int i=0;i<4;i++) {
        	for(int j=0;j<3;j++) {
        		if(thePad[i][j].getNumber().equals("*") == false && 
                        thePad[i][j].getNumber().equals("#") == false && !(i==row && j==col)) {
        			
        			if(isValMove(from,thePad[i][j])) {
        				found.add(thePad[i][j]);
                        this.movesFrom[from.getNumberAsNumber()] = this.movesFrom[from.getNumberAsNumber()] + 1;

        			}
        		}
        	}
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

boolean isValMove(PadNumber from, PadNumber to) {
	return true;
}

@Override
public String toString()
{
    return this.name;
}

}
