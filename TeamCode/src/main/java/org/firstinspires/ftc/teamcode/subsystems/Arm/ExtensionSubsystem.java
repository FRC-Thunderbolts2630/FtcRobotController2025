package org.firstinspires.ftc.teamcode.subsystems.Arm;
import static org.firstinspires.ftc.teamcode.subsystems.Arm.ArmConstants.armPIDConstants.*;
import static org.firstinspires.ftc.teamcode.subsystems.Arm.ArmConstants.extensionConstants.*;

import com.acmerobotics.dashboard.FtcDashboard;
import com.arcrobotics.ftclib.command.Subsystem;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DigitalChannelImpl;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.utils.PID.PIDController;
import org.firstinspires.ftc.teamcode.utils.telescopicArmCOM;

public class ExtensionSubsystem extends SubsystemBase {
    private static ExtensionSubsystem instance;
    HardwareMap map;
    public MotorEx arm1;
    public MotorEx arm2;
    public Motor.Encoder extensionEncoder1;
    public Motor.Encoder extensionEncoder2;
//    public DigitalChannel limitSwitch;
    PIDController m_extensionPID;
    public double currentArmLength;
    public double armCOM;
    FtcDashboard dashboard = FtcDashboard.getInstance();
    private Telemetry dashboardTelemetry = dashboard.getTelemetry();
   
    public ExtensionSubsystem(HardwareMap map){
        this.map = map;
        arm1 = new MotorEx(map,"backExtension");//hibur tbd
        arm2 =  new MotorEx(map,"frontExtension");//hibur tbd
        extensionEncoder1 = arm1.encoder;
        extensionEncoder2 = arm2.encoder;
        currentArmLength = extensionEncoder1.getRevolutions();
        armCOM = telescopicArmCOM.calculateCenterOfMass(segmentMasses,segmentLengths,currentArmLength);
        m_extensionPID = new PIDController(eKP,eKI,eKD);
        extensionEncoder1.reset();




    }

    @Override
    public void periodic() {
        updateTelemetry();
        updateValues();
    }

    private ExtensionSubsystem()    {    }

    public double getArmLength()
    {
        return currentArmLength;
    }

    public double getArmCOM(){return armCOM;}

    private void updateValues() {
        currentArmLength = extensionEncoder1.getRevolutions();
        armCOM = telescopicArmCOM.calculateCenterOfMass(segmentMasses,segmentLengths,currentArmLength);

    }

    private void updateTelemetry() {
        dashboardTelemetry.addData("encoder1 rev", extensionEncoder1.getRevolutions());
        dashboardTelemetry.addData("armLength ",currentArmLength);
//        dashboardTelemetry.addData("isClosed", limitSwitch.getState());
        dashboardTelemetry.update();
    }
}
