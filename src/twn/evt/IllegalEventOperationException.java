package twn.evt;

class IllegalEventOperationException extends Exception {
	private static final long serialVersionUID = 1L;

	static void throwCatchAndPrintNewIllegalEventOperationException(String message) {
		try {
			throw new IllegalEventOperationException(message);
		} catch (IllegalEventOperationException e) {
			e.printStackTrace();
		}
	}

	private IllegalEventOperationException(String message) {
		super(message);
	}
	
}
