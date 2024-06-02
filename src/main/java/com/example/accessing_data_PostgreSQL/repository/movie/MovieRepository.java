package com.example.accessing_data_PostgreSQL.repository.movie;

import org.springframework.data.repository.CrudRepository;

import com.example.accessing_data_PostgreSQL.model.movie.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
