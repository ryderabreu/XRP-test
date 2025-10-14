package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class TankDrive extends Command {
    private final XboxController controller;
    private final Drivetrain drivetrain;

    public TankDrive(XboxController controller, Drivetrain drivetrain) {
        this.controller = controller;
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        drivetrain.setMotors(controller.getLeftY(), controller.getLeftY());
    }

}