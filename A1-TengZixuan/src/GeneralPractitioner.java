/**
 * Part 2: 全科医生（具体子类，继承自 HealthProfessional）
 */
public class GeneralPractitioner extends HealthProfessional {
    
   // 子类特有的属性：比如诊室号
    private String roomNumber; 

    // 构造方法：必须调用父类的构造方法来初始化共享信息
    public GeneralPractitioner(String id, String name, String availableDays, String roomNumber) {
        super(id, name, availableDays); // 调用父类构造方法
        this.roomNumber = roomNumber;
    }

   // 重载构造方法（仅传递 id 和 name，符合作业里提到的 flexibility） 
    public GeneralPractitioner(String id, String name) {
        super(id, name); 
        this.roomNumber = "General Room"; // 默认诊室
    }

    // Getter 获取特有属性
    public String getRoomNumber() {
       return roomNumber;
    }
    // 全科医生特有的行为：开药
    public void prescribeMedicine() {
        System.out.println(getName() + " is prescribing medicine.");
    }
    // 重写父类的 toString，同时包含父类信息和子类特有信息
    @Override
    public String toString() {
       // super.toString() 会去调用父类的打印逻辑
        return super.toString() + " | Room: " + roomNumber + " | Role: General Practitioner";
    }
}
