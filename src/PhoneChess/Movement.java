package PhoneChess;

import java.util.List;

public interface Movement 
{
public Integer findNumbers(PadNumber start, Integer digits);
public List<PadNumber> allowedMoves(PadNumber from);
}