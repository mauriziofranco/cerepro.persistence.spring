package centauri.academy.cerepro.persistence.entity;

public class CustomErrorType extends CeReProAbstractEntity {
	private String errorMessage;

	public CustomErrorType(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

//	@Override
	public String getErrorMessage() {
		return errorMessage;
	}
}
