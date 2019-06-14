import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String firstName;
    private String lastName;
    private Employee manager;
    private List<Employee> subordinates;
	  private String phone;
	  private String secondPhone;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subordinates = new ArrayList<>();
    }

    public void setSubordinates(List<Employee> subordinates){
        this.subordinates = subordinates;
        this.subordinates.forEach(sub -> sub.setManager(this));
    }

    public void setManager(Employee manager){
        this.manager = manager;
    }


    public Employee getManager() {
        return manager;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void printAllsubordinates(){
        subordinates.forEach(subordinate -> {
            if(!subordinate.getSubordinates().isEmpty()) {
                subordinate.printAllsubordinates();
            }
            System.out.println(subordinate);
        });
    }

    public void printCEOName(){
        System.out.print(getCEO());
    }

    public void printAllEmployee(){
        Employee ceo = getCEO();
        System.out.println(ceo);
        ceo.printAllsubordinates();
    }

    private Employee getCEO(){
        if(manager == null){
            return this;
        }else{
            return manager.getCEO();
        }
    }


    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
