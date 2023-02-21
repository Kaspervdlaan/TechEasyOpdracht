package com.example.Tech.it.Easy.Controllers;

import com.example.Tech.it.Easy.Models.Television;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("televisions")
public class TelevisionsController {

    private List<Television> televisions = new ArrayList<>();

    @GetMapping("")
    public ResponseEntity<Iterable<Television>> getTelevision() {
        return new ResponseEntity<>(televisions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> getTv(@PathVariable int id) {
        return new ResponseEntity<>(televisions.get(id), HttpStatus.FOUND);
    }

    @PostMapping("")
    public ResponseEntity<Television> postTv(@RequestBody Television t) {
        televisions.add(t);
        return new ResponseEntity<>(t, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> putTv(@PathVariable int id, @RequestBody Television t) {

        if (id >= 0 && id < televisions.size()) {
            televisions.set(id, t);
            return new ResponseEntity<>(t, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("invalid id", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Object> deleteTv(@PathVariable String name) {
        for (Television t : televisions) {
            if (t.getName().equals(name)) {
                televisions.remove(t);
                return new ResponseEntity<>("deleted", HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
    }


    //Get all
    //Get one
    //Post one
    //Put one
    //Delete one





}
