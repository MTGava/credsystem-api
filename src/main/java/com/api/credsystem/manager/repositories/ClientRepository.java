package com.api.credsystem.manager.repositories;

import com.api.credsystem.manager.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Integer> {

}
