package gr.codelearn.movie.db.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Content extends BaseModel {

    private String title;
    private Double rating;
    private String plot;
    private Set<ContentCategory> genre;
    private Set<Actor> actors;
    private Set<Producer> producers;
    private Set<Director> directors;
}
