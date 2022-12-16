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
import com.acorp.ventimetriquadri.app.product.Product;
import com.acorp.ventimetriquadri.app.product.ProductRepository;
import com.acorp.ventimetriquadri.app.product.ProductService;
import com.acorp.ventimetriquadri.app.product.product_utils.UnitMeasure;
import com.acorp.ventimetriquadri.app.relations.branch_event.BranchEventStorageRepository;
import com.acorp.ventimetriquadri.app.relations.branch_storage.BranchStorageRepository;
import com.acorp.ventimetriquadri.app.relations.branch_supplier.BranchSupplierRepository;
import com.acorp.ventimetriquadri.app.relations.branch_supplier.BranchSupplierService;
import com.acorp.ventimetriquadri.app.relations.event_expence.EventExpenceRepository;
import com.acorp.ventimetriquadri.app.relations.event_workstation.EventWorkstationRepository;
import com.acorp.ventimetriquadri.app.relations.storage_product.R_StorageProduct;
import com.acorp.ventimetriquadri.app.relations.storage_product.StorageProductRepository;
import com.acorp.ventimetriquadri.app.relations.supplier_product.SupplierProductRepository;
import com.acorp.ventimetriquadri.app.relations.user_branch.UserBranchRepository;
import com.acorp.ventimetriquadri.app.storage.Storage;
import com.acorp.ventimetriquadri.app.storage.StorageRepository;
import com.acorp.ventimetriquadri.app.storage.StorageService;
import com.acorp.ventimetriquadri.app.supplier.Supplier;
import com.acorp.ventimetriquadri.app.supplier.SupplierRepository;
import com.acorp.ventimetriquadri.app.supplier.SuppliersService;
import com.acorp.ventimetriquadri.app.user.UserEntity;
import com.acorp.ventimetriquadri.app.user.UserRepository;
import com.acorp.ventimetriquadri.app.user.UserService;
import com.acorp.ventimetriquadri.utils.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@ContextConfiguration(classes = VentimetriquadriApplication.class)
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

    private EventService eventService;
    private StorageService storageService;
    private ProductService productService;
    private SuppliersService suppliersService;
    private UserService userService;
    private BranchService branchService;
    private BranchSupplierService branchSupplierService;

    @BeforeEach
    public void initService(){

        eventService = new EventService(eventRepository,
                eventExpenceRepository,
                branchEventStorageRepository,
                expenceRepository,
                storageRepository,
                branchRepository,
                workstationRepository,
                eventWorkstationRepository);

        productService = new ProductService(productRepository, supplierProductRepository);
        branchSupplierService = new BranchSupplierService(branchSupplierRepository, supplierProductRepository);
        suppliersService = new SuppliersService(supplierRepository, branchSupplierService);

        storageService = new StorageService(storageRepository, branchStorageRepository, storageProductRepository, productRepository);
        branchService = new BranchService(branchRepository, userBranchRepository, branchSupplierService, supplierProductRepository);
        userService = new UserService(userRepository, userBranchRepository, storageService, branchService, eventService);
    }

    @Test
    public void test_user_create_find_update_delete() {

        UserEntity userEntity = getUserEntityBody();

        UserEntity userEntity1 = userService.addNewUser(userEntity);

        UserEntity byEmail = userService.findByEmail("amati.angelo90");
        assertEquals(byEmail.getEmail(), "amati.angelo90");
        assertEquals(byEmail.getPhone(), "3454937047");
        assertEquals(userEntity, userEntity1);

        byEmail.setPhone("123123");
        userService.update(byEmail);

        UserEntity byEmailUpdated = userService.findByEmail("amati.angelo90");

        assertEquals(byEmailUpdated.getEmail(), "amati.angelo90");
        assertEquals(byEmailUpdated.getPhone(), "123123");

        userService.delete(byEmailUpdated);

        UserEntity byEmailAfterDelete = userService.findByEmail("amati.angelo90");
        assertNull(byEmailAfterDelete);
    }

    @Test
    public void test_branch_create_delete_update_search() throws JsonProcessingException {

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
        List<Product> buildProductList = retriveProductList(supplier.getSupplierId(), 15);

        for(Product product : buildProductList){
            productService.saveProduct(product);
        }

        //TEST - salvo e controllo che ad una successiva ricerca di prodotti per SupplierID il numero dei prodotti sia corrispndente a quello salvato
        List<Product> allBySupplierId = productService.findAllBySupplierId(supplierSaved.getSupplierId());
        assertEquals(allBySupplierId.size(), 15);

        List<Product> prodListWithFakeSupplierId = productService.findAllBySupplierId(62354);
        assertEquals(prodListWithFakeSupplierId.size(), 0);

        Storage storage = buildStorageEntity(branchEntity.getBranchId());

        Storage storageSaved = storageService.saveStorage(storage);

        List<Branch> br = userService.retrieveAllBranchesByUserId(userEntity1.getUserId());
        assertEquals(br.get(0).getSuppliers().size(), 1);
        assertEquals(br.get(0).getSuppliers().get(0).getProductList().size(), 15);
        assertEquals(br.get(0).getStorages().size(), 1);
        assertEquals(br.get(0).getStorages().get(0).getProducts().size(), 0);
        assertEquals(br.get(0).getStorages().get(0).getName(), "Magazzino 1");


        storageService.insertProductIntoStorage(storageSaved.getStorageId(), (br.get(0).getSuppliers().get(0).getProductList().get(1).getProductId()));
        storageService.insertProductIntoStorage(storageSaved.getStorageId(), (br.get(0).getSuppliers().get(0).getProductList().get(4).getProductId()));
        storageService.insertProductIntoStorage(storageSaved.getStorageId(), (br.get(0).getSuppliers().get(0).getProductList().get(7).getProductId()));
        storageService.insertProductIntoStorage(storageSaved.getStorageId(), (br.get(0).getSuppliers().get(0).getProductList().get(9).getProductId()));

        br = userService.retrieveAllBranchesByUserId(userEntity1.getUserId());
        System.out.println("Outpur total: " + Utils.jsonFormat(br));

        Storage currentStorage = br.get(0).getStorages().get(0);
        R_StorageProduct r_storageProduct = br.get(0).getStorages().get(0).getProducts().get(1);

        assertEquals(currentStorage.getName(), "Magazzino 1");
        assertEquals(r_storageProduct.getProductName(), "Name prodotto 4");
        assertEquals(r_storageProduct.getStock(), 0.0);
        assertEquals(r_storageProduct.getAmountHundred(), 0.0);


        storageService.updateRStorageProduct(R_StorageProduct.builder()
                .storageProductId(r_storageProduct.getStorageProductId())
                .productName(r_storageProduct.getProductName())
                .productId(r_storageProduct.getProductId())
                .isAvailable(false)
                .stock(34)
                .amountHundred(12)
                .build());


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

//        eventService.closeEvent(eventSaved);
        List<Branch> brAfterUpdate = userService.retrieveAllBranchesByUserId(userEntity1.getUserId());
        System.out.println("Output total: " + Utils.jsonFormat(brAfterUpdate));
    }

    private List<Workstation> createWorkstationList(long eventId, int num) {

        List<Workstation> workstations = new ArrayList<>();
        for(int i = 0; i < num; i++){

            workstations.add(Workstation.builder()
                    .name(randomEnum(WorkstationType.class).name() + " " + i)
                    .workstationType(randomEnum(WorkstationType.class))
                    .extra("extra arguments " + i)
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
