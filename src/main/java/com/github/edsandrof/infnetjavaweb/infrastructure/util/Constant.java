package com.github.edsandrof.infnetjavaweb.infrastructure.util;

public class Constant {

    public static final String FILE_PATH = "src/main/resources";

    private Constant() {
    }

    public static class Page {
        public static final String REDIRECT = "redirect:/";
        public static final String HOME = "home";
        public static final String LOGIN = "login";
        public static final String ERROR = "error";
        public static final String ABOUT = "about";

        public static final String VEHICLE = "vehicle";
        public static final String CAR = "car";
        public static final String TRUCK = "truck";
        public static final String MOTORCYCLE = "motorcycle";
        public static final String EMPLOYEE = "employee";
        public static final String VEHICLE_SALE = "vehiclesale";
        public static final String VEHICLE_BUYER = "vehiclebuyer";
        private static final String LIST = "/list";
        private static final String REGISTER = "/register";

        public static final String VEHICLE_CAR = VEHICLE + "/" + CAR;
        public static final String VEHICLE_TRUCK = VEHICLE + "/" + TRUCK;
        public static final String VEHICLE_MOTORCYCLE = VEHICLE + "/" + MOTORCYCLE;

        public static final String VEHICLE_LIST = VEHICLE + LIST;
        public static final String VEHICLE_REGISTER = VEHICLE + REGISTER;
        public static final String VEHICLE_CAR_LIST = VEHICLE_CAR + LIST;
        public static final String VEHICLE_CAR_REGISTER = VEHICLE_CAR + REGISTER;
        public static final String VEHICLE_TRUCK_LIST = VEHICLE_TRUCK + LIST;
        public static final String VEHICLE_TRUCK_REGISTER = VEHICLE_TRUCK + REGISTER;
        public static final String VEHICLE_MOTORCYCLE_LIST = VEHICLE_MOTORCYCLE + LIST;
        public static final String VEHICLE_MOTORCYCLE_REGISTER = VEHICLE_MOTORCYCLE + REGISTER;

        public static final String VEHICLE_SALE_LIST = VEHICLE_SALE + LIST;
        public static final String VEHICLE_SALE_REGISTER = VEHICLE_SALE + REGISTER;
        public static final String VEHICLE_BUYER_LIST = VEHICLE_BUYER + LIST;
        public static final String VEHICLE_BUYER_REGISTER = VEHICLE_BUYER + REGISTER;
        public static final String EMPLOYEE_LIST = EMPLOYEE + LIST;
        public static final String EMPLOYEE_REGISTER = EMPLOYEE + REGISTER;


        private Page() {
        }
    }

    public static class Route {
        public static final String VEHICLE = "/" + Page.VEHICLE;
        public static final String CAR = "/" + Page.VEHICLE_CAR;
        public static final String TRUCK = "/" + Page.VEHICLE_TRUCK;
        public static final String MOTORCYCLE = "/" + Page.VEHICLE_MOTORCYCLE;
        public static final String EMPLOYEE = "/" + Page.EMPLOYEE;
        public static final String VEHICLE_SALE = "/" + Page.VEHICLE_SALE;
        public static final String VEHICLE_BUYER = "/" + Page.VEHICLE_BUYER;
    }
}
