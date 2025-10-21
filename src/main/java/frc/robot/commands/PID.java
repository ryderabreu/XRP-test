package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Gyro;

public class PID extends Command {
    private PIDController pidController = new PIDController(1, 0, 0);
    private Gyro gyro;
    private Drivetrain drivetrain;

    public PID(Gyro gyro, Drivetrain drivetrain) {
        this.gyro = gyro;
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        drivetrain.setLeftMotor(motorPower());
        drivetrain.setRightMotor(-motorPower());
        SmartDashboard.putNumber("PID/motorPower", motorPower());
    }

    public double motorPower() {
        double gyroZ = gyro.getZ();

        if(Math.abs(gyroZ - 90) > Math.abs(gyroZ - 450)) {
            gyroZ = gyroZ - 360;
        }
        else if(Math.abs(gyroZ - 90) > Math.abs(gyroZ + 270)) {
            gyroZ = gyroZ + 360;
        }

        return pidController.calculate(gyroZ, 90) / 2;
      }
}