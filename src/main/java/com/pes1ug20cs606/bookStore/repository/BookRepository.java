package com.pes1ug20cs606.bookStore.repository;

import com.pes1ug20cs606.bookStore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
