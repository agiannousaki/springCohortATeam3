package gr.codelearn.movie.db.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Series extends Content {
    private int numberOfSeasons;
    private int totalEpisodes;
    private BigInteger yearOfFirstSeason;
    private BigInteger yearOfLastSeason;
}
