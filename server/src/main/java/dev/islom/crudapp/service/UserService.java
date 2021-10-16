package dev.islom.crudapp.service;

import dev.islom.crudapp.entity.User;
import dev.islom.crudapp.payload.ApiResponse;
import dev.islom.crudapp.payload.UserDto;
import dev.islom.crudapp.repository.UserRepository;
import org.springframework.stereotype.Service;

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
            return new ApiResponse("Success!",true,userRepository.findAll());
        }catch (Exception e){
            return new ApiResponse("Error!", false);
        }
    }
}
