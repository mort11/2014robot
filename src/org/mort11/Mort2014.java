/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.mort11;

import com.team254.lib.CheesyVisionServer;
import edu.first.util.File;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.mort11.auton.BackPush;
import org.mort11.auton.GoaliePoleAuton;
import org.mort11.auton.OneBallLongShot;
import org.mort11.auton.OneBallPowerShot;
import org.mort11.auton.OneBallPowerShotControlled;
import org.mort11.auton.TwoBallLongShot;
import org.mort11.auton.TwoBallPowerShot;
import org.mort11.auton.TwoBallPowerShotControlled;
import org.mort11.commands.CommandBase;
import org.mort11.commands.dt.ShiftGear;
import org.mort11.commands.ee.ActuateIntake;
import org.mort11.commands.ee.SetShotType;
import org.mort11.util.Gear;
import org.mort11.util.IntakeState;
import org.mort11.util.MORTLogger;
import org.mort11.util.ShotType;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Mort2014 extends IterativeRobot {

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    Command autoncommand = null;
//    MORTLogger logger;
    CheesyVisionServer server = CheesyVisionServer.getInstance();
    public final int listenPort = 1180;

    private String logName(int num) {
        DriverStation ds = DriverStation.getInstance();
        return "nav6." + (ds.isFMSAttached() ? "match" : "practice") + "." + num
                + ".log";
    }

    public void robotInit() {
        // instantiate the command used for the autonomous period        
        // Initialize all subsystems
        CommandBase.init();
//        int logNum = 0;
//        File logFile = new File(logName(logNum));
//        while (logFile.exists() && Math.abs(logNum) < 200) {
//            System.out.println(logNum);
//            logFile = new File(logName(++logNum));
//
//        }
//        System.out.println(logFile.getPath());
//        logger = new MORTLogger(logFile, true);
//        logger.open();
        server.setPort(listenPort);
        server.start();
    }

    public void setSoftEnable(boolean b) {
        CommandBase.catapult.setEnabled(b);
        CommandBase.leftDT.setEnabled(b);
        CommandBase.rightDT.setEnabled(b);
        CommandBase.intake.setEnabled(b);
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
//        server.reset();
//        server.startSamplingCounts();
//        new ShiftGear(Gear.LowGear).start();
//        new ActuateIntake(IntakeState.out).start();
        setSoftEnable(true);
//        autoncommand = new TwoBallLongShot();
//        autoncommand = new TwoBallPowerShot();
//        autoncommand = new TwoBallPowerShotControlled();
//        autoncommand = new OneBallLongShot();
//        autoncommand = new OneBallPowerShot();
        autoncommand = new OneBallPowerShotControlled();
//        autoncommand = new GoaliePolEAuton();
//        autoncommand = new BackPush();
        if (autoncommand != null) {
            autoncommand.start();
        }

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

        Scheduler.getInstance().run();
//        System.out.println(CommandBase.leftDT.getDist()+","+CommandBase.rightDT.getDist());
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        server.reset();
        server.stopSamplingCounts();
        server.stop();
        if (autoncommand != null) {
            autoncommand.cancel();
        }
        setSoftEnable(true);
        new ShiftGear(Gear.LowGear).start();
        new ActuateIntake(IntakeState.out).start();
//        new SetShotType(ShotType.LOB).start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
//        System.out.println(CommandBase.intake.getSpeed());
        System.out.println(CommandBase.catapult.getAngle() + "," +
                           CommandBase.leftDT.getRate() + "," +
                           CommandBase.rightDT.getRate() + ", " +
                           CommandBase.gears.getGear().name);
//        logger.writeLine(DriverStation.getInstance().getMatchTime()+","+CommandBase.leftDT.getCurVal() + ","+CommandBase.leftDT.getRate());
//        logger.writeLine("nav6@" + System.currentTimeMillis() + " " +
//                         "Field Time ~=" + DriverStation.getInstance().
//                         getMatchTime() + "\n" +
//                         "\tisConnected(): " + CommandBase.imu.isConnected() +
//                         "\n" +
//                         "\tisCalibrating(): " + CommandBase.imu.isCalibrating() +
//                         "\n" +
//                         "\tgetUpdateCount(): " + CommandBase.imu.
//                         getUpdateCount() +
//                         "\n" +
//                         "\tgetByteCount(): " + CommandBase.imu.getByteCount() +
//                         "\n" +
//                         "\tgetYaw():" + CommandBase.imu.getYaw() + "\n" +
//                         "\tgetPitch(): " + CommandBase.imu.getPitch() + "\n" +
//                         "\tgetRoll(): " + CommandBase.imu.getRoll() + "\n" +
//                         "\tgetCompassHeading(): " + CommandBase.imu.
//                         getCompassHeading() +
//                         "\n" +
//                         "\tgetWorldLinearAccelX(): " + CommandBase.imu.
//                         getWorldLinearAccelX() + "\n" +
//                         "\tgetWorldLinearAccelY(): " + CommandBase.imu.
//                         getWorldLinearAccelY() + "\n" +
//                         "\tgetWorldLinearAccelZ(): " + CommandBase.imu.
//                         getWorldLinearAccelZ() + "\n" +
//                         "\tgetTempC(): " + CommandBase.imu.getTempC() + "\n" +
//                         "\tisMoving(): " + CommandBase.imu.isMoving() + "\n" +
//                         "\tgetAverageFromWorldLinearAccelHistory(): " +
//                         CommandBase.imu.getAverageFromWorldLinearAccelHistory() +
//                         "\n"
//        );
    }

    /**
     * This function is called periodically during test mode
     */
    public void testInit() {
        setSoftEnable(false);
        server.reset();
        server.startSamplingCounts();
    }

    public void testPeriodic() {
        LiveWindow.run();
        System.out.println("Current left: " + server.getLeftStatus()
                + ", current right: " + server.getRightStatus());
        System.out.println("Left count: " + server.getLeftCount()
                + ", right count: " + server.getRightCount()
                + ", total: " + server.getTotalCount() + "\n");
    }

    public void disabledInit() {
        server.stopSamplingCounts();
//        logger.flush();
        System.out.println("Disabled init");
    }

    public void disabledPeriodic() {
//        System.out.println("Disabled periodic");
    }
}
