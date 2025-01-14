package frc.robot.commands;

import org.photonvision.PhotonCamera;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Systems;
import frc.robot.util.CameraCalc;

public class ShootPlusCommand extends ParallelCommandGroup {
    public static final double SHOOT_DELAY = 0.5;

    /*
     * 7.5m  - 17750 - 0.65
     * 2.15m - 11240 - 0.45
     */

    private final PhotonCamera camera;
    
    public ShootPlusCommand(Systems systems) {
        this.camera = systems.getCamera();

        addCommands(
            // new AnglerCommand(systems, AnglerCommand.COMMAND.SET, CameraCalc.calculateAngler(camera)),
            new WaitCommand(SHOOT_DELAY)
                .andThen(new ShootCommand(systems, CameraCalc.calculateRPM(camera)))
        );
    }
}
