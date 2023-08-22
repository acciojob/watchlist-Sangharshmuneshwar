package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return ResponseEntity.ok("Movie added successfully.");
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return ResponseEntity.ok("Director added successfully.");
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movieName, @RequestParam String directorName){
        movieService.addMovieDirectorPair(movieName,directorName);
        return ResponseEntity.ok("movie-director-pair added successfully.");
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
     Movie movie = movieService.getMovieByName(name);
     return ResponseEntity.ok(movie);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director director1 = movieService.getDirectorByName(name);
        return ResponseEntity.ok(director1);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
     List<String> movies = movieService.getMoviesByDirectorName(director);
     return ResponseEntity.ok(movies);
    }

   @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
       List<String> movies = movieService.findAllMovies();
     return ResponseEntity.ok(movies);
   }

   @DeleteMapping("/delete-director-by-name")
   public ResponseEntity<String> deleteDirectorByName(@RequestParam String name){
        movieService.deleteDirectorByName(name);
       return ResponseEntity.ok("Director and its movies are deleted");
   }

   @DeleteMapping("/delete-all-directors")
   public ResponseEntity<String> deleteAllDirectors(){
    movieService.deleteAllDirectors();
    return ResponseEntity.ok("All director and their movies are deleted");
   }
}
