package com.nelumbo.zoo.security.auth.authinformation;

import com.nelumbo.zoo.security.userdetails.UserDetailsImpl;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthInformationAdapter implements IAuthInformation {
    @Override
    public Long getIdFromAuthentication() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getId();
    }
    @Override
    public String getRolFromAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString();
    }
}
