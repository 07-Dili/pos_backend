package org.dilip.first.pos_backend.dao;

import org.dilip.first.pos_backend.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<ClientEntity, Integer> {
    ClientEntity findByEmail(String email);
}

