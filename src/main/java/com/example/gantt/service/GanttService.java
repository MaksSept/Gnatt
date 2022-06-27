package com.example.gantt.service;

import com.example.gantt.Domain.Gantt;
import com.example.gantt.repository.GanttRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class GanttService {

    private GanttRepository ganttRepository;


    public GanttService(GanttRepository ganttRepository) {
        this.ganttRepository = ganttRepository;
    }

    public Iterable<Gantt> list() {
        return ganttRepository.findAll();
    }

    public Gantt create(Gantt gantt) {
        return ganttRepository.save(gantt);
    }

    public Iterable<Gantt> create(List<Gantt> gantts) {
        return ganttRepository.saveAll(gantts);
    }

    public void updateGantt(Gantt gantt, Long id) {
        ganttRepository.save(gantt);
    }

    public void deleteGantt(Long id) {
        ganttRepository.deleteById(id);
    }
}
