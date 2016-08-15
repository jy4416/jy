package com.jy.controller;

import org.junit.Test;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GroupControllerTest extends BaseTest {
	
	@Test
	public void testGroups() throws Exception{
		mockMvc.perform(
				get("/groups")
				.param("pageNum", 1+"")
				.param("pageSize", 4+"")
				)
				.andDo(print())
				.andExpect(status().isOk());
	}

}
