
package com.example.securityjwt.service;

import com.example.securityjwt.entity.AppUser;
import com.example.securityjwt.repository.AppUserRepository;
import com.example.securityjwt.security.AppUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AppService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(appUserRepository.findByUsername(username));
        Optional<AppUser> appUser = appUserRepository.findByUsername(username);
        return new AppUserDetails(appUser.get());
    }
}
