package org.snippetkeeper.exception;

public class SnippetNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -694354952032299587L;

	private String snippetId;

	public SnippetNotFoundException(String snippetId) {
		this.snippetId = snippetId;
	}

	@Override
	public String getMessage() {
		return "Snippet with Id " + snippetId + " not found";
	}

}
