package org.firstinspires.ftc.teamcode.subsystems.Arm;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.util.InterpLUT;

import org.firstinspires.ftc.teamcode.utils.BT.BTTranslation2d;
import org.firstinspires.ftc.teamcode.utils.cheesy.InterpolatingDouble;
import org.firstinspires.ftc.teamcode.utils.cheesy.InterpolatingTreeMap;

public class ArmConstants {
    public static final double armMass = 0;
    public static final double totalLength = 1; //in revolutions

    public static final double g = 9.81;
    public static double maxArmAngle = 0;

    @Config
    public static class TranslationConstants{
        public static final double x = 0;
        public static final double y = 0;
        public BTTranslation2d setpoint = new BTTranslation2d(x,y);
    }
    @Config
    public static class armPIDConstants {
        public static double kG = 0;
        public static double kS = 0.032;
        public static double eKP = 0;
        public static double eKI = 0;
        public static double eKD = 0;
        public static double pKP = 0;
        public static double pKI = 0;
        public static double pKD = 0;

    }
    public static class ffConstants{

    }

    public static class extensionConstants {
        public static double encoderToLength(double x){return x;}//find linear function
        public static final double[] segmentLengths = {0,0,0};//todo:find values
        public static final double[] segmentMasses = {0,0,0};//todo:find values

    }

//    public static class FFInterpolation{
//        private static final InterpolatingTreeMap<InterpolatingDouble,InterpolatingDouble> balanceByLength = new InterpolatingTreeMap<>();
//        static {
//            balanceByLength.put(new InterpolatingDouble(0.0),new InterpolatingDouble(110));
//            balanceByLength.put(new InterpolatingDouble(0.0),new InterpolatingDouble(107.0));
//            balanceByLength.put(new InterpolatingDouble(0.0),new InterpolatingDouble(107.0));
//        }
//        private static final InterpolatingTreeMap<InterpolatingDouble,InterpolatingDouble> maxFFangleByLength = new InterpolatingTreeMap<>();
//        static {
//            balanceByLength.put(new InterpolatingDouble(0.0),new InterpolatingDouble(110));
//            balanceByLength.put(new InterpolatingDouble(0.0),new InterpolatingDouble(107.0));
//            balanceByLength.put(new InterpolatingDouble(0.0),new InterpolatingDouble(107.0));
//        }


}
