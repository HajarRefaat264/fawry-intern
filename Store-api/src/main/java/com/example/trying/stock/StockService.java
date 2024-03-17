package com.example.trying.stock;

import com.example.trying.StockConsumtionHistory.StockConsumptionHistory;
import com.example.trying.StockConsumtionHistory.StockConsumptionHistoryRepository;
import com.example.trying.store.Store;
import com.example.trying.store.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private final StockConsumptionHistoryRepository stockUpdateHistoryRepository;

    @Autowired
    private StoreRepository storeRepository;

    public StockService(StockConsumptionHistoryRepository stockUpdateHistoryRepository) {
        this.stockUpdateHistoryRepository = stockUpdateHistoryRepository;
    }

    public void deleteAllStocks() {
        stockRepository.deleteAll();
    }
    public Stock addStock(Long storeId, Stock stock) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("Store with ID " + storeId + " not found."));

        stock.setStore(store);
        stock.setCreatedAt(LocalDateTime.now());
        stock.setUpdatedAt(LocalDateTime.now());
        Stock savedStock = stockRepository.save(stock);

        // Update stock history
        StockConsumptionHistory history = new StockConsumptionHistory();
        history.setStock(savedStock);
        history.setQuantityBeforeUpdate(savedStock.getQuantity());
        history.setStoreId(storeId);
        history.setUpdateTime(LocalDateTime.now());
        stockUpdateHistoryRepository.save(history);

        return savedStock;
    }

    public Stock updateStock(Long stockId, Stock updatedStock) {
        Optional<Stock> optionalStock = stockRepository.findById(stockId);

        if (optionalStock.isPresent()) {
            Stock existingStock = optionalStock.get();
            existingStock.setQuantity(updatedStock.getQuantity());
            existingStock.setProductCode(updatedStock.getProductCode());
            existingStock.setStore(updatedStock.getStore());
            return stockRepository.save(existingStock);
        } else {
            throw new IllegalArgumentException("Stock with ID " + stockId + " not found.");
        }
    }
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }
    public ResponseEntity<Stock> searchProduct(Long storeId, Long productCode) {
        Optional<Stock> stock = stockRepository.findByStoreIdAndProductCode(storeId, productCode);
        return stock.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public boolean checkAvailability(Long storeId, Long productCode) {
        Optional<Stock> stock = stockRepository.findByStoreIdAndProductCode(storeId, productCode);
        return stock.isPresent() && stock.get().getQuantity() > 0;
    }

    @Transactional
    public ResponseEntity<String> consumeProduct(Long storeId, Long productCode) {
        Optional<Stock> stockOptional = stockRepository.findByStoreIdAndProductCode(storeId, productCode);
        if (stockOptional.isPresent()) {
            Stock stock = stockOptional.get();
            if (checkAvailability(storeId, productCode)) {
                int quantityBeforeUpdate = stock.getQuantity();
                stock.setQuantity(quantityBeforeUpdate - 1);
                stockRepository.save(stock);


                StockConsumptionHistory updateHistory = new StockConsumptionHistory();
                updateHistory.setStoreId(storeId);
                updateHistory.setProductCode(productCode);
                updateHistory.setQuantityBeforeUpdate(quantityBeforeUpdate);
                updateHistory.setQuantityAfterUpdate(quantityBeforeUpdate - 1);
                updateHistory.setStoreId(storeId);
                updateHistory.setUpdateTime(LocalDateTime.now());
                stockUpdateHistoryRepository.save(updateHistory);

                return ResponseEntity.ok("Product consumed successfully");
            } else {
                return ResponseEntity.badRequest().body("Product not available");
            }
        } else {
            return ResponseEntity.badRequest().body("Stock not found");
        }}



}

