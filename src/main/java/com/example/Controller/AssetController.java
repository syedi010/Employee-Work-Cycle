package com.example.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Entity.Asset;
import com.example.Service.AssetService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/asset")
public class AssetController {

private final AssetService assetService;

public AssetController(AssetService assetService)
{
    this.assetService = assetService;
}
    
    @PostMapping("/createAsset")
    public ResponseEntity<Asset> createAsset(@Valid @RequestBody Asset asset)
    {
        if(asset==null)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        
        else{
        Asset newAsset=assetService.createAsset(asset);
        return ResponseEntity.ok(newAsset);
        }
    }

    
    
}
