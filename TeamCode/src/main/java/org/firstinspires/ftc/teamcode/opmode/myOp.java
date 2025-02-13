package org.firstinspires.ftc.teamcode.opmode;

import static org.firstinspires.ftc.teamcode.subsystems.Gripper.GripperConstants.closeClaw;
import static org.firstinspires.ftc.teamcode.subsystems.Gripper.GripperConstants.score;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RobotContainer;
import org.firstinspires.ftc.teamcode.utils.BT.BTController;

@TeleOp
public class myOp extends CommandOpMode {
    protected RobotContainer m_robot;

    @Override
    public void initialize() {
        m_robot= new RobotContainer(hardwareMap, new BTController(gamepad1), new BTController(gamepad2));
        m_robot.m_gripper.pivotServo.setPosition(closeClaw);
        m_robot.m_gripper.servoClaw.setPosition(score);
        enable();

    }
    @Override
    public void runOpMode() throws InterruptedException {
        initialize();
        waitForStart();

        // run the scheduler
        while (!isStopRequested() && opModeIsActive()) {
            run();
            m_robot.period();
        }
        reset();
    }
}