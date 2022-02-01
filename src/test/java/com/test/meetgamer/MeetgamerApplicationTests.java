package com.test.meetgamer;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@SpringBootTest
@AutoConfigureMockMvc
class MeetgamerApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testenrollGame() throws Exception
	{
		String jsonString = "{\"userName\": \"hunter\", \"userNickName\": \"HunterxHunter\",\"gender\": \"Male\", \"region\": \"USA\", \"userGamePrefList\": [\n"
				+ "    {\"favGame\": \"Call of Duty: Warzone\", \"skillLevel\": \"Pro\"},\n"
				+ "    {\"favGame\": \"Destiny 2\", \"skillLevel\": \"Pro\"},\n"
				+ "    {\"favGame\": \"Valorant\", \"skillLevel\": \"Noob\"}\n"
				+ "]}";
		String result = 
		        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/enrollGamer")
		        		.content(jsonString)
		        		.contentType(MediaType.APPLICATION_JSON)
		        	    .accept(MediaType.APPLICATION_JSON))
		        	    .andExpect(status().isCreated())
		        	    .andDo(MockMvcResultHandlers.print())
		                .andReturn().getResponse().getContentAsString();
		assertNotNull(result);
	}
	
	@Test
	public void testAddUserCredits() throws Exception
	{
		String jsonString = "{\n"
				+ "    \"userCredits\": 800\n"
				+ "}";
		String result = 
		        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/addUserCredits/2")
		        		.content(jsonString)
		        		.contentType(MediaType.APPLICATION_JSON)
		        	    .accept(MediaType.APPLICATION_JSON))
		        	    .andExpect(status().isOk())
		        	    .andDo(MockMvcResultHandlers.print())
		                .andReturn().getResponse().getContentAsString();
		assertNotNull(result);
	}
	
	@Test
	public void testSearchGamers() throws Exception
	{
		String result = 
		        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/searchGamers/Pro/Monster Hunter World/ASIA")
		        	    .accept(MediaType.APPLICATION_JSON))
		                .andDo(print())
		        	    .andExpect(status().isOk())
		        	    .andDo(MockMvcResultHandlers.print())
		                .andReturn().getResponse().getContentAsString();
		assertNotNull(result);
	}
	
	@Test
	public void testGetGamerWithMaxCredit() throws Exception
	{
		String result = 
		        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/getGamerWithMaxCredit/Call of Duty: Warzone/Pro")
		        	    .accept(MediaType.APPLICATION_JSON))
		                .andDo(print())
		        	    .andExpect(status().isOk())
		        	    .andDo(MockMvcResultHandlers.print())
		                .andReturn().getResponse().getContentAsString();
		assertNotNull(result);
	}
	
	@Test
    public void testGetAllVideoGameInfo() throws Exception 
    {
		String result = 
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/videogameinfo")
        .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn().getResponse().getContentAsString();
		assertNotNull(result);
    }

}
