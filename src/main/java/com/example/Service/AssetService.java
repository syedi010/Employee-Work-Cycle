package com.example.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Entity.Asset;
import com.example.Exception.ResourceNotFoundException;
import com.example.Repository.AssetRepository;


@Service
public class AssetService {
    
    private final AssetRepository assetRepository;

    public AssetService(AssetRepository assetRepository)
    {
        this.assetRepository=assetRepository;
    }

    public Asset createAsset(Asset asset)
    {
    
        return assetRepository.save(asset);
    }

    public Asset fetchAssetById(Long id)
    {
        return assetRepository.findById(id)
                            .orElseThrow(()-> new ResourceNotFoundException("Id not found")); 
    // findById(id) returns Optional<Asset> but .orElseThrow() Optional unwrap kar deta hai
    }

    public List<Asset> fetchAllAsset()
    {
        return assetRepository.findAll();
    }

}
