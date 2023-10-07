package com.github.edsandrof.infnetjavaweb.infrastructure.util;

public class Constant {

    public static final String FILE_PATH = "src/main/resources";

    private Constant() {
    }

    public static class Page {
        public static final String REDIRECT = "redirect:/";
        public static final String HOME = "home";
        public static final String LOGIN = "login";

        private static final String VEHICLE = "vehicle";
        private static final String CAR = "car";
        private static final String TRUCK = "truck";
        private static final String MOTORCYCLE = "motorcycle";
        private static final String LIST = "list";
        private static final String REGISTER = "register";

        private static final String VEHICLE_CAR = VEHICLE + "/" + CAR;
        private static final String VEHICLE_TRUCK = VEHICLE + "/" + TRUCK;
        private static final String VEHICLE_MOTORCYCLE = VEHICLE + "/" + MOTORCYCLE;

        public static final String VEHICLE_LIST = VEHICLE + "/" + LIST;
        public static final String VEHICLE_REGISTER = VEHICLE + "/" + REGISTER;
        public static final String VEHICLE_CAR_LIST = VEHICLE_CAR + "/" + LIST;
        public static final String VEHICLE_CAR_REGISTER = VEHICLE_CAR + "/" + REGISTER;
        public static final String VEHICLE_TRUCK_LIST = VEHICLE_TRUCK + "/" + LIST;
        public static final String VEHICLE_TRUCK_REGISTER = VEHICLE_TRUCK + "/" + REGISTER;
        public static final String VEHICLE_MOTORCYCLE_LIST = VEHICLE_MOTORCYCLE + "/" + LIST;
        public static final String VEHICLE_MOTORCYCLE_REGISTER = VEHICLE_MOTORCYCLE + "/" + REGISTER;

        private Page() {
        }
    }
}
