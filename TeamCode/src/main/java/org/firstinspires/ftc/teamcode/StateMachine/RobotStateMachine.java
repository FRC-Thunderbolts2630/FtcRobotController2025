package org.firstinspires.ftc.teamcode.StateMachine;

import com.arcrobotics.ftclib.command.button.Trigger;

import org.firstinspires.ftc.TBlib.Subsystems.TBVirtualSubsystem;
import org.firstinspires.ftc.teamcode.StateMachine.States.Idle;
import org.firstinspires.ftc.teamcode.StateMachine.States.Intaking;
import org.firstinspires.ftc.teamcode.StateMachine.States.Placing;

public class RobotStateMachine extends TBVirtualSubsystem {

    private static Trigger m_intakeBtn;
    private static Trigger m_placeBtn;

    private static Trigger idle;
    private static Trigger intaking;
    private static Trigger placing;

    public RobotStateMachine(
            Idle idleCommand,
            Intaking intakeCommand,
            Placing placeCommand,
            Trigger placeBtn,
            Trigger intakeBtn
    )
    {
        m_intakeBtn = intakeBtn;
        m_placeBtn = placeBtn;

        idle = new Trigger().and(m_intakeBtn).negate().and(m_placeBtn).negate();
        intake = new Trigger().and(m_placeBtn).and(m_intakeBtn).negate();
        place = new Trigger().and(m_intakeBtn).and(m_placeBtn).negate();

        idleCommand.addRequirements(this);
        placeCommand.addRequirements(this);
        intakeCommand.addRequirements(this);

        idle.whileActiveContinuous(idleCommand);
        intaking.whileActiveContinuous(intakeCommand);
        placing.whileActiveOnce(placeCommand);

    }
}
