/**
 * Part 2: 心理医生（具体子类）。
 */
public class Psychiatrist extends HealthProfessional {

    // 特有属性：治疗流派（如 CBT）
    private String therapyType;

    // 构造方法 1：全参数
    public Psychiatrist(String id, String name, String availableDays, String therapyType) {
        super(id, name, availableDays);
        this.therapyType = therapyType;
    }

    // 构造方法 2：重载（提供默认流派）
    public Psychiatrist(String id, String name) {
        super(id, name);
        this.therapyType = "CBT"; 
    }

   // Getter 方法
    public String getTherapyType() {
        return therapyType;
    }

    // 特有行为
    public void conductTherapy() {
        System.out.println(getName() + " is conducting " + therapyType + " therapy.");
    }

    // 重写 toString
    @Override
    public String toString() {
        return super.toString() + " | Room: Therapy Room | Role: Psychiatrist | Therapy Type: " + therapyType;
    }
}