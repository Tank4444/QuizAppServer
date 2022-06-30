package ru.chuikov.entity.dto.actor;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.chuikov.entity.actor.UserRole;
import ru.chuikov.entity.ar.File;
import ru.chuikov.entity.dto.ar.FileDto;
import ru.chuikov.entity.dto.quiz.GameDto;
import ru.chuikov.entity.quiz.Game;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class UserDto {

        private Long id;

        private String email;

        @JsonIgnore
        private String password;

        private String first_name;

        private String last_name;

        private String org_name;

        @JsonIgnore
        private List<GameDto> games;

        @JsonIgnore
        private List<FileDto> files;

        private UserRole role;

}