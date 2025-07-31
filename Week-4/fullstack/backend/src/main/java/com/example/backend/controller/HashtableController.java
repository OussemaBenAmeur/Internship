package com.example.backend.controller;

import com.example.backend.model.Node;
import com.example.backend.service.HashtableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hashtable")
@CrossOrigin(origins = "http://localhost:4200") // Allow Angular frontend
public class HashtableController {

    @Autowired
    private HashtableService hashtableService;

    // Add size query parameter with default 8
    @GetMapping
    public List<List<Node>> getHashtable(@RequestParam(defaultValue = "8") int size) {
        hashtableService.setSize(size);
        return hashtableService.getTable();
    }

    @PostMapping
    public void addKey(@RequestBody KeyValuePair data,
                       @RequestParam(defaultValue = "8") int size) {
        hashtableService.setSize(size);
        hashtableService.put(data.getKey(), data.getValue());
    }

    @DeleteMapping("/{key}")
    public void deleteKey(@PathVariable String key,
                          @RequestParam(defaultValue = "8") int size) {
        hashtableService.setSize(size);
        hashtableService.delete(key);
    }

    public static class KeyValuePair {
        private String key;
        private String value;

        public KeyValuePair() {
        }

        public KeyValuePair(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
