package com.orion.io.ashish.MovieCatalogService.resources;

import com.orion.io.ashish.MovieCatalogService.models.CatalogueItem;
import com.orion.io.ashish.MovieCatalogService.models.Movie;
import com.orion.io.ashish.MovieCatalogService.models.Rating;
import com.orion.io.ashish.MovieCatalogService.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogueItem> getCatalog(@PathVariable("userId") String userId)
    {


//        List<Rating> ratings = Arrays.asList(
//                new Rating("1234", 4),
//                new Rating("5678", 3)
//        );

        UserRating userRatings = restTemplate.getForObject("http://localhost:8082/ratingsdata/users/" + "ashish",
                UserRating.class);

        return userRatings.getUserRatings().stream().map(rating -> {
            Movie movie  = restTemplate.getForObject("http://localhost:8081/movies/" + rating.getMovieiD(), Movie.class);
            /*Movie movie = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8081/movies/" + rating.getMovieId))
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();
            */
            return new CatalogueItem(movie.getName(), "test_desc", rating.getRating());
        })
        .collect(Collectors.toList());

    }

}
