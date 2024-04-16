package org.humber.student.transformers;

import org.humber.student.domain.User;
import org.humber.student.repositories.entities.UserEntity;

import java.util.List;

public class UserEntityTransformer {
    
    public static User transformToUser(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .roles(userEntity.getRoles())
                .build();
    }

    public static UserEntity transformToUserEntity(User user) {
        return new UserEntity(user.getId(), user.getUsername(), user.getPassword(), user.getRoles());
    }
    
    public static List<User> transformToUsers(List<UserEntity> userEntities) {
        return userEntities.stream()
                .map(UserEntityTransformer::transformToUser)
                .toList();
    }
    
    public static List<UserEntity> transformToUserEntities(List<User> users) {
        return users.stream()
                .map(UserEntityTransformer::transformToUserEntity).toList();
    }
}