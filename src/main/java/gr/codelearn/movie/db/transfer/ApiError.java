package gr.codelearn.movie.db.transfer;

import lombok.ToString;
import lombok.Value;

@Value
@ToString
public class ApiError {
	Integer status;
	String message;
}
