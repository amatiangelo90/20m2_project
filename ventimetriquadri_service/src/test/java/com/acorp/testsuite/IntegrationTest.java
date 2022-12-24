package com.acorp.testsuite;

import com.acorp.ventimetriquadri.VentimetriquadriApplication;
import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.branch.BranchRepository;
import com.acorp.ventimetriquadri.app.branch.BranchService;
import com.acorp.ventimetriquadri.app.event.Event;
import com.acorp.ventimetriquadri.app.event.EventRepository;
import com.acorp.ventimetriquadri.app.event.EventService;
import com.acorp.ventimetriquadri.app.event.expences.ExpenceEvent;
import com.acorp.ventimetriquadri.app.event.expences.ExpenceRepository;
import com.acorp.ventimetriquadri.app.event.utils.EventStatus;
import com.acorp.ventimetriquadri.app.event.utils.WorkstationStatus;
import com.acorp.ventimetriquadri.app.event.utils.WorkstationType;
import com.acorp.ventimetriquadri.app.event.workstations.Workstation;
import com.acorp.ventimetriquadri.app.event.workstations.WorkstationRepository;
import com.acorp.ventimetriquadri.app.event.workstations.WorkstationService;
import com.acorp.ventimetriquadri.app.order.OrderEntity;
import com.acorp.ventimetriquadri.app.order.OrderRepository;
import com.acorp.ventimetriquadri.app.order.OrderService;
import com.acorp.ventimetriquadri.app.order.utils.OrderStatus;
import com.acorp.ventimetriquadri.app.product.Product;
import com.acorp.ventimetriquadri.app.product.ProductRepository;
import com.acorp.ventimetriquadri.app.product.ProductService;
import com.acorp.ventimetriquadri.app.product.product_utils.UnitMeasure;
import com.acorp.ventimetriquadri.app.relations.branch_event.BranchEventStorageRepository;
import com.acorp.ventimetriquadri.app.relations.branch_storage.BranchStorageRepository;
import com.acorp.ventimetriquadri.app.relations.branch_supplier.BranchSupplierRepository;
import com.acorp.ventimetriquadri.app.relations.event_expence.EventExpenceRepository;
import com.acorp.ventimetriquadri.app.relations.event_workstation.EventWorkstationRepository;
import com.acorp.ventimetriquadri.app.relations.order_product.OrderProductRepository;
import com.acorp.ventimetriquadri.app.relations.order_product.R_OrderProduct;
import com.acorp.ventimetriquadri.app.relations.storage_product.R_StorageProduct;
import com.acorp.ventimetriquadri.app.relations.storage_product.StorageProduct;
import com.acorp.ventimetriquadri.app.relations.storage_product.StorageProductRepository;
import com.acorp.ventimetriquadri.app.relations.supplier_product.SupplierProductRepository;
import com.acorp.ventimetriquadri.app.relations.user_branch.UserBranchRepository;
import com.acorp.ventimetriquadri.app.relations.workstation_product.R_WorkstationProduct;
import com.acorp.ventimetriquadri.app.relations.workstation_product.WorkstationProductRepository;
import com.acorp.ventimetriquadri.app.storage.Storage;
import com.acorp.ventimetriquadri.app.storage.StorageRepository;
import com.acorp.ventimetriquadri.app.storage.StorageService;
import com.acorp.ventimetriquadri.app.supplier.Supplier;
import com.acorp.ventimetriquadri.app.supplier.SupplierRepository;
import com.acorp.ventimetriquadri.app.supplier.SuppliersService;
import com.acorp.ventimetriquadri.app.user.UserEntity;
import com.acorp.ventimetriquadri.app.user.UserRepository;
import com.acorp.ventimetriquadri.app.user.UserService;
import com.acorp.ventimetriquadri.exception.CustomException;
import com.acorp.ventimetriquadri.external_integration.email_service.EmailEngineService;
import com.acorp.ventimetriquadri.external_integration.email_service.EmailSenderException;
import com.acorp.ventimetriquadri.utils.Utils;
import com.acorp.ventimetriquadri.website.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;


