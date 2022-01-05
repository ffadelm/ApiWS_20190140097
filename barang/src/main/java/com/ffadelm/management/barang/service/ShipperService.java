/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ffadelm.management.barang.service;

import com.ffadelm.management.barang.domain.dao.Ship;
import com.ffadelm.management.barang.domain.dao.Shipper;
import com.ffadelm.management.barang.domain.dto.DataRiwayat;
import com.ffadelm.management.barang.repository.ShipperRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class ShipperService {

    @Autowired
    private ShipperRepository shipperRepo;

    @Autowired
    private ShipService shipService;
    
    public List<Shipper> getAll() {
        return shipperRepo.findAll();
    }

    public Shipper saveShipper(Shipper shipper) {
        return shipperRepo.save(shipper);
    }

    public void deleteShipper(Long id) {
        shipperRepo.deleteById(id);
    }

    public List<DataRiwayat> getShipByShipper(Long id) {
        return shipService.findShipByShipper(id);
    }
}
