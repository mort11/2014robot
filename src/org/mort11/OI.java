package org.mort11;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import org.mort11.commands.dt.DecrementLoopIConstant;
import org.mort11.commands.dt.DecrementLoopPConstant;
import org.mort11.commands.dt.DriveFPSBoth;
import org.mort11.commands.dt.DriveRelativeBoth;
import org.mort11.commands.dt.IncrementLoopIConstant;
import org.mort11.commands.dt.IncrementLoopPConstant;
import org.mort11.commands.dt.ShiftGear;
import org.mort11.commands.dt.SwapDriveControl;
import org.mort11.commands.ee.ActuateIntake;
import org.mort11.commands.ee.CatapultBallLockout;
import org.mort11.commands.ee.Launch;
import org.mort11.commands.ee.Load;
import org.mort11.commands.ee.PassBack;
import org.mort11.commands.ee.Prime;
import org.mort11.commands.ee.SetCAMAndFinish;
import org.mort11.commands.ee.SetCAMAngle;
import org.mort11.commands.ee.SetShotType;
import org.mort11.commands.ee.SwapCamControl;
import org.mort11.commands.ee.Unload;
import org.mort11.subsystems.DriveTrainSide;
import org.mort11.subsystems.GearShifter;
import org.mort11.subsystems.RightDriveTrain;
import org.mort11.util.DriveStyle;
import org.mort11.util.DriveTrainConstants;
import org.mort11.util.Gear;
import org.mort11.util.ShotType;
import org.mort11.util.TeleopConstants;

public class OI {

    private final Joystick dtLeftJoy = new Joystick(RobotMap.DT_LEFT_JOY);
    private final Joystick dtRightJoy = new Joystick(RobotMap.DT_RIGHT_JOY);
    private final Joystick eeJoy = new Joystick(RobotMap.EE_JOY);
    private final MultiAndButton shootButton
            = new MultiAndButton(new Button[]{new JoystickButton(eeJoy, TeleopConstants.EE_TRIGGER), new JoystickButton(eeJoy, TeleopConstants.EE_SAFETY)
            });
    private final JoystickButton shiftButton = new JoystickButton(dtRightJoy,
            TeleopConstants.SHIFT_GEAR);
    private final MultiOrButton eeLoadButton = new MultiOrButton(new Button[]{new JoystickButton(eeJoy,
        TeleopConstants.LOAD_BUTTON), new JoystickButton(eeJoy, 4)});
    private final JoystickButton eeUnloadButton = new JoystickButton(eeJoy,
            TeleopConstants.UNLOAD_BUTTON);
    private final JoystickButton swapDriveButton = new JoystickButton(dtLeftJoy, TeleopConstants.SWAP_DRIVE_BUTTON);
    private final JoystickButton tankInvDriveButton = new JoystickButton(dtLeftJoy, TeleopConstants.TANK_DRIVE_INV_BUTTON);
    private final JoystickButton kajDriveButton = new JoystickButton(dtLeftJoy, TeleopConstants.ARCADE_DRIVE_BUTTON);
    private final JoystickButton standardShotButton = new JoystickButton(eeJoy,
            TeleopConstants.STANDARD_SHOT_BUTTON);
    private final JoystickButton lobShotButton = new JoystickButton(eeJoy,
            TeleopConstants.LOB_SHOT_BUTTON);
    private final MultiOrButton toggleIntakeButton = new MultiOrButton(new Button[]{new JoystickButton(dtLeftJoy,
        7)});
    private final JoystickButton toggleCamControl = new JoystickButton(eeJoy,
            TeleopConstants.CAM_SWAP_BUTTON);
    private final JoystickButton lockout = new JoystickButton(eeJoy,
            8);
    private final JoystickButton passBack = new JoystickButton(eeJoy, 11);
    private final JoystickButton upI = new JoystickButton(dtRightJoy, 4);
    private final JoystickButton downI = new JoystickButton(dtRightJoy, 6);
    private final JoystickButton upP = new JoystickButton(dtRightJoy, 3);
    private final JoystickButton downP = new JoystickButton(dtRightJoy, 5);

    private final DriveTrainSide leftDT;
    private final RightDriveTrain rightDT;
    private final GearShifter gShift;

    public OI(GearShifter gShift, DriveTrainSide leftDT, RightDriveTrain rightDT) {
        this.gShift = gShift;
        this.rightDT = rightDT;
        this.leftDT = leftDT;
        shiftButton.whenActive(new ShiftGear());
        shootButton.whenActive(new Launch());
        eeLoadButton.whileHeld(new Load());
        eeUnloadButton.whileHeld(new Unload());
        swapDriveButton.whenPressed(new SwapDriveControl());

        standardShotButton.whenPressed(new SetShotType(ShotType.STANDARD));
        lobShotButton.whenPressed(new SetShotType(ShotType.LOB));
        toggleIntakeButton.whenPressed(new ActuateIntake());
        toggleCamControl.whenPressed(new SwapCamControl());

        passBack.whenPressed(new PassBack());

        upI.whenPressed(new IncrementLoopIConstant());
        downI.whenPressed(new DecrementLoopIConstant());
        upP.whenPressed(new IncrementLoopPConstant());
        downP.whenPressed(new DecrementLoopPConstant());
    }

    public static double doThreshold(double input) {
        if (Math.abs(input) <= TeleopConstants.DEADBAND) {
            return 0;
        }
        return input / Math.abs(input) * (Math.abs(input)
                - TeleopConstants.DEADBAND)
                / (1 - TeleopConstants.DEADBAND);
    }

    public double getEESpeed() {
        return doThreshold(eeJoy.getY());
    }

    public Joystick getLeftJoy() {
        return dtLeftJoy;
    }

    public Joystick getRightJoy() {
        return dtRightJoy;
    }

}
