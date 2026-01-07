package com.example.mini_P.Controller;

import com.example.mini_P.Dto.AddNotesDto;
import com.example.mini_P.Dto.ResponseNotesDto;
import com.example.mini_P.Service.NotesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/notes")
public class NotesController {
    private final NotesService notesService;

    @PostMapping("/addNotes")
    public ResponseEntity<ResponseNotesDto> addNotes(@RequestBody AddNotesDto addNotesDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(notesService.addNotes(addNotesDto));
    }
    @GetMapping("/getNotes")
    public ResponseEntity<List<ResponseNotesDto>> getNotes() {
        return ResponseEntity.status(HttpStatus.OK).body(notesService.getAllNotes());
    }
    @GetMapping("/getNotes/{id}")
    public ResponseEntity<ResponseNotesDto> getNotesById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(notesService.getNotesById(id));
    }




    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseNotesDto> updateNotes(@RequestBody AddNotesDto addNotesDto, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(notesService.updateNoteById(addNotesDto, id));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNotes(@PathVariable Long id) {
         notesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
