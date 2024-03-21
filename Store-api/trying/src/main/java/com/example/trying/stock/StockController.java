package com.example.trying.stock;
import com.example.trying.store.Store;
import com.example.trying.store.StoreRepository;
import com.example.trying.store.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/stock")
public class StockController {
    @Autowired
    private StockService stockService;
    @Autowired
    private StoreRepository storeRepository;

    @GetMapping("/search")
    public ResponseEntity<Stock> searchProduct(@RequestParam Long storeId,@RequestParam Long productCode) {
        return stockService.searchProduct(storeId,productCode);
    }

    @GetMapping("/checkAvailability")
    public boolean checkAvailability(@RequestParam Long storeId,@RequestParam Long productCode) {
        return stockService.checkAvailability(storeId,productCode);
    }

    @PostMapping("/add/{storeId}")
    public Stock addStock(@PathVariable Long storeId, @RequestBody Stock stock) {
        return stockService.addStock(storeId, stock);
    }
    @PostMapping("/consume")
    public ResponseEntity<String> consumeProduct(@RequestParam Long storeId,@RequestParam Long productCode) {
        return stockService.consumeProduct(storeId,productCode);
    }

    //CRUD
    @DeleteMapping("/deleteAll")
    public void deleteAllStocks() {
        stockService.deleteAllStocks();
    }
    @PutMapping("/update/{stockId}")
    public Stock updateStock(@PathVariable Long stockId, @RequestBody Stock updatedStock) {
        return stockService.updateStock(stockId, updatedStock);
    }
    @GetMapping("/getAll")
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }
}

