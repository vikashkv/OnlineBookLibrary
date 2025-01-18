package com.vk.onlineBookLibrary.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Nonnull
    private String skuCode;
    @Nonnull
    private String bookName;
    @Nonnull
    private String bookAuthor;
    @Nonnull
    private LocalDateTime bookPublished;

}
