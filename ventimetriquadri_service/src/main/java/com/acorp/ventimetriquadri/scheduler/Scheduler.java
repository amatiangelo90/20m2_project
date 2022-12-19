package com.acorp.ventimetriquadri.scheduler;

import com.acorp.ventimetriquadri.utils.Utils;
import com.acorp.ventimetriquadri.website.PienissimoClient;
import com.acorp.ventimetriquadri.website.entity.BranchLocation;
import com.acorp.ventimetriquadri.website.entity.Customer;
import com.acorp.ventimetriquadri.website.entity.CustomerAccess;
import com.acorp.ventimetriquadri.website.entity.PienissimoEntity;
import com.acorp.ventimetriquadri.website.service.CustomerAccessService;
import com.acorp.ventimetriquadri.website.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Thread.sleep;

@EnableScheduling
@Configuration
public class Scheduler {

    private static final Logger logger = LoggerFactory.getLogger(Scheduler.class);

    @Autowired
    private PienissimoClient pienissimoClient;

    @Autowired
    private CustomerService customerService;

    @Scheduled(cron = "0 45 22 * * *")
    public void migrateCustomerDataToPienissimoServer() {

        Instant now = Instant.now();
//        Instant yesterdayInst = now.minus(1, ChronoUnit.DAYS);

        String nowString = Utils.globalDTFormat.format(Date.from(now));
        logger.info("20m2 - Migrate customers data to Pienissimo server. Exporting data registered on date: " + nowString);
        List<Customer> customers = customerService.findAllByDate(nowString);



        if(customers.size() == 0){
            logger.info("No record found on CustomerAccess table for current date [" + nowString + "]");
        }else{

            List<PienissimoEntity> cisternino = new ArrayList<>();
            List<PienissimoEntity> locorotondo = new ArrayList<>();
            List<PienissimoEntity> monopoli = new ArrayList<>();

            logger.info("Found for current date [" + nowString + "] " + customers.size() + " records. Start migrating...");

            for(Customer customer : customers){
                logger.info("Current customer to migrate: " + customer.toString());
                for(CustomerAccess customerAccess : customer.getAccessesList()){
                    if(customerAccess.getAccessDate().equalsIgnoreCase(nowString)){

                        if(customerAccess.getBranchLocation() == BranchLocation.CISTERNINO){
                            cisternino.add(PienissimoEntity
                                    .builder()
                                    .cap("")
                                    .cod_univoco("35793246")
                                    .cognome(customer.getLastname())
                                    .data_nascita(customer.getDob())
                                    .email(customer.getEmail())
                                    .id_menu("1")
                                    .marketing("true")
                                    .nome(customer.getName())
                                    .numero_versione_informativa("1")
                                    .profilazione("true")
                                    .telefono(refactoringPhoneNumber(customer.getPhone()))
                                    .build()

                            );
                        }
                        if(customerAccess.getBranchLocation() == BranchLocation.LOCOROTONDO){
                            locorotondo.add(PienissimoEntity
                                    .builder()
                                    .cap("")
                                    .cod_univoco("91918886")
                                    .cognome(customer.getLastname())
                                    .data_nascita(customer.getDob())
                                    .email(customer.getEmail())
                                    .id_menu("1")
                                    .marketing("true")
                                    .nome(customer.getName())
                                    .numero_versione_informativa("1")
                                    .profilazione("true")
                                    .telefono(refactoringPhoneNumber(customer.getPhone()))
                                    .build()

                            );
                        }
                        if(customerAccess.getBranchLocation() == BranchLocation.MONOPOLI){
                            monopoli.add(PienissimoEntity
                                    .builder()
                                    .cap("")
                                    .cod_univoco("45349141")
                                    .cognome(customer.getLastname())
                                    .data_nascita(customer.getDob())
                                    .email(customer.getEmail())
                                    .id_menu("1")
                                    .marketing("true")
                                    .nome(customer.getName())
                                    .numero_versione_informativa("1")
                                    .profilazione("true")
                                    .telefono(refactoringPhoneNumber(customer.getPhone()))
                                    .build()

                            );
                        }
                    }
                }
            }

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();


            performPienissimoPostCall(cisternino, ow);

            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            performPienissimoPostCall(locorotondo, ow);

            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            performPienissimoPostCall(monopoli, ow);
        }
    }

    private void performPienissimoPostCall(List<PienissimoEntity> pienissimoEntities, ObjectWriter ow) {
        for(PienissimoEntity pienissimoEntity : pienissimoEntities){
            try {

                pienissimoClient.post(ow.writeValueAsString(pienissimoEntity));
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private String refactoringPhoneNumber(String phone) {
        if(phone.contains("+39")){
            return phone;
        }else{
            return "+39"+phone;
        }
    }
}
