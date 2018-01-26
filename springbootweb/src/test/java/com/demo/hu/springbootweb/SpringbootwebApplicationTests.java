package com.demo.hu.springbootweb;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class SpringbootwebApplicationTests {
	private MockMvc mvc;

	@Before
	public void setUp() throws Exception{
		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}

	@Test
	public void testUserController() throws Exception {
	//测试UserController
		RequestBuilder request = null;
		//1.get查一下user列表，应该为空；
//		request = get("/users/");
//		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));
		//2.post提交一个User
		mvc.perform(post("/users/").
				param("id","1").
				param("name","测试大师").
				param("age","20")).andExpect(content().string(equalTo("success")));
		//3.get获取Use列表，应该有刚才插入的数据
		mvc.perform(get("/users/")).
				andExpect(status().isOk()).
				andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]")));
		//4.put修改id位1的User
		mvc.perform(put("/users/1").
				param("name","测试终极大师").
				param("age","26")).
				andExpect(content().string(equalTo("success")));
		//5.get一个id为1的user
		mvc.perform(get("/users/1")).
				andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":26}")));
		//6.del删除id为1的user
		mvc.perform(delete("/users/1")).
				andExpect(content().string(equalTo("success")));
		//7.get查一下user列表，应该为空
		mvc.perform(get("/users/")).
				andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));
	}

}
