package labb2;

class FifteenModel implements Boardgame {
	
	private String currentMessage = "No message yet";
	private String[][] board = new String[4][4];   
	public int iemp, jemp;                        

	
	public boolean move(int i, int j) {
		if ((iemp == i+1 || iemp == i-1) && jemp == j && board[i][j] != "  ") {
			String temp = board[i][j];
			board[i][j] = "  ";
			board[iemp][jemp] = temp;
			iemp = i;
			jemp = j;
			currentMessage = "OK";
			return true;
			
		}
		else if ((jemp == j+1 || jemp == j-1) && iemp == i && board[i][j] != "  ") {
			String temp = board[i][j];
			board[i][j] = "  ";
			board[iemp][jemp] = temp;
			iemp = i;
			jemp = j;
			currentMessage = "OK";
			return true;
		}
		else if (i > 3 || j > 3) {
			currentMessage = "Please choose a position within the board!";
			return false;
		}
		else {
			currentMessage = "Please choose a position next to the empty one!";
			return false;
		}
	}
	
	public String getStatus(int i, int j) {
		return board[i][j];
	}

	public String getMessage() {
		return currentMessage;
	}

}