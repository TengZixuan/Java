/**
 * Part 2: 骨科医生（具体子类）。
 */
public class OrthopedicSurgeon extends HealthProfessional {

     // 特有属性：手术重点（如 Knee Replacement）
    private String surgeryFocus;

     // 构造方法 1：全参数
    public OrthopedicSurgeon(String id, String name, String availableDays, String surgeryFocus) {
        super(id, name, availableDays);
        this.surgeryFocus = surgeryFocus;
    }

    // 构造方法 2：重载（提供默认手术方向）
    public OrthopedicSurgeon(String id, String name) {
        super(id, name);
        this.surgeryFocus = "General Orthopedics";
    }

    // Getter 方法
    public String getSurgeryFocus() {
        return surgeryFocus;
    }

   // 特有行为
    public void performBoneSurgery() {
        System.out.println(getName() + " is performing bone surgery focused on " + surgeryFocus + ".");
    }

    // 重写 toString
    @Override
    public String toString() {
        return super.toString() + " | Room: OR-2 | Role: Orthopedic Surgeon | Focus: " + surgeryFocus;
    }
}