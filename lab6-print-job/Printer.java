import java.util.LinkedList;
import java.util.Queue;

class PrintJob {
    private String documentName;
    private int pageCount;

    public PrintJob(String documentName, int pageCount) {
        this.documentName = documentName;
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return "PrintJob[Document: " + documentName + ", Pages: " + pageCount + "]";
    }
}

public class Printer {
    private Queue<PrintJob> jobQueue;

    public Printer() {

        jobQueue = new LinkedList<>();
    }

    public void addJob(PrintJob job) {
        System.out.println("Adding to queue: " + job);
        jobQueue.add(job);
    }
    
    public void processNextJob() {
        if (jobQueue.isEmpty()) {
            System.out.println("No jobs in queue. Printer is idle.");
        } else {
            PrintJob nextJob = jobQueue.poll(); // 从队首取出
            System.out.println("Processing: " + nextJob);
        }
    }

    public static void main(String[] args) {
        Printer officePrinter = new Printer();

        officePrinter.addJob(new PrintJob("Annual_Report.pdf", 25));
        officePrinter.addJob(new PrintJob("Meeting_Agenda.docx", 2));
        officePrinter.addJob(new PrintJob("Presentation_Slides.pptx", 30));

        System.out.println("\n--- Starting to Print ---");
        officePrinter.processNextJob(); // Annual_Report.pdf
        officePrinter.processNextJob(); // Meeting_Agenda.docx

        System.out.println("\nNew high-priority job arrives...");
        officePrinter.addJob(new PrintJob("Urgent_Memo.pdf", 1));

        officePrinter.processNextJob(); // Presentation_Slides.pptx
        officePrinter.processNextJob(); // Urgent_Memo.pdf
        officePrinter.processNextJob(); // Queue empty
    }
}
