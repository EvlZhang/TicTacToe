package com.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.HashMap;

public class XOButton extends JButton implements ActionListener{
	



	/**
	 * 
	 */
	private static final long serialVersionUID = -4009464866791102945L;


	static int[][] board;
	
	
	ImageIcon X,O;
	int value=0; 
	Tic t;
	int num=2;
	UI ui;
	Boolean clicked=false;
	HashMap<Integer,Integer[]> hm;
	// 0:nothing 1:X 2:O
	public XOButton(int num,Tic t,UI ui) {
		this.t=t;
		this.num=num;
		this.ui=ui;
		this.hm=new HashMap<Integer,Integer[]>();
		X=new ImageIcon(this.getClass().getResource("X.png"));
		O=new ImageIcon(this.getClass().getResource("O.png"));
		this.addActionListener(this);
		board=new int[3][3];
		for(int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				board[i][j]=0;
			}
		}
		
	}
	public void setValue(int val) {
		this.value=val;
		this.setIcon(O);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		value=1;
		setIcon(X);
		this.clicked=true;
		if(num==0) {
			board[0][0]=1;
			System.out.println(this.play(board, num));
			finalMove=selectMove();
			ui.tick(finalMove);
			
		}
		else if(num==1) {
			board[0][1]=1;
			System.out.println(this.play(board, num));
			finalMove=selectMove();
			ui.tick(finalMove);
		}
		else if(num==2) {
			board[0][2]=1;
			System.out.println(this.play(board, num));
			finalMove=selectMove();
			ui.tick(finalMove);
		}
		else if(num==3) {
			board[1][0]=1;
			System.out.println(this.play(board, num));
			finalMove=selectMove();
			ui.tick(finalMove);
		}
		else if(num==4) {
			board[1][1]=1;
			System.out.println(this.play(board, num));
			finalMove=selectMove();
			ui.tick(finalMove);
		}
		else if(num==5) {
			board[1][2]=1;
			System.out.println(this.play(board, num));
			finalMove=selectMove();
			ui.tick(finalMove);
		}
		else if(num==6) {
			board[2][0]=1;
			System.out.println(this.play(board, num));
			finalMove=selectMove();
			ui.tick(finalMove);
		}
		else if(num==7) {
			board[2][1]=1;
			System.out.println(this.play(board, num));
			finalMove=selectMove();
			ui.tick(finalMove);
		}
		else if(num==8) {
			board[2][2]=1;
			System.out.println(this.play(board, num));
			finalMove=selectMove();
			ui.tick(finalMove);
		}
		for(int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				//System.out.println(board[i][j]);
			}
		}
	}
	
		
	
	
	 int netwins=0;
	 int pwins=0;
	 int cwins=0;
	 int theMove=0;
	 int finalMove=0;
	 int difference=0;
	 Integer[] store=new Integer[2];
	 
	public int selectMove() {
		int move=0;
		for(int i=0;i<hm.size();i++) {
			for(int j=0;j<hm.get(i).length;j++) {
				System.out.println(hm.get(i)[j]);
				move=hm.get(i)[0];
			}
		}
		return move;
	}
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
						//calculate which tile the move is
						if(i==0) {
							if(j==0) theMove=1;
							else if(j==1) theMove=2;
							else if(j==2) theMove=3;
						}
						else if(i==1) {
							if(j==0) theMove=4;
							else if(j==1) theMove=5;
							else if(j==2) theMove=6;
						}
						else if(i==2) {
							if(j==0) theMove=7;
							else if(j==1) theMove=8;
							else if(j==2) theMove=9;
						}
						if(num==2) {
							num=1;
						}
						else {
							num=2;
						}
						
						play(nb,num);
						
						netwins=cwins-pwins;
						if (netwins>difference) {
							finalMove=theMove;
							difference=netwins;
						}
						store[0]=theMove;
						store[1]=netwins;
						hm.put(i,store);
						
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
						//System.out.println("row win");
						return i;
						
					}
					if(j==0) {
						if(board[1][1]==i&&board[2][2]==i) {
							//System.out.println("diagnal win");
							return i;
						}
					}
					else if(j==2) {
						if(board[1][1]==i&&board[0][2]==i) {
							//System.out.println("diagnal win");
							return i;
						}
					}
				}
				if(board[0][j]==i) {
					if(board[1][j]==i&&board[2][j]==i) {
						//System.out.println("column win");
						return i;
					}
				}
			}
		}
		return 0;
		
	}

	
}
