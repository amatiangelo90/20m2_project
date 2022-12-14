//import com.acorp.ventimetriquadri.app.user.UserEntity;
//import com.acorp.ventimetriquadri.app.user.UserRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.support.AnnotationConfigContextLoader;
//
//import javax.annotation.Resource;
//import javax.transaction.Transactional;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(
//        classes = { ConfigurationTest.class },
//        loader = AnnotationConfigContextLoader.class)
//@Transactional
//public class TestSuite {
//
//    @Resource
//    private UserRepository userRepository;
//
//    @Test
//    public void givenStudent_whenSave_thenGetOk() {
//
//        userRepository.save(UserEntity.builder().name("Angelo").email("amati.angelo90@gmail.com").build());
//
//        UserEntity userEntity = userRepository.findByEmail("amati.angelo90@gmail.com");
//        assertEquals("Angelo", userEntity.getName());
//    }
//
////    @Test
////    public void user_entity_check_create_check_findall_check_delete_() throws Exception {
////        UserEntity angelo = new UserEntity(0, "Angelo", "Amati", "anmatas.asd@gmai.com", "123123123");
////        UserEntity alberto = new UserEntity(0, "Alberto", "Amati", "anma123asd@gmai.com", "1231243123");
////        UserEntity balo = new UserEntity(0, "Bslo", "Amati", "anmat3333as.asd@gmai.com", "123656123123");
////
////        String save = baseUrl.concat("/api/v1/app/users/save");
////        restTemplate.postForObject(save, angelo, Void.class);
//////        restTemplate.postForObject(save, alberto, Void.class);
//////        restTemplate.postForObject(save, balo, Void.class);
////
////
//////        mockMvc.perform(post("/api/v1/app/users/save")
//////                .contentType(MediaType.APPLICATION_JSON)
//////                .content(ow.writeValueAsString(angelo)))
//////                .andDo(print())
//////                .andExpect(status().isOk());
//////
//////        mockMvc.perform(post("/api/v1/app/users/save")
//////                .contentType(MediaType.APPLICATION_JSON)
//////                .content(ow.writeValueAsString(alberto)))
//////                .andDo(print())
//////                .andExpect(status().isOk());
//////
//////        mockMvc.perform(post("/api/v1/app/users/save")
//////                .contentType(MediaType.APPLICATION_JSON)
//////                .content(ow.writeValueAsString(balo)))
//////                .andDo(print())
//////                .andExpect(status().isOk());
////
////        String findAllUrl = baseUrl.concat("/api/v1/app/users/findall");
////
////        ArrayList<UserEntity> userEntities = restTemplate.getForObject(findAllUrl, ArrayList.class);
////        assertEquals(3, userEntities.size());
////
////        if(userEntities.size() != 0){
////            System.out.println("Outcoming users: ");
////            for(UserEntity user : userEntities){
////                System.out.println(ow.writeValueAsString(user));
////            }
////        }
////
////
////    }
//
////
////    @Test
////    public void user_entity_check_create_check_findall_check_delete() throws Exception {
//////        UserEntity userEntity
//////                = UserEntity.builder()
//////                .name("Angelo")
//////                .lastname("Amati")
//////                .email("amati.angelo90@gmail.com")
//////                .phone("3454937601")
//////                .userId(0)
//////                .build();
////
//////
//////        System.out.println("INFO - User to json : " + ow.writeValueAsString(userEntity));
//////
//////        mockMvc.perform(post("/api/v1/app/users/save")
//////                .contentType(MediaType.APPLICATION_JSON)
//////                .content(ow.writeValueAsString(userEntity)))
//////                .andDo(print())
//////                .andExpect(status().isOk());
//////
//////        mockMvc.perform(get("/api/v1/app/users/findall"))
//////                .andExpect(status().isOk());
////
////
//////                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//////                .andExpect(jsonPath("$customerId").value("1"));
////
////    }
//
//}