package br.com.api.endpoints;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PatrimonyEndpointTest extends EndpointTest{

    @Test
    public void shouldReturnAllPatrimony() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/rs/patrimonies")
                .header("Authorization", "Bearer " + getToken())
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldReturnPatrimonyById() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/rs/patrimonies/1001")
                .header("Authorization", "Bearer " + getToken())
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldCreatePatrimony() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                .post("/rs/patrimonies")
                .content("{\n" +
                        "\t\"name\": \"Patrimonio 1\",\n" +
                        "\t\"description\": \"Patriminio Description\",\n" +
                        "\t\"mark\": {\n" +
                        "\t\t\"id\": 2001\n" +
                        "\t}\n" +
                        "}")
                .header("Authorization", "Bearer " + getToken())
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldChangePatrimony() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                .put("/rs/patrimonies/1001")
                .content("{\n" +
                        "\t\"name\": \"Patrimonio Alterado\",\n" +
                        "\t\"description\": \"Patriminio Description Alterado\",\n" +
                        "\t\"mark\": {\n" +
                        "\t\t\"id\": 2002\n" +
                        "\t}\n" +
                        "}")
                .header("Authorization", "Bearer " + getToken())
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldReturnBadRequestWhenTryChangeNumTumbles() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                .put("/rs/patrimonies/1001")
                .content("{\n" +
                        "\t\"name\": \"Patrimonio Alterado\",\n" +
                        "\t\"description\": \"Patriminio Description Alterado\",\n" +
                        "\t\"numTumble\": 1000,\n" +
                        "\t\"mark\": {\n" +
                        "\t\t\"id\": 2002\n" +
                        "\t}\n" +
                        "}")
                .header("Authorization", "Bearer " + getToken())
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void shouldDeletePatrimony() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .delete("/rs/patrimonies/1002")
                .header("Authorization", "Bearer " + getToken())
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

}
