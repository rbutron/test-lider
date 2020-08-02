package co.com.test.adapter.web.mapper;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class StatusTransaction {

	@NonNull
	private String messages;

	@NonNull
	private HttpStatus status;

}
