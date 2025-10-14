package frc.robot.subsystems;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.xrp.XRPReflectanceSensor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LineFollower extends SubsystemBase {
    private final XRPReflectanceSensor sensor = new XRPReflectanceSensor();

    public double leftSensor() {
        return sensor.getLeftReflectanceValue();
    }

    public double rightSensor() {
        return sensor.getRightReflectanceValue();
    }
}