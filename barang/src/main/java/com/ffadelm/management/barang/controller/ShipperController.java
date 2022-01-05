/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ffadelm.management.barang.controller;

import com.ffadelm.management.barang.domain.dao.Ship;
import com.ffadelm.management.barang.domain.dao.Shipper;
import com.ffadelm.management.barang.domain.dto.DataRiwayat;
import com.ffadelm.management.barang.service.ShipperService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */
@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ShipperController {
    @Autowired
    private ShipperService shipperService;
    
    @GetMapping("/shipper")
    public List<Shipper> getAll(){
        return shipperService.getAll();
    }
    
    @PostMapping("/shipper")
    public Shipper saveShipper(@RequestBody Shipper shipper){
        return shipperService.saveShipper(shipper);
    }
    
    @PutMapping("/shipper")
    public  Shipper updateShipper(@RequestBody Shipper shipper){
        return shipperService.saveShipper(shipper);
    }
    
    @DeleteMapping("/shipper/{id}")
    public void deleteShipper(@PathVariable Long id){
        shipperService.deleteShipper(id);
    }
    
    @GetMapping("shipper/{id}/shipping")
    public List<DataRiwayat> getShipper(@PathVariable Long id){
        return shipperService.getShipByShipper(id);
    }
}
