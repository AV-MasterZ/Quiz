package org.zhadaev.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zhadaev.user.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(final String username);
}
