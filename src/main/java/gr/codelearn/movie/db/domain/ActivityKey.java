package gr.codelearn.movie.db.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ActivityKey implements Serializable {
	private Long contentId;
	private Long personId;
	private PersonType personType;
}
