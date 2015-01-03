package org.mort11.commands;

import com.kauailabs.nav6.frc.BufferingSerialPort;
import com.kauailabs.nav6.frc.IMU;
import com.kauailabs.nav6.frc.IMUAdvanced;
import com.team254.lib.CheesyVisionServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.visa.VisaException;
import org.mort11.OI;
import org.mort11.RobotMap;
import org.mort11.subsystems.Catapult;
import org.mort11.subsystems.CompressorSubsystem;
import org.mort11.subsystems.Intake;
import org.mort11.subsystems.GearShifter;
import org.mort11.subsystems.HardStop;
import org.mort11.subsystems.DriveTrainSide;
import org.mort11.subsystems.LeftDriveTrain;
import org.mort11.subsystems.RightDriveTrain;

/**
 * @author Author
 */
public abstract class CommandBase extends Command
{

    public static Catapult catapult;
    public static CompressorSubsystem comp;
    public static HardStop hardStop;
    public static Intake intake;
    public static GearShifter gears;
    public static DriveTrainSide leftDT;
    public static RightDriveTrain rightDT;
//    public static IMUAdvanced imu;
//    public static BufferingSerialPort imuSerialPort;
    public static CheesyVisionServer visionServer;
    public static OI oi;
    

    public static void init()
    {

        gears = new GearShifter();
        catapult = new Catapult();
        comp = new CompressorSubsystem();
        hardStop = new HardStop();
        intake = new Intake();
        leftDT = new LeftDriveTrain();
        rightDT = new RightDriveTrain();
//        try {
//            imuSerialPort = new BufferingSerialPort(57600, 8,
//                    BufferingSerialPort.Parity.kNone, BufferingSerialPort.StopBits.kOne);
//            imu = new IMUAdvanced(imuSerialPort, (byte)20);
//        } catch (VisaException ex) {
//            ex.printStackTrace();
//        }
        visionServer = CheesyVisionServer.getInstance();
        oi = new OI(gears,leftDT,rightDT);
    }

    public CommandBase(double timeout){
        super(timeout);
    }
    
    public CommandBase(String name)
    {
        super(name);
    }

    public CommandBase()
    {
        super();
    }
}
