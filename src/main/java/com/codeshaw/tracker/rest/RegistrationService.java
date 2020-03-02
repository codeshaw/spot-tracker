package com.codeshaw.tracker.rest;

import com.codeshaw.tracker.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface RegistrationService {

  /**
   * Registers a new user
   *
   * @param user The user details to register
   */
  ResponseEntity<?> register(UserDto user);
}
