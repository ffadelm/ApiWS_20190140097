/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ffadelm.management.barang.service;

import com.ffadelm.management.barang.domain.dao.Ship;
import com.ffadelm.management.barang.domain.dto.DataRiwayat;
import com.ffadelm.management.barang.repository.ShipRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */

@Service
public class ShipService {
    @Autowired
    private ShipRepository shipRepo;
    
    public List<Ship> getShipByBarang(Long id){
        return shipRepo.findByBarangId(id);
    }
    
    public List<DataRiwayat> findShipByShipper(Long id){
        return shipRepo.findByDataRiwayatId(id);
    }

}
