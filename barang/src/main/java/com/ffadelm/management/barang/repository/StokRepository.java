/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ffadelm.management.barang.repository;

import com.ffadelm.management.barang.domain.dao.Stok;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository
@Transactional
public interface StokRepository extends JpaRepository<Stok, Long>{
    public void deleteByBarangId(Long id);
    
    public Optional<Stok> findByBarangId(Long id);
}
