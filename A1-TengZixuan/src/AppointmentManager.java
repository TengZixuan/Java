import java.util.ArrayList;
import java.util.Collections;

/**
 * Part 5: 预约管理系统。
 * 负责管理所有预约的系统，提供添加、取消、过滤和排序显示的功能。
 */
public class AppointmentManager {
    
    // 内部用 ArrayList 来保存所有的预约单
    private ArrayList<Appointment> appointments;

    // 构造方法：初始化这个系统
    public AppointmentManager() {
        this.appointments = new ArrayList<>();
    }

    /**
     * 添加预约。
     * 包括冲突检查：同一个医生在同一个时间段不能被预约两次。
     * @param newAppt 待添加的预约对象
     * @return 添加成功返回 true，失败返回 false
     */
    public boolean addAppointment(Appointment newAppt) {
        // 浏览现有的所有预约，检查冲突
        for (Appointment existingAppt : appointments) {
            // 如果医生是同一个人（用到了我们在父类重写的 equals 方法），而且时间也一样
            if (existingAppt.getDoctor().equals(newAppt.getDoctor()) && 
                existingAppt.getTimeSlot().equals(newAppt.getTimeSlot())) {
                
                System.out.println("错误 预约失败：医生 " + newAppt.getDoctor().getName() + 
                                   " 在 " + newAppt.getTimeSlot() + " 已经有预约了！");
                return false; // 添加失败
            }
        }
        // 没有冲突，加入系统
        appointments.add(newAppt);
        System.out.println("成功 预约成功：" + newAppt.getPatientName() + " -> " + newAppt.getDoctor().getName());
        return true;
    }

     /**
     * 根据病人的姓名和医生的姓名取消预约。
     * 包含错误情况处理：如果找不到对应预约就打印失败信息。
     */
    public boolean cancelAppointment(String patientName, String doctorName) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appt = appointments.get(i);
            // 找到匹配的病人和医生
            if (appt.getPatientName().equalsIgnoreCase(patientName) && 
                appt.getDoctor().getName().equalsIgnoreCase(doctorName)) {
                
                appointments.remove(i);
                System.out.println("成功 取消成功：" + patientName + " 的预约已取消。");
                return true;
            }
        }
        // 循环结束没找到
        System.out.println("错误 取消失败：找不到 " + patientName + " 针对医生 " + doctorName + " 的预约。");
        return false;
    }

    /**
     * 显示所有预约，并按照时间从早到晚排序。
     */
    public void displayAllAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("当前没有预约。");
            return;
        }
        
        // 因为 Appointment 类实现了 Comparable 接口，这里可以直接调用 sort 排序
        Collections.sort(appointments);
        
        System.out.println("--- 所有预约列表 (按时间排序) ---");
        for (Appointment appt : appointments) {
            System.out.println(appt.toString());
        }
    }

    /**
     * 过滤显示：只查看某位指定医生的预约。
     */
    public void displayAppointmentsByDoctor(HealthProfessional doctor) {
        System.out.println("--- " + doctor.getName() + " 的预约列表 ---");
        boolean found = false;
        for (Appointment appt : appointments) {
            if (appt.getDoctor().equals(doctor)) {
                System.out.println(appt.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("该医生目前没有预约。");
        }
    }
}