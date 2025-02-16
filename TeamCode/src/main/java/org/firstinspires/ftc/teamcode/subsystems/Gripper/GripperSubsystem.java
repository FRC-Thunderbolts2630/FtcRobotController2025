package org.firstinspires.ftc.teamcode.subsystems.Gripper;

import static org.firstinspires.ftc.teamcode.subsystems.Gripper.GripperConstants.*;       ;
import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.acmerobotics.dashboard.FtcDashboard;

public class GripperSubsystem extends SubsystemBase {

    private Telemetry dashboard = FtcDashboard.getInstance().getTelemetry();
    public Servo pivotServo;
    public Servo servoClaw;
    public boolean isOpen = false;
    public boolean isPickup;

    public GripperSubsystem(HardwareMap map){
        servoClaw = map.servo.get("servoRot");
        pivotServo = map.servo.get("servoClaw");
        register();
        servoClaw.getController().pwmEnable();
        pivotServo.getController().pwmEnable();




    }
    public void periodic() {
        servoClaw.setPosition(isOpen?openClaw:closeClaw);
//            pivotServo.setPosition(pos);
//            servoClaw.setPosition(clawpos);
            dashboard.addData("gripperOpen: ", isOpen);
    }

    public Command setPickup(){
        return new InstantCommand(()-> pivotServo.setPosition(pickup));
    }
    public Command setPickupFromWall(){
        return new InstantCommand(()-> pivotServo.setPosition(pickupFromWall));
    }
    public Command setScore(){
        return new InstantCommand(()-> pivotServo.setPosition(score));
    }
    public Command setMid(){
        return new InstantCommand(()-> pivotServo.setPosition(0));
    }

    public Command toggleClaw() {
        return new InstantCommand(()-> isOpen = !isOpen);
    }
    public Command openClaw() {
        return new InstantCommand(()-> isOpen = true);
    }
    public Command closeClaw() {
        return new InstantCommand(()-> isOpen = false);
    }


    public Command setSpecimenScore() {
        return new InstantCommand(()-> pivotServo.setPosition(0.4));
    }
    public Command setSpecimenAim() {
        return new InstantCommand(()-> pivotServo.setPosition(0.6));
    }

}
