import java.util.Scanner;
import java.io.IOException;
import java.util.Random;



class Main {
  public static void main(String[] args) {
   // System.out.println("Hello World");
    boolean playGame = true;

    while(playGame == true){
    String[][] board = new String[3][3];
    Scanner option = new Scanner(System.in);



    System.out.println("Welcome to the tic-tac-toe game");
    System.out.println("vs computer - 1\nvs another player-2\nexit-3");
    String userChoice = option.nextLine();

    if(isNumeric(userChoice) == true){
      
      if(Integer.parseInt(userChoice) == 1)
      {
        playerVsComputer(board);

      }else if(Integer.parseInt(userChoice) == 2)
      {
        playerVsPlayer(board);
      }
      else if(Integer.parseInt(userChoice) == 3){
        playGame = false;
      }
      else
      {
        System.out.println("you entered an incorrect value ");
        
      }
    }else{
        System.out.println("you entered an incorrect value");
        
      }
      





      

    }

    

  }
  public static boolean isNumeric(String str) { 
  try {  
    Double.parseDouble(str);  
    return true;
  } catch(NumberFormatException e){  
    return false;  
  }  
}
public static void playerVsPlayer(String[][] board){
  
  boolean playerVsPlayerDuration = true;
  int player1Wins = 0;
  int player2Wins = 0;

  while(playerVsPlayerDuration ==true){
    boolean round = true;
    boolean xTurn = true;
    Scanner coordinates = new Scanner(System.in);
    String sight = "X";
    
    for(int i = 0; i < 3; i++){
      
          for(int j = 0; j < 3; j++){
              board[i][j] = "*";
              
              
            
              
          }
          

      }

    while(round == true){
      System.out.println("Player One "+player1Wins+":"+player2Wins+ " Player two");
      System.out.print("\n");


      System.out.print(" 1|2|3 \n");

      for(int i = 0; i < 3; i++){
        System.out.print(i+1);
          for(int j = 0; j < 3; j++){
              
              System.out.print(board[i][j]);
              
              if(j<2){
                  System.out.print("|");
              }
              
          }
          if(i<2){
                  System.out.print("\n"+"------"+ "\n");
              }

      }
      System.out.print("\n");
      
      boolean move = true;

      while(move){
        System.out.println("enter coordinates to make a move");
        System.out.println("It's "+sight+" turn");
      
      
        
        System.out.println("set row:");
        
        String xString = coordinates.nextLine();
        System.out.println("set column:");
        String yString = coordinates.nextLine();
        int x = 0, y = 0;
        if(isNumeric(yString) && isNumeric(xString)){

            y = Integer.parseInt(yString);
            x = Integer.parseInt(xString);  
        }

        if(x > 0 && x < 4 && y > 0 && y < 4){
          if(board[x-1][y-1] == "*"){
            board[x-1][y-1] = sight;
            move = false;

          }else{
            System.out.println("this field is already occupied");
          }
        }else{
          System.out.println("Wrong coordinates were selected");
        }

        if (winCheckRow(board, sight) == true || winCheckColumn(board, sight) || winCheckDiagonally(board, sight)){
          if(sight == "X"){
            player1Wins++;
          }
          else{
            player2Wins++;
          }
          
          System.out.print("Player "+sight+" won"+"\n");
          
          move = false;
          round = false;
          


        }
        if(boardFilled(board)){
          System.out.println("Board full filled");
          move = false;
          round = false;
        }

      }

      


        
      if(xTurn == true){
        xTurn = false;
        sight = "O";
      }else{
        xTurn = true;
        sight = "X";
      }
        
    }

    

    System.out.println("Do you want to play again? Y-1 N-2");
    boolean decision = true;

    while(decision){
      Scanner playAgainS = new Scanner(System.in);
      String playAgainString = playAgainS.nextLine();
      
      if(isNumeric(playAgainString)){
        
        int playAgain = Integer.parseInt(playAgainString);
        if(playAgain == 1 || playAgain == 2){
          decision = false;
          if(playAgain == 1){
            round = true;
      
          }else {
            playerVsPlayerDuration = false;
          }
          
        }else{
          System.out.println("choose between Yes-1 or No-2 ");
        }
      }else{
        System.out.println("Choose again");
      }
  

    }
    
}



}

public static void playerVsComputer(String[][] board){
  boolean playerVsComputerDuration = true;
  int playerWins = 0;
  int computerWins = 0;

  while(playerVsComputerDuration ==true){
    boolean round = true;
    boolean xTurn = true;
    Scanner coordinates = new Scanner(System.in);
    String sight = "X";
    
    for(int i = 0; i < 3; i++){
      
          for(int j = 0; j < 3; j++){
              board[i][j] = "*";
              
              
            
              
          }
          

      }

    while(round == true){
      System.out.println("Player"+playerWins+":"+computerWins+ " Computer");
      System.out.print("\n");


      System.out.print(" 1|2|3 \n");

      for(int i = 0; i < 3; i++){
        System.out.print(i+1);
          for(int j = 0; j < 3; j++){
              
              System.out.print(board[i][j]);
              
              if(j<2){
                  System.out.print("|");
              }
              
          }
          if(i<2){
            System.out.print("\n"+"------"+ "\n");
          }

      }
      System.out.print("\n");
      
      if(xTurn == true){
        boolean move = true;
        while(move){
        System.out.println("enter coordinates to make a move");
        System.out.println("It's Player turn");
      
      
        
        System.out.println("set row:");
        
        String xString = coordinates.nextLine();
        System.out.println("set column:");
        String yString = coordinates.nextLine();
        int x = 0, y = 0;
        if(isNumeric(yString) && isNumeric(xString)){

            y = Integer.parseInt(yString);
            x = Integer.parseInt(xString);  
        }

        if(x > 0 && x < 4 && y > 0 && y < 4){
          if(board[x-1][y-1] == "*"){
            board[x-1][y-1] = sight;
            move = false;

          }else{
            System.out.println("this field is already occupied");
          }
        }else{
          System.out.println("Wrong coordinates were selected");
        }
        
      }
      xTurn = false;
      sight = "O";
    }else{
        boolean computerMove = true;
        while(computerMove){
          Random rand = new Random();
          int computerX = rand.nextInt(3);
          int computerY = rand.nextInt(3);

          if(board[computerX][computerY]== "*"){
            board[computerX][computerY] = sight;
            computerMove = false;
          }

        }
      
      
      
      xTurn = true;



      sight = "X";
      }
      if (winCheckRow(board, sight) == true || winCheckColumn(board, sight) || winCheckDiagonally(board, sight)){
        if(sight == "X"){
          playerWins++;
        }
        else{
        computerWins++;
      }
      
      System.out.print("Player "+sight+" won"+"\n");
      
      
      round = false;
      
      
      
    }
    
    if(boardFilled(board)){
      System.out.println("Board full filled");
      
      round = false;
    }
      

      


        
        
    }

    

    System.out.println("Do you want to play again? Y-1 N-2");
    boolean decision = true;

    while(decision){
      Scanner playAgainS = new Scanner(System.in);
      String playAgainString = playAgainS.nextLine();
      
      if(isNumeric(playAgainString)){
        
        int playAgain = Integer.parseInt(playAgainString);
        if(playAgain == 1 || playAgain == 2){
          decision = false;
          if(playAgain == 1){
            round = true;
      
          }else {
            playerVsComputerDuration = false;
          }
          
        }else{
          System.out.println("choose between Yes-1 or No-2 ");
        }
      }else{
        System.out.println("Choose again");
      }
  

    }
    
}

}



public static boolean winCheckRow(String[][] board, String symbol){
  int symbolCounter = 0;
  for(int i  = 0; i < 3; i++){
    for(int j = 0; j < 3; j++){
      if(board[i][j] == symbol){
        symbolCounter++;
        if(symbolCounter == 3){
          return true;
        }
      }else{
        symbolCounter = 0;
      }

    }
    symbolCounter = 0;
  }
  return false;
  
}
public static boolean winCheckColumn(String[][] board, String symbol){
  int symbolCounter = 0;

  for(int i  = 0; i < 3; i++){
    for(int j = 0; j < 3; j++){
      if(board[j][i] == symbol){
        symbolCounter++;
        if(symbolCounter == 3){
          return true;
        }
      }else{
        symbolCounter = 0;
      }

    }
    symbolCounter = 0;
  }
  return false;
  



}
public static boolean winCheckDiagonally(String[][] board, String symbol){
  if((board[0][0] == symbol && board[1][1] == symbol && board[2][2]== symbol) || (board[0][2] == symbol && board[1][1] == symbol && board[2][0]== symbol)){
    return true;
  }
  else{
    return false;
  }
}
public static boolean boardFilled(String[][] board){
  int counter = 0;
  for(int i  = 0; i < 3; i++){
    for(int j = 0; j < 3; j++){
      if(board[i][j] != "*"){
        counter++;
        if(counter == 9){
          return true;
        }
      }else{
        counter = 0;
      }

    }
  }
  return false;


}




  
}