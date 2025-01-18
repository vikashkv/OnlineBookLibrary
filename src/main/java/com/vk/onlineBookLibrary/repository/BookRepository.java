package com.vk.onlineBookLibrary.repository;

import com.vk.onlineBookLibrary.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Books, Long> {
    boolean existsBySkuCode(String skuCode);

    void deleteBySkuCode(String skuCode);

    Books findBySkuCode(String skuCode);
}
