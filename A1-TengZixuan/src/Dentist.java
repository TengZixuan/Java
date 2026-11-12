/**
 * Part 2: 牙医（具体子类）。
 */
public class Dentist extends HealthProfessional {

    // 特有属性：专长领域（如 Orthodontics 正畸）
    private String specialtyArea;

    // 构造方法 1：全参数
    public Dentist(String id, String name, String availableDays, String specialtyArea) {
        super(id, name, availableDays);
        this.specialtyArea = specialtyArea;
    }

    // 构造方法 2：重载（提供默认专长）
    public Dentist(String id, String name) {
        super(id, name);
        this.specialtyArea = "General Dentistry";
    }

    // Getter 方法
    public String getSpecialtyArea() {
        return specialtyArea;
    }

     // 特有行为
    public void performDentalCheckup() {
        System.out.println(getName() + " is performing a dental checkup for " + specialtyArea + ".");
    }

    // 重写 toString
    @Override
    public String toString() {
        return super.toString() + " | Room: Dental-1 | Role: Dentist | Specialty: " + specialtyArea;
    }
}