/**
 * This class OutputForUser contains all the output text to give information to players while gaming.
 * Additionally, it also checks and sets the desired language chosen by the players.
 * 
 * @author Gruppe2 IT20ta_WIN
 * @version 2020-09-26
 */
public class OutputForUser
{
    /*
     * Sets the default language to german 
     */
    private String currentLanguage = "de";
    
    /*
     * Sets German and English as supported languages
     */
    private String supportedLanguages = "de, en";
    
    /*
     * Output text to greet the players to the game
     */
    private String welcomeText; 
    
    /*
     * Output text to confirm that the desired language has been set
     */
    private String desiredLanguageSetText;
    
    /*
     * Output text if the desired language of the player is not supported
     */
    private String notSupportedLanguageText;
    
    /*
     * Output text to tell the players who is next
     */
    private String moveSwitchPlayerText;
    
    /*
     * Output text to let the player know that the chosen field is already occupied
     */
    private String occupiedFieldText;
    
    /*
     * Output text to inform the players that game ends in a tie
     */
    private String gameEndTieText;
    
    /*
     * Output text to inform the players that game end and who is the winner
     */
    private String gameEndWinText;
    
    /*
     * Output text to ask the player if they want to play another round
     */
    private String gamefinishedText;
    
    /*
     * Output text to confirm that the next round hast started
     */
    private String nextRoundText;
    
    /*
     * Output text to inform player that a rematch is not possible while they are still gaming
     */
    private String nextRoundNotPossibleYetText;
    
    /*
     * Output text for player, if help is needed
     */
    private String helpLanguageText;
    private String helpFieldSetText;
    private String helpPossilbeLanguagesText;
    private String helpRematchText; 
    private String helpFieldSetSyntaxText; 
    
        
    /**
     * Calls the "main" constructor but with presetted language
     */
    public OutputForUser() {
        this("de");
    }

    /**
     * Constructor for output text for different cases in the corresponding languages
     * @param language - The chosen language by user to set (only if supported)
     */
    public OutputForUser(String language) {
        boolean isUnsupported = true;
        if(isDesiredLanguageSupported(language)){
            currentLanguage = language;
            isUnsupported = false;
        } 
        initializeText();        
        if(isUnsupported){
            System.out.println(language + notSupportedLanguageText);
        }
    }

    /*
     * Initializes all the possible sentences
     */
    private void initializeText(){
        if(currentLanguage.equals("en")){
            welcomeText = "Welcome to the game TicTacToe and have fun while playing. Player X, please make your first move.";
            desiredLanguageSetText = "The desired language has been set.";
            notSupportedLanguageText = " is not supported. Please choose one from the following languages: " + getSupportedLanguages() + ".";
            moveSwitchPlayerText = ", it's your turn, please make your move.";
            occupiedFieldText = " is already occupied or an invalid field.";
            gameEndTieText = "This game ends in a tie. See you next time.";
            gameEndWinText = " wins. The game has ended. See you next time.";
            gamefinishedText = "Aww, already over? Would you like to play another round?";
            nextRoundText = "Next round starts now, have fun!";
            nextRoundNotPossibleYetText = "The game is not finished yet!";
            helpLanguageText="Choose readInputChangeLanguage() to set the prefered language.";
            helpFieldSetText= "Choose readUserInputSetDesiredField() to set the desired field.";
            helpPossilbeLanguagesText= "Supported languages: "+ getSupportedLanguages();
            helpRematchText="Choose requestForRematch() only in case of a tie or win to restart the game.";
            helpFieldSetSyntaxText = "In order to choose a field, type first the desired row then the column.";
         } else if(currentLanguage.equals("de")){
            //If nothing is set or known, go with german as default language
            welcomeText = "Herzlichen Willkommen zum Spiel TicTacToe und viel Spass. Spieler X, bitte mach deinen ersten Zug.";
            desiredLanguageSetText = "Die gewünschte Sprache wurde gesetzt.";
            notSupportedLanguageText = " wird nicht unterstuetzt, Bitte wähle einer der folgenden Sprache aus: " + getSupportedLanguages() + "." ;
            moveSwitchPlayerText = ", du bist an der Reihe. Spiel jetzt deinen Zug.";
            occupiedFieldText = " ist bereits belegt oder ein ungültiges Spielfeld.";
            gameEndTieText = "Das Spiel endet in einem Untentschieden. Bis zum nächsten Mal.";
            gameEndWinText = " gewinnt. Das Spiel ist nun beendet. Bis zum nächsten Mal";
            gamefinishedText = "Oh, schon vorbei? Wollt ihr noch eine Runde spielen?";
            nextRoundText = "Neue Runde beginnt, viel Spass!";
            nextRoundNotPossibleYetText = "Das Spiel ist noch nicht fertig!";
            helpLanguageText= "Wähle readInputChangeLanguage(), um die bevorzugte Sprache zu setzen.";
            helpFieldSetText="Wähle readUserInputSetDesiredField(), um das gewünschte Feld zu setzen.";
            helpPossilbeLanguagesText="Unterstützte Sprachen: "+ getSupportedLanguages();
            helpRematchText="Wähle requestForRematch() um das Spiel neu zustarten. Nur im Fall von Untentschieden oder Sieg.";
            helpFieldSetSyntaxText="Um ein Feld zu wählen, schreibe zunächst die gewünschte Zeile, danach die Spalte"; 
         }
    }

