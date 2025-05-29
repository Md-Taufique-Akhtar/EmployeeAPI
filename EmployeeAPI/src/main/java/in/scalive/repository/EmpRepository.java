package in.scalive.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.scalive.entity.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer>{
  public Optional<Emp> findByEname(String ename);
}
