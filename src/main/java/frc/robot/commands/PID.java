package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Gyro;

public class PID extends Command {
    private PIDController pidController = new PIDController(0.1, 0, 1.1);
    private Gyro gyro;
    private Drivetrain drivetrain;

    public PID(Gyro gyro, Drivetrain drivetrain) {
        this.gyro = gyro;
        this.drivetrain = drivetrain;
        pidController.enableContinuousInput(0, 360);
        pidController.setTolerance(5);
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        drivetrain.setMotors(-motorPower(), motorPower());
        SmartDashboard.putNumber("PID/motorPower", motorPower());
    }

    public double motorPower() {
        double gyroZ = gyro.getZ();

        return pidController.calculate(gyroZ, 90);
      }
}