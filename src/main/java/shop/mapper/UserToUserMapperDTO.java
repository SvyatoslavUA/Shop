package shop.mapper;

import org.springframework.stereotype.Component;
import shop.dto.UserDTO;
import shop.entity.User;

@Component
public class UserToUserMapperDTO {
    public User toEntity(final UserDTO userDTO){
        final User user = new User();

        user.setRole(userDTO.getRole());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());

        return user;
    }

    public UserDTO toDTO(final User user){
        final UserDTO userDTO = new UserDTO();

        userDTO.setRole(user.getRole());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }
}
