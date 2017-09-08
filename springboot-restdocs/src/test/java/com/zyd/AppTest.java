package com.zyd;

import com.zyd.restdocs.controller.RestdocsController;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(RestdocsController.class)
//@AutoConfigureRestDocs(outputDir = "target/snippets")
public class AppTest {
    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/snippets");

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(this.restDocumentation))
                .build();
    }

    @Test
    public void index() throws Exception {
        this.mockMvc.perform(get("/index").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("index",responseFields(
                        fieldWithPath("message").description("The user's email address"))));
    }

    @Test
    public void getUserById() throws Exception {
        this.mockMvc.perform(get("/getUserById/{id}", 1))
                .andExpect(status().isOk())
                .andDo(document("getUserById", pathParameters(
                parameterWithName("id").description("用户ID")
        )));
    }

    @Test
    public void listUsers() throws Exception {
        this.mockMvc.perform(post("/listUsers").param("age","20").param("name", "张三"))
                .andExpect(status().isOk())
                .andDo(document("listUsers",requestParameters(
                        parameterWithName("age").description("用户年龄"),
                        parameterWithName("name").description("用户名"))));
    }

    @Test
    public void removeUser() throws Exception {
        this.mockMvc.perform(get("/removeUser/{id}", 1))
                .andExpect(status().isOk())
                .andDo(document("removeUser", pathParameters(
                        parameterWithName("id").description("用户ID")
                )));
    }
}
