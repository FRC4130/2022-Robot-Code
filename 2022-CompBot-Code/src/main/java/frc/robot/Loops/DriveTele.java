package frc.robot.Loops;

import com.ctre.phoenix.ILoopable;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robots.RobotMap;
import frc.robot.Robots.Subsystems;
import frc.robot.Subsystems.DriveTrain;

public class DriveTele implements ILoopable{

    DriveTrain _drive;
    PS4Controller _controller;
    DriveDistance driveDistance;

    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tv = table.getEntry("tv");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ta = table.getEntry("ta");

    double m_LimelightDriveCommand = 0.0;
    double m_LimelightSteerCommand = 0.0;
    boolean m_LimelightHasValidTarget = false;

    public DriveTele(){
        _drive = Subsystems.driveTrain;
        _controller = RobotMap.controller;
    }

    public void onStart(){
        _drive.setNeutralMode(NeutralMode.Brake);
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(0);
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(1);
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);
    }

    public void onLoop(){
        //Driver Control Input
        //Limelight - read variables tv, tx, ty, ta, ts, tl, tshort, tlong, thor, and tvert
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("ts").getDouble(0);
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("tl").getDouble(0);
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("tshort").getDouble(0);
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("tlong").getDouble(0);
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("thor").getDouble(0);
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("tvert").getDouble(0);

        //Limelight - Limelight Autonomous Aim/Seek/Range w/ button
        LimelightTracking();
        double steer = -_controller.getRightX();
        double drive = -_controller.getLeftY();
        boolean auto = _controller.getCrossButton();
        steer *= 1;
        drive *= 1;
        if (auto) {
            NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(1); //0
            NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1); //3
            if (m_LimelightHasValidTarget) {
                _drive.arcade(m_LimelightDriveCommand, -m_LimelightSteerCommand);
            }
            else {
                NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(1); //0
                NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1); //3
                _drive.RobotMovement(drive, steer);
            }
        }

        //20% Speed
        else if (_controller.getL1Button()){
            _drive.RobotMovement(_controller.getLeftY()*0.20, _controller.getRightY()*0.20);
        }
        //100% Speed
        else if(_controller.getR1Button()){
            _drive.RobotMovement(_controller.getLeftY(), _controller.getRightY());
        }
        //60% Speed, Default
        else{
            NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(1); //0
            NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1); //3
            _drive.RobotMovement(_controller.getLeftY()*0.60, _controller.getRightY()*0.60);
        }


        
        /* --- Code to Tune in the robot for DriveDistance
        if(_controller.getTriangleButton()){
           _drive.setPos(_drive.distanceToRotations(120));

        }
        if(_controller.getOptionsButton()){
            _drive.RobotMovement(-.40, -.40);
        
        
        }*/

        if(_controller.getPSButton()){
            _drive.resetSensors();
        }
        
        _drive.smartDashboard();
        }

        public boolean isDone(){
        return false;
        }

        public void onStop(){
        _drive.RobotMovement(0, 0);
    }
    
    public void LimelightTracking() {

        // These numbers must be tuned...
        final double STEER_K = 0.5; // How hard to turn toward the target
        final double DRIVE_K = 0.5; // How hard to drive fwd toward the target
        final double DESIRED_TARGET_AREA = 1.0; // Area of the target when the robot reaches the wall
        final double MAX_DRIVE = .70; // Speed limit so we don't drive too fast
        double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
        double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
        double ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);
        SmartDashboard.putNumber("tv", tv);
        SmartDashboard.putNumber("tx", tx);
        SmartDashboard.putNumber("ta", ta);

        // Function to determine autonomous drive and steering settings
        if (tv < 0.5) {
            m_LimelightHasValidTarget = false;
            m_LimelightDriveCommand = 0.0;
            m_LimelightSteerCommand = 0.0;
            return;
        }
        m_LimelightHasValidTarget = true;
        // Start with proportional steering
        double steer_cmd = tx * STEER_K;
        m_LimelightSteerCommand = steer_cmd;
        // Try to drive forward until the target area reaches our desired area
        double drive_cmd = (DESIRED_TARGET_AREA - ta) * DRIVE_K;
        // Don't let the robot drive too fast into the target
        if (drive_cmd > MAX_DRIVE) {
            drive_cmd = MAX_DRIVE;
        }
        m_LimelightDriveCommand = drive_cmd;
    }
}
