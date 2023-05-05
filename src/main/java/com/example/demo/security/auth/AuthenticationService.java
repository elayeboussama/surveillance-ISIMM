package com.example.demo.security.auth;


import com.example.demo.Doa.EnseignantRepository;
//import com.example.demo.Doa.StaffAdministratifRepository;
import com.example.demo.Doa.PersonneRepository;
import com.example.demo.Doa.StaffAdministratifRepository;
import com.example.demo.entities.Enseignant;
import com.example.demo.entities.Personne;
import com.example.demo.entities.StaffAdministratif;
import com.example.demo.entities.enums.Role;
import com.example.demo.security.config.JwtService;
import com.example.demo.security.token.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final EnseignantRepository enseignantRepository;
  private final PersonneRepository personneRepository;
  private final StaffAdministratifRepository staffAdministratifRepository;
  private final TokenRepository tokenRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
    System.out.println("hello");
    System.out.println(request);
    String jwtToken ="";
    if(request.getRole().equals(Role.ENSEIGNANT)){
      var user = Enseignant.builder()
              .department(request.getDepartment())
              .cin(request.getCin())
              .nom(request.getNom())
              .email(request.getEmail())
              .age(request.getAge())
              .gradeEnseignant(request.getGradeEnseignant())
              .adresse(request.getAdresse())
              .nombreHeures(request.getNombreHeures())
              .DateEmbauche(request.getDateEmbauche())
              .prenom(request.getPrenom())
              .Salaire(request.getSalaire())
              .sexe(request.getSexe())
              .telephone(request.getTelephone())
              .naissance(request.getNaissance())
              .NbJourCongeRestant(request.getNbJourCongeRestant())
              .NbJourCongeTotale(request.getNbJourCongeTotale())
              .password(passwordEncoder.encode(request.getPassword()))
              //.role(Role.valueOf(request.getRole()))
              .build();
      var savedUser = enseignantRepository.save(user);
      jwtToken = jwtService.generateToken(user);
      saveUserToken(savedUser, jwtToken);
    }else if(request.getRole().equals(Role.ADMIN)){
      var user = StaffAdministratif.builder()
              .department(request.getDepartment())
              .cin(request.getCin())
              .nom(request.getNom())
              .email(request.getEmail())
              .password(passwordEncoder.encode(request.getPassword()))
              //.role(Role.valueOf(request.getRole()))
              .build();
      var savedUser = staffAdministratifRepository.save(user);
      jwtToken = jwtService.generateToken(user);
      saveUserToken(savedUser, jwtToken);

    }
    return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    var user = personneRepository.findByEmail(request.getEmail())
        .orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    revokeAllUserTokens(user);
    saveUserToken(user, jwtToken);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }

  private void saveUserToken(Personne user, String jwtToken) {
    var token = Token.builder()
        .user(user)
        .token(jwtToken)
        .tokenType(TokenType.BEARER)
        .expired(false)
        .revoked(false)
        .build();
    tokenRepository.save(token);
  }

  private void revokeAllUserTokens(Personne user) {
    var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
    if (validUserTokens.isEmpty())
      return;
    validUserTokens.forEach(token -> {
      token.setExpired(true);
      token.setRevoked(true);
    });
    tokenRepository.saveAll(validUserTokens);
  }
}
