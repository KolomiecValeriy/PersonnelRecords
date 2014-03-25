package allClasses;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class EmployeeHourlyWages extends AbstractEmployees {

	public EmployeeHourlyWages() {
	}

	@Override
	public float calculatingWage() {
		float r = (float) ((20.8 * 8) * this.getSalary());
		DecimalFormat decFormat = new DecimalFormat();
		decFormat.setMinimumFractionDigits(2);
//		return Double.parseDouble(decFormat.format(r));
		return r;
	}

}
