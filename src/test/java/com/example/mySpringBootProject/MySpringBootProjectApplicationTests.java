package com.example.mySpringBootProject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.mySpringBootProject.controller.StudentController;
import com.example.mySpringBootProject.service.MySpringBootService;
import com.example.mySpringBootProject.service.StudentService;

@SpringBootTest(classes = { MySpringBootProjectApplication.class, StudentService.class, StudentController.class, MySpringBootService.class})
@WebAppConfiguration
@AutoConfigureMockMvc
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(controllers = StudentController.class)
@RunWith(SpringJUnit4ClassRunner.class)
class MySpringBootProjectApplicationTests { //extends AbstractTest {

//	@Override
//	@Before
//	public void setUp() {
//		super.setUp();
//	}

	@Autowired
	private StudentService studentService;

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    @Before
    public void setUp() {
      this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
      //this.mockMvc = MockMvcBuilders.standaloneSetup(new StudentController()).build();

    }

	@Test
	public void testStudentSearchById() {
		System.out.println("Test #1");
		Assert.assertEquals("Returning the student with ID: 1", studentService.getStudentById(1));
	}

	/** Rests based tests **/

	@Test
	public void getStudentsTest() throws Exception {
		System.out.println("Test #2");
		String uri = "/students";
		System.out.println("mockMvc >> " +  mockMvc);
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept("application/text")).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		//String response = super.mapFromJson(content, String.class);
		System.out.println("Test Response :: " + content);
		assertTrue("Returning all the students' names.".equals(content));
	}

}
