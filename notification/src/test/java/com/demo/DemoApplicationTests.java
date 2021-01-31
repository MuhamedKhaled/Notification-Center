package com.demo;

import com.demo.request.UserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;


@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class DemoApplicationTests {

    @Autowired
    private TestRestTemplate client;

    String baseUrl = "http://localhost:8084";
    @Test
    void testCreateUser() {
        UserRequest request = new UserRequest("testName","Testemail@yahoo.com");
        assert(this.client.postForObject(baseUrl+"/users",
                request,String.class))
                .contains("User has been added successfully");
    }

    @Test
    void testDeleteUsers(){
        this.client.delete(baseUrl+"/users",String.class);
    }
    @Test
    void getUsers(){
        String users = this.client.getForObject(baseUrl+"/users",String.class);
        System.out.println(users);
    }
    @Test
    void getNotifications(){
        this.client.getForObject(baseUrl+"/notification/notifications",String.class);

    }
}
