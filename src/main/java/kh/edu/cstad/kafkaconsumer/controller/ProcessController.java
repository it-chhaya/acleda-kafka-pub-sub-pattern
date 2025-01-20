package kh.edu.cstad.kafkaconsumer.controller;

import kh.edu.cstad.kafkaconsumer.domain.Process;
import kh.edu.cstad.kafkaconsumer.service.ProcessService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class ProcessController {

    private final ProcessService processService;

    @PostMapping("/start-process")
    @ResponseBody
    public ResponseEntity<Process> startProcess(@RequestBody String data) {
        Process request = processService.createProcess(data);
        processService.executeProcess(request.getId());
        return ResponseEntity.ok(request);
    }

}
