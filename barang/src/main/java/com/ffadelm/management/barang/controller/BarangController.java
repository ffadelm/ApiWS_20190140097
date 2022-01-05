/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ffadelm.management.barang.controller;

import com.ffadelm.management.barang.domain.dao.Barang;
import com.ffadelm.management.barang.domain.dao.Ship;
import com.ffadelm.management.barang.domain.dto.BarangStokData;
import com.ffadelm.management.barang.service.BarangService;
import com.ffadelm.management.barang.service.ShipService;
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
public class BarangController {
    
    @Autowired
    private BarangService barangService;
    @Autowired
    private ShipService shipService;
    
    @GetMapping("/barang")
    public List<BarangStokData> getAllBarang(){
        return barangService.getAllBarang();
    }
    
    @PostMapping("/barang")
    public Barang saveBarang(@RequestBody Barang barang){
        return barangService.saveBarang(barang);
    }
    
    @PutMapping("/barang")
    public  Barang updateBarang(@RequestBody Barang barang){
        return  barangService.saveBarang(barang);
    }
    
    @DeleteMapping("barang/{id}")
    public  void deleteBarang(@PathVariable Long id){
        barangService.deleteBarang(id);
    }
    
    @GetMapping("/barang/{id}/ship")
    public List<Ship> getBarangShip(@PathVariable Long id){
        return shipService.getShipByBarang(id);
    }
}
