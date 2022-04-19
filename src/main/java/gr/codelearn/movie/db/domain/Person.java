package gr.codelearn.movie.db.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PEOPLE")
@SequenceGenerator(name = "idGenerator", sequenceName = "PEOPLE_SEQ", initialValue = 1, allocationSize = 1)
public class Person extends BaseModel {

    @NotNull
    @Column(length = 200, nullable = false)
    private String lastName;

    @NotNull
    @Column(length = 200, nullable = false)
    private String firstName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateOfBirth;

    @NotNull
    @Column(precision = 3, scale = 2, nullable = false)
    private Double height;

    @NotNull
    @Column(length = 200, nullable = false)
    private String placeOfBirth;

    @NotNull
    @Column(length = 1000, nullable = false)
    private String biography;

    @NotNull
    @Column(length = 100, nullable = false)
    private String company;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "person")
    private Set<Activity> activities;

}
