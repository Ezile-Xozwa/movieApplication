package za.ac.cput.util;


    public class MovieValidationHelper {
        public static boolean IsEmptyOrNullString (String str){
            return str == null || str.trim().isEmpty();
        }

        public static boolean isValidDuration(String duration) {
            return duration != null && duration.matches("^(\\d+h)?(\\s?\\d{1,2}min)?$");
        }

    }
