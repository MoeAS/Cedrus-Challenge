package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    public boolean existsByName(String name);

    public List<Book> findByName(String name);

    @Query("select max(b.id) from Book b")
    public Integer findMaxId();

    @Query("SELECT b FROM Book b WHERE UPPER(b.name) LIKE CONCAT('%',UPPER(:name),'%')")
    public List<Book> searchByTitleLike(@Param("name") String name);
}
