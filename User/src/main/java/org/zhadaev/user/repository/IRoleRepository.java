package org.zhadaev.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zhadaev.user.model.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findByName(final String name);
}
