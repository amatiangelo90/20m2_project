package com.acorp.ventimetriquadri.app;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.branch.BranchService;
import com.acorp.ventimetriquadri.app.event.Event;
import com.acorp.ventimetriquadri.app.event.EventService;
import com.acorp.ventimetriquadri.app.event.expences.ExpenceEvent;
import com.acorp.ventimetriquadri.app.event.utils.EventStatus;
import com.acorp.ventimetriquadri.app.event.utils.WorkstationType;
import com.acorp.ventimetriquadri.app.event.workstations.Workstation;
import com.acorp.ventimetriquadri.app.event.workstations.WorkstationService;
import com.acorp.ventimetriquadri.app.order.OrderEntity;
import com.acorp.ventimetriquadri.app.order.OrderService;
import com.acorp.ventimetriquadri.app.product.Product;
import com.acorp.ventimetriquadri.app.product.ProductService;
import com.acorp.ventimetriquadri.app.product.product_utils.UnitMeasure;
import com.acorp.ventimetriquadri.app.relations.order_product.R_OrderProduct;
import com.acorp.ventimetriquadri.app.relations.supplier_product.SupplierProductRepository;
import com.acorp.ventimetriquadri.app.storage.Storage;
import com.acorp.ventimetriquadri.app.storage.StorageService;
import com.acorp.ventimetriquadri.app.supplier.Supplier;
import com.acorp.ventimetriquadri.app.supplier.SuppliersService;
import com.acorp.ventimetriquadri.app.user.UserEntity;
import com.acorp.ventimetriquadri.app.user.UserService;
import com.acorp.ventimetriquadri.app.user.UserType;
import com.acorp.ventimetriquadri.utils.Utils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class InitRunConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserService userService,
                                        BranchService branchService,
                                        SuppliersService suppliersService,
                                        ProductService productService,
                                        StorageService storageService,
                                        EventService eventService,
                                        WorkstationService workstationService,
                                        OrderService orderService,
                                        SupplierProductRepository supplierProductRepository                                        ){
        return args -> {
//            // creo e salvo un utente
            UserEntity userEntity = getUserEntityBody();
            UserEntity userEntity1 = userService.addNewUser(userEntity);
//
//            //TEST - non esiste ancora un branch associato all'utente creato
//            List<Branch> branchListRetrievedByUserIdFake = userService.retrieveAllBranchesByUserId(userEntity1.getUserId());
//            // con l'id dell'utente salvato creo un branch (associato all'utente)
//            Branch branchEntity = getBranchEntity(userEntity1.getUserId());
//            branchService.addNewBranch(branchEntity);
//
//            //TEST - esiste il branch associato all'utente
//            List<Branch> branchListRetrievedByUserId = userService.retrieveAllBranchesByUserId(userEntity1.getUserId());
//    //creo un supplier associandolo direttamente al branch su cui sto lavorando in questo momento
//            Supplier supplier = getSupplierEntity(branchListRetrievedByUserId.get(0).getBranchId());
//            Supplier supplierSaved = suppliersService.saveSupplier(supplier);
//
//            //creo 20 prodotti da associare al fornitore(supplier) sul quale sto lavorando
//            List<Product> buildProductList = retriveProductList(supplier.getSupplierId(), 3);
//
//            for(Product product : buildProductList){
//                productService.saveProduct(product);
//            }
//
//            //TEST - salvo e controllo che ad una successiva ricerca di prodotti per SupplierID il numero dei prodotti sia corrispndente a quello salvato
//            List<Product> allBySupplierId = productService.findAllBySupplierId(supplierSaved.getSupplierId());
//
//            List<Product> prodListWithFakeSupplierId = productService.findAllBySupplierId(62354);
//
//            Storage storage = buildStorageEntity(branchEntity.getBranchId());
//
//            Storage storageSaved = storageService.saveStorage(storage);
//
//            List<Branch> br = userService.retrieveAllBranchesByUserId(userEntity1.getUserId());
//
//            storageService.insertProductIntoStorage(storageSaved.getStorageId(), (br.get(0).getSuppliers().get(0).getProductList().get(0).getProductId()));
//            storageService.insertProductIntoStorage(storageSaved.getStorageId(), (br.get(0).getSuppliers().get(0).getProductList().get(1).getProductId()));
//            storageService.insertProductIntoStorage(storageSaved.getStorageId(), (br.get(0).getSuppliers().get(0).getProductList().get(2).getProductId()));
//
//
//            br = userService.retrieveAllBranchesByUserId(userEntity1.getUserId());
//
//
//            storageService.addStockAmountToStorageProduct(1, 34);
//
//
//            Storage currentStorage = br.get(0).getStorages().get(0);
//            R_StorageProduct r_storageProduct = br.get(0).getStorages().get(0).getProducts().get(1);
//
//
//            Event event = buildEventForBranch(branchListRetrievedByUserId.get(0).getBranchId(), storageSaved.getStorageId());
//
//            Event eventSaved = eventService.createEvent(event);
//
//
//            List<ExpenceEvent> expenceEvents = createEventExpence(eventSaved.getEventId(), 5);
//
//            for(ExpenceEvent expenceEvent : expenceEvents){
//                eventService.saveExpence(expenceEvent);
//            }
//
//            List<Workstation> workstations = createWorkstationList(eventSaved.getEventId(), 5);
//
//            for(Workstation workstation : workstations){
//                eventService.createWorkstation(workstation);
//            }
//
//            List<Branch> brAfterUpdate = userService.retrieveAllBranchesByUserId(userEntity1.getUserId());
//
//            eventService.deleteEventExpence(brAfterUpdate.get(0).getEvents().get(0).getExpenceEvents().get(0));
//
//            Event eventToRework = brAfterUpdate.get(0).getEvents().get(0);
//            Workstation workstation = eventToRework.getWorkstations().get(0);
//            Workstation workstation_1 = eventToRework.getWorkstations().get(1);
//
//            List<StorageProduct> storageProducts = storageService.retrieveAllProductByStorage(Storage.builder().storageId(eventToRework.getStorageId()).build());
//
//
//            workstationService.insertProductIntoWorkstation(workstation.getWorkstationId(),
//                    storageProducts.get(0).getProductId(),
//                    eventToRework.getStorageId());
//
//
//            workstationService.insertProductIntoWorkstation(workstation.getWorkstationId(), storageProducts.get(2).getProductId(), eventToRework.getStorageId());
//
//            workstationService.insertProductIntoWorkstation(workstation_1.getWorkstationId(), storageProducts.get(1).getProductId(), eventToRework.getStorageId());
//            workstationService.insertProductIntoWorkstation(workstation_1.getWorkstationId(), storageProducts.get(2).getProductId(), eventToRework.getStorageId());
//
//
////        eventService.closeEvent(eventSaved);
//
//            brAfterUpdate = userService.retrieveAllBranchesByUserId(userEntity1.getUserId());
//
//            workstation.setProducts(
//                    workstationService.retrieveAllProductByWorkstationId(workstation.getWorkstationId())
//            );
//
////        workstationService.removeProductFromWorkstation(workstation1.getProducts().get(1).getWorkstationProductId());
////
//            workstation.setProducts(
//                    workstationService.retrieveAllProductByWorkstationId(workstation.getWorkstationId())
//            );
//
//            workstation_1.setProducts(
//                    workstationService.retrieveAllProductByWorkstationId(workstation_1.getWorkstationId())
//            );
//
////        workstationService.removeProductFromWorkstation(workstation1.getProducts().get(1).getWorkstationProductId());
////
//            workstation_1.setProducts(
//                    workstationService.retrieveAllProductByWorkstationId(workstation_1.getWorkstationId())
//            );
//
//
//            List<R_WorkstationProduct> products = workstation.getProducts();
//
//            workstation.setProducts(
//                    workstationService.retrieveAllProductByWorkstationId(workstation.getWorkstationId())
//            );
//
//
//            workstationService.workstationProduct_updateStockValue(workstation.getProducts().get(0).getWorkstationProductId(), 77);
//            workstationService.workstationProduct_updateConsumedValue(workstation.getProducts().get(0).getWorkstationProductId(), 45);
//
//            workstationService.removeProductFromWorkstation(1);
//
//            workstationService.removeWorkstation(workstation.getWorkstationId());
//
//            brAfterUpdate = userService.retrieveAllBranchesByUserId(userEntity1.getUserId());
//
//
//            List<ExpenceEvent> allByEvent = eventExpenceRepository.findAllByEvent(Event.builder().eventId(1).build());
//
//            List<Branch> branches = userService.retrieveAllBranchesByUserId(userEntity1.getUserId());
//
//            OrderEntity orderEntity = buildOrderEntity(
//                    branches.get(0).getBranchId(),
//                    branches.get(0).getSuppliers().get(0).getSupplierId(),
//                    branches.get(0).getStorages().get(0).getStorageId(),
//                    supplierProductRepository);
//
//
//
//            OrderEntity orderProcessed = orderService.sendOrder(orderEntity);
//            branches = userService.retrieveAllBranchesByUserId(userEntity1.getUserId());
//
//            System.out.println("XXXXXXXXXXXXXXXXXXXX: " + Utils.jsonFormat(branches));
        };
    }

    private OrderEntity buildOrderEntity(long branchId,
                                         long supplierId,
                                         long storageId, SupplierProductRepository supplierProductRepository) {
        return OrderEntity.builder()
                .branchId(branchId)
                .storageId(storageId)
                .code(UUID.randomUUID().toString())
                .details("ORDINE XXXXXX")
                .creationDate(Utils.globalDTFormat.format(new Date()))
                .deliveryDate(Utils.globalDTFormat.format(new Date()))
                .products(buildOrderProducts(supplierId, supplierProductRepository))
                .supplierId(supplierId)
                .build();
    }

    private ArrayList<R_OrderProduct> buildOrderProducts(long supplierId, SupplierProductRepository supplierProductRepository) {
        ArrayList<R_OrderProduct> r_orderProducts = new ArrayList<>();

        List<Product> allBySupplierId = supplierProductRepository.findAllBySupplierId(Supplier.builder().supplierId(supplierId).build());

        for(Product product : allBySupplierId){
            r_orderProducts.add(R_OrderProduct.builder()
                    .amount(12)
                    .productId(product.getProductId())
                    .productName(product.getName())
                    .price(product.getPrice())
                    .unitMeasure(product.getUnitMeasure().name())
                    .build());
        }

        return r_orderProducts;

    }

    // TEST UTILS

    private List<Workstation> createWorkstationList(long eventId, int num) {

        List<Workstation> workstations = new ArrayList<>();
        for(int i = 0; i < num; i++){
            workstations.add(Workstation.builder()
                    .name(randomEnum(WorkstationType.class).name() + " " + i)
                    .workstationType(randomEnum(WorkstationType.class))
                    .extra("extra arguments " + i)
                    .responsable("un fesso qualsiasi")
                    .eventId(eventId)
                    .build());
        }
        return workstations;
    }

    private List<ExpenceEvent> createEventExpence(long eventId, int num) {
        List<ExpenceEvent> expenceEvents = new ArrayList<>();
        for(int i = 0 ; i < num; i++){
            expenceEvents.add(ExpenceEvent
                    .builder()
                    .amount(12 * i)
                    .description("spesa evento " + i)
                    .eventId(eventId)
                    .dateIntert(Utils.globalDTFormat.format(new Date())).build());
        }

        return expenceEvents;
    }

    private Event buildEventForBranch(long branchId, long storageId) {
        return Event.builder()
                .eventId(0)
                .dateCreation(Utils.globalDTFormat.format(new Date()))
                .eventStatus(EventStatus.APERTO)
                .location("Locorotondo - Mavu")
                .name("Festone pieno di troiolone")
                .storageId(storageId)
                .branchId(branchId)
                .dateEvent("2022-12-12")
                .build();
    }

    private Storage buildStorageEntity(long branchId) {
        return Storage.builder()
                .address("via le mani dagli occhi")
                .name("Magazzino 1")
                .cap("12345")
                .creationDate(Utils.globalDTFormat.format(new Date()))
                .branchId(branchId)
                .city("Milano")
                .build();
    }

    private List<Product> retriveProductList(long supplierId, int productNumber) {


        List<Product> products = new ArrayList<>();
        for(int i = 0; i < productNumber; i++){
            products.add(Product
                    .builder()
                    .category("")
                    .description("description " + i)
                    .name("Name prodotto " + i)
                    .price(i * 12.32)
                    .vatApplied(22)
                    .supplierId(supplierId)
                    .unitMeasure(randomEnum(UnitMeasure.class))
                    .build());
        }


        return products;
    }



    private Supplier getSupplierEntity(long branchId) {
        return Supplier.builder()
                .address("Via dalle palle 98")
                .cap("12312")
                .city("Monopoli")
                .email("amati.angelo90@gmail.com")
                .name("AmatiCorporation Informatica")
                .pec("amati@pec.com")
                .phoneNumber("34534534223")
                .vatNumber("1231231231")
                .branchId(branchId)
                .build();
    }

    private UserEntity getUserEntityBody(){
        return UserEntity.builder()
                .name("angelo")
                .phone("3454937047")
                .userType(UserType.entrepreneur)
                .lastname("amati")
                .email("amati.angelo90@gmailò.asddsa").build();
    }

    private Branch getBranchEntity(long userId){
        String address = "Via dalle palle 98";
        String cap = "22002";
        String city = "Cisternino";
        String email = "amati.ang33elo90@gmail.com";
        String branchName = "Amaticorporation";
        String phone = "3454937047";
        String token = "123123123-12312312-123123123-123123123";
        String vat = "33333333333";

        return Branch.builder()
                .address(address)
                .cap(cap)
                .city(city)
                .userId(userId)
                .email(email)
                .name(branchName)
                .phoneNumber(phone)
                .vatNumber(vat)
                .token(token)
                .build();
    }

    private static final Random RANDOM = new Random();

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = RANDOM.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

}
