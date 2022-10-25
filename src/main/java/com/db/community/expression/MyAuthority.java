package com.db.community.expression;

import com.db.community.model.auth.LoginUser;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("ma")
public class MyAuthority {

    public boolean hasAuthority(String authority){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication instanceof AnonymousAuthenticationToken){
            System.out.println("匿名用户");
            return false;
        }
        System.out.println("到这");
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return loginUser.getPermissions().contains(authority);
    }
}
