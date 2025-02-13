package org.firstinspires.ftc.teamcode.opmode.autos;

import static org.firstinspires.ftc.teamcode.subsystems.Gripper.GripperConstants.closeClaw;
import static org.firstinspires.ftc.teamcode.subsystems.Gripper.GripperConstants.score;

import com.acmerobotics.dashboard.FtcDashboard;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.internal.system.AppUtil;
import org.firstinspires.ftc.teamcode.RobotContainer;
import org.firstinspires.ftc.teamcode.utils.BT.BTRecordedController;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public abstract class Playback extends PeriodicOpMode {
    BTRecordedController controller;
    BTRecordedController controller2;
    BufferedReader bufferedReader;
    //allow override by child classes
    protected abstract int maxIterations();// default should be 20*30 //Hz * Sec
    protected abstract String file_name();
    FtcDashboard dashboard = FtcDashboard.getInstance();
    Telemetry dashboardTelemetry = dashboard.getTelemetry();

    @Override
    public void initialize() {
        final String file_name=file_name();
        final int maxIterations=maxIterations();

        try {
            File log = AppUtil.getInstance().getSettingsFile(file_name);
            controller=new BTRecordedController(gamepad1,log,maxIterations);
            controller2 = new BTRecordedController(gamepad2,log,maxIterations);
            m_robot=new RobotContainer(hardwareMap,controller,controller2);
            m_robot.m_gripper.servoClaw.setPosition(score);
            m_robot.m_gripper.pivotServo.setPosition(closeClaw);
        } catch (IOException e) {
            dashboardTelemetry.addData("error data:",e.toString());
            dashboardTelemetry.update();
        }
    }

    @Override
    protected void period() {
        controller.next();
    }

    @Override
    protected void endFunction() {
        try {
            controller.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
