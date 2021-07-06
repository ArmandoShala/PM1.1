/**
 * In this class the logic is implemented to check if the current user has won or not. 
 * Different methods have been created to check the individual fields regarding to their dependencies to one another.  
 * 
 * @author Gruppe2 IT20ta_WIN
 * @version 2020-09-26
 * */
public class GamelogicTTT 
{
    /**
     * Checks vertically, horizontally and diagonally for 3 same symbols in a row. If that's the case, current player wins
     * @param currentField - describes the field given by the playground 
     * @param fieldToCheck - describes the field that is set by the current player
     * @return true, if the current player has won
     **/
    public boolean didCurrentPlayerWin(PlayingField currentField, String fieldToCheck){
        return
                checkDiagonalFields(currentField, fieldToCheck)
            ||  checkVerticalFields(currentField, fieldToCheck) 
            ||  checkHorizontalFields(currentField, fieldToCheck);
    }

    /*
     * Checks vertical fields for same symbol. If there are 3 in a row, current player wins
     * @param field - describes the field given by the playground 
     * @param fieldToCheck - describes the field that is set by the current player
     * @return true, if there are 3 in a row (columnwise)
     **/ 
    private boolean checkVerticalFields(PlayingField field, String fieldToCheck){
        String columnId = fieldToCheck.substring(1);
        boolean isThreeInARow = false;
        if (columnId.equals("1")){
            isThreeInARow = field.getA1().equals(field.getB1()) && field.getA1().equals(field.getC1()); 
        }
        if (columnId.equals("2")){
            isThreeInARow = field.getA2().equals(field.getB2()) && field.getA2().equals(field.getC2()); 
        }
        if (columnId.equals("3")){    
            isThreeInARow = field.getA3().equals(field.getB3()) && field.getA3().equals(field.getC3());            
        }
        return isThreeInARow;
    }          

    /*
     * Checks horizontal fields for same symbol. If there are 3 in a row, current player wins
     * @param field - describes the field given by the playground 
     * @param fieldToCheck - describes the field that is set by the current player
     * @return true, if there are 3 in a row (rowwise)
     **/
    private boolean checkHorizontalFields(PlayingField field, String fieldToCheck){
        String rowId = fieldToCheck.substring(0,1);
        boolean isThreeInARow = false;
        if (rowId.equals("a")) {    
            isThreeInARow = field.getA1().equals(field.getA2()) && field.getA1().equals(field.getA3()); 
        }
        if (rowId.equals("b")) {
            isThreeInARow = field.getB1().equals(field.getB2()) && field.getB1().equals(field.getB3()); 
        }
        if (rowId.equals("c")){
            isThreeInARow = field.getC1().equals(field.getC2()) && field.getC1().equals(field.getC3());
        }
        return isThreeInARow; 
    }

    /*
     * Checks diagonal fields for same symbol. If there are 3 in a row, current player wins
     * @param field - describes the field given by the playground 
     * @param fieldToCheck - describes the field that is set by the current player
     * @return true, if there are 3 in a row (in a diagonal way)
     **/
    private boolean checkDiagonalFields(PlayingField field, String fieldToCheck){
        boolean isThreeInARowLeftSide = false;
        boolean isThreeInARowRightSide = false; 
        if (fieldToCheck.equals("a1") || fieldToCheck.equals("b2") || fieldToCheck.equals("c3")) {
            isThreeInARowLeftSide = field.getA1().equals(field.getB2()) && field.getA1().equals(field.getC3()); 
        } 
        if (fieldToCheck.equals("c1") || fieldToCheck.equals("b2") || fieldToCheck.equals("a3")) {
            isThreeInARowRightSide = field.getC1().equals(field.getB2()) && field.getC1().equals(field.getA3()); 
        }
         return isThreeInARowLeftSide || isThreeInARowRightSide; 
    }
}