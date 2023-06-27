import java.util.List;

public class ReportView {
    public void displayReports(List<Report> reports) {
        System.out.println("Lista dei report:");
        for (Report report : reports) {
            System.out.println(report);
        }
    }

    public void displayReport(Report report) {
        System.out.println("Dettagli del report:");
        System.out.println(report);
    }
}
