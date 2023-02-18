package frc.robot.subsystems.LED;

import com.ctre.phoenix.led.CANdle;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.RobotMap;
import frc.robot.lib.statemachine.State;
import frc.robot.lib.statemachine.Transition;
import frc.robot.lib.states.LED;

public class ConeLEDState extends State {
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
    LED.m_candle.setLEDs(255, 255, 0);
    }

    @Override
    public void exit() {
        
    }

}
