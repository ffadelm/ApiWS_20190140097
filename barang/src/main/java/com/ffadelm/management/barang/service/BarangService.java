/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ffadelm.management.barang.service;

import com.ffadelm.management.barang.domain.dao.Barang;
import com.ffadelm.management.barang.domain.dao.Stok;
import com.ffadelm.management.barang.domain.dto.BarangStokData;
import com.ffadelm.management.barang.repository.BarangRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class BarangService {

    @Autowired
    private BarangRepository barangRepo;

    @Autowired
    private StokService stokService;

    public List<BarangStokData> getAllBarang() {
        //     return barangRepo.findAll();
        return barangRepo.barangAllWithStok();
    }

    public Barang saveBarang(Barang barang) {
        //nilai awal
        boolean isCreated = false;
        //klo null buat stok
        if (Objects.isNull(barang.getId())) {
            isCreated = true;
        }
        barang = barangRepo.save(barang);

        //klo ada dapetin id 
        if (isCreated) {
            Stok stok = Stok.builder()
                    .barangId(barang.getId())
                    .stok(0)
                    .build();

            stokService.saveStok(stok);
        }

        return barang;
    }

    public void deleteBarang(Long id) {
        Optional<Barang> barangOpt = barangRepo.findById(id);
        if (!barangOpt.isPresent()) {
            throw new RuntimeException("Barang tidak ditemukan");
        }
        stokService.deleteStokByBarang(id);
        barangRepo.deleteById(id);
    }
}
