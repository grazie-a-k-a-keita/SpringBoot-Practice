package com.example.accessing_data_PostgreSQL;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.accessing_data_PostgreSQL.dto.MovieSubscriptionResponse;
import com.example.accessing_data_PostgreSQL.model.matching.Matching;
import com.example.accessing_data_PostgreSQL.model.movie.Movie;
import com.example.accessing_data_PostgreSQL.model.subscription.Subscription;
import com.example.accessing_data_PostgreSQL.repository.matching.MatchingRepository;
import com.example.accessing_data_PostgreSQL.repository.movie.MovieRepository;
import com.example.accessing_data_PostgreSQL.repository.subscription.SubscriptionRepository;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
  @Autowired
  private MovieRepository movieRepository;
  @Autowired
  private MatchingRepository matchingRepository;
  @Autowired
  private SubscriptionRepository subscriptionRepository;

  @GetMapping(path = "/movie/{id}")
  public @ResponseBody ResponseEntity<?> getMovieById(@PathVariable Integer id) {
    List<MovieSubscriptionResponse> list = new ArrayList<>();

    // 映画情報を取得
    Optional<Movie> movie = movieRepository.findById(id);
    if (!movie.isPresent()) {
      return new ResponseEntity<>("Movie not found", HttpStatus.NOT_FOUND);
    }

    List<Matching> matchingList = matchingRepository.findByMatching(movie.get().getMatchingId());

    // 映画情報とマッチングのIDに紐づく、サブスクリプション情報を取得
    for (Matching matching : matchingList) {
      MovieSubscriptionResponse movieSubscriptionResponse = new MovieSubscriptionResponse();
      movieSubscriptionResponse.setId(movie.get().getId());
      movieSubscriptionResponse.setTitle(movie.get().getTitle());
      movieSubscriptionResponse.setGenre(movie.get().getGenre());

      Optional<Subscription> subscription = subscriptionRepository.findById(matching.getSubId());
      if (!subscription.isPresent()) {
        return new ResponseEntity<>("Subscription not found", HttpStatus.NOT_FOUND);
      }

      movieSubscriptionResponse.setSubscriptionName(subscription.get().getSubscriptionName());
      list.add(movieSubscriptionResponse);
    }

    return new ResponseEntity<>(list, HttpStatus.OK);
  }

}
