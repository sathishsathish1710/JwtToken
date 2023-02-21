package com.example.jwtdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/")
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    @PostMapping("/")
    public Item addItem(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable(value = "id") String id, @RequestBody Item item) {
        Item existingItem = itemRepository.findById(id).orElse(null);

        if (existingItem == null) {
            return ResponseEntity.notFound().build();
        }

        existingItem.setName(item.getName());
        existingItem.setQuantity(item.getQuantity());

        Item updatedItem = itemRepository.save(existingItem);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable(value = "id") String id) {
        Item existingItem = itemRepository.findById(id).orElse(null);

        if (existingItem == null) {
            return ResponseEntity.notFound().build();
        }

        itemRepository.delete(existingItem);
        return ResponseEntity.ok(existingItem);
    }
}
