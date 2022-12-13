import com.acorp.ventimetriquadri.VentimetriquadriApplication;
import com.acorp.ventimetriquadri.app.user.UserEntity;
import com.acorp.ventimetriquadri.app.user.UserRepository;
import com.acorp.ventimetriquadri.app.user.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = VentimetriquadriApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TestSuite {

//    @Autowired
//    private MockMvc mockMvc;

    @LocalServerPort
    private int port;

    private static String baseUrl = "http://localhost";


    private ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    private static RestTemplate restTemplate;

    private static final Logger LOG = LoggerFactory.getLogger(TestSuite.class);


    @BeforeEach
    public void initUrl(){
        baseUrl = baseUrl.concat(":").concat(port  + "");
    }

    @BeforeAll
    public static void init(){
        restTemplate = new RestTemplate();
    }

    @Test
    public void user_entity_check_create_check_findall_check_delete_() throws Exception {
        UserEntity angelo = new UserEntity(0, "Angelo", "Amati", "anmatas.asd@gmai.com", "123123123");
        UserEntity alberto = new UserEntity(0, "Alberto", "Amati", "anma123asd@gmai.com", "1231243123");
        UserEntity balo = new UserEntity(0, "Bslo", "Amati", "anmat3333as.asd@gmai.com", "123656123123");

        String save = baseUrl.concat("/api/v1/app/users/save");
        restTemplate.postForObject(save, angelo, Void.class);
//        restTemplate.postForObject(save, alberto, Void.class);
//        restTemplate.postForObject(save, balo, Void.class);


//        mockMvc.perform(post("/api/v1/app/users/save")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(ow.writeValueAsString(angelo)))
//                .andDo(print())
//                .andExpect(status().isOk());
//
//        mockMvc.perform(post("/api/v1/app/users/save")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(ow.writeValueAsString(alberto)))
//                .andDo(print())
//                .andExpect(status().isOk());
//
//        mockMvc.perform(post("/api/v1/app/users/save")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(ow.writeValueAsString(balo)))
//                .andDo(print())
//                .andExpect(status().isOk());

        String findAllUrl = baseUrl.concat("/api/v1/app/users/findall");

        ArrayList<UserEntity> userEntities = restTemplate.getForObject(findAllUrl, ArrayList.class);
        assertEquals(3, userEntities.size());

        if(userEntities.size() != 0){
            System.out.println("Outcoming users: ");
            for(UserEntity user : userEntities){
                System.out.println(ow.writeValueAsString(user));
            }
        }


    }


    @Test
    public void user_entity_check_create_check_findall_check_delete() throws Exception {
//        UserEntity userEntity
//                = UserEntity.builder()
//                .name("Angelo")
//                .lastname("Amati")
//                .email("amati.angelo90@gmail.com")
//                .phone("3454937601")
//                .userId(0)
//                .build();

//
//        System.out.println("INFO - User to json : " + ow.writeValueAsString(userEntity));
//
//        mockMvc.perform(post("/api/v1/app/users/save")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(ow.writeValueAsString(userEntity)))
//                .andDo(print())
//                .andExpect(status().isOk());
//
//        mockMvc.perform(get("/api/v1/app/users/findall"))
//                .andExpect(status().isOk());


//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$customerId").value("1"));

    }

}