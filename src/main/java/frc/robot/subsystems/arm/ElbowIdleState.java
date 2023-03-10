// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.arm;

import frc.robot.Constants;
import frc.robot.RobotMap;
import frc.robot.lib.interfaces.Arm;
import frc.robot.lib.interfaces.Claw;
import frc.robot.lib.statemachine.State;
import frc.robot.lib.statemachine.Transition;

/** Add your docs here. */
public class ElbowIdleState extends State {

    @Override
    public void build() {
        transitions.add(new Transition(() -> {
            return Arm.getArrived(Constants.ELBOW_IDLE.ALLOWANCE, Constants.ELBOW_IDLE.TIME);
        }, ArmStateMachine.idleState));
    }
    
    @Override
    public void init() {
        RobotMap.arm.setElbowIdle();
        Claw.requestClawClosed();
    }

    @Override
    public void execute() {
        
    }

    @Override
    public void exit() {
        
    }
}
    
