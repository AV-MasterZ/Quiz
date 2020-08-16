package org.zhadaev.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zhadaev.user.model.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findByName(final String name);
}
