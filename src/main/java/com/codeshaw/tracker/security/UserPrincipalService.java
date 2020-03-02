package com.codeshaw.tracker.security;

import com.codeshaw.tracker.domain.User;
import com.codeshaw.tracker.repository.CheckInRepository;
import com.codeshaw.tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);
    if(user == null) {
      throw new UsernameNotFoundException(username);
    }
    return new UserPrincipal(user);
  }
}
