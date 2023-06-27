import java.util.ArrayList;
import java.util.List;

public class ReportManager {
    private List<Report> reports;

    public ReportManager() {
        this.reports = new ArrayList<>();
    }

    public void inserisciReport(Report report) {
        reports.add(report);
    }

    public List<Report> getReports() {
        return reports;
    }
}
