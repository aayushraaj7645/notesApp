package com.example.mini_P.ServiceImplementation;

import com.example.mini_P.Dto.AddNotesDto;
import com.example.mini_P.Dto.ResponseNotesDto;
import com.example.mini_P.Entity.NotesEntity;
import com.example.mini_P.Repository.NotesRepository;
import com.example.mini_P.Service.NotesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotesServiceImplementation implements NotesService {

    private final NotesRepository notesRepository;



    @Override
    public ResponseNotesDto addNotes(AddNotesDto addNotesDto) {
 NotesEntity notesEntity = new NotesEntity();
 notesEntity.setNotes(addNotesDto.getNotes());
 notesEntity.setDescription(addNotesDto.getDescription());
 NotesEntity notesEntity1 = notesRepository.save(notesEntity);
 ResponseNotesDto responseNotesDto = new ResponseNotesDto();
 responseNotesDto.setId(notesEntity1.getId());
 responseNotesDto.setNotes(notesEntity1.getNotes());
 responseNotesDto.setDescription(notesEntity1.getDescription());
 return responseNotesDto;
    }

    @Override
    public List<ResponseNotesDto> getAllNotes() {
       List<NotesEntity> notesEntitiesList = notesRepository.findAll();
       List<ResponseNotesDto> responseNotesDtoList = new ArrayList<>();
       for (NotesEntity notesEntity : notesEntitiesList) {
           ResponseNotesDto responseNotesDto = new ResponseNotesDto();
           responseNotesDto.setId(notesEntity.getId());
           responseNotesDto.setNotes(notesEntity.getNotes());
           responseNotesDto.setDescription(notesEntity.getDescription());
           responseNotesDtoList.add(responseNotesDto);
       }
       return responseNotesDtoList;
    }

    @Override
    public ResponseNotesDto updateNoteById(AddNotesDto addNotesDto ,Long id) {
        NotesEntity notesEntity = notesRepository.getNotesById(id);
        notesEntity.setNotes(addNotesDto.getNotes());
        notesEntity.setDescription(addNotesDto.getDescription());
        notesEntity.setId(id);
        NotesEntity notesEntity1 = notesRepository.save(notesEntity);
        ResponseNotesDto responseNotesDto = new ResponseNotesDto();
        responseNotesDto.setId(notesEntity1.getId());
        responseNotesDto.setNotes(notesEntity1.getNotes());
        responseNotesDto.setDescription(notesEntity1.getDescription());
        return responseNotesDto;
    }

    @Override
    public void deleteById(Long id) {
        if(notesRepository.existsById(id)) {
            notesRepository.deleteById(id);
        }

    }

    @Override
    public ResponseNotesDto getNotesById(Long id) {

        NotesEntity notesEntity = notesRepository.findById(id)
                .orElseThrow(()->new RuntimeException("there is no notes with this id"));

               ResponseNotesDto responseNotesDto = new ResponseNotesDto();
               responseNotesDto.setId(notesEntity.getId());
               responseNotesDto.setNotes(notesEntity.getNotes());
               responseNotesDto.setDescription(notesEntity.getDescription());
               return responseNotesDto;
           }







    }