    /*
     * Checks if desired language is one of the supported ones.
     * @param desiredLanguage - The chosen language by a player that needs to be checked
     * @return True if the language is supported
     */
    private boolean isDesiredLanguageSupported(String desiredLanguage) {
        return supportedLanguages.contains(desiredLanguage);
    }

    /**
     * Method to change language if it is supported
     * @param desiredLanguage - The chosen language by a player that should be checked
     * @return True if the language is set
     */
    public boolean tryChangeCurrentLanguage(String desiredLanguage)
    {
        boolean languagChangedSuccessfully = false;
        if(isDesiredLanguageSupported(desiredLanguage)){
            currentLanguage = desiredLanguage;
            initializeText();
            languagChangedSuccessfully = true;
        }
        return languagChangedSuccessfully;
    }

    
    //print statements from here on, getters and setters later on

    /**
     * Method to print text that greets the players to the game
     */
    public void printWelcomeText()
    {
        System.out.println(welcomeText);
    }

    /**
     * Method to print text that language is set
     */
    public void printDesiredLanguageSetText()
    {
        System.out.println(desiredLanguageSetText);
    }

    /**
     * Method to print text that language is not supported
     * @param language - The chosen language by a player
     */
    public void printNotSupportedLanguageText(String language)
    {
        System.out.println(language + notSupportedLanguageText);
    }

    /**
     * Method to print text that it is the next player's turn
     * @param input - represents the current player
     */
    public void printMoveSwitchPlayerText(String input)
    {
        System.out.println(input + moveSwitchPlayerText);
    }

    /**
     * Method to print that the desired move is not possible
     * @param input - represents the chosen field by a player
     */
    public void printOccupiedFieldText(String input)
    {
        System.out.println(input + occupiedFieldText);
    }

    /**
     * Method to print text that game ends in a tie
     */
    public void printGameEndTieText()
    {
        System.out.println(gameEndTieText);
    }

    /**
     * Method to print text that game ends with a win
     * @param input - represents the current player who won
     */
    public void printGameEndWinText(String input)
    {
        System.out.println(input + gameEndWinText);
    }

    /**
     * Method to print text that game is finished
     */
    public void printGamefinishedText()
    {
        System.out.println(gamefinishedText);
    }

    /**
     * Method to print text that next round has begun
     */
    public void printNextRoundText()
    {
        System.out.println(nextRoundText);
    }    

    /**
     * Method to print text that starting next round is not possible yet
     */
    public void printNextRoundNotPossibleYetText()
    {
        System.out.println(nextRoundNotPossibleYetText);
    }
    /**
     * Method to print text that starting next round is not possible yet
     */
    public void needHelpText()
    { 
        System.out.println(helpFieldSetText);
        System.out.println(helpFieldSetSyntaxText);
        System.out.println(helpLanguageText);
        System.out.println(helpPossilbeLanguagesText);
        System.out.println(helpRematchText);
     }
     
        // getters and setters
    /**
     * method to get current language
     */
    public String getCurrentLanguage()
    {
        return currentLanguage;
    }

    /**
     * method to get supported languages
     */
    public String getSupportedLanguages()
    {
        return supportedLanguages;
    }
}