@DataJpaTest
@ContextConfiguration(classes = VentimetriquadriApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class IntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private BranchStorageRepository branchStorageRepository;

    @Autowired
    private UserBranchRepository userBranchRepository;

    @Autowired
    private StorageProductRepository storageProductRepository;

    @Autowired
    private BranchSupplierRepository branchSupplierRepository;

    @Autowired
    private SupplierProductRepository supplierProductRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventExpenceRepository eventExpenceRepository;

    @Autowired
    private BranchEventStorageRepository branchEventStorageRepository;

    @Autowired
    private ExpenceRepository expenceRepository;

    @Autowired
    private WorkstationRepository workstationRepository;

    @Autowired
    private EventWorkstationRepository eventWorkstationRepository;

    @Autowired
    private WorkstationProductRepository workstationProductRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    private OrderService orderService;
    private EventService eventService;
    private WorkstationService workstationService;
    private StorageService storageService;
    private ProductService productService;
    private SuppliersService suppliersService;
    private UserService userService;
    private BranchService branchService;

    @Mock
    private EmailEngineService emailEngineService;

    @BeforeEach
    public void initService(){

        workstationService = new WorkstationService(workstationRepository, workstationProductRepository, storageProductRepository, eventWorkstationRepository);

        eventService = new EventService(eventRepository,
                eventExpenceRepository,
                branchEventStorageRepository,
                expenceRepository,
                storageRepository,
                branchRepository,
                eventWorkstationRepository,
                workstationService);

        productService = new ProductService(productRepository, supplierProductRepository);
        suppliersService = new SuppliersService(supplierRepository, branchSupplierRepository);

        storageService = new StorageService(storageRepository, branchStorageRepository, storageProductRepository, productRepository);
        branchService = new BranchService(branchRepository, userBranchRepository, branchSupplierRepository, supplierProductRepository, storageService, eventService);
        userService = new UserService(userRepository, userBranchRepository, storageService, branchService, eventService);
        emailEngineService = new EmailEngineService();

        orderService = new OrderService(orderRepository,
                orderProductRepository,
                suppliersService,
                branchService,
                storageService,
                emailEngineService);
    }

    @Test
    public void test_productPutIntoWorkstation_add_remove_AmountFromStorage_checkSubtraction(){
        prepareEnviromnent();

        List<Branch> branches = userService.retrieveAllBranchesByUserId(1);
        System.out.println(branches.toString());

        for(R_StorageProduct r_storageProduct : branches.get(0).getStorages().get(0).getProducts()){
            storageService.addStockAmountToStorageProduct(r_storageProduct.getStorageProductId(), 87);
        }

        branches = userService.retrieveAllBranchesByUserId(1);

        for(R_StorageProduct r_storageProduct : branches.get(0).getStorages().get(0).getProducts()){
            assertEquals(87, r_storageProduct.getStock());
        }
        for(R_StorageProduct r_storageProduct : branches.get(0).getStorages().get(0).getProducts()){
            storageService.removeStockAmountFromStorageProduct(r_storageProduct.getStorageProductId(), 34);
        }

        branches = userService.retrieveAllBranchesByUserId(1);

        for(R_StorageProduct r_storageProduct : branches.get(0).getStorages().get(0).getProducts()){
            assertEquals(87 - 34, r_storageProduct.getStock());
        }
        List<Branch> branches1 = userService.retrieveAllBranchesByUserId(1);
        System.out.println("Output total after edit: " + Utils.jsonFormat(branches1));
    }

    private void prepareEnviromnent() {
        // creo e salvo un utente
        UserEntity userEntity = getUserEntityBody();
        UserEntity userEntity1 = userService.addNewUser(userEntity);

        //TEST - non esiste ancora un branch associato all'utente creato
        List<Branch> branchListRetrievedByUserIdFake = userService.retrieveAllBranchesByUserId(userEntity1.getUserId());
//        assertEquals(branchListRetrievedByUserIdFake.size(), 0);

        // con l'id dell'utente salvato creo un branch (associato all'utente)
        Branch branchEntity = getBranchEntity(userEntity1.getUserId());
        branchService.addNewBranch(branchEntity);

        //TEST - esiste il branch associato all'utente
        List<Branch> branchListRetrievedByUserId = userService.retrieveAllBranchesByUserId(userEntity1.getUserId());
//        assertEquals(branchListRetrievedByUserId.size(), 1);

        //creo un supplier associandolo direttamente al branch su cui sto lavorando in questo momento
        Supplier supplier = getSupplierEntity(branchListRetrievedByUserId.get(0).getBranchId());
        Supplier supplierSaved = suppliersService.saveSupplier(supplier);

        //TEST - controllo che il branch recuperato dal salvataggio sia effetticamente quello caricato
//        assertEquals(supplierSaved.getPhoneNumber(), "34534534223");
//        assertEquals(supplierSaved.getEmail(), "amati.angelo90@gmail.com");
//        assertEquals(supplierSaved.getVatNumber(), "1231231231");
//        assertEquals(supplierSaved.getAddress(), "Via dalle palle 98");

        //creo 20 prodotti da associare al fornitore(supplier) sul quale sto lavorando
        List<Product> buildProductList = retriveProductList(supplier.getSupplierId(), 3);

        for(Product product : buildProductList){
            productService.saveProduct(product);
        }

        //TEST - salvo e controllo che ad una successiva ricerca di prodotti per SupplierID il numero dei prodotti sia corrispndente a quello salvato
        List<Product> allBySupplierId = productService.findAllBySupplierId(supplierSaved.getSupplierId());

        Storage storage = buildStorageEntity(branchEntity.getBranchId());
        Storage storageSaved = storageService.saveStorage(storage);

        List<Branch> br = userService.retrieveAllBranchesByUserId(userEntity1.getUserId());
        storageService.insertProductIntoStorage(storageSaved.getStorageId(), (br.get(0).getSuppliers().get(0).getProductList().get(0).getProductId()));
        storageService.insertProductIntoStorage(storageSaved.getStorageId(), (br.get(0).getSuppliers().get(0).getProductList().get(1).getProductId()));
        storageService.insertProductIntoStorage(storageSaved.getStorageId(), (br.get(0).getSuppliers().get(0).getProductList().get(2).getProductId()));
    }

    @Test
    public void test_branch_create_delete_update_search() throws CustomException {

        // creo e salvo un utente
        UserEntity userEntity = getUserEntityBody();
        UserEntity userEntity1 = userService.addNewUser(userEntity);

        //TEST - non esiste ancora un branch associato all'utente creato
        List<Branch> branchListRetrievedByUserIdFake = userService.retrieveAllBranchesByUserId(userEntity1.getUserId());
        assertEquals(branchListRetrievedByUserIdFake.size(), 0);

        // con l'id dell'utente salvato creo un branch (associato all'utente)
        Branch branchEntity = getBranchEntity(userEntity1.getUserId());
        branchService.addNewBranch(branchEntity);

        //TEST - esiste il branch associato all'utente
        List<Branch> branchListRetrievedByUserId = userService.retrieveAllBranchesByUserId(userEntity1.getUserId());
        assertEquals(branchListRetrievedByUserId.size(), 1);

        //creo un supplier associandolo direttamente al branch su cui sto lavorando in questo momento
        Supplier supplier = getSupplierEntity(branchListRetrievedByUserId.get(0).getBranchId());
        Supplier supplierSaved = suppliersService.saveSupplier(supplier);

        //TEST - controllo che il branch recuperato dal salvataggio sia effetticamente quello caricato
        assertEquals(supplierSaved.getPhoneNumber(), "34534534223");
        assertEquals(supplierSaved.getEmail(), "amati.angelo90@gmail.com");
        assertEquals(supplierSaved.getVatNumber(), "1231231231");
        assertEquals(supplierSaved.getAddress(), "Via dalle palle 98");

        //creo 20 prodotti da associare al fornitore(supplier) sul quale sto lavorando
        List<Product> buildProductList = retriveProductList(supplier.getSupplierId(), 3);

        for(Product product : buildProductList){
            productService.saveProduct(product);
        }

        //TEST - salvo e controllo che ad una successiva ricerca di prodotti per SupplierID il numero dei prodotti sia corrispndente a quello salvato
        List<Product> allBySupplierId = productService.findAllBySupplierId(supplierSaved.getSupplierId());
        assertEquals(allBySupplierId.size(), 3);

        List<Product> prodListWithFakeSupplierId = productService.findAllBySupplierId(62354);
        assertEquals(prodListWithFakeSupplierId.size(), 0);

        Storage storage = buildStorageEntity(branchEntity.getBranchId());

        Storage storageSaved = storageService.saveStorage(storage);

        List<Branch> br = userService.retrieveAllBranchesByUserId(userEntity1.getUserId());
        assertEquals(br.get(0).getSuppliers().size(), 1);
        assertEquals(br.get(0).getSuppliers().get(0).getProductList().size(), 3);
        assertEquals(br.get(0).getStorages().size(), 1);
        assertEquals(br.get(0).getStorages().get(0).getProducts().size(), 0);
        assertEquals(br.get(0).getStorages().get(0).getName(), "Magazzino 1");


        storageService.insertProductIntoStorage(storageSaved.getStorageId(), (br.get(0).getSuppliers().get(0).getProductList().get(0).getProductId()));
        storageService.insertProductIntoStorage(storageSaved.getStorageId(), (br.get(0).getSuppliers().get(0).getProductList().get(1).getProductId()));
        storageService.insertProductIntoStorage(storageSaved.getStorageId(), (br.get(0).getSuppliers().get(0).getProductList().get(2).getProductId()));


        br = userService.retrieveAllBranchesByUserId(userEntity1.getUserId());


        storageService.addStockAmountToStorageProduct(1, 34);


        Storage currentStorage = br.get(0).getStorages().get(0);
        R_StorageProduct r_storageProduct = br.get(0).getStorages().get(0).getProducts().get(1);

        assertEquals(currentStorage.getName(), "Magazzino 1");
        assertEquals(r_storageProduct.getProductName(), "Name prodotto 1");
        assertEquals(r_storageProduct.getStock(), 0.0);
        assertEquals(r_storageProduct.getAmountHundred(), 0.0);


        Event event = buildEventForBranch(branchListRetrievedByUserId.get(0).getBranchId(), storageSaved.getStorageId());

        Event eventSaved = eventService.createEvent(event);


        List<ExpenceEvent> expenceEvents = createEventExpence(eventSaved.getEventId(), 5);

        for(ExpenceEvent expenceEvent : expenceEvents){
            eventService.saveExpence(expenceEvent);
        }

        List<Workstation> workstations = createWorkstationList(eventSaved.getEventId(), 5);

        for(Workstation workstation : workstations){
            eventService.createWorkstation(workstation);
        }

        List<Branch> brAfterUpdate = userService.retrieveAllBranchesByUserId(userEntity1.getUserId());

        assertEquals(1, brAfterUpdate.get(0).getEvents().size());

        assertEquals(5, eventExpenceRepository.findAll().size());
        assertEquals(5, expenceRepository.findAll().size());

        eventService.deleteEventExpence(brAfterUpdate.get(0).getEvents().get(0).getExpenceEvents().get(0));

        assertEquals(4, eventExpenceRepository.findAll().size());
        assertEquals(4, expenceRepository.findAll().size());


        Event eventToRework = brAfterUpdate.get(0).getEvents().get(0);
        Workstation workstation = eventToRework.getWorkstations().get(0);
        Workstation workstation_1 = eventToRework.getWorkstations().get(1);

        List<StorageProduct> storageProducts = storageService.retrieveAllProductByStorage(Storage.builder().storageId(eventToRework.getStorageId()).build());


        workstationService.insertProductIntoWorkstation(workstation.getWorkstationId(),
                storageProducts.get(0).getProductId(),
                eventToRework.getStorageId());


        workstationService.insertProductIntoWorkstation(workstation.getWorkstationId(), storageProducts.get(2).getProductId(), eventToRework.getStorageId());

        workstationService.insertProductIntoWorkstation(workstation_1.getWorkstationId(), storageProducts.get(1).getProductId(), eventToRework.getStorageId());
        workstationService.insertProductIntoWorkstation(workstation_1.getWorkstationId(), storageProducts.get(2).getProductId(), eventToRework.getStorageId());


//        eventService.closeEvent(eventSaved);

        brAfterUpdate = userService.retrieveAllBranchesByUserId(userEntity1.getUserId());

        workstation.setProducts(
                workstationService.retrieveAllProductByWorkstationId(workstation.getWorkstationId())
        );

//        workstationService.removeProductFromWorkstation(workstation1.getProducts().get(1).getWorkstationProductId());
//
        workstation.setProducts(
                workstationService.retrieveAllProductByWorkstationId(workstation.getWorkstationId())
        );

        workstation_1.setProducts(
                workstationService.retrieveAllProductByWorkstationId(workstation_1.getWorkstationId())
        );

//        workstationService.removeProductFromWorkstation(workstation1.getProducts().get(1).getWorkstationProductId());
//
        workstation_1.setProducts(
                workstationService.retrieveAllProductByWorkstationId(workstation_1.getWorkstationId())
        );


        List<R_WorkstationProduct> products = workstation.getProducts();

        workstation.setProducts(
                workstationService.retrieveAllProductByWorkstationId(workstation.getWorkstationId())
        );


        workstationService.workstationProduct_updateStockValue(workstation.getProducts().get(0).getWorkstationProductId(), 77);
        workstationService.workstationProduct_updateConsumedValue(workstation.getProducts().get(0).getWorkstationProductId(), 45);

        workstationService.removeProductFromWorkstation(1);

        workstationService.removeWorkstation(workstation.getWorkstationId());

        brAfterUpdate = userService.retrieveAllBranchesByUserId(userEntity1.getUserId());

        eventService.deleteEvent(1);

        List<ExpenceEvent> allByEvent = eventExpenceRepository.findAllByEvent(Event.builder().eventId(1).build());

        List<Branch> branches = userService.retrieveAllBranchesByUserId(userEntity1.getUserId());

        OrderEntity orderEntity = buildOrderEntity(
                branches.get(0).getBranchId(),
                branches.get(0).getSuppliers().get(0).getSupplierId(),
                branches.get(0).getStorages().get(0).getStorageId());



//        Mockito.when(emailEngineService.sendEmail(any())).thenThrow(new CustomException("Customer exception for test"));
        OrderEntity orderProcessed = orderService.sendOrder(orderEntity, orderEntity.getProducts());
        assertEquals(orderProcessed.getOrderStatus(), OrderStatus.INVIATO);

        branches = userService.retrieveAllBranchesByUserId(userEntity1.getUserId());

        assertEquals(Utils.jsonFormat(brAfterUpdate), Utils.jsonFormat(branches));
        System.out.println("XXXXXXXXXXXXXXXXXXXX: " + Utils.jsonFormat(branches));
    }


    private OrderEntity buildOrderEntity(long branchId,
                                         long supplierId,
                                         long storageId) {
        return OrderEntity.builder()
                .branchId(branchId)
                .storageId(storageId)
                .code(UUID.randomUUID().toString())
                .details("ORDINE XXXXXX")
                .creationDate(Utils.globalDTFormat.format(new Date()))
                .deliveryDate(Utils.globalDTFormat.format(new Date()))
                .products(buildOrderProducts(supplierId))
                .supplierId(supplierId)
                .build();
    }

    private ArrayList<R_OrderProduct> buildOrderProducts(long supplierId) {
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
                    .workstationStatus(WorkstationStatus.APERTO)
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
                .lastname("amati")
                .email("amati.angelo90").build();
    }

    private Branch getBranchEntity(long userId){
        String address = "Via dalle palle 98";
        String cap = "22002";
        String city = "Cisternino";
        String email = "amati.angelo90@gmail.com";
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
