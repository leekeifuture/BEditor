package com.company.BEditor.repo;

import com.company.BEditor.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDetailRepo extends JpaRepository<User, String> {
}
