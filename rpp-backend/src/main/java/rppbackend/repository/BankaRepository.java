package rppbackend.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import rppbackend.model.Banka;

public interface BankaRepository extends JpaRepository<Banka,Integer> {

    List<Banka> findBynazivContainingIgnoreCase(String naziv);
    List<Banka> findBypib(int number);
    List<Banka> findBykontakt(String number);
}
