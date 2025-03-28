package za.ac.cput.factory;

import za.ac.cput.domain.Home;
import za.ac.cput.util.HomeValidationHelper;

public class HomeFactory {
    public static Home createHome(String title, String movieId, String genre,String duration) {

        if (HomeValidationHelper.IsEmptyOrNullString(title) ||
                HomeValidationHelper.IsEmptyOrNullString(movieId) ||
                HomeValidationHelper.IsEmptyOrNullString(genre) ||
                HomeValidationHelper.IsEmptyOrNullString(duration))
                {
            return null;
        }

        return new Home.Builder()
                .setMovieId(movieId)
                .setTitle(title)
                .setGenre(genre)
                .setDuration(duration)
                .build();
    }

}
