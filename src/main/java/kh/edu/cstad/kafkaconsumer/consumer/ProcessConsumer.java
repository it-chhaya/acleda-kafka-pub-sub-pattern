package kh.edu.cstad.kafkaconsumer.consumer;

import kh.edu.cstad.kafkaconsumer.domain.EmployeeRepository;
import kh.edu.cstad.kafkaconsumer.domain.Process;
import kh.edu.cstad.kafkaconsumer.domain.ProcessRepository;
import kh.edu.cstad.kafkaconsumer.dto.EmployeeReportResponse;
import kh.edu.cstad.kafkaconsumer.dto.ProcessNotification;
import kh.edu.cstad.kafkaconsumer.service.ProcessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProcessConsumer {

    private final EmployeeRepository employeeRepository;
    private final ProcessRepository processRepository;
    private final ProcessService processService;
    private final SimpMessagingTemplate messagingTemplate;

    @KafkaListener(topics = "background-process-topic")
    public void listen(UUID processId) {
        try {

            // Execute the stored procedure
            String result = processRepository.executeLongRunningProcedure(processId);

            List<EmployeeReportResponse> employeeReportResponses = employeeRepository
                    .getEmployeeReport("d005");

            System.out.println("Employee report responses");
            System.out.println("-------------------------");
            AtomicInteger i = new AtomicInteger();
            employeeReportResponses
                    .forEach(employeeReportResponse -> {
                        System.out.printf("[%d] => [%s] ", i.get() + 1,employeeReportResponse.getEmployeeFirstName());
                        System.out.println(employeeReportResponse.getEmployeeLastName());
                        System.out.println(employeeReportResponse.getTitleName());
                        System.out.println(employeeReportResponse.getCurrentSalary());
                        i.getAndIncrement();
                    });

            // Update request status
            Process completedRequest = processService.completeProcess(processId);

            // Send notification to UI through WebSocket
            messagingTemplate.convertAndSend("/topic/notifications",
                    new ProcessNotification(String.format("Process %s: %s", completedRequest.getStatus(), completedRequest.getId()), completedRequest.getCompletedAt())
            );

        } catch (Exception e) {
            log.error(e.getMessage());
            messagingTemplate.convertAndSend("/topic/notifications",
                    new ProcessNotification("Process failed for request: " + processId + " - " + e.getMessage(), LocalDateTime.now())
            );
        }
    }

}
