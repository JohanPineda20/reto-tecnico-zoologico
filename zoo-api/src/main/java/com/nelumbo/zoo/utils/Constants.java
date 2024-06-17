package com.nelumbo.zoo.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {
    public static final byte ZERO = 0;
    public static final Long ID_EMPLOYEE = 2L;
    public static final String EMPLOYEE = "EMPLOYEE";
    public static final String ROLE_NOT_FOUND = "Role not found";
    public static final String USER_NOT_FOUND = "User not found";
    public static final String AREA_NOT_FOUND = "Area not found";
    public static final String SPECIE_NOT_FOUND = "Specie not found";
    public static final String ANIMAL_NOT_FOUND = "Animal not found";
    public static final String COMMENT_NOT_FOUND = "Comment not found";
    public static final String DNI = "DNI";
    public static final String EMAIL = "email";
    public static final String USER_ALREADY_EXISTS = "User with %s: %s already exists";
    public static final String AREA_ALREADY_EXISTS = "Area with name: %s already exists";
    public static final String SPECIE_ALREADY_EXISTS = "Specie with name: %s already exists";
    public static final String CANNOT_DELETE_AREA = "cannot delete area %s because specie %s has animals";
    public static final String CANNOT_DELETE_SPECIE = "cannot delete specie %s because has animals";
    public static final String CANNOT_DELETE_COMMENT = "cannot delete comment because you are not the author";
    public static final String ADMIN_ALLOWED =  "hasAuthority('ADMIN')";
    public static final String ADMIN_OR_EMPLOYEE_ALLOWED =  "hasAnyAuthority('ADMIN', 'EMPLOYEE')";
}
