package com.tulipsoftwaresolutions.mobileapp.services.common;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Utils {
    public String generateUID(){
        return UUID.randomUUID().toString();
    }
}
