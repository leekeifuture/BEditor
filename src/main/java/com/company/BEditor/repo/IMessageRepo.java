package com.company.BEditor.repo;

import com.company.BEditor.domain.Message;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMessageRepo extends JpaRepository<Message, Long> {

    @EntityGraph(attributePaths = {"comments"})
    Page<Message> findAll(Pageable pageable);
}
