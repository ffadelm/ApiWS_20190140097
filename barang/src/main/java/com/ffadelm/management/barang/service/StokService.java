/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ffadelm.management.barang.service;

import com.ffadelm.management.barang.constant.ShipTipeConstant;
import com.ffadelm.management.barang.domain.dao.Ship;
import com.ffadelm.management.barang.domain.dao.Stok;
import com.ffadelm.management.barang.domain.dto.StokShipRqDTO;
import com.ffadelm.management.barang.repository.ShipRepository;
import com.ffadelm.management.barang.repository.StokRepository;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class StokService {

    @Autowired
    private StokRepository stokRepo;
    @Autowired
    private ShipRepository shipRepo;

    public Stok saveStok(Stok stok) {
        return stokRepo.save(stok);
    }

    public void deleteStokByBarang(Long id) {
        stokRepo.deleteByBarangId(id);
    }

    public Stok addStokShip(StokShipRqDTO req) {
        //cek tipe IN : masuk OUT: keluar

        Optional<Stok> stokOpt = stokRepo.findByBarangId(req.getBarangId());
        if (!stokOpt.isPresent()) {
            //bila stok tidak ada
            throw new RuntimeException("stok tidak ditemukan");
        }

        //optional agar tidak kena runtime
        Stok stok = stokOpt.get();

        //menambahkan data ke tbl ship
        Ship ship = Ship.builder()
                .barangId(req.getBarangId())
                .shipperId(req.getShipperId())
                .stok(req.getStok())
                .tipe(req.getTipe())
                .tanggal(new Date())
                .build();
        shipRepo.save(ship);

        //cek tipe 
        switch (req.getTipe()) {
            case ShipTipeConstant.TIPE_IN:
                //menambah stok yang lama dengan stok baru
                stok.setStok(stok.getStok() + req.getStok());
                break;
            case ShipTipeConstant.TIPE_OUT:
                //validasi stok out
                if (stok.getStok() < req.getStok()) {
                    throw new RuntimeException("Error Stok tidak tersedia");
                }
                //mengurangi stok lama dengan yang baru
                stok.setStok(stok.getStok() - req.getStok());
                break;
            default:
                throw new RuntimeException("Tipe Error");
        }

        return stokRepo.save(stok);
    }
}
