package gr.codelearn.movie.db.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Person extends BaseModel {
    private String lastName;
    private String firstName;
    private Date dateOfBirth;
    private String placeOfBirth;
    private String biography;
    private Set<Film> films;
    private Set<Series> series;
}
