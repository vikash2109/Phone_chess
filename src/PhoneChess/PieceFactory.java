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
    else
        return null;
}
}