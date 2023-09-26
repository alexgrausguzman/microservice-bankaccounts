package com.ntt.microserviceaccounts.domain.repository;


import com.ntt.microserviceaccounts.domain.model.enity.FixedTermAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixedTermAccountRepository extends JpaRepository<FixedTermAccount, Long> {

}
