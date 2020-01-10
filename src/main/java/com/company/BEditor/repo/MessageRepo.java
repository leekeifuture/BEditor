package com.company.BEditor.repo;

import com.company.BEditor.domain.Message;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
