/**
 * Our first project in PM1, TicTacToe.
 * 
 * @author Gruppe2 IT20ta_WIN
 * @version 2020-09-26
 */
public class TicTacToe
{
    /**
     * Instance of the game logic, e.g. to check if current user won
     */
    private GamelogicTTT gamelogic;

    /**
     * Instance of the acutal playing field, e.g. to print the field
     */
    private PlayingField playingField;

    /**
     * Instance for outputs (texts) for the user/player
     */
    private OutputForUser outputForUser;

    /**
     * Datafield to track if game is finished (win or tie)
     */
    private boolean isGameFinished;

    /**
     * Constructor for members of class TicTacToe with default language set
     */
    public TicTacToe() {
        this("de");
    }

    /**
     * Constructor for objects of class TicTacToe
     * @param desiredLanguage - If the overall language needs to be set initialy
     */
    public TicTacToe(String desiredLanguage)
    {
        gamelogic = new GamelogicTTT();
        playingField = new PlayingField();
        outputForUser = new OutputForUser(desiredLanguage);
        isGameFinished = false;
        startGame();
    }

    /**
     * Starts the game by printing the playground and greeting text
     */
    private void startGame()
    {
        playingField.printPlayground();
        outputForUser.printWelcomeText();
    }

    /**
     * Reads the input from the user to set his desired field if possible
     * @param desiredField - The field the current player wants to set
     */
    public void readUserInputSetDesiredField(String desiredField) {
        if(isGameFinished){
            outputForUser.printGamefinishedText();
            return;
        }
        desiredField = prepareInput(desiredField);

        if(playingField.isMovePossible(desiredField)){
            updatePlayground(desiredField);
            furtherMovesPossible(desiredField);
        } else {
            outputForUser.printOccupiedFieldText(desiredField);
        }
    }

    /**
     * Reads the input from the user to set his desired language if possible
     * @param desiredLanguage - The new language the user wants to set
     */
    public void readInputChangeLanguage(String desiredLanguage) {
        desiredLanguage = prepareInput(desiredLanguage);
        playingField.printPlayground();

        if(outputForUser.tryChangeCurrentLanguage(desiredLanguage)){
            outputForUser.printDesiredLanguageSetText();
        } else {
            outputForUser.printNotSupportedLanguageText(desiredLanguage);
        }
    }

    /**
     * Check if the game is over yet. Gives an opputrunity to restart the match
     * @param inDesiredField - The field to check, if current player managed to get 3 in a row
     */
    private void furtherMovesPossible(String inDesiredField){
        boolean didCurrentPlayerWin = gamelogic.didCurrentPlayerWin(playingField, inDesiredField);
        int freeFields = playingField.getHowManyFieldsAreFree();
        if(freeFields >= 1 && !didCurrentPlayerWin){
            // no one wins,keep playing
            playingField.switchCurrentPlayer();
            outputForUser.printMoveSwitchPlayerText(playingField.getCurrentPlayer());
            return;
        } else {
            if(didCurrentPlayerWin){
                // current user wins
                outputForUser.printGameEndWinText(playingField.getCurrentPlayer());
            } else if (freeFields == 0) {
                // tie
                outputForUser.printGameEndTieText();
            }
            isGameFinished = true;
            outputForUser.printGamefinishedText();
        }
    }

    /**
     * Sets the field (after successful validation) and prints the playground with updated fields
     * @param inDesiredField - The field that is going to be set
     */
    private void updatePlayground(String inDesiredField){
        playingField.setDesiredField(inDesiredField);
        playingField.printPlayground();
    }

    /**
     * Checks if a rematch is possible
     */
    public void requestForRematch(){
        if(isGameFinished){
            restartMatch();
        } else{
            outputForUser.printNextRoundNotPossibleYetText();
        }
    }

    /**
     * Clears all the fields and switches player, so the other one can start this time
     */
    private void restartMatch(){
        isGameFinished = false;
        outputForUser.printNextRoundText();
        playingField.resetFields();
        playingField.printPlayground();
        playingField.switchCurrentPlayer(); // because my goals are beyond your understanding
        outputForUser.printMoveSwitchPlayerText(playingField.getCurrentPlayer());
    }

    /**
     * Removes leading and tailing whitespaces and transforms the text to lower case, so validating is easier
     * @param input - The input to prepare for furthur use
     * @return the input in lower case and without whitespaces
     */
    private String prepareInput(String input){
        return input.trim().toLowerCase();
    }
    /**
     * For helping the user with the game
     */
    public void needHelp () {
        outputForUser.needHelpText();
    }
    /*
     * For debug purposes only to quickly set some fields
     * @param isSetMostOfField - If true, 8 out of 9 fields get set, if false sets only 4 fields
     */
    /* // Remove comment to quickly debug by setting fields automatically
     public void debugMode(boolean isSetMostOfField){
        // this method is here so teachers can check the functionality faster
        playingField.setFieldsToDebug(isSetMostOfField);
        playingField.printPlayground();
        outputForUser.printMoveSwitchPlayerText(playingField.getCurrentPlayer());
    }
    */
    
}