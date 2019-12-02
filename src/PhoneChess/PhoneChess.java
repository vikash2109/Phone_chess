package PhoneChess;

import java.awt.Point;

public final class PhoneChess {
	
	private ChessPiece thePiece = null;
	private PieceFactory factory = null;

	public ChessPiece ThePiece()
	{
	    return this.thePiece;
	}

	public PhoneChess(PadNumber[][] thePad, String piece)
	{
	    if(thePad == null || thePad.length == 0 || thePad[0].length == 0)
	        throw new IllegalArgumentException("Invalid pad");
	    if(piece == null)
	        throw new IllegalArgumentException("Invalid chess piece");

	    this.factory = new PieceFactory();
	    this.thePiece = this.factory.getPiece(piece, thePad);
	}

	public Integer findPossibleDigits(PadNumber start, Integer digits)
	{
	    if(digits <= 0)
	        throw new IllegalArgumentException("Digits cannot be less than or equal to zero");

	    return thePiece.findNumbers(start, digits);
	}

	public static void main(String[] args) {


	    PadNumber[][] thePad = new PadNumber[4][3];
	    thePad[0][0] = new PadNumber("1", new Point(0,0));
	    thePad[0][1] = new PadNumber("2", new Point(1,0));
	    thePad[0][2] = new PadNumber("3",new Point(2,0));
	    thePad[1][0] = new PadNumber("4",new Point(0,1));
	    thePad[1][1] = new PadNumber("5",new Point(1,1));
	    thePad[1][2] = new PadNumber("6", new Point(2,1));
	    thePad[2][0] = new PadNumber("7", new Point(0,2));
	    thePad[2][1] = new PadNumber("8", new Point(1,2));
	    thePad[2][2] = new PadNumber("9", new Point(2,2));
	    thePad[3][0] = new PadNumber("*", new Point(0,3));
	    thePad[3][1] = new PadNumber("0", new Point(1,3));
	    thePad[3][2] = new PadNumber("#", new Point(2,3));
	    
	    //Driver code to run.
	    PhoneChess phoneChess = new PhoneChess(thePad, "Knight"); //here you can change knight with any chess piece (King, Queen, Bishop, Knight, Rook, Pawn)
	    
	    System.out.println(phoneChess.findPossibleDigits(thePad[0][0],10)); // here you can change the starting position of phone Keypad(i.e thePad[i][j]) and number of digits(by default it is 10)
	    
	}
}
