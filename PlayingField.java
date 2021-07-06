/**
 * Represents the PlayingField, where fields, player and stuff are.
 * 
 * @author Gruppe2 IT20ta_WIN
 * @version 2020-09-26
 */
public class PlayingField
{
    /**
     * Symbol to set in the field, player 1
     */
    private String symbolPlayer1 = "X";

    /**
     * Symbol to set in the field, player 2
     */
    private String symbolPlayer2 = "O";

    /**
     * Set current player to symbol
     */
    private String currentPlayer = symbolPlayer1;

    /**
     * String to fill empty fields
     */
    private String symbolFreeField = " ";

    /**
     * Field in Playground (Syntax: YX) with init value from {@link #symbolFreeField} 
     */
    private String a1 = symbolFreeField;

    /**
     * Field in Playground (Syntax: YX) with init value from {@link #symbolFreeField} 
     */
    private String a2 = symbolFreeField;

    /**
     * Field in Playground (Syntax: YX) with init value from {@link #symbolFreeField} 
     */
    private String a3 = symbolFreeField;

    /**
     * Field in Playground (Syntax: YX) with init value from {@link #symbolFreeField} 
     */
    private String b1 = symbolFreeField;

    /**
     * Field in Playground (Syntax: YX) with init value from {@link #symbolFreeField} 
     */
    private String b2 = symbolFreeField;

    /**
     * Field in Playground (Syntax: YX) with init value from {@link #symbolFreeField} 
     */
    private String b3 = symbolFreeField;

    /**
     * Field in Playground (Syntax: YX) with init value from {@link #symbolFreeField} 
     */
    private String c1 = symbolFreeField;

    /**
     * Field in Playground (Syntax: YX) with init value from {@link #symbolFreeField} 
     */
    private String c2 = symbolFreeField;

    /**
     * Field in Playground (Syntax: YX) with init value from {@link #symbolFreeField} 
     */
    private String c3 = symbolFreeField;

    /**
     * Constructor for objects of class PlayingField
     */
    public PlayingField()
    {
    }

    /**
     * Resets all the fields to the preset symbol for empty field
     */
    public void resetFields(){
        a1 = getSymbolFreeField();
        a2 = getSymbolFreeField();
        a3 = getSymbolFreeField();
        b1 = getSymbolFreeField();
        b2 = getSymbolFreeField();
        b3 = getSymbolFreeField();
        c1 = getSymbolFreeField();
        c2 = getSymbolFreeField();
        c3 = getSymbolFreeField();
    }

    /**
     * Prints the playground to the console with the values of the fields
     */
    public void printPlayground() {
        System.out.println("  | 1 | 2 | 3 |");
        System.out.println("A | " + getA1() + " | " + getA2() + " | " + getA3() + " | ");
        System.out.println("B | " + getB1() + " | " + getB2() + " | " + getB3() + " | ");
        System.out.println("C | " + getC1() + " | " + getC2() + " | " + getC3() + " | ");
    }

    /**
     * Logic to alternate between players.
     */
    public void switchCurrentPlayer(){
        if(currentPlayer.equals(symbolPlayer1)){
            setCurrentPlayer(symbolPlayer2);
        } else {
            setCurrentPlayer(symbolPlayer1);
        } 
    }

    /**
     * If input is valid, desired field is set with value of current players symbol
     * @param field - The fields to set
     */
    public void setDesiredField(String field){
        if(field.equals("a1")){
            setA1(currentPlayer);
        } else if(field.equals("a2")){
            setA2(currentPlayer);
        } else if(field.equals("a3")){
            setA3(currentPlayer);
        } else if(field.equals("b1")){
            setB1(currentPlayer);
        } else if(field.equals("b2")){
            setB2(currentPlayer);
        } else if(field.equals("b3")){
            setB3(currentPlayer);
        } else if(field.equals("c1")){
            setC1(currentPlayer);
        } else if(field.equals("c2")){
            setC2(currentPlayer);
        } else if(field.equals("c3")){
            setC3(currentPlayer);
        } else{
            System.out.println("this should not have happened. Please contact support: +1 (800) MY–APPLE");
            //something went wrong, now its big brain time;
        }
    }

    /**
     * Encapsuling method to check if input is valid and field is free
     * @param fieldToCheck - The field that needs to be checked
     * @return True if move is possible
     */
    public boolean isMovePossible(String fieldToCheck) {
        return isInputWithinRange(fieldToCheck) && isFieldOccupied(fieldToCheck);
    }

