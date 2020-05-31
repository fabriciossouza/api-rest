package br.com.api.endpoints;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserEndpointTest extends EndpointTest{

    @Test
    public void shouldReturnAllUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/rs/users")
                .header("Authorization", "Bearer " + getToken())
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldCreateUser() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                .post("/rs/users")
                .content("{\n" +
                        "\t\"name\": \"jose\",\n" +
                        "\t\"email\": \"jose@gmail.com\",\n" +
                        "\t\"password\": \"jose\"\n" +
                        "}")
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldReturnBadRequestWhenTryCreateEmailAlreadyExisting() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                .post("/rs/users")
                .content("{\n" +
                        "\t\"name\": \"User Existing\",\n" +
                        "\t\"email\": \"user@user.com\",\n" +
                        "\t\"password\": \"1234\"\n" +
                        "}")
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void shouldDeleteUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .delete("/rs/users/1010")
                .header("Authorization", "Bearer " + getToken())
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }
}
