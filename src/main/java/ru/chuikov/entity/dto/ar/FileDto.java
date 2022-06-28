package ru.chuikov.entity.dto.ar;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.chuikov.entity.dto.actor.UserDto;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileDto {
    Long id;

    String name;

    byte[] bytes;

    UserDto creator;

    String meta;

    ARDto ar;
}
