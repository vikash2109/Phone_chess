package PhoneChess;

public class PieceFactory 
{
    public ChessPiece getPiece(String piece, PadNumber[][] thePad)
    {
    if(thePad == null || thePad.length == 0 || thePad[0].length == 0)
        throw new IllegalArgumentException("Invalid pad");
    if(piece == null)
        throw new IllegalArgumentException("Invalid chess piece");

    if(piece.equalsIgnoreCase("Knight"))
        return new Knight("Knight", thePad);
    
    else if(piece.equalsIgnoreCase("Rook"))
        return new Rook("Rook", thePad);
    
    else if(piece.equalsIgnoreCase("Bishop"))
        return new Bishop("Bishop", thePad);
    
    else if(piece.equalsIgnoreCase("King"))
        return new King("King", thePad);
    
    else if(piece.equalsIgnoreCase("Queen"))
        return new Queen("Queen", thePad);
    
    else if(piece.equalsIgnoreCase("Pawn"))
        return new Pawn("Pawn", thePad);
    
    else
        return null;
}
}