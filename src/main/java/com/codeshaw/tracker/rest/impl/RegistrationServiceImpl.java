package com.codeshaw.tracker.rest.impl;

import com.codeshaw.tracker.domain.User;
import com.codeshaw.tracker.dto.UserDto;
import com.codeshaw.tracker.repository.UserRepository;
import com.codeshaw.tracker.rest.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationServiceImpl implements RegistrationService {

  private UserRepository userRepository;

  private PasswordEncoder passwordEncoder;

  public RegistrationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  @RequestMapping(value = "/api/register", method = RequestMethod.POST)
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<?> register(@RequestBody UserDto userDto) {
    User user = new User();
    user.setUsername(userDto.getUsername());
    user.setPassword(passwordEncoder.encode(userDto.getPassword()));
    userRepository.save(user);
    return ResponseEntity.ok().build();
  }
}
