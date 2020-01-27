package com.company.BEditor.repo;

import com.company.BEditor.domain.Message;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IMessageRepo extends JpaRepository<Message, Long> {
}
