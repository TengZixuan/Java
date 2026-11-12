import java.util.ArrayList;

/**
 * 主类：用于运行和演示整个系统的功能（Part 3 和 Part 6）。
 */
public class AssignmentOne {
    public static void main(String[] args) {
        
        System.out.println("=========================================");
        System.out.println("      Part 6: Clinic Appointment System  ");
        System.out.println("=========================================\n");

        // ==========================================
        // 第一幕：诊所开业，医生就位
        // ==========================================
        System.out.println("--- 1. Creating Health Professionals ---");
        
        // 创建 3 个全科医生 (使用不同的构造方法展示灵活性)
        GeneralPractitioner gp1 = new GeneralPractitioner("101", "Dr. Alice", "Mon, Wed", "Room 101");
        GeneralPractitioner gp2 = new GeneralPractitioner("102", "Dr. Bob", "Tue, Thu", "Room 102");
        GeneralPractitioner gp3 = new GeneralPractitioner("103", "Dr. Charlie"); // 缺省构造
        
        // 创建专科医生
        Psychiatrist psy1 = new Psychiatrist("201", "Dr. Diana", "Fri", "CBT");
        OrthopedicSurgeon ortho1 = new OrthopedicSurgeon("301", "Dr. Evan", "Mon, Fri", "Knee Replacement");
        Dentist dent1 = new Dentist("401", "Dr. Fiona");

        // 展示所有员工信息
        ArrayList<HealthProfessional> staff = new ArrayList<>();
        staff.add(gp1); staff.add(gp2); staff.add(gp3);
        staff.add(psy1); staff.add(ortho1); staff.add(dent1);
        
        for (HealthProfessional hp : staff) {
            System.out.println(hp.toString());
        }
        System.out.println();

        // ==========================================
        // 第二幕：前台建立，开始挂号
        // ==========================================
        System.out.println("--- 2. Managing Appointments ---");
        AppointmentManager manager = new AppointmentManager();

        // 正常挂号
        Appointment appt1 = new Appointment("John Doe", "0412345678", gp1, "09:00");
        Appointment appt2 = new Appointment("Jane Smith", "0498765432", psy1, "10:00");
        Appointment appt3 = new Appointment("Tom Brown", "0455555555", ortho1, "11:30");
        Appointment appt4 = new Appointment("Emily White", "0433333333", gp1, "14:00"); // 同一个医生，不同时间

        manager.addAppointment(appt1);
        manager.addAppointment(appt2);
        manager.addAppointment(appt3);
        manager.addAppointment(appt4);
        System.out.println();

        // ==========================================
        // 第三幕：展示与过滤（验证排序功能）
        // ==========================================
        System.out.println("--- 3. Displaying and Filtering ---");
        // 显示所有预约（注意看终端里是不是按时间 09:00, 10:00, 11:30, 14:00 排序的）
        manager.displayAllAppointments();
        System.out.println();

        // 过滤：只看 Dr. Alice 的预约
        manager.displayAppointmentsByDoctor(gp1);
        System.out.println();

        // ==========================================
        // 第四幕：错误演示与取消操作（高潮部分！）
        // ==========================================
        System.out.println("--- 4. Error Cases and Cancellations ---");
        
        // 错误演示 A：双重预约冲突 (Dr. Alice 在 09:00 已经有病人了)
        System.out.println("\n[Error Case A: Attempting to double-book a doctor]");
        Appointment conflictAppt = new Appointment("Mark Lee", "0400000000", gp1, "09:00");
        manager.addAppointment(conflictAppt); // 应该会提示预约失败

        // 错误演示 B：取消一个不存在的预约
        System.out.println("\n[Error Case B: Cancelling a non-existent appointment]");
        manager.cancelAppointment("Unknown Patient", "Dr. Alice"); // 应该提示找不到

        // 正常取消：Jane Smith 不来了
        System.out.println("\n[Normal Case: Cancelling an existing appointment]");
        manager.cancelAppointment("Jane Smith", "Dr. Diana");

        // ==========================================
        // 终幕：再次展示，证明取消成功
        // ==========================================
        System.out.println("\n--- 5. Final Appointment List ---");
        manager.displayAllAppointments(); // 此时列表里应该没有 Jane Smith 了

        System.out.println("\n=========================================");
        System.out.println("      End of Demonstration  ");
        System.out.println("=========================================");
    }
}