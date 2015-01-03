package org.mort11.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.mort11.RobotMap;
import org.mort11.commands.ee.DontLoad;
import org.mort11.util.EndEffectorConstants;
import org.mort11.util.IntakeState;

public class Intake extends Subsystem
{

    private IntakeState currState;
    private boolean enabled = false;
    private final Talon roller1, roller2;
    private final Solenoid in;
    private final Solenoid out;

    public Intake()
    {
        roller1 = new Talon(RobotMap.INTAKE_TALON_PORT1);
        roller2 = new Talon(RobotMap.INTAKE_TALON_PORT2);
        in = new Solenoid(RobotMap.INTAKE_IN_SOLENOID_PORT);
        out = new Solenoid(RobotMap.INTAKE_OUT_SOLENOID_PORT);
        currState = IntakeState.out;
    }

    public void setEnabled(boolean b)
    {
        enabled = b;
    }

    public void initDefaultCommand()
    {
        setDefaultCommand(new DontLoad());
    }

    public void rollIntake(double speed)
    {
        if (!enabled) {
            speed = 0;
        }
        roller1.set(EndEffectorConstants.INTAKE_FORWARD * speed);
        roller2.set(EndEffectorConstants.INTAKE_FORWARD * speed);
    }

    public double getSpeed()
    {
        return roller1.get();
    }

    public void setIn(boolean in)
    {
        if (enabled) {
            this.in.set(in);
        }
    }

    public void setOut(boolean out)
    {
        if (enabled) {
            this.out.set(out);
        }
    }

    public IntakeState getIntakeState()
    {
        return currState;
    }

    public void setIntakeState(IntakeState state)
    {
        currState = state;

    }
}
