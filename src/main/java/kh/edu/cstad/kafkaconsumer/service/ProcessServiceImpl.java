package kh.edu.cstad.kafkaconsumer.service;

import kh.edu.cstad.kafkaconsumer.domain.Process;
import kh.edu.cstad.kafkaconsumer.domain.ProcessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ProcessServiceImpl implements ProcessService {

    private final ProcessRepository processRepository;

    private final KafkaTemplate<String, String> kafkaTemplate;


    @Override
    public Process createProcess(String processName) {
        Process request = new Process();
        request.setProcessName(processName);
        request.setStatus("PENDING");
        request.setCreatedAt(LocalDateTime.now());
        return processRepository.save(request);
    }

    @Override
    public void executeProcess(UUID processId) {
        kafkaTemplate.send("background-process-topic", processId.toString());
    }

    @Override
    public Process completeProcess(UUID processId) {
        Process request = processRepository.findById(processId)
                .orElseThrow(() -> new RuntimeException("Process not found"));
        request.setStatus("COMPLETED");
        request.setCompletedAt(LocalDateTime.now());
        return processRepository.save(request);

    }
}
