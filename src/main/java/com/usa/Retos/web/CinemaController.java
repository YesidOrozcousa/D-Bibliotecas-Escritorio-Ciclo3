package com.usa.Retos.web;

import com.usa.Retos.model.Cinema;
import com.usa.Retos.model.Tables.CapacityAmount;
import com.usa.Retos.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api/Cinema")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;
    @GetMapping("/all")
    public List<Cinema> getAll(){
        return cinemaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Cinema> getCinema(@PathVariable("id") int id) {
        return cinemaService.getCinema(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cinema save(@RequestBody Cinema cinema) {
        return cinemaService.save(cinema);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cinema update(@RequestBody Cinema cinema) {
        return cinemaService.update(cinema);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return cinemaService.delete(id);
    }

    @GetMapping("/report")
    public List<CapacityAmount> getReport(){
        return cinemaService.getTopCinemaByCapacity();
    }
}
