package com.cmpe272.spring.authentication;

import com.cmpe272.domain.AccountInfo;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.cmpe272.dao.AccountInfoDAO;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    AccountInfoDAO accountInfoDAO = new AccountInfoDAO();
    @Override
    public Authentication authenticate(Authentication authentication) {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        AccountInfo accountInfo = accountInfoDAO.getAccountInfo(name);

        List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
        Authentication auth = null;

        if(name.equals("admin") && password.equals("admin")) {
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            auth = new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
        } else if (accountInfo != null && password.equals(accountInfo.getPassword())) {
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
            auth = new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
        }

        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}