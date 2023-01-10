package com.acorp.ventimetriquadri.app.event.workstations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WorkstationLoadUnloadProduct {

    private long storageId;
    private long productId;
    private double amount;
    private long workstationProductId;
    private long storageProductId;
}
