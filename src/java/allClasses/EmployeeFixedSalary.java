package allClasses;

public class EmployeeFixedSalary extends AbstractEmployees {

	public EmployeeFixedSalary() {
	}
	
	@Override
	public float calculatingWage() {
		return this.getSalary();
	}

}
