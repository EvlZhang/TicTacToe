package com.main;

public class Tic {
	static int[][] board;
	public Tic() {
		board=new int[3][3];
		for(int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				board[i][j]=0;
			}
		}
		
	}
	
	int num=2;
	static int pwins=0;
	static int cwins=0;
	public int play(int[][] board,int num) {
		
		if(checkBoard(board)!=0) {
			if(checkBoard(board)==1) {
				pwins++;
				return 1;
			}
			else {
				cwins++;
				return 2;
			}
		}
		else {
			for(int i=0;i<3;i++) {
				for (int j=0;j<3;j++) {
					if(board[i][j]==0) {
						int[][] nb=new int[3][3];
						for(int x=0;x<3;x++) {
							for (int y=0;y<3;y++) {
								nb[x][y]=board[x][y];
								
							}
						}
						nb[i][j]=num;
						if(num==2) {
							num=1;
						}
						else {
							num=2;
						}
						play(nb,num);
					}
					
				}
			}
		}
		return cwins;
	}
	public int checkBoard(int[][] board) {
		//going through players
		
		for (int i=1;i<=2;i++) {
			//going through grid
			for(int j=0;j<=2;j++) {
				if(board[j][0]==i) {
					if(board[j][1]==i&&board[j][2]==i) {
						System.out.println("row win");
						return i;
						
					}
					if(j==0) {
						if(board[1][1]==i&&board[2][2]==i) {
							System.out.println("diagnal win");
							return i;
						}
					}
					else if(j==2) {
						if(board[1][1]==i&&board[0][2]==i) {
							System.out.println("diagnal win");
							return i;
						}
					}
				}
				if(board[0][j]==i) {
					if(board[1][j]==i&&board[2][j]==i) {
						System.out.println("column win");
						return i;
					}
				}
			}
		}
		return 0;
		
	}
}
