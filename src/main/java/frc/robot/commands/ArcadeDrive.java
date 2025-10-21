package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Gyro;

public class ArcadeDrive extends Command {
    private final XboxController controller;
    private final Drivetrain drivetrain;
    private DifferentialDrive differentialDrive;
    private Gyro gyro;

    public ArcadeDrive(XboxController controller, Drivetrain drivetrain, Gyro gyro) {
        this.controller = controller;
        this.drivetrain = drivetrain;
        this.gyro = gyro;
        this.differentialDrive = new DifferentialDrive(drivetrain::setLeftMotor, drivetrain::setRightMotor);
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        differentialDrive.arcadeDrive(controller.getLeftX(), controller.getLeftY());
        gyro.periodic();
    }
}