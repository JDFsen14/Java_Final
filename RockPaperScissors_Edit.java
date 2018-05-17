import java.util.Scanner;
import java.lang.String;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RockPaperScissors_Edit implements ActionListener
{
	String playerHand = "";
	final String ROCK = "rock";
	final String PAPER = "paper";
	final String SCISSORS = "scissors";
	
	final String QUIT = "q";
	final String LOSS_MSG = "You lost!";
	final String WIN_MSG = "You won!";
	final String TIE_MSG = "Tie!";
	
	Random rand = new Random();
	
	String computerHand = "";
	String roundResult = "You threw %s, computer threw %s\n";
	String scoreMsg = "Player Score: %d, Computer Score: %d\n\n";
	String winnerMsg = "";
	int playerScore = 0;
	int computerScore = 0;
	
	JLabel user = new JLabel("Click a button below");
	JLabel comp = new JLabel("");
	JLabel round = new JLabel("");
	JLabel score = new JLabel("");
	JButton rock = new JButton("Rock");
	JButton paper = new JButton("Paper");
	JButton scissors = new JButton("Scissors");

	
	public RockPaperScissors_Edit() 
	{
		
		JFrame frame = new JFrame("Rock, Paper, Scissors");
		frame.setSize(400, 400);
		frame.setLayout(new FlowLayout());
			
		frame.add(user);
		frame.add(rock);
		frame.add(paper);
		frame.add(scissors);
		frame.add(comp);
		frame.add(round);
		frame.add(score);
		frame.setVisible(true);
		
		rock.addActionListener(this);
		paper.addActionListener(this);
		scissors.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Rock"){
			playerHand = ROCK;
		}
		else if(e.getActionCommand() == "Paper"){
			playerHand = PAPER;
		}
		else{
			playerHand = SCISSORS;
		
			}
			
			boolean inputValid = true;
			
			//Computer
			int tempHand = rand.nextInt(3);
			switch (tempHand) 
			{
			case 0:
				computerHand = ROCK;
				break;
			case 1:
				computerHand = PAPER;
				break;
			case 2:
				computerHand = SCISSORS;
				break;
			}
			
			//Tie
			if (playerHand.equals(computerHand))
			{
				winnerMsg = TIE_MSG;
			}
			else
			{
				//Winner
				switch (computerHand)
				{
				case ROCK:
					if (playerHand.equals(PAPER))
					{
						winnerMsg = WIN_MSG;
						playerScore++;
					}
					else if (playerHand.equals(SCISSORS))
					{
						winnerMsg = LOSS_MSG;
						computerScore++;
					}
					break;
					
				case PAPER:
					if (playerHand.equals(ROCK))
					{
						winnerMsg = LOSS_MSG;
						computerScore++;
					}
					else if (playerHand.equals(SCISSORS))
					{
						winnerMsg = WIN_MSG;
						playerScore++;
					}
					break;
					
				case SCISSORS:
					if (playerHand.equals(ROCK))
					{
						winnerMsg = WIN_MSG;
						playerScore++;
					}
					else if (playerHand.equals(PAPER))
					{
						winnerMsg = LOSS_MSG;
						computerScore++;
					}
					break;
				}
		}
		comp.setText("You threw " + playerHand + ", computer threw " + computerHand + "\n");
		round.setText(winnerMsg);
		score.setText("Player Score: " + playerScore + ", Computer Score: " + computerScore + "\n\n");
	}
}

class Demo 
{
	public static void main(String[] args){
		RockPaperScissors_Edit game = new RockPaperScissors_Edit();
	}
}