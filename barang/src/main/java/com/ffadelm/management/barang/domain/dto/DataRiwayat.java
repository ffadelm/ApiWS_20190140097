/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ffadelm.management.barang.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author USER
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataRiwayat {
    private String barang;
    private Integer stok;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy hh:mm")
    private Date tanggal;
    private String tipe;
}
