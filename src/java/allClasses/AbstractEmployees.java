package allClasses;

public abstract class AbstractEmployees {
    
	private int count;
    private int id;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private String date;
    private String typeSalary;
	private float salary;
   
    public abstract float calculatingWage();

    
/******Getters******/
	
	public int getCount(){
		return count;
    }
    public int getId(){
		return id;
    }
    public String getName(){
		return name;
    }
    public String getSurname(){
		return surname;
    }
    public String getAddress(){
		return address;
    }
    public String getPhone(){
		return phone;
    }    
    public String getDate(){
		return date;
    }
    public String getTypeSalary(){
		return typeSalary;
    }
	public float getSalary(){
		return salary;
    }
    
    /******Setters******/
	
	public void setCount(int count) {
		this.count = count;
    }
    public void setId(int id) {
		this.id = id;
    }
	public void setName(String name) {
		this.name = name;
    }
    public void setSurname(String surname) {
		this.surname = surname;
    } 
    public void setAddress(String address) {
		this.address = address;
    }    
    public void setPhone(String phone) {
		this.phone = phone;
    }  
    public void setDate(String date) {
		this.date = date;
    }
	public void setSalary(float salary) {
		this.salary = salary;
    }
    public void setTypeSalary(String typeSalary) {
		this.typeSalary = typeSalary;
    }
    

}
