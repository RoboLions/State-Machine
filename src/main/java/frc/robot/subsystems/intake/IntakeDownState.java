// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants;
import frc.robot.RobotMap;
import frc.robot.lib.statemachine.State;
import frc.robot.lib.states.Intake;

/** Add your docs here. */
public class IntakeDownState extends State {
    
    public IntakeDownState() {}

    @Override
    public void init() {
    }

    @Override
    public void execute() {
        Intake.runIntake(Constants.Intake.INTAKE_ROLLER_POWER, Constants.Intake.INTAKE_DOWN_POSITION);
    }

    @Override
    public void exit() {
        Intake.runIntake(0.0, 0.0);
    }

}