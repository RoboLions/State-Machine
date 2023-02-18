package frc.robot.lib.states;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;

import frc.robot.RobotMap;

public class Intake {
    public Intake() {
        RobotMap.intakeVertical.setNeutralMode(NeutralMode.Brake);
        RobotMap.intakeVertical.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 10);
        RobotMap.intakeVertical.configNominalOutputForward(0, 10);
        RobotMap.intakeVertical.configNominalOutputReverse(0, 10);
        RobotMap.intakeVertical.configPeakOutputForward(1, 10);
        RobotMap.intakeVertical.configPeakOutputReverse(-1, 10);
        RobotMap.intakeVertical.configNeutralDeadband(0.001, 10);
        RobotMap.intakeVertical.configAllowableClosedloopError(0, 0, 10);
    }

    public void setIdle() {
        RobotMap.intakeVertical.set(TalonFXControlMode.Position, 0.0);
        RobotMap.intakeRoller.set(VictorSPXControlMode.Position, 0.0);
    }

    public static void runIntake(double intakeRollerPower, double intakePosition) {
        RobotMap.intakeRoller.set(VictorSPXControlMode.PercentOutput, intakeRollerPower);
        RobotMap.intakeVertical.set(TalonFXControlMode.Position, intakePosition);
    }

    public void resetEncoders() {
        RobotMap.intakeVertical.setSelectedSensorPosition(0.0);
        RobotMap.intakeRoller.setSelectedSensorPosition(0.0);
    }
}
