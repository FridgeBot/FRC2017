package org.usfirst.frc.team5084.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends SampleRobot {
	Spark lDrive = new Spark (0);
	Spark rDrive = new Spark (1);
	RobotDrive myRobot = new RobotDrive(lDrive , rDrive);
	Joystick stick = new Joystick(0);
	Spark door = new Spark (4);
	Spark shoot = new Spark (5);
	Spark belt = new Spark (2);
	Spark gear = new Spark (3);
	Encoder lEncode = new Encoder (0, 1, false);
	Encoder rEncode = new Encoder (2, 3, true);
	boolean doorb;
	boolean doora;
	boolean belta;
	boolean beltb;
	boolean geara;
	boolean gearb;
	boolean shoota;
	boolean shootb;
	double lDist;
	double rDist;
	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	SendableChooser<String> chooser = new SendableChooser<>();

	public Robot() {
		myRobot.setExpiration(0.002);
	}

	@Override
	public void robotInit() {
		chooser.addDefault("Default Auto", defaultAuto);
		chooser.addObject("My Auto", customAuto);
		SmartDashboard.putData("Auto modes", chooser);
	    myRobot.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
	    myRobot.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
	}

	@Override
	public void autonomous() {
		String autoSelected = chooser.getSelected();
		System.out.println("Auto selected: " + autoSelected);

		switch (autoSelected) {
		case customAuto:
			myRobot.setSafetyEnabled(false);
			lEncode.setDistancePerPulse(0.0087266462599);
			rEncode.setDistancePerPulse(0.0087266462599);
			lDist = lEncode.getDistance();
			rDist = rEncode.getDistance();
			if (lEncode.get() > 5)
				myRobot.drive(0.5, 0.0);
			else 
				myRobot.drive(0.0, 0.0);
			break;
		case defaultAuto:
		default:
			myRobot.setSafetyEnabled(false);
			myRobot.drive(0.0, 0.0); 
			break;
		}
	}

	@Override
	public void operatorControl() {
		myRobot.setSafetyEnabled(true);
		while (isOperatorControl() && isEnabled()) {
			myRobot.arcadeDrive(stick);
			boolean doorb = false;
		       door.set(0);
		       if(doorb == false){
		           if(stick.getRawButton(1)){
		               doorb = true;
		               door.set(1);    
		           }
		           else if(doorb == true){
		               if(stick.getRawButton(1)){
		               doorb = false;
		               door.set(0);
		               }              
		           }
		         boolean doora = false;
			     door.set(0);
			     if(doora == false){
			         if(stick.getRawButton(2)){
			             doora = true;
			             door.set(-1);    
			         }
			         else if(doora == true){
			             if(stick.getRawButton(2)){
			             doora = false;
			             door.set(0);
			             }
			         }
				    boolean beltb = false;
				    belt.set(0);
				    if(beltb == false){
				        if(stick.getRawButton(3)){
				            beltb = true;
				            belt.set(1);    
				        }
				        else if(beltb == true){
				            if(stick.getRawButton(3)){
				            beltb = false;
				            belt.set(0);
				            }              
				        }
				      boolean belta = false;
					  belt.set(0);
					  if(belta == false){
					      if(stick.getRawButton(5)){
					          belta = true;
					          belt.set(-1);    
					      }
					      else if(belta == true){
					          if(stick.getRawButton(5)){
					          belta = false;
					          belt.set(0);
					          }
					      }
					   boolean gearb = false;
					   gear.set(0);
					   if(gearb == false){
					        if(stick.getRawButton(4)){
					            gearb = true;
					            gear.set(.75);    
					        }
					        else if(gearb == true){
					            if(stick.getRawButton(4)){
					            gearb = false;
					            gear.set(0);
					            }              
					        }
					     boolean geara = false;
						 gear.set(0);
						 if(geara == false){
						      if(stick.getRawButton(6)){
						          geara = true;
						          gear.set(-.75);    
						      }
						      else if(geara == true){
						          if(stick.getRawButton(6)){
						          geara = false;
						          gear.set(0);
						          }
						      }
						   boolean shootb = false;
						   shoot.set(0);
						   if(shootb == false){
						           if(stick.getRawButton(8)){
						               shootb = true;
						               shoot.set(.75);    
						           }
						           else if(shootb == true){
						               if(stick.getRawButton(8)){
						               shootb = false;
						               shoot.set(0);
						               }              
						           }
						         boolean shoota = false;
							     shoot.set(0);
							     if(shoota == false){
							         if(stick.getRawButton(7)){
							             shoota = true;
							             shoot.set(-.75);    
							         }
							         else if(shoota == true){
							             if(stick.getRawButton(7)){
							             shoota = false;
							             shoot.set(0);
							             }
							         }
			         }
			Timer.delay(0.002);
		}
						   }
						 }
					   }
					  }
				    }
			      }
		       }
		}
		       
	


	@Override
	public void test() {
	}
}
