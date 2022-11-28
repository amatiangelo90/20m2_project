//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.web.client.RestTemplate;
//import test_repository.UserEntityRepository;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class TestSuite {
//
//    @LocalServerPort
//    private int port;
//
//
//    private String baseUrl = "http://localhost";
//
//    private static RestTemplate restTemplate;
//
//
//    @Autowired
//    private UserEntityRepository userEntityRepository;
//
//
//    @BeforeAll
//    public static void init(){
//        restTemplate = new RestTemplate();
//    }
//
//    @BeforeEach
//    public void setUp(){
//        baseUrl = baseUrl.concat(":").concat(port+"").concat("/ventimetriquadriservice");
//    }
//}
