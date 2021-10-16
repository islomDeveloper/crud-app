package dev.islom.crudapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String id;
    private String firstName;
    private String lastName;

    public UserDto(String firsName, String lastName) {
        this.firstName = firsName;
        this.lastName = lastName;
    }
}
