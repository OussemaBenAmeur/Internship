package com.example.backend.service;

import com.example.backend.model.LinkedHashtable;
import com.example.backend.model.Node;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HashtableService {

    private LinkedHashtable hashtable;
    private int currentSize = 8; // default size

    public HashtableService() {
        this.hashtable = new LinkedHashtable(currentSize);
    }

    // Set size (resets hashtable if size changes)
    public void setSize(int size) {
        if (size != currentSize) {
            currentSize = size;
            this.hashtable = new LinkedHashtable(size);
        }
    }

    public List<List<Node>> getTable() {
        return hashtable.getTableAsList();
    }

    public void put(String key, String value) {
        hashtable.put(key, value);
    }

    public void delete(String key) {
        hashtable.delete(key);
    }
}
