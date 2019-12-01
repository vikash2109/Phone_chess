package PhoneChess;

import java.util.List;

public interface Movement 
{
public Integer findNumbers(PadNumber start, Integer digits);
public abstract boolean canMove(PadNumber from, PadNumber to);
public List<PadNumber> allowedMoves(PadNumber from);
public Integer countAllowedMoves(PadNumber from);
}