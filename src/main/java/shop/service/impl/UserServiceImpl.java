package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dto.UserDTO;
import shop.entity.User;
import shop.exeption.ServiceException;
import shop.mapper.UserToUserMapperDTO;
import shop.repositiry.UserRepository;
import shop.service.UserService;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserToUserMapperDTO userToUserMapperDTO;

    @Autowired
    private UserRepository userRepository;

    public UserDTO getUser(Long userId, String password) {
        if(!Objects.equals(userRepository.getUserById(userId).getPassword(), password)){
            throw new RuntimeException("Password is wrong!");
        }

        return userToUserMapperDTO.toDTO(userRepository.findById(userId)
                .orElseThrow(() -> new ServiceException(400, "User with id not found: " + userId, "")));
    }

    public UserDTO saveUser(final UserDTO userDTO) {

        final User user = userToUserMapperDTO.toEntity(userDTO);

        userRepository.save(user);

        return userToUserMapperDTO.toDTO(user);
    }

    public UserDTO updateUserInformation(Long userId, String password){
        User user = userRepository.getUserById(userId);

        final User savedUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new ServiceException(400, "User with id not found: " + userId, ""));

        if(!Objects.equals(userRepository.getUserById(userId).getPassword(), password)){
            throw new RuntimeException("Password is wrong!");
        }

        savedUser.setPassword(user.getPassword());
        savedUser.setSurname(user.getSurname());
        savedUser.setName(user.getName());

        return userToUserMapperDTO.toDTO(userRepository.save(savedUser));
    }


}
