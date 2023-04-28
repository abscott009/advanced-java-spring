package platform.codingnomads.co.springtest.lab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import platform.codingnomads.co.springtest.lab.SpringTestLab;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;
import platform.codingnomads.co.springtest.lab.service.MovieService;

import static javax.swing.UIManager.get;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = SpringTestLab.class)
@AutoConfigureMockMvc
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    MovieRepository movieRepo;

    @org.testng.annotations.Test
    public void testGetAllMoviesSuccess() throws Exception{


    }

    @Test
    public void testGetAllMoviesFailure() throws Exception {

        when(movieService.getAllMovies()).thenThrow(new NoSuchMovieException("Not listed"));

        //perform GET all movies
        this.mockMvc.perform(get("/all"))
                .andDo(print())
                //expect 404 NOT FOUND
                .andExpect(status().isNotFound())
                //expect error message defined above
                .andExpect(content().string(containsString("Not listed")));

    }

    @Test
    public void testGetAllMoviesSuccessMockService() {
        mockMvc.perform(get("/all"))

                .andExpect(status().isOk())

                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

                .andExpect(jsonPath("$", hasSize(2)));

    }
}