    /**
     * Checks if input is within bounderies of playground
     * @param fieldToCheck - The field that needs to be checked
     * @return True if field is within bounderies of playground
     */
    private boolean isInputWithinRange(String fieldToCheck) {
        return "a1,a2,a3,b1,b2,b3,c1,c2,c3".contains(fieldToCheck);
    }

    /**
     * Checks if field has already a value other than a blank
     * @param fieldToCheck - The field that needs to be checked
     * @return True if field is occupied
     */
    private boolean isFieldOccupied(String fieldToCheck) {
        if(fieldToCheck.equals("a1")){
            return getA1().equals(symbolFreeField);
        } else if(fieldToCheck.equals("a2")){
            return getA2().equals(symbolFreeField);
        } else if(fieldToCheck.equals("a3")){
            return getA3().equals(symbolFreeField);
        } else if(fieldToCheck.equals("b1")){
            return getB1().equals(symbolFreeField);
        } else if(fieldToCheck.equals("b2")){
            return getB2().equals(symbolFreeField);
        } else if(fieldToCheck.equals("b3")){
            return getB3().equals(symbolFreeField);
        } else if(fieldToCheck.equals("c1")){
            return getC1().equals(symbolFreeField);
        } else if(fieldToCheck.equals("c2")){
            return getC2().equals(symbolFreeField);
        } else if(fieldToCheck.equals("c3")){
            return getC3().equals(symbolFreeField);
        } else{
            return false;
            //something went wrong, now its big brain time;
        }
    }

    /**
     * Checks how many fields are free
     * @return The number of free fields
     */
    public int getHowManyFieldsAreFree(){
        int freeFields = 0;
        if(getA1().equals(symbolFreeField)){
            freeFields++;
        }

        if(getA2().equals(symbolFreeField)){
            freeFields++;
        }

        if(getA3().equals(symbolFreeField)){
            freeFields++;
        }

        if(getB1().equals(symbolFreeField)){
            freeFields++;
        }

        if(getB2().equals(symbolFreeField)){
            freeFields++;
        }

        if(getB3().equals(symbolFreeField)){
            freeFields++;
        }

        if(getC1().equals(symbolFreeField)){
            freeFields++;
        }

        if(getC2().equals(symbolFreeField)){
            freeFields++;
        }

        if(getC3().equals(symbolFreeField)){
            freeFields++;
        }
        return freeFields;
    }

    /**
     * For debug purposes only. If wished to be used, remove comment in TicTacToe
     * @param isSetMostOfField - If true, 8 out of 9 fields get set, if false sets only 4 fields
     */
    public void setFieldsToDebug(boolean isSetMostOfField){
        // This is ment to be only here for devs, so its a bit bareboned
        a1 = "O";
        a2 = "X";
        b1 = "O";
        b2 = "X";
        if(isSetMostOfField){
            a2 = "O";
            a3 = "O";
            b3 = "X";
            c1 = "X";
            c3 = "X";
        }
    }

    // Getters and setters beyond this point only
    public String getSymbolFreeField(){
        return symbolFreeField;
    }

    private void setSymbolFreeField(String inSymbolFreeField){
        symbolFreeField = inSymbolFreeField;
    }

    public String getSymbolPlayer1(){
        return symbolPlayer1;
    }

    private void setSymbolPlayer1(String inSymbol){
        symbolPlayer1 = inSymbol;
    }

    public String getSymbolPlayer2(){
        return symbolPlayer2;
    }

    private void setSymbolPlayer2(String inSymbol){
        symbolPlayer2 = inSymbol;
    }

    public String getCurrentPlayer(){
        return currentPlayer;
    }

    private void setCurrentPlayer(String inCurrentPlayer){
        currentPlayer = inCurrentPlayer;
    }

    public String getA1(){
        return a1;
    }

    private void setA1(String inValue){
        a1 = inValue;
    }

    public String getA2(){
        return a2;
    }

    private void setA2(String inValue){
        a2 = inValue;
    }

    public String getA3(){
        return a3;
    }

    private void setA3(String inValue){
        a3 = inValue;
    }

    public String getB1(){
        return b1;
    }

    private void setB1(String inValue){
        b1 = inValue;
    }

    public String getB2(){
        return b2;
    }

    private void setB2(String inValue){
        b2 = inValue;
    }

    public String getB3(){
        return b3;
    }

    private void setB3(String inValue){
        b3 = inValue;
    }

    public String getC1(){
        return c1;
    }

    private void setC1(String inValue){
        c1 = inValue;
    }

    public String getC2(){
        return c2;
    }

    private void setC2(String inValue){
        c2 = inValue;
    }

    public String getC3(){
        return c3;
    }

    private void setC3(String inValue){
        c3 = inValue;
    }
}