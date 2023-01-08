package shop.mapper;

import org.springframework.stereotype.Component;
import shop.dto.UserDTO;
import shop.entity.User;

@Component
public class UserToUserMapperDTO {
    public User toEntity(final UserDTO userDTO){
        final User user = new User();

        user.setId(userDTO.getId());
        user.setEmployeeRole(userDTO.getEmployeeRole());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setPassword(userDTO.getPassword());

        return user;
    }

    public UserDTO toDTO(final User user){
        final UserDTO userDTO = new UserDTO();

        userDTO.setEmployeeRole(user.getEmployeeRole());
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }
}
