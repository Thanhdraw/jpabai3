package com.cybersoft.jpabai3.repository;

import com.cybersoft.jpabai3.entity.book.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long>, JpaSpecificationExecutor<BookEntity> {
}
