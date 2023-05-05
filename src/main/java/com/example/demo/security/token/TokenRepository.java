package com.example.demo.security.token;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TokenRepository extends JpaRepository<Token, Long> {

  @Query(value = """
      select t from Token t 
      inner JOIN Enseignant e ON t.user.id = e.id 
      inner JOIN StaffAdministratif s ON t.user.id = s.id
      where (e.id = :id and (t.expired = false or t.revoked = false)) or (s.id = :id and (t.expired = false or t.revoked = false))
      """)
  List<Token> findAllValidTokenByUser(Long id);

  Optional<Token> findByToken(String token);
}
