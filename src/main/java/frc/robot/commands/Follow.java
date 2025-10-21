package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.LineFollower;

public class Follow extends Command {
    private final Drivetrain drivetrain;
    private final LineFollower lineFollower;

    public Follow(Drivetrain drivetrain, LineFollower lineFollower) {
        this.drivetrain = drivetrain;
        this.lineFollower = lineFollower;
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        drivetrain.setMotors(lineFollower.rightSensor(), -lineFollower.leftSensor());
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.setMotors(0, 0);
    }
}