package gr.codelearn.movie.db.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "ACTIVITIES")
public class Activity {
	@EmbeddedId
	private ActivityKey key;

	@ManyToOne
	@MapsId("personId")
	@JsonBackReference("activities")
	@NotNull
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
