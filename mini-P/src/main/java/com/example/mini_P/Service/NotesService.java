package com.example.mini_P.Service;

import com.example.mini_P.Dto.AddNotesDto;
import com.example.mini_P.Dto.ResponseNotesDto;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotesService {


    ResponseNotesDto addNotes(AddNotesDto addNotesDto);

     List<ResponseNotesDto> getAllNotes();

    ResponseNotesDto updateNoteById(AddNotesDto addNotesDto,Long id);
    void deleteById(Long id);

     ResponseNotesDto getNotesById(Long id);
}
