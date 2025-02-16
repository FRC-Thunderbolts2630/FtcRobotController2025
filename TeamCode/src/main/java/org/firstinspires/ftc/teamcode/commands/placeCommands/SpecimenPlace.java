package org.firstinspires.ftc.teamcode.commands.placeCommands;

import static org.firstinspires.ftc.teamcode.subsystems.Arm.ArmConstants.eStates.closed;
import static org.firstinspires.ftc.teamcode.subsystems.Arm.ArmConstants.eStates.half;
import static org.firstinspires.ftc.teamcode.subsystems.Arm.ArmConstants.eStates.quarter;
import static org.firstinspires.ftc.teamcode.subsystems.Arm.ArmConstants.pStates.midpoint;
import static org.firstinspires.ftc.teamcode.subsystems.Arm.ArmConstants.pStates.specimenPlace;
import static org.firstinspires.ftc.teamcode.subsystems.Arm.ArmConstants.pStates.specimenScore;
import static org.firstinspires.ftc.teamcode.utils.BT.BTController.Buttons.BUMPER_LEFT;
import static org.firstinspires.ftc.teamcode.utils.BT.BTController.Buttons.BUMPER_RIGHT;
import static org.firstinspires.ftc.teamcode.utils.BT.BTController.Buttons.BUTTON_DOWN;

import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.RepeatCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.command.WaitUntilCommand;

import org.firstinspires.ftc.teamcode.commands.globalCommands.IdleFromIntake;
import org.firstinspires.ftc.teamcode.commands.intakeCommands.Pickup;
import org.firstinspires.ftc.teamcode.subsystems.Arm.ExtensionSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.Arm.PivotSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain.ChassisSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.Gripper.GripperSubsystem;
import org.firstinspires.ftc.teamcode.utils.BT.BTController;

public class SpecimenPlace extends SequentialCommandGroup{
    public SpecimenPlace(ExtensionSubsystem extension, PivotSubsystem pivot, ChassisSubsystem chassis, GripperSubsystem gripper, BTController controller){
        super(
//
//                chassis.stopSlowDriving(),
//                pivot.setWithProfile(specimenPlace,80,300),
//                new WaitCommand(500),
//                extension.setExtension(closed),
//                gripper.setSpecimenScore(),
//                new WaitUntilCommand(controller.m_buttonsSuppliers[BUMPER_LEFT.ordinal()]),
//                new WaitUntilCommand(()->!controller.m_buttonsSuppliers[BUMPER_LEFT.ordinal()].getAsBoolean()),
//                gripper.setSpecimenAim(),
//                new WaitUntilCommand(controller.m_buttonsSuppliers[BUMPER_LEFT.ordinal()]),
//                new WaitUntilCommand(()->!controller.m_buttonsSuppliers[BUMPER_LEFT.ordinal()].getAsBoolean()),
//                gripper.openClaw()
                chassis.stopSlowDriving(),
                pivot.setWithProfile(specimenPlace,80,300),
                new WaitCommand(500),
                extension.setExtension(closed),
                gripper.setSpecimenScore(),//changed to 0.4 from 1
                new WaitUntilCommand(controller.m_buttonsSuppliers[BUMPER_LEFT.ordinal()]),
                new WaitUntilCommand(()->!controller.m_buttonsSuppliers[BUMPER_LEFT.ordinal()].getAsBoolean()),
                extension.setExtension(quarter),
                new WaitUntilCommand(controller.m_buttonsSuppliers[BUMPER_LEFT.ordinal()]),
                new WaitUntilCommand(()->!controller.m_buttonsSuppliers[BUMPER_LEFT.ordinal()].getAsBoolean()),
                gripper.openClaw(),
                extension.setExtension(closed)
        );
    }
}
