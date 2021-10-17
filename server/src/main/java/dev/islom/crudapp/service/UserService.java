package dev.islom.crudapp.service;

import dev.islom.crudapp.entity.User;
import dev.islom.crudapp.payload.ApiResponse;
import dev.islom.crudapp.payload.UserDto;
import dev.islom.crudapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    final
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ApiResponse addUser(UserDto userDto) {
        try {
            userRepository.save(new User(userDto.getFirstName(), userDto.getLastName()));
            return new ApiResponse("Successfully added!", true);

        } catch (Exception e) {
            return new ApiResponse("Error!", false);
        }
    }

    public ApiResponse getUsers() {
        try {
            return new ApiResponse("Success!", true, userRepository.findAll());
        } catch (Exception e) {
            return new ApiResponse("Error!", false);
        }
    }

    public ApiResponse editUser(UserDto userDto) {
        try {
            Optional<User> optionalUser = userRepository.findById(userDto.getId());
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                if (userDto.getFirstName() != null)
                    user.setFirstName(userDto.getFirstName());
                if (userDto.getLastName() != null)
                    user.setLastName(userDto.getLastName());
                userRepository.save(user);
                return new ApiResponse("Successfully edited!", true);
            } else {
                return new ApiResponse("User not found!", false);
            }
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), false);
        }
    }

    public ApiResponse deleteUser(UserDto userDto) {
        try {
            Optional<User> optionalUser = userRepository.findById(userDto.getId());
            if (optionalUser.isPresent()) {
                userRepository.deleteById(userDto.getId());
                return new ApiResponse("Successfully deleted!", true);
            } else {
                return new ApiResponse("User not found!", false);
            }

        } catch (Exception e) {
            return new ApiResponse("Error", false);
        }
    }
}
