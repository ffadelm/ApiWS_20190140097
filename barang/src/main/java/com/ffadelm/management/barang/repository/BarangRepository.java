/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ffadelm.management.barang.repository;

import com.ffadelm.management.barang.domain.dao.Barang;
import com.ffadelm.management.barang.domain.dto.BarangStokData;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */@Repository
public interface BarangRepository extends JpaRepository<Barang, Long>{
    @Query("SELECT new com.ffadelm.management.barang.domain.dto.BarangStokData(b.id, b.nama, b.kategori, b.berat, s.stok)"
            + " FROM Barang b INNER JOIN Stok s ON s.barangId = b.id")
     List<BarangStokData> barangAllWithStok();
}
