package test.lowes.assignment.car.constants;

public final class CarConstants {

	public class LogConstants {
		public static final String METHOD_ENTER = "CLCI001: Entering into ";
		public static final String METHOD_EXIT = "CLCI002: Exiting from ";
	}

	public class ErrorLogConstants {
		public static final String INVALID_CAR_ID = "CELCE001: Invalid car ID passed in request";
		public static final String CAR_NOT_FOUND_FOR_ID = "CELCE002: Car not found for the requested ID";
		public static final String INVALID_COMPANY_ID = "CELCE003: Invalid company ID passed in request";
		public static final String COMPANY_NOT_FOUND_FOR_ID = "CELCE004: Company not found for the requested ID";
		public static final String SQL_SYNTAX_ERROR_EXCEPTION = "CELCE005: Something went wrong with the database";
	}

	public class ErrorResponseConstants {
		public static final String INVALID_CAR_ID = "Invalid car ID. Please check the ID";
		public static final String CAR_NOT_FOUND_FOR_ID = "Car not found for the given ID. Please check the ID";
		public static final String INVALID_COMPANY_ID = "Invalid company ID. Please check the ID";
		public static final String COMPANY_NOT_FOUND_FOR_ID = "Company not found for the given ID. Please check the ID";
		public static final String SQL_SYNTAX_ERROR_EXCEPTION = "Something went wrong with the database. Please contact administrator";
	}

}
