
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Chomp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=3;
		new MyFrame(a);
	}

}

class MyFrame extends JFrame implements ActionListener{
	JButton easy,medium,hard,playAgain;
	JButton[][] btn;
	JPanel topPanel, bottomPanel;
	JLabel label;

	int size;
	int turn;
	int x;
	int y;
//	boolean gameOver=false;
	int rand1,rand2;
	boolean loop;
	
	public MyFrame(int size) {
		this.size = size;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(400, 200, 700, 400);
//		this.setLayout(new FlowLayout());
		
		
		
//	SETTING DIVVICULTY BUTTONS	
//		fullPanel = new JPanel( new BorderLayout());
//		topPanel.setLayout();
		topPanel=new JPanel(new FlowLayout());
//		fullPanel.add(topPanel,BorderLayout.NORTH);
		easy=new JButton("SMALL");
		medium=new JButton("MEDIUM");
		hard=new JButton("LARGE");
		playAgain=new JButton("PLAY AGAIN!!");
		label=new JLabel("Player 1 turn");
		topPanel.add(label);
		topPanel.add(easy);
		topPanel.add(medium);
		topPanel.add(hard);
		topPanel.add(playAgain);
		

		
		
		easy.addActionListener(this);
		medium.addActionListener(this);
		hard.addActionListener(this);
		playAgain.addActionListener(this);
		
//		initialize(3);
		bottomPanel = new JPanel(new GridLayout(size,size,1,1));
		btn=new JButton[size][size];
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if (i==0 && j==0) {
					btn[i][j]=new JButton("SOAP");
					bottomPanel.add(btn[i][j]);
					btn[i][j].setOpaque(true);
					btn[i][j].setContentAreaFilled(true);
					btn[i][j].setBorderPainted(false);
					btn[i][j].setBackground(new Color(12,135,22));
					
					btn[i][j].addActionListener(this);
				}else {
					btn[i][j]=new JButton();
					bottomPanel.add(btn[i][j]);
					btn[i][j].setOpaque(true);
					btn[i][j].setContentAreaFilled(true);
					btn[i][j].setBorderPainted(false);
					btn[i][j].setBackground(new Color(123,63,0));
					btn[i][j].addActionListener(this);
				}
	
			}		
		}


		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(topPanel,BorderLayout.NORTH);
		getContentPane().add(bottomPanel,BorderLayout.CENTER);
		setVisible(true);
		this.setResizable(false);
		
		
		
	}		
//	public static double getRandomIntegerBetweenRange(int size){
//	    double x = (int)(Math.random()*size);
//	    return x;
//	}
		

	public void actionPerformed(ActionEvent e) {


		if(e.getSource()==easy) {
			size = 3;
			new MyFrame(size);
			setVisible(false);
		
		}else if(e.getSource()==medium) {
			size = 5;
			setVisible(false);

			new MyFrame(size);
		}else if(e.getSource()==hard) {
			size = 7;
			setVisible(false);
			new MyFrame(size);
		}else if(e.getSource()==playAgain) {
			size = 3;
			new MyFrame(size);
			setVisible(false);
		}
		
		turn=1;
		if (turn==1) {
			label.setText("Player 1 turn" );
			if(btn[0][1].isEnabled()==true || btn[1][0].isEnabled()==true) {
				try {
					for(int i=0;i<size;i++) {
						for (int j=0;j<size;j++) {
							if (e.getSource()==btn[i][j]) {
								x=i;
								y=j;
								for(int k=i;k<size;k++)
									for(int l=j;l<size;l++) {
										btn[k][l].setEnabled(false);
										btn[k][l].setBackground(Color.white);
										
									}
							}
						}
					}
					turn=2;
					
//					Timer timer=new Timer(12, this);
//				    timer.setInitialDelay(0);
////				    timer.setDelay(25);
////				    timer.restart();
//					timer.start();
//					timer.stop();
					
				}catch(Exception ignore) {}
			}
			else if((e.getSource()!=easy)&&(e.getSource()!=medium)&&(e.getSource()!=hard)&&(e.getSource()!=playAgain)){
//				gameOver=true;
//				System.out.println("Player 1 loses.");
				label.setText("Player 1 loses");
			}
			

		}

		if (turn==2) {
			loop=false;
			label.setText("Computer's turn" );
			if(x==0 && y==0) {
				label.setText("Player 1 loses");
				loop=true;
			}
			if((btn[0][1].isEnabled()==false && btn[1][0].isEnabled()==false)&&!(x==0 && y==0)){
				label.setText("Computer Loses!" );
				loop=true;
			}
			
			rand1=(int)(Math.random()*size);
			rand2=(int)(Math.random()*size);
			new Timer(1400, new ActionListener() {
	            @Override 
	            public void actionPerformed(ActionEvent e) {
	              
	              while(loop==false) {

	  				if(((rand1<=x && rand2<=y)&&((rand1==x && rand2!=y)||(rand1!=x && rand2==y)) && !(rand1==0 && rand2==0) ||(x==0 && y==1)||(x==1 && y==0))) {
////	  					System.out.println("moved to turn2");
//	  					System.out.println(rand1);
//	  					System.out.println(rand2);
//	  						

	  					
	  					if(btn[0][1].isEnabled()==true || btn[1][0].isEnabled()==true) {
	  						try {
//	  							btn[rand1][rand2].doClick(12);
	  							if(btn[1][0].isEnabled()==false) {
	  								rand1=0;
	  							}
	  							else if(btn[0][1].isEnabled()==false) {
	  								rand2=0;
	  							}

	  							for(int k=rand1;k<size;k++) {
	  								for(int l=rand2;l<size;l++) {
	  									if(btn[k][l].isEnabled()) {
	  										btn[k][l].setEnabled(false);
	  										btn[rand1][rand2].setBackground(new Color(85,43,0));
	  										btn[k][l].setBackground(Color.white);
	  										btn[rand1][rand2].setBackground(Color.white);
	  									}						
	  								}
	  							}
	  							turn=1;
	  							if(btn[0][1].isEnabled()==false && btn[1][0].isEnabled()==false) {
	  								loop=true;
//	  								System.out.println("Player 1 loses!");
	  								label.setText("Player 1 loses!" );
	  								break;
	  							}
	  							
	  							
	  						}catch(Exception ignore) {}
	  					}else if (btn[0][1].isEnabled()==false && btn[1][0].isEnabled()==false){
//	  						gameOver=true;
//	  						loop=true;
//	  						System.out.println("Computer Loses!");
//	  						label.setText("Computer Loses!" );
	  					}
	  					loop=true;

	  				}else {
//	  					turn=1;
	  					rand1=(int)(Math.random()*size);
	  					rand2=(int)(Math.random()*size);
	  				}
	  				label.setText("Player 1 turn");
	  				
	  			  }
	              
	            }
	          }).start();
			
			
			
			

		}

	}
	
}