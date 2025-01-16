package org.firstinspires.ftc.teamcode.StateMachine.States;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.Arm.ExtensionSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.Arm.PivotSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.Gripper.GripperSubsystem;

public class Intaking extends CommandBase {
    private GripperSubsystem m_gripper;
    public Intaking(GripperSubsystem gripperSubsystem){
        m_gripper = gripperSubsystem;
    }

    @Override
    public void initialize(){
        m_gripper.place();
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
