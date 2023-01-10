package com.acorp.ventimetriquadri.app.order;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.branch.BranchRepository;
import com.acorp.ventimetriquadri.app.order.utils.OrderStatus;
import com.acorp.ventimetriquadri.app.relations.branch_order.BranchOrderStorageSupplier;
import com.acorp.ventimetriquadri.app.relations.branch_order.BranchOrderRepository;
import com.acorp.ventimetriquadri.app.relations.order_product.OrderProduct;
import com.acorp.ventimetriquadri.app.relations.order_product.OrderProductRepository;
import com.acorp.ventimetriquadri.app.relations.order_product.R_OrderProduct;
import com.acorp.ventimetriquadri.app.storage.Storage;
import com.acorp.ventimetriquadri.app.storage.StorageService;
import com.acorp.ventimetriquadri.app.supplier.Supplier;
import com.acorp.ventimetriquadri.app.supplier.SuppliersService;
import com.acorp.ventimetriquadri.exception.CustomException;
import com.acorp.ventimetriquadri.external_integration.email_service.EmailEngineService;
import com.acorp.ventimetriquadri.external_integration.email_service.EmailEntity;
import com.acorp.ventimetriquadri.external_integration.email_service.EmailSenderException;
import com.acorp.ventimetriquadri.external_integration.email_service.EmailSenderResponse;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private SuppliersService suppliersService;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private StorageService storageService;

    @Autowired
    private BranchOrderRepository branchOrderRepository;

    @Autowired
    private EmailEngineService emailEngineService;


    @Transactional
    public OrderEntity sendOrder(OrderEntity orderEntity, List<R_OrderProduct> r_orderProductList) throws CustomException {
        logger.info("Send current order : " + orderEntity.toString());
        Optional<Supplier> supplier = suppliersService.findSupplierById(orderEntity.getSupplierId());
        Optional<Branch> branch = branchRepository.findById(orderEntity.getBranchId());
        Optional<Storage> storage = storageService.findStorageByStorageId(orderEntity.getStorageId());

        validateRequest(supplier,
                branch,
                storage,
                orderEntity,
                r_orderProductList);

        orderEntity.setCode(UUID.randomUUID().toString());
        OrderEntity orderSaved = orderRepository.save(orderEntity);


        for(R_OrderProduct r_orderProduct : r_orderProductList){
            orderProductRepository.save(OrderProduct
                    .builder()
                    .amount(r_orderProduct.getAmount())
                    .unitMeasure(r_orderProduct.getUnitMeasure())
                    .price(r_orderProduct.getPrice())
                    .productName(r_orderProduct.getProductName())
                    .productId(r_orderProduct.getProductId())
                    .price(r_orderProduct.getPrice())
                    .order(orderSaved)
                    .build());
        }

        // create relation between order and branch
        branchOrderRepository.save(BranchOrderStorageSupplier.builder()
                .branch(branch.get())
                .storage(storage.get())
                .supplier(supplier.get())
                .orderEntity(orderSaved)
                .build());


        EmailSenderResponse emailSenderResponse = emailEngineService.sendEmail(EmailEntity
                .builder()
                .branchAddress(branch.get().getAddress())
                .branchCap(branch.get().getCap())
                .branchCity(branch.get().getCity())
                .branchName(branch.get().getName())
                .branchNumber(branch.get().getPhoneNumber())
                .deliveryDate(orderEntity.getDeliveryDate())
                .supplierName(supplier.get().getName())
                .supplierEmail(supplier.get().getEmail())
                .message(buildMessageFromOrderProductList(orderEntity.getProducts()))
                .orderCode(orderEntity.getCode())
                .user_name(orderEntity.getSenderUser())
                .build());

        if(emailSenderResponse.getStatus() == "OK"){
            Optional<OrderEntity> order = orderRepository.findById(orderSaved.getOrderId());
            if(order.isPresent()){
                order.get().setOrderStatus(OrderStatus.INVIATO);
                return order.get();
            }
        }else{
            Optional<OrderEntity> order = orderRepository.findById(orderSaved.getOrderId());
            if(order.isPresent()){
                order.get().setOrderStatus(OrderStatus.NON_INVIATO);
                order.get().setErrorMessage(emailSenderResponse.getMessage());
                return order.get();
            }
        }
        return null;
    }

    private void validateRequest(Optional<Supplier> supplier,
                                 Optional<Branch> branch,
                                 Optional<Storage> storage,
                                 OrderEntity orderEntity,
                                 List<R_OrderProduct> r_orderProductList) throws CustomException {
        if(!supplier.isPresent()){
            throw new CustomException("Error - Impossibile creare ordine. Nessun fornitore trovato per l'id [" + orderEntity.getSupplierId() + "]");
        }

        if(!branch.isPresent()){
            throw new CustomException("Error - Impossibile creare ordine. Nessun branch trovato per l'id [" + orderEntity.getBranchId() + "]");
        }

        if(!storage.isPresent()){
            throw new CustomException("Error - Impossibile creare ordine. Nessun magazzino trovato per l'id [" + orderEntity.getStorageId() + "]");
        }

        if(orderEntity == null){
            throw new CustomException("Error - Impossibile creare ordine. Request is NULL");
        }

        if(r_orderProductList == null || r_orderProductList.isEmpty()){
            throw new CustomException("Error - Impossibile creare ordine. La lista prodotti è vuota");
        }
    }

    private String buildMessageFromOrderProductList(List<R_OrderProduct> products) {

        //TODO fare l'ordine dalla lista prodotti
        return "creare l'ordine aslidhsalfkjshdlfkajshdfl asdukhalsdkvbjhadflvbjhadflvk adlfkjvbadlfhk bad fhladlfj vhadflj hadf hj adfvljad fhlj fvhadlfj h";
    }

    public List<OrderEntity> findOrderByBranch(Branch branch) {
        List<OrderEntity> orderEntities = new ArrayList<>();

        logger.info("Find order by branch " + branch.toString());

        Optional<List<BranchOrderStorageSupplier>> ordersByBranch = branchOrderRepository.findOrdersByBranch(branch);
        if(ordersByBranch.isPresent()){
            for(BranchOrderStorageSupplier branchOrderStorageSupplier : ordersByBranch.get()){
                Optional<List<OrderProduct>> allProductByOrder = orderProductRepository.findAllProductByOrder(branchOrderStorageSupplier.getOrderEntity());

                branchOrderStorageSupplier.getOrderEntity().setProducts(buildROrderProduct(allProductByOrder.get()));
                branchOrderStorageSupplier.getOrderEntity().setStorageId(branchOrderStorageSupplier.getStorage().getStorageId());
                branchOrderStorageSupplier.getOrderEntity().setSupplierId(branchOrderStorageSupplier.getSupplier().getSupplierId());
                orderEntities.add(branchOrderStorageSupplier.getOrderEntity());
            }
            return orderEntities;
        }else{
            return orderEntities;
        }
    }

    private List<R_OrderProduct> buildROrderProduct(List<OrderProduct> orderProducts) {
        List<R_OrderProduct> r_orderProducts = new ArrayList<>();

        for(OrderProduct orderProduct : orderProducts){
            r_orderProducts.add(R_OrderProduct.buildR_OrderProduct(orderProduct));
        }
        return r_orderProducts;
    }

    @Transactional
    public void updateOrder(OrderEntity orderEntity) throws CustomException {
        Optional<OrderEntity> orderById = orderRepository.findById(orderEntity.getOrderId());
        if(orderById.isPresent()){

            orderById.get().setOrderStatus(orderEntity.getOrderStatus());


        }else{
            throw new CustomException("Error - Nessun ordine trovato per l'id [" + orderEntity.getOrderId() + "]");
        }


    }
}
