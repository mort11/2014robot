package org.mort11.commands.dt;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.Timer;
import org.mort11.commands.CommandBase;
import org.mort11.subsystems.DriveTrainSide;
import org.mort11.util.DriveTrainConstants;

/**
 *
 * @author admin
 */
public abstract class MoveDistance extends CommandBase
{
    protected double sp;
    private double dist, speed;
    private double errorSum = 0;
    private double lastError = 0;
    private final Timer loopTimer;
    private final DriveTrainSide dt;
    
    protected MoveDistance(DriveTrainSide side, double dist, double speed){
        this.dt = side;
        this.dist = dist;
        this.speed = speed;
        loopTimer = new Timer();
        setInterruptible(true);
        requires(side);
    }
    
    
    protected void initialize()
    {
        loopTimer.start();
        dt.resetEnc();
    }

    protected double getPV()
    {
        return dt.getDist();
    }

    protected double doLoop()
    {
        return speed * (dist/Math.abs(dist));
    }

    protected void execute()
    {

//        System.out.println(doLoop());
//        if (loopTimer.get() > 1 / DriveTrainConstants.CONTROL_LOOP_HERTZ) {
            dt.set(doLoop());
            loopTimer.reset();
//        }
//            System.out.println(dt.getDist());
    }

    protected boolean isFinished()
    {
        return Math.abs(dist) < Math.abs(getPV());
    }

    protected void end()
    {
        loopTimer.stop();
        dt.set(0);
    }

    protected void interrupted()
    {
    }
    
}