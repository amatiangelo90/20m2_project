package com.acorp.ventimetriquadri.website.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PienissimoEntity {

    private String cap;
    private String cod_univoco;
    private String cognome;
    private String data_nascita;
    private String email;
    private String id_menu;
    private String marketing;
    private String nome;
    private String numero_versione_informativa;
    private String profilazione;
    private String telefono;
}
