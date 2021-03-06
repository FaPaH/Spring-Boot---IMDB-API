package sumdu.edu.ua.radchenko.lab3.services.servicesImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import sumdu.edu.ua.radchenko.lab3.connection.connectionImpl.ConnectionImpl;
import sumdu.edu.ua.radchenko.lab3.model.Movie;
import sumdu.edu.ua.radchenko.lab3.services.MovieService;

import java.util.concurrent.CompletableFuture;

@Service
public class MovieServiceImpl implements MovieService {

    private final static Logger logger = Logger.getLogger(MovieServiceImpl.class);

    private ConnectionImpl connection;

    @Autowired
    public void setConnection(ConnectionImpl connection) {
        this.connection = connection;
    }

    @Override
    @Async("processExecutor")
    public CompletableFuture<Movie> getMovieByName(String movieName) {
        logger.info("Call getMovieByName for: " + movieName);
        return CompletableFuture.completedFuture(connection.getMovieByName(movieName));
    }

    @Override
    @Async("processExecutor")
    public CompletableFuture<Movie> getMovieById(String movieId) {
        logger.info("Call getMovieByName for: " + movieId);
        return CompletableFuture.completedFuture(connection.getMovieById(movieId));
    }
}