package be.ss13security.service;

import be.ss13security.entity.UserApp;
import be.ss13security.entity.UserRole;
import be.ss13security.repository.UserAppRepository;
import be.ss13security.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserAppRepository userAppRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserApp userApp = userAppRepository.findByUserName(username);
        if (userApp == null) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }

        List<UserRole> userRoleList = userRoleRepository.findAllByUserApp(userApp);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (UserRole role : userRoleList) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().getRoleName()));
        }

        return new User(username, userApp.getPassword(), grantedAuthorities);
    }
}
