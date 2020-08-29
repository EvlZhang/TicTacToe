package com.main;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class UI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel p=new JPanel();
	public Tic t;
	XOButton buttons[]=new XOButton[9];
	
	public static void main(String args[]) {
		UI ui=new UI();
		Tic t=new Tic();
		
		//System.out.println(t.play(t.board, 2));
		
		
		
	}
	public void tick(int move) {
		int index=move-1;
		if(index<0) {
			return;
		}
		System.out.println(index+"inde");
		buttons[index].setValue(2);
		
		
	}
	public UI() {
		super("TicTacToe");
		
		setSize(400,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p.setLayout(new GridLayout(3,3));
		for(int i=0;i<9;i++) {
			buttons[i]=new XOButton(i,t,this);
			p.add(buttons[i]);
		}
		add(p);
		setVisible(true);
		
	}
}
