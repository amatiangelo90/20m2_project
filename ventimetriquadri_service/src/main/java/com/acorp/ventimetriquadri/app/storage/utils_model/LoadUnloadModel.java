package com.acorp.ventimetriquadri.app.storage.utils_model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoadUnloadModel {

    private long storageId;
    private long productId;
    private double amount;
}
