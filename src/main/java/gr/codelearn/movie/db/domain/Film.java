package gr.codelearn.movie.db.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigInteger;
import java.util.Date;

@Data
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Film extends Content {
    private BigInteger durationInSec;
    private Date dateOfRelease;
}
