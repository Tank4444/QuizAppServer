package ru.chuikov.entity.dto.ar;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.chuikov.entity.ar.ArType;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ARDto {

    Long id;

    ArType arType;

    String hint;

    FileDto target;

    FileDto object;

}
