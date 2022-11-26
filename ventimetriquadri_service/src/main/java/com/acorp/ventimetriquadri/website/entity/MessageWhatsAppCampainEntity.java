package com.acorp.ventimetriquadri.website.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
@Entity(name = "WhatsAppMessage")
@Table(name = "WHATS_APP_MESSAGE",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"ws_campain_id"}))
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageWhatsAppCampainEntity implements Serializable {

    @Id
    @SequenceGenerator(
            name = "ws_campain_id",
            sequenceName = "ws_campain_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ws_campain_id"
    )
    @Column(
            name = "ws_campain_id",
            updatable = false
    )
    private long wsCampainId;

    ArrayList<String> numbers;
    String message;
    String date;
    String errors;
}
