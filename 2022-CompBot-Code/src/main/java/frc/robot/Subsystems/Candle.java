package frc.robot.Subsystems;

import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.RainbowAnimation;
import com.ctre.phoenix.led.SingleFadeAnimation;
import com.ctre.phoenix.led.CANdle.LEDStripType;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robots.RobotMap;
import frc.robot.Robots.Subsystems;

public class Candle {
/*    // Instance
    private static Candle mInstance = null;
    private DriveTrain mDrive;
    private final Climb mClimber;
    private final Index mIndexer;

    // CANdle
    private final CANdle mCANdle;

    // State
    private LEDState mState;

    // PeriodicIO
    private final PeriodicIO mPeriodicIO;

    public enum LEDState {
        IDLE, BALL_DETECT, AIM, PREP_CLIMB, CLIMBY_PARTY_MODE
    }

    public static class PeriodicIO {
        // Inputs
        Alliance[] indexerBalls = new Alliance[2];
        boolean leftHookState = false;
        boolean rightHookState = false;
        boolean aimState = false;
    }

    public synchronized static Candle getInstance() {
        if (mInstance == null) {
            mInstance = new Candle();
        }

        return mInstance;
    }

    public Candle() {
        mCANdle = RobotMap.candle;
        mCANdle.configLEDType(LEDStripType.GRB);

        mDrive = Subsystems.driveTrain;
        mIndexer = Subsystems.index;
        mClimber = Subsystems.climb;

        mPeriodicIO = new PeriodicIO();
        mState = LEDState.IDLE;
    }

    public static class LEDParameters {
        private LEDSequence[] ledSequences;

        public LEDParameters(LEDSequence[] ledSequences) {
            this.ledSequences = ledSequences;
        }

        public LEDSequence[] getSequences() {
            return ledSequences;
        }
    }

    public static class LEDSequence {
        int r, g, b, w, startIdx, ledCount;

        public LEDSequence(int r, int g, int b, int w, int startIdx, int ledCount) {
            this.r = r;
            this.g = g;
            this.b = b;
            this.w = w;
            this.startIdx = startIdx;
            this.ledCount = ledCount;
        }

        public int[] getColor() {
            return new int[] { r, g, b, w };
        }

        public int[] getLEDLength() {
            return new int[] { startIdx, ledCount };
        }
    }

    private static LEDParameters mParameters[] = {
            new LEDParameters(new LEDSequence[] { new LEDSequence(255, 75, 0, 0, 0, 120) }), // [0]

            new LEDParameters(
                    new LEDSequence[] { new LEDSequence(255, 0, 0, 0, 8, 10), new LEDSequence(255, 0, 0, 0, 47, 21),
                            new LEDSequence(0, 0, 0, 0, 18, 29) }), // Left Red, No Right [1]

            new LEDParameters(
                    new LEDSequence[] { new LEDSequence(0, 0, 255, 0, 8, 10), new LEDSequence(0, 0, 255, 0, 47, 21),
                            new LEDSequence(0, 0, 0, 0, 18, 29) }), // Left Blue, No Right [2]

            new LEDParameters(
                    new LEDSequence[] { new LEDSequence(0, 0, 0, 0, 8, 10), new LEDSequence(0, 0, 0, 0, 47, 21),
                            new LEDSequence(255, 0, 0, 0, 18, 29) }), // No Left, Right Red [3]

            new LEDParameters(
                    new LEDSequence[] { new LEDSequence(0, 0, 0, 0, 8, 10), new LEDSequence(0, 0, 0, 0, 47, 21),
                            new LEDSequence(0, 0, 255, 0, 18, 29) }), // No Left, Right Blue [4]

            new LEDParameters(
                    new LEDSequence[] { new LEDSequence(255, 0, 0, 0, 8, 10), new LEDSequence(255, 0, 0, 0, 47, 21),
                            new LEDSequence(255, 0, 0, 0, 18, 29) }), // Left Red, Right Red [5]

            new LEDParameters(
                    new LEDSequence[] { new LEDSequence(0, 0, 255, 0, 8, 10), new LEDSequence(0, 0, 255, 0, 47, 21),
                            new LEDSequence(0, 0, 255, 0, 18, 29) }), // Left Blue, Right Blue [6]

            // new LEDParameters(new LEDSequence[] { new LEDSequence(0, 0, 255, 0, 0, 76) }), // All Blue [7]

            // new LEDParameters(new LEDSequence[] { new LEDSequence(0, 0, 225, 0, 0, 76) }), // Lil Less All Blue [8]

            new LEDParameters(
                new LEDSequence[] { new LEDSequence(0, 255, 0, 0, 8, 10), new LEDSequence(0, 255, 0, 0, 47, 21),
                        new LEDSequence(255, 0, 0, 0, 18, 29) }), // Left Hook Good, No Right Hook [7]

            new LEDParameters(
                new LEDSequence[] { new LEDSequence(255, 0, 0, 0, 8, 10), new LEDSequence(255, 0, 0, 0, 47, 21),
                        new LEDSequence(0, 255, 0, 0, 18, 29) }), // No Left Hook, Right Hook Good [8]

            new LEDParameters(new LEDSequence[] { new LEDSequence(0, 255, 0, 0, 0, 76) }), // All Green [9]

            new LEDParameters(new LEDSequence[] { new LEDSequence(255, 0, 0, 0, 0, 76) }), // All Red [10]

            new LEDParameters(
                    new LEDSequence[] { new LEDSequence(0, 0, 255, 0, 8, 10), new LEDSequence(0, 0, 255, 0, 47, 21),
                            new LEDSequence(255, 0, 0, 0, 18, 29) }), // Left Blue, Right Red [11]

            new LEDParameters(
                    new LEDSequence[] { new LEDSequence(255, 0, 0, 0, 8, 10), new LEDSequence(255, 0, 0, 0, 47, 21),
                            new LEDSequence(0, 0, 255, 0, 18, 29) }), // Left Red, Right Blue [12]
            
            new LEDParameters(new LEDSequence[] { new LEDSequence(3, 252, 78, 0, 0, 76) }) // All Seafoam [13]
    };

    public void readPeriodicInputs(double timestamp) {
        mPeriodicIO.aimState = mDrive.getAimStatus();
        mPeriodicIO.indexerBalls = mIndexer.getIndexerColors();
        mPeriodicIO.leftHookState = mClimber.getElevatorHookLeftSensor();
        mPeriodicIO.rightHookState = mClimber.getElevatorHookRightSensor();
    }

    public void processLoop(double timestamp) {
            var idleSequences = mParameters[0].getSequences();

            switch (mState) {
                case IDLE:
                    for (var sequence : idleSequences) {
                        var color = sequence.getColor();
                        var length = sequence.getLEDLength();

                        mCANdle.setLEDs(color[0], color[1], color[2], color[3], length[0], length[1]);
                        mCANdle.setLEDs(0, 0, 255);
                    }

                    break;

                case BALL_DETECT:
                    var allianceColor = DriverStation.getAlliance();
                    var leftBallColor = mPeriodicIO.indexerBalls[0];
                    var rightBallColor = mPeriodicIO.indexerBalls[1];

                    var ballSequences = idleSequences;

                    if (allianceColor == Alliance.Red && mIndexer.getInfeederSensorState()) {
                        if ((leftBallColor == Alliance.Red && rightBallColor == Alliance.Invalid) ||
                            (leftBallColor == Alliance.Invalid && rightBallColor == Alliance.Red)) {
                            ballSequences = mParameters[5].getSequences(); // Top Red, Bottom Red
                        }
                        else if ((leftBallColor == Alliance.Blue && rightBallColor == Alliance.Invalid) ||
                                 (leftBallColor == Alliance.Invalid && rightBallColor == Alliance.Blue)) {
                            ballSequences = mParameters[11].getSequences(); // Top Red, Bottom Blue
                        }
                        else if (leftBallColor == Alliance.Blue && rightBallColor == Alliance.Red) {
                            if (allianceColor == Alliance.Red) {
                                ballSequences = mParameters[5].getSequences(); // Top Red, Bottom Red
                            }
                            else {
                                ballSequences = mParameters[11].getSequences(); // Top Red, Bottom Blue
                            }
                        }
                        else if (leftBallColor == Alliance.Red && rightBallColor == Alliance.Blue) {
                            if (allianceColor == Alliance.Red) {
                                ballSequences = mParameters[5].getSequences(); // Top Red, Bottom Red
                            }
                            else {
                                ballSequences = mParameters[11].getSequences(); // Top Red, Bottom Blue
                            }
                        }
                        else {
                            ballSequences = mParameters[3].getSequences(); // Top Red, Bottom None
                        }
                    }
                    else if (allianceColor == Alliance.Blue && mIndexer.getInfeederSensorState()) {
                        if ((leftBallColor == Alliance.Red && rightBallColor == Alliance.Invalid) ||
                            (leftBallColor == Alliance.Invalid && rightBallColor == Alliance.Red)) {
                            ballSequences = mParameters[12].getSequences(); // Top Blue, Bottom Red
                        }
                        else if ((leftBallColor == Alliance.Blue && rightBallColor == Alliance.Invalid) ||
                                 (leftBallColor == Alliance.Invalid && rightBallColor == Alliance.Blue)) {
                            ballSequences = mParameters[6].getSequences(); // Top Blue, Bottom Blue
                        }
                        else if (leftBallColor == Alliance.Blue && rightBallColor == Alliance.Red) {
                            if (allianceColor == Alliance.Blue) {
                                ballSequences = mParameters[6].getSequences(); // Top Blue, Bottom Blue
                            }
                            else {
                                ballSequences = mParameters[12].getSequences(); // Top Blue, Bottom Red
                            }
                        }
                        else if (leftBallColor == Alliance.Red && rightBallColor == Alliance.Blue) {
                            if (allianceColor == Alliance.Blue) {
                                ballSequences = mParameters[6].getSequences(); // Top Blue, Bottom Blue
                            }
                            else {
                                ballSequences = mParameters[12].getSequences(); // Top Blue, Bottom Red
                            }
                        }
                        else {
                            ballSequences = mParameters[4].getSequences(); // Top Blue, Bottom None
                        }
                    }
                    else {
                        if (leftBallColor == Alliance.Red && rightBallColor == Alliance.Invalid) {
                            ballSequences = mParameters[1].getSequences();
                        } else if (leftBallColor == Alliance.Blue && rightBallColor == Alliance.Invalid) {
                            ballSequences = mParameters[2].getSequences();
                        } else if (leftBallColor == Alliance.Invalid && rightBallColor == Alliance.Red) {
                            ballSequences = mParameters[3].getSequences();
                        } else if (leftBallColor == Alliance.Invalid && rightBallColor == Alliance.Blue) {
                            ballSequences = mParameters[4].getSequences();
                        } else if (leftBallColor == Alliance.Red && rightBallColor == Alliance.Red) {
                            ballSequences = mParameters[5].getSequences();
                        } else if (leftBallColor == Alliance.Blue && rightBallColor == Alliance.Blue) {
                            ballSequences = mParameters[6].getSequences();
                        } else if (leftBallColor == Alliance.Blue && rightBallColor == Alliance.Red) {
                            ballSequences = mParameters[11].getSequences();
                        } else if (leftBallColor == Alliance.Red && rightBallColor == Alliance.Blue) {
                            ballSequences = mParameters[12].getSequences();
                        }
                    }

                    for (var sequence : ballSequences) {
                        var color = sequence.getColor();
                        var length = sequence.getLEDLength(); 
                        
                        mCANdle.setLEDs(color[0], color[1], color[2], color[3], length[0], length[1]);
                    }

                    break;

                case AIM:
                    var aimSequences = mPeriodicIO.aimState ? mParameters[13].getSequences() : mParameters[10].getSequences();

                    for (var sequence : aimSequences) {
                        var color = sequence.getColor();
                        var length = sequence.getLEDLength();

                        mCANdle.setLEDs(color[0], color[1], color[2], color[3], length[0], length[1]);
                    }

                    break;

                case PREP_CLIMB:
                    var hookSequences = idleSequences;

                    if (mPeriodicIO.leftHookState && !mPeriodicIO.rightHookState) {
                        hookSequences = mParameters[7].getSequences();
                    } else if (!mPeriodicIO.leftHookState && mPeriodicIO.rightHookState) {
                        hookSequences = mParameters[8].getSequences();
                    } else if (mPeriodicIO.leftHookState && mPeriodicIO.rightHookState) {
                        hookSequences = mParameters[9].getSequences();
                    } else {
                        hookSequences = mParameters[10].getSequences();
                    }

                    for (var sequence : hookSequences) {
                        var color = sequence.getColor();
                        var length = sequence.getLEDLength();

                        mCANdle.setLEDs(color[0], color[1], color[2], color[3], length[0], length[1]);
                    }

                    break;

                case CLIMBY_PARTY_MODE:
                    var rainbowAnim = new RainbowAnimation();

                    mCANdle.animate(rainbowAnim);

                    break;
            }
    }

    public void writePeriodicOutputs(double timestamp) {
    }

    public void setState(LEDState state) {
        mState = state;
    }

    public LEDState getState() {
        return mState;
    }

    public void disableAllLEDs() {
        mCANdle.setLEDs(0, 0, 0);
        mCANdle.clearAnimation(0);
    }

    public void outputTelemetry(double timestamp) {
        SmartDashboard.putString("LED State", mState.toString());
    }

    public String getId() {
        return "LEDs";
    }
    */
}

