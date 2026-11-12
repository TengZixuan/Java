/**
 * Part 1: 代表通用的健康专业人员（基类）。
 * 这是一个抽象类，不能被直接实例化，强制子类实现相关行为。
 * 体现了面向对象四大支柱中的：封装（Encapsulation）和 抽象（Abstraction）。
 */
public abstract class HealthProfessional {
    
    // 封装：属性全部私有(private)，外部不能直接修改，防止对象进入无效状态
    private String id; 
    private String name;
    private String availableDays; 

    /**
     * 构造方法 1：全参数
     * @param id 员工ID，必须是纯数字
     * @param name 姓名
     * @param availableDays 可用日期，例如 "Mon, Wed"
     */
    public HealthProfessional(String id, String name, String availableDays) {
        // 验证 ID 必须只包含数字。如果不符合，抛出异常，保护数据安全。
        if (id != null && id.matches("\\d+")) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("错误：ID 必须只包含数字！");
        }
        this.name = name;
        this.availableDays = availableDays;
    }

    /**
     * 构造方法 2：重载（方法重载 Overloading）。
     * 如果调用者不提供可用日期，则赋予默认值 "Not specified"。
     */
    public HealthProfessional(String id, String name) {
        this(id, name, "Not specified"); 
    }

    // 提供只读访问：Getter 方法。不提供 Setter，确保封装性。
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvailableDays() {
        return availableDays;
    }

    /**
     * 重写 Object 类的 toString 方法。
     * 当我们打印对象时，会输出带有类型、ID、姓名等可读信息。
     */
    @Override
    public String toString() {
        // this.getClass().getSimpleName() 会动态获取子类的名字（多态体现）
        return "Type: " + this.getClass().getSimpleName() + 
               " | ID: " + id + 
               " | Name: " + name + 
               " | Available Days: " + availableDays;
    }

    /**
     * 重写 equals 方法。
     * 在预约系统中，判断两个医生是否为同一个人，我们认定只要 ID 相同即为同一个人。
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // 地址相同，必定是同一个对象
        if (obj == null || getClass() != obj.getClass()) return false; // 类型不同，必定不相等
        HealthProfessional that = (HealthProfessional) obj;
        return this.id.equals(that.id); // 比较 ID 字符串
    }

    /**
     * 重写 hashCode 方法。
     * Java 规范要求：如果重写了 equals，必须同时重写 hashCode。
     */
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}