package com.nelumbo.zoo.security.auth.authinformation;

public interface IAuthInformation {
    Long getIdFromAuthentication();
    String getRolFromAuthentication();
}
