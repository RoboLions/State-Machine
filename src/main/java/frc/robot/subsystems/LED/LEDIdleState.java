package frc.robot.subsystems.LED;

import com.ctre.phoenix.led.CANdle;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.RobotMap;
import frc.robot.lib.statemachine.State;
import frc.robot.lib.statemachine.Transition;
import frc.robot.lib.states.LED;

public class LEDIdleState extends State {
    private static XboxController driverController = RobotMap.driverController;
    
    public void build() {  
        transitions.add(new Transition(() -> {
            return driverController.getYButton();
        }, LEDStateMachine.coneLEDState));
        transitions.add(new Transition(() -> {
            return driverController.getAButton();
        }, LEDStateMachine.cubeLEDState));
    }
    @Override
    public void init() {

    }

    @Override
    public void execute() {
        LED.m_candle.setLEDs(0, 0, 0);
    }

    @Override
    public void exit() {
        
    }

}