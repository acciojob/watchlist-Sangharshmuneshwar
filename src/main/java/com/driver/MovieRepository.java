package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {
    private HashMap<String,Movie> moviesMap = new HashMap<>();
    private HashMap<String,Director> directorsMap = new HashMap<>();
    private Map<String, List<String>> directorMovieMap = new HashMap<>();

    public void addMovie(Movie movie) {
        moviesMap.put(movie.getName(),movie);
    }

    public void addDirector(Director director) {
        directorsMap.put(director.getName(),director);
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        List<String> movieList = directorMovieMap.getOrDefault(directorName,new ArrayList<>());
        movieList.add(movieName);
        directorMovieMap.put(directorName,movieList);
    }

    public Movie getMovieByName(String name) {
        return moviesMap.get(name);
    }

    public Director getDirectorByName(String name) {
        return directorsMap.get(name);
    }

    public List<String> getMoviesByDirectorName(String director) {
        return directorMovieMap.getOrDefault(director,new ArrayList<>());
    }

    public List<String> findAllMovies() {
        return new ArrayList<>(moviesMap.keySet());
    }

    public void deleteDirectorByName(String name) {
        directorsMap.remove(name);
        directorMovieMap.remove(name);
    }

    public void deleteAllDirectors() {
        directorsMap.clear();
        for (String name : directorsMap.keySet()){
            if(!name.equals("")){
                directorsMap.remove(name);
            }
        }
    }
}
