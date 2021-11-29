package api1.api1.validator;
import java.time.LocalDate;
import java.sql.Date;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UserDobValidator implements ConstraintValidator<UserDob, String> {
	@Override
	public boolean isValid(String dob ,ConstraintValidatorContext constraintValidatorContext ) {

	if(!dob.matches("^\\d{2}-\\d{2}-\\d{4}$"))
	{
	return false;
	}
	LocalDate dates=LocalDate.of(Integer.parseInt(dob.substring(6,9)),
	Integer.parseInt(dob.substring(3,4)), Integer.parseInt(dob.substring(0,1)));


	if(!Date.valueOf(dates).before(Date.valueOf(LocalDate.now())))
	{
	return false;
	}
	return true;

	}
}
