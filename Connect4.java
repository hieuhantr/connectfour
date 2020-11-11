import java.util.Scanner;
import java.util.Random;
public class Connect4 {

	public static void main(String[] args) {
		
		//declare and initialize values
		boolean tie = false, winner = false;
		int turn=1;
		char currentPlayer = ' ';
		char [][] board = new char [6][7];
		Scanner keyboard = new Scanner(System.in);
		int selection;
		char winnerChar = ' ';
		boolean validPlay=false;
		
		
		//initialize values for board
		 for (int row=0; row<6; row++)
		 {
			 for (int column=0; column<7; column++)
			 {
				 board[row][column]=' ';
			 }
		 }
			
		 
		 //perform each turn
		 do
		 {
		//see whose turn it is and randomize for O
			if (turn%2 == 0)
				{currentPlayer= 'O';
				Random rand = new Random();
				selection = rand.nextInt(7);
				}
			else
				{ currentPlayer = 'X';
		
				//print the board for X
				printBoard(board);
		
		
				//have user select a spot (validate if input is valid, then check if each row (in selection column) is occupied)
				do
				{	
			System.out.println("Player " + currentPlayer +", pick a column from 0 to 6 to put your checker: ");
			selection = keyboard.nextInt();
			//check if valid column
			if (selection >=0 && selection <=6)
				validPlay=true;
			else
				{
				validPlay=false;
				}
				//check if column is full
			if (validPlay==true)
			{
			if (board[0][selection]=='X' || board[0][selection]=='O')
					{ 
					validPlay=false;
					}
			}
				} while (validPlay==false); 
				}
		
		//for both X and O, check which row is empty
		 for (int row=5; row>=0; row--)
			{
				if (board[row][selection]==' ')
				{
				board[row][selection]=currentPlayer;
				winnerChar = currentPlayer;
				//change turn
				turn++;
				//call winner method
				winner = isWinner(currentPlayer,board);
				//check if the board is filled
				if (turn==43)
					tie=true;
				break;
				}
			}
			
		 } while (winner==false && tie==false);

		//reprint the board if there's a winner or if it's a tie

		 printBoard(board);
		 
	
		//Print if there is winner	
		 if(winner)
			 
			 System.out.println("Congratulations player " + winnerChar +", you won!");

			 //print if there is a tie
		 	else if(tie)

			 System.out.println("The board is filled, it's a tie.");

			 }


	
	//print the current state of the board
public static void printBoard(char[][]board)
{
	System.out.println(" 0 | 1 | 2 | 3 | 4 | 5 | 6 ");
	System.out.println("---|---|---|---|---|---|---");
	for (int row=0; row < 6; row++)
	{
		for (int column=0; column<7; column++)
		{
		System.out.print(" "+ board[row][column] +"  ");
		}
		System.out.println();
		System.out.println("---|---|---|---|---|---|---");
	}
}

			
		 
	//check if there is a winner
public static boolean isWinner(char currentPlayer, char[][] board){
		//check vertically
				for(int row = 0; row < board.length - 3; row++){
					for(int  column = 0;  column < board[0].length;  column++){
						if (board[row][ column] == currentPlayer   &&    
								board[row+1][ column] == currentPlayer &&   
									board[row+2][ column] == currentPlayer &&
											board[row+3][ column] == currentPlayer){
							return true;
						}
					}
				}
		//check horizontally
						for(int row = 0; row<board.length; row++){
							for (int column = 0; column < board[0].length - 3; column++){
								if (board[row][ column] == currentPlayer   && 
										board[row][ column+1] == currentPlayer &&
												board[row][ column+2] == currentPlayer &&
														board[row][ column+3] == currentPlayer){
							return true;
						}
					}			
				}
		//check downward diagonal
				for(int row = 0; row < board.length - 3; row++){
					for(int  column = 0;  column < board[0].length - 3;  column++){
						if (board[row][ column] == currentPlayer   && 
								board[row+1][ column+1] == currentPlayer &&
										board[row+2][ column+2] == currentPlayer &&
												board[row+3][ column+3] == currentPlayer){
							return true;
						}
					}
				}
				//check upward diagonal
						for(int row = 3; row < board.length; row++){
							for(int  column = 0;  column < board[0].length - 3;  column++){
								if (board[row][ column] == currentPlayer   && 
										board[row-1][ column+1] == currentPlayer &&
												board[row-2][ column+2] == currentPlayer &&
														board[row-3][ column+3] == currentPlayer){
									return true;
						}
					}
				}
				return false;
				}
				
					
				}



	

		
		
			
				
			
			
			
	

	
		

