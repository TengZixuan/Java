/**
 * Part 4: 预约（挂号单）类。
 * 链接了患者、健康专业人员和具体时间。
 */
public class Appointment implements Comparable<Appointment> {
    
    // 1. 挂号单的基本信息
    private String patientName;      // 病人的姓名
    private String patientPhone;     // 病人的电话
    private HealthProfessional doctor; // 对应的是哪个医生 (注意：这里用父类类型，可以接收任何子类)
    private String timeSlot;         // 预约时间段 (如 "09:00", "10:30")

    // 构造方法
    public Appointment(String patientName, String patientPhone, HealthProfessional doctor, String timeSlot) {
        // 简单的数据核对
        if (patientPhone == null || patientPhone.length() < 10) {
            throw new IllegalArgumentException("错误：电话号码无效！");
        }
        this.patientName = patientName;
        this.patientPhone = patientPhone;
        this.doctor = doctor;
        this.timeSlot = timeSlot;
    }

    // 提供 Getter 方法（后面管理类要用）
    public String getPatientName() { return patientName; }
    public HealthProfessional getDoctor() { return doctor; }
    public String getTimeSlot() { return timeSlot; }

    // 重写 toString，打印挂号单详情
    @Override
    public String toString() {
        return "Appointment [Patient: " + patientName + 
               ", Phone: " + patientPhone + 
               ", Doctor: " + doctor.getName() + " (" + doctor.getClass().getSimpleName() + ")" + 
               ", Time: " + timeSlot + "]";
    }

     /**
     * 实现 Comparable 接口，重写 compareTo 方法。
     * 作用：如果我们把多个 Appointment 放入 List 并且调用 Collections.sort() 时，
     * 系统就会自动按照 timeSlot 的字典顺序进行排序（也就是从早到晚）。
     */
    @Override
    public int compareTo(Appointment other) {
        // 比较时间字符串。因为 "09:00" 这种格式在字典顺序下就是时间先后顺序
        return this.timeSlot.compareTo(other.timeSlot);
    }
}