// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.claw;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.math.controller.PIDController;
import frc.robot.Constants;
import frc.robot.RobotMap;
import frc.robot.lib.interfaces.Claw;
import frc.robot.lib.statemachine.State;
import frc.robot.lib.statemachine.Transition;

/** Add your docs here. */
public class OpeningState extends State {
    
    private PIDController controller = new PIDController(
        0.01, 0.0, 0.0
    );
    
    @Override
    public void build() {
        transitions.add(new Transition(() -> {
            return Claw.getArrived(Constants.CLAW.ALLOWANCE, Constants.CLAW.TIME, Constants.CLAW.OPEN_POSITION);
        }, ClawStateMachine.openState));
    }

    @Override
    public void init() {
        RobotMap.clawMotor.set(ControlMode.Position, Constants.CLAW.OPEN_POSITION);
    }

    @Override
    public void execute() {

        double command = controller.calculate(RobotMap.clawEncoder.get(), Constants.CLAW.OPEN_POSITION);
        RobotMap.clawMotor.set(ControlMode.PercentOutput, command);

    }

    @Override
    public void exit() {

    }
}
