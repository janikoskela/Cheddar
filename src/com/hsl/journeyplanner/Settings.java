package com.hsl.journeyplanner;

/**
 *
 * @author janikoskela
 */
public class Settings {
    private static CoordinateSystem inCoordinateSystem = CoordinateSystem.KKJ2;
    private static CoordinateSystem outCoordinateSystem = CoordinateSystem.KKJ2;
    
    public enum CoordinateSystem {
        KKJ2("2392"), KKJ1("2391"), KKJ3("2393"), WGS84("4326"), Mercator("3395");
        
        private String coordinateSystem;
        private CoordinateSystem(String coordinateSystem) {
            this.coordinateSystem = coordinateSystem;
        }
        
        @Override
        public String toString(){
            return coordinateSystem;
        }
    }

    public static CoordinateSystem getInCoordinateSystem() {
        return inCoordinateSystem;
    }

    public static void setInCoordinateSystem(CoordinateSystem inCoordinateSystem) {
        Settings.inCoordinateSystem = inCoordinateSystem;
    }

    public static CoordinateSystem getOutCoordinateSystem() {
        return outCoordinateSystem;
    }

    public static void setOutCoordinateSystem(CoordinateSystem outCoordinateSystem) {
        Settings.outCoordinateSystem = outCoordinateSystem;
    }
}
