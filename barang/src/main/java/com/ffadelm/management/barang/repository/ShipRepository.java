/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ffadelm.management.barang.repository;

import com.ffadelm.management.barang.domain.dao.Ship;
import com.ffadelm.management.barang.domain.dto.DataRiwayat;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    List<Ship> findByBarangId(Long id);

    List<Ship> findByShipperId(Long id);

     @Query(value = "SELECT new com.ffadelm.management.barang.domain.dto.DataRiwayat(b.nama, s.stok, s.tanggal, s.tipe) " +
            "FROM Ship s INNER JOIN Barang b ON b.id = s.barangId " +
            "WHERE s.shipperId = :id")
    List<DataRiwayat> findByDataRiwayatId(Long id);
}
