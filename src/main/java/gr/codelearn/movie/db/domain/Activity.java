package gr.codelearn.movie.db.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "ACTIVITIES")
public class Activity {
	@EmbeddedId
	private ActivityKey key;

	@ManyToOne
	@MapsId("personId")
	private Person person;

	@ManyToOne
	@MapsId("contentId")
	private Content content;

	@Column(name = "PERSON_TYPE", nullable = false)
	@Enumerated(EnumType.STRING)
	private PersonType personType;

	public Activity(final Content content, final Person person, final PersonType personType) {
		this.key = new ActivityKey(content.getId(), person.getId());
		this.content = content;
		this.person = person;
		this.personType = personType;
	}
}
