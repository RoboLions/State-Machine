package frc.robot.subsystems.LED;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.RobotMap;
import frc.robot.lib.statemachine.State;
import frc.robot.lib.statemachine.Transition;
import frc.robot.lib.states.LED;

import com.ctre.phoenix.led.*;
import com.ctre.phoenix.led.CANdle.LEDStripType;
import com.ctre.phoenix.led.CANdle.VBatOutputMode;
import com.ctre.phoenix.led.ColorFlowAnimation.Direction;
import com.ctre.phoenix.led.LarsonAnimation.BounceMode;
import com.ctre.phoenix.led.TwinkleAnimation.TwinklePercent;
import com.ctre.phoenix.led.TwinkleOffAnimation.TwinkleOffPercent;


public class CubeLEDState extends State {
    private static XboxController driverController = RobotMap.driverController;
    public void build(){
        transitions.add(new Transition(() -> {
            return driverController.getLeftTriggerAxis() > 0.25;
        }, LEDStateMachine.LEDIdleState));    
    }

    @Override
    public void init() {

    }

    @Override
    public void execute() {
    LED.m_candle.setLEDs(255, 0, 255);
    }

    @Override
    public void exit() {
        
    }

}