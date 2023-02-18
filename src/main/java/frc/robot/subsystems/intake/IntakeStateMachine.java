package frc.robot.subsystems.intake;

import java.util.function.Supplier;

import edu.wpi.first.math.filter.Debouncer;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.lib.statemachine.StateMachine;
import frc.robot.lib.statemachine.Transition;

public class IntakeStateMachine extends StateMachine {
    
    public IntakeUpState intakeUpState = new IntakeUpState(); // idle
    public IntakeDownState intakeDownState = new IntakeDownState(); // intaking

    private Debouncer m_debouncer = new Debouncer(0.1, Debouncer.DebounceType.kRising);
    
    private static XboxController manipulatorController = RobotMap.manipulatorController;

    public IntakeStateMachine() {

        Supplier<Boolean> checkBButton = () -> {
            return m_debouncer.calculate(manipulatorController.getBButton()); // TODO: check if this returns true if there is a rising edge
        };

        Supplier<Boolean> checkAButton = () -> {
            return manipulatorController.getAButton();
        };

        intakeUpState.addTransition(new Transition(checkBButton, intakeDownState)); // transition when the button is held down
        intakeDownState.addTransition(new Transition(checkAButton, intakeUpState));

        setCurrentState(intakeUpState);
    }

}
