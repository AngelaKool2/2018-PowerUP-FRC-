package org.usfirst.frc.team7327.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;


public class Group0 
{
	
	DoubleSolenoid.Value Puncher = DoubleSolenoid.Value.kOff;
	DoubleSolenoid.Value Hands =  DoubleSolenoid.Value.kOff;
	double throttleX = 0.30;
	
	
	
	public static void WhileLoops()
	{
		int counter = 0;
		while (counter < 21)
		{
			Robot.MoveForward();
			counter++;
		}
		Robot.TurnLeft();
		Robot.TurnLeft();
		counter = 0;
		while (counter < 21)
		{
			Robot.MoveForward();
			counter++;
		}
		
	}
	
	public static void OneWhile()
	{
		int counter = 0;
		while (counter < 42) 
		{
			Robot.MoveForward();
			if (counter == 21)
			{
				Robot.TurnLeft();
				Robot.TurnLeft();
				counter++;
			}
			counter++;
		}
	}
	
	public static void Switch(int station)
	{
		switch(station)
		{
		case 1:
			
			Shake();
			Robot.MoveForward();
			Robot.TurnRight();
			Robot.MoveForward();
			Robot.TurnLeft();
			Spin();
			
			break;
		case 2:
			
			Robot.MoveForward();
			Robot.MoveForward();
			Shake();
			Spin();
			
			break;
		case 3:
			
			Shake();
			Robot.MoveForward();
			Robot.TurnLeft();
			Robot.MoveForward();
			Robot.TurnRight();
			Spin();
			
			break;
		}
	}
	
	public void TimedIfElse()
	{
		while(true) 
		{
			
			double timer = Robot.myTimer.get();
			
			
			if (timer < 5)
			{
				Puncher = DoubleSolenoid.Value.kReverse;
				Robot.drivetrain.setPunchers(Puncher);
				Robot.drivetrain.setRaw1(.25, .25);
			} 
			else if (timer < 10)
			{
				Robot.drivetrain.setRaw1(0, 0);
				Robot.drivetrain.setRawSpinner(.3,-.3);
			} 
			else if (timer < 15)
			{
				Robot.drivetrain.setRawSpinner(0,0);
				Hands = DoubleSolenoid.Value.kForward;
				Robot.drivetrain.setRawGrabber(Hands);
			}
			else if (timer < 20)
			{
				Robot.drivetrain.setRawArm(1*throttleX);
			}
			else if (timer < 25)
			{
				Puncher = DoubleSolenoid.Value.kReverse;
				Robot.drivetrain.setPunchers(Puncher);
			}
			else 
			{
				Robot.drivetrain.setRaw1(0, 0);
			}
		}
	}
	
	public static void AccelerateDecelerate()
	{
		double leftSp = 0.01;
		double rightSp = 0.01;
		
			while (leftSp <= 0.60 && rightSp <= 0.60)
			{
				leftSp = leftSp * 2;
				rightSp = rightSp * 2;
				Robot.drivetrain.setRaw1(leftSp, rightSp);		
			}
					
			while (leftSp >= 0.00 && rightSp >= 0.00)
			{
				leftSp = leftSp / 2;
				rightSp = rightSp / 2;
				Robot.drivetrain.setRaw1(leftSp, rightSp);
			}
	}
	
	public static void MoveForward(int distance)
	{
		int i = 0;
		while (i > distance)
		{
			Robot.MoveForward();
			i++;
		}
	}
	
	public static void Shake(){
		Robot.TurnRight();
		Robot.TurnLeft();
		Robot.TurnLeft();
		Robot.TurnRight();
		Robot.TurnRight();
		Robot.TurnLeft();
	}
	
	public static void Spin()
	{
		Robot.TurnRight();
		Robot.TurnRight();
		Robot.TurnRight();
		Robot.TurnRight();
	}
}
