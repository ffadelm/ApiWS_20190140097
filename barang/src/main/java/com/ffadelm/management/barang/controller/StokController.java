/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ffadelm.management.barang.controller;

import com.ffadelm.management.barang.domain.dao.Stok;
import com.ffadelm.management.barang.domain.dto.StokShipRqDTO;
import com.ffadelm.management.barang.service.StokService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
public class StokController {
    @Autowired
    private StokService stokService;
    
    @PostMapping("/stok")
    public Stok saveStok(@RequestBody StokShipRqDTO req){
        return stokService.addStokShip(req);
    }
}
