package com.example.trying.store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/store")
public class StoreController {
    @Autowired
    private StoreService storeService;
    @DeleteMapping("/delete/{storeId}")
    public void deleteStoreById(@PathVariable Long storeId) {
        storeService.deleteStoreById(storeId);
    }
    @PutMapping("/update/{storeId}")
    public Store updateStore(@PathVariable Long storeId, @RequestBody Store updatedStore) {
        return storeService.updateStore(storeId, updatedStore);
    }

    @PostMapping("/create")
    public Store createStore(@RequestBody Store store) {
        return storeService.createStore(store);
    }
    @GetMapping("/getAll")
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }
}
