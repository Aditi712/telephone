package com.example.Telephone.Repository;

import com.example.Telephone.Model.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TelephoneRepository extends JpaRepository<Telephone, Integer> {

    List<Telephone> findByName(String name);

    Optional<Telephone> findByEmail(String email);

    List<Telephone> findByAddress(String address);
}
