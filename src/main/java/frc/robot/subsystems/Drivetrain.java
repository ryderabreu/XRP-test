package frc.robot.subsystems;

import edu.wpi.first.wpilibj.xrp.XRPMotor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    private final XRPMotor leftMotor = new XRPMotor(0);
    private final XRPMotor rightMotor = new XRPMotor(1);

    public void setMotors(double x, double y) {
        leftMotor.set(x);
        rightMotor.set(y);
    }

    public void setLeftMotor(double speed) {
        leftMotor.set(speed);
    }

    public void setRightMotor(double speed) {
        rightMotor.set(speed);
    }
}