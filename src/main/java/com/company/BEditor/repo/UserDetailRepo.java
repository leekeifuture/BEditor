package com.company.BEditor.repo;

import com.company.BEditor.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepo extends JpaRepository<User, String> {
}
