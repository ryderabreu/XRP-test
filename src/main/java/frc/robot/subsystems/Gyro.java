package frc.robot.subsystems;

import edu.wpi.first.math.filter.MedianFilter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.xrp.XRPGyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Gyro extends SubsystemBase {
    private XRPGyro gyro = new XRPGyro();

    private MedianFilter xFilter = new MedianFilter(3);
    private MedianFilter yFilter = new MedianFilter(3);
    private MedianFilter zFilter = new MedianFilter(3);

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Gyro/AngleX", xFilter.calculate(gyro.getAngleX()));
        SmartDashboard.putNumber("Gyro/AngleY", yFilter.calculate(gyro.getAngleY()));
        SmartDashboard.putNumber("Gyro/AngleZ", zFilter.calculate(gyro.getAngleZ()));
    }
}
