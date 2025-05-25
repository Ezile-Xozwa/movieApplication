package za.ac.cput.util;


    public class HomeValidationHelper {
        public static boolean IsEmptyOrNullString (String str){
            return str == null || str.trim().isEmpty();
        }
        public static boolean isValidMovieId(String movieId){
            return movieId != null && movieId.matches("^[A-Za-z0-9_-]+$");
        }

        public static boolean isValidDuration(String duration) {
            return duration != null && duration.matches("^(\\d+h)?(\\s?\\d{1,2}min)?$");
        }

    }
