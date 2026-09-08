package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Asset;

public interface AssetRepository extends JpaRepository<Asset, Long>
{
    
}