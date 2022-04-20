package gr.codelearn.movie.db.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "CONTENTS")
@SequenceGenerator(name = "idGenerator", sequenceName = "CONTENTS_SEQ", initialValue = 1, allocationSize = 1)
@Inheritance(strategy = InheritanceType.JOINED)
public class Content extends BaseModel {

    @NotNull
    @Column(length = 200, nullable = false)
    private String title;

    @NotNull
    @Column(precision = 4, scale = 2, nullable = false)
    private Double rating;

    @NotNull
    @Column(length = 1000, nullable = false)
    private String plot;

    @ElementCollection(targetClass = Category.class)
    @CollectionTable(name="CONTENT_CATEGORY")
    @Column(name = "CATEGORY", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Category> genre;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "content",fetch = FetchType.EAGER)
    private Set<Activity> activities;
}
