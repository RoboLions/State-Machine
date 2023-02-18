// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.intake;

import frc.robot.Constants;
import frc.robot.RobotMap;
import frc.robot.lib.statemachine.State;
import frc.robot.lib.statemachine.Transition;
import frc.robot.lib.states.Intake;

/** Add your docs here. */
public class IntakeUpState extends State {

    public IntakeUpState() {}

    @Override
    public void init() {
    }

    @Override
    public void execute() {
        Intake.runIntake(0.0, Constants.Intake.INTAKE_UP_POSITION);
    }

    @Override
    public void exit() {
        Intake.runIntake(0.0, 0.0);
    }

}