package gr.codelearn.movie.db.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column
    private Date dateOfBirth;

    @Column(precision = 3, scale = 2)
    private Double height;

    @Column(length = 200)
    private String placeOfBirth;

    @Column(length = 1000)
    private String biography;

    @Column(length = 100)
    private String company;

    @JsonManagedReference("activities")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "person",fetch = FetchType.EAGER)
    private Set<Activity> activities;

}
