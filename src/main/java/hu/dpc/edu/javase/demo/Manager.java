package hu.dpc.edu.javase.demo;

/**
 *
 * @author IQJB
 */
public class Manager extends Employee{
    private Department managerOf = new Department();
    private String name;

//    {
//        name = "alma";
//    }

    public Manager() {
        super(111);
    }
    
    public Manager(Department department, String name) {
        this(generateId(), name, department);
        System.out.println("Manager(dep, name)");
    }

    public Manager(long id, String name, Department department) {
        super(id, name);
        System.out.println("Manager(id, dep, name)");
        this.managerOf = department;
    }
    
//    
//    {
//        super.name = "korte";
//        ((Employee)this).name = "ize";
//    }

    public Department getManagerOf() {
        return managerOf;
    }

    public void setManagerOf(Department managerOf) {
        this.managerOf = managerOf;
    }

    @Override
    public void appendInfo(StringBuilder sb) {
        super.appendInfo(sb);
        sb.append(", managerOf=").append(managerOf)
                .append(", name=").append(name);
    }

}
