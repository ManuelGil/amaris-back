package com.amaris.technicaltest.service;

import com.amaris.technicaltest.client.CommuneClient;
import com.amaris.technicaltest.persistence.entity.CommuneEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommuneService {

    private final CommuneClient communeClient;

    @Autowired
    public CommuneService(CommuneClient communeClient) {
        this.communeClient = communeClient;
    }

    public List<CommuneEntity> getAll() {
        return this.communeClient.getAll();
    }
}
