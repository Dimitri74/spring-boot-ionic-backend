/**
 * 
 */
package com.cursomc.resources.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcus Dimitri
 *
 */
public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError(Integer status, Long timestamp,  String error, String message, String path) {
		super(timestamp, status, error, message, path);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String messagem) {
		errors.add(new FieldMessage(fieldName, messagem));
	}

}
