package br.com.api.endpoints;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MarkEndpointTest extends EndpointTest{

    @Test
    public void shouldReturnAllMarks() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/rs/marks")
                .header("Authorization", "Bearer " + getToken())
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldReturnMarkById() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/rs/marks/2001")
                .header("Authorization", "Bearer " + getToken())
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldReturnPatrimoniesByMarkId() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/rs/marks/2001/patrimonies")
                .header("Authorization", "Bearer " + getToken())
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldCreateMark() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                .post("/rs/marks")
                .content("{\"name\": \"MARCA NOVA\"}")
                .header("Authorization", "Bearer " + getToken())
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldReturnBadRequestWhenTryCreateMarkWithSameName() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                .post("/rs/marks")
                .content("{\"name\": \"MARCA 3\"}")
                .header("Authorization", "Bearer " + getToken())
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void shouldChangeMark() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .put("/rs/marks/2002")
                .content("{\"name\": \"MARCA ALTERADA\"}")
                .header("Authorization", "Bearer " + getToken())
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void shouldDeleteMark() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .delete("/rs/marks/2003")
                .header("Authorization", "Bearer " + getToken())
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

}
