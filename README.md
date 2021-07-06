## TIC-TAC-TOE

Welcome to our first Tic-Tac-Toe Project. 

Tic-Tac-Toe is a game played by two people either an X or an O in an open block of nine squares.
Each player tries to complete a vertical, horizontal or diagonal row of his symbol before the other player can. In this game it is possible to choose between the languages English and German. 

Have fun playing! 

### USER INSTRUCTIONS: 
- Create an instance of TicTacToe by right-clicking on the class TicTacToe . If you want to change the language (default DE) to English at the beginning, you can select the constructor with the parameter 
`desiredLanguage()` and enter "en". 

- Click on the method `readUserInputSetDesiredField()` to set the desired field. Illegal moves like setting a field which is already set or outside the given fields are checked and are therefore not possible. 
   
  |     | 1           | 2          | 3          |
  |:---:|     :---:   |  :---:     |    :---:   |
  | A   | A1          | A2         |      A3    |
  | B   |      B1     |      B2    |      B3    |
  | C   | C1          |      C2    |      C3    |


- By choosing the method `readInputChangeLanguage()`
it is also possible to change the language during the game. 

- If someone has won or the game ends in a tie you can restart a new game with the method `requestForRematch()` . It will print a new playground and will automatically switch the current player.  

- If help is needed, the method `needHelp()`prints the user guidance. 

- We also created  a `debugMode()`method for easing the debugging. For a release it is possible to unable the method by commenting it out in the TicTacToe class. 


### SUPPORTED LANGUAGE
These languages are supported at the moment
- German (de) - default
- English (en)

### TECHNICAL INFORMATION:
- version: v1.0 

- Java version: openjdk 11.0.8 2020-07-14 LTS

- IDE: Bluej (4.2.2)

### AUTHORS: 
- Armando Shala (shalaar3) 
- Daae Suh (suhdaa01)
- Benssy Kolattukudy (kolatben)
