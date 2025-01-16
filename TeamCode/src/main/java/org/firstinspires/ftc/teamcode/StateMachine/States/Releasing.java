package org.firstinspires.ftc.teamcode.StateMachine.States;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.Arm.ExtensionSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.Arm.PivotSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.Gripper.GripperSubsystem;

public class Releasing extends CommandBase {

    private ExtensionSubsystem m_extension;
    private PivotSubsystem m_pivot;
    private GripperSubsystem m_gripper;
    public Releasing(GripperSubsystem gripperSubsystem, ExtensionSubsystem extensionSubsystem, PivotSubsystem pivotSubsystem){
        m_gripper = gripperSubsystem;
        m_extension = extensionSubsystem;
        m_pivot = pivotSubsystem;
    }

    @Override
    public void initialize(){
        m_pivot.idle();
        m_gripper.idle();
        m_extension.idle();
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
