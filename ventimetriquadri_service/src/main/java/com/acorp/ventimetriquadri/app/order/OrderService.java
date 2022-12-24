package com.acorp.ventimetriquadri.app.order;

import com.acorp.ventimetriquadri.app.branch.Branch;
import com.acorp.ventimetriquadri.app.branch.BranchService;
import com.acorp.ventimetriquadri.app.order.utils.OrderStatus;
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
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private SuppliersService suppliersService;

    @Autowired
    private BranchService branchService;

    @Autowired
    private StorageService storageService;

    @Autowired
    private EmailEngineService emailEngineService;


    @Transactional
    public OrderEntity sendOrder(OrderEntity orderEntity, List<R_OrderProduct> r_orderProductList) throws CustomException {
        Optional<Supplier> supplierById = suppliersService.findSupplierById(orderEntity.getSupplierId());
        Optional<Branch> branch = branchService.findByBranchId(orderEntity.getBranchId());
        Optional<Storage> storage = storageService.findStorageByStorageId(orderEntity.getStorageId());

        validateRequest(supplierById, branch, storage, orderEntity, r_orderProductList);

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
        try {
            emailEngineService.sendEmail(EmailEntity
                    .builder()
                    .branchAddress(branch.get().getAddress())
                    .branchCap(branch.get().getCap())
                    .branchCity(branch.get().getCity())
                    .branchName(branch.get().getName())
                    .branchNumber(branch.get().getPhoneNumber())
                    .deliveryDate(orderEntity.getDeliveryDate())
                    .supplierName(supplierById.get().getName())
                    .supplierEmail(supplierById.get().getEmail())
                    .message(buildMessageFromOrderProductList(orderEntity.getProducts()))
                    .orderCode(orderEntity.getCode())
                    .user_name(orderEntity.getSenderUser())
                    .build());

            Optional<OrderEntity> order = orderRepository.findById(orderSaved.getOrderId());
            if(order.isPresent()){
                order.get().setOrderStatus(OrderStatus.INVIATO);
                return order.get();
            }
        } catch (EmailSenderException e) {
            Optional<OrderEntity> order = orderRepository.findById(orderSaved.getOrderId());
            if(order.isPresent()){
                order.get().setOrderStatus(OrderStatus.NON_INVIATO);
                order.get().setErrorStatus(e.toString());
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
        return "sadasdsa";
    }
}
