package com.example.gantt.controller;

import com.example.gantt.Domain.Gantt;
import org.springframework.web.bind.annotation.*;
import com.example.gantt.service.GanttService;

@RestController
@RequestMapping("/gantts")
public class GanttController {

    private GanttService ganttService;

    //add "redirect:/gantts";

    public GanttController(GanttService ganttService) {
        this.ganttService = ganttService;
    }

    @GetMapping("/list")
    public Iterable<Gantt> list() {
        return ganttService.list();
    }

    @PostMapping("/create")
    public Gantt createGantt(  Gantt gantt) {
        return ganttService.create(gantt);
    }

    @PutMapping ("/{id}")
    public void updateGantt(Gantt gantt, @PathVariable("id") Long id) {
        ganttService.updateGantt(gantt, id);
    }

    @DeleteMapping("/{id}")
    public void deleteGnatt(@PathVariable("id") Long id) {
        ganttService.deleteGantt(id);
    }


}
