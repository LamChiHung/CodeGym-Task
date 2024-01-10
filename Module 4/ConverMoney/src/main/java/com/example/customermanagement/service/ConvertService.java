package com.example.customermanagement.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvertService {
    @Override
    public int Convert(int usd) {
        int vnd = usd * 20000;
        return vnd;
    }
}
