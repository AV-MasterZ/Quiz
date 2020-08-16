package org.zhadaev.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zhadaev.user.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(final String username);
}
