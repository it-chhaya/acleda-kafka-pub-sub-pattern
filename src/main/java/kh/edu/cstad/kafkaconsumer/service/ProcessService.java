package kh.edu.cstad.kafkaconsumer.service;

import kh.edu.cstad.kafkaconsumer.domain.Process;

import java.util.UUID;

public interface ProcessService {

    Process createProcess(String processName);

    void executeProcess(UUID processId);

    Process completeProcess(UUID processId);

}